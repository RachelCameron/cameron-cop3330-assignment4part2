package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Rachel Cameron
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.util.converter.BooleanStringConverter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static ucf.assignments.Item.descriptionIsValid;
import static ucf.assignments.Item.dueDateIsValid;

public class ListManagerController {

    private final ToDoList list = new ToDoList();

    //2. An item shall have a description
    // - A description shall be between 1 and 256 characters in length
    @FXML private TextField itemField;
    //requires user to describe what their item (task) is between 1 and 256 characters in length
    //if you try to type in a duplicate item description or invalid description, you will be given an error message

    //3. An item shall have a due date
    // - A due date shall be a valid date within the Gregorian Calendar
    // - A due date shall be displayed to users in the format: YYYY-MM-DD
    @FXML private TextField itemDueDateField;
    //requires user to give their item a valid due date in the format of YYYY-MM-DD
    //if you try to type in an invalid date that is not in the Gregorian calendar or mis-formatted, you will be given an error message

    //all my GUI buttons
    @FXML private Button addItemButton;
    @FXML private Button clearAllListItemsButton;
    @FXML private Button removeItemButton;
    @FXML private Button saveListButton;
    @FXML private Button loadListButton;
    @FXML private Button showCompleteItemsOnlyButton;
    @FXML private Button showIncompleteItemsOnlyButton;

    //9. A user shall be able to mark an item in the list as either complete or incomplete
    @FXML private CheckBox completeCheckBox;
    //checkbox for completion status

    //necessary for my show complete/incomplete items only buttons
    boolean completeFlag;
    boolean incompleteFlag;

    //1. The application shall manage a single list of items
    // - The list shall have the capacity to store at least 100 unique items
    //10. A user shall be able to display all of the existing items in the list
    @FXML private TableView<Item> listViewer;
    //view of the list

    //7. A user shall be able to edit the description of an item within the list
    @FXML private TableColumn<Item, String> itemViewer;
    //view of the list items

    //8. A user shall be able to edit the due date of an item within the list
    @FXML private TableColumn<Item, String> dueDateViewer;
    //view of the list items' due dates

    @FXML private TableColumn<Item, Boolean> statusViewer;
    //view of the list items' statuses (complete or incomplete)

    private int index = 0;

    //javafx table view automatically handles editing so the editing feature CANNOT BE TESTED by nature
    //implemented descriptionIsValid and dueDateIsValid within table view to ensure that new entries through editing will always be valid
    //if you try and edit in any invalid inputs, the invalid input is rejected and the old valid input is kept instead
    @FXML
    void initialize() {
        //connects item descriptions to my table view
        itemViewer.setCellFactory(TextFieldTableCell.forTableColumn());
        itemViewer.setOnEditCommit(event ->
        {
            //will only allow editing if the new description is valid
            if (descriptionIsValid(event.getNewValue())) {
                Item item = event.getRowValue();
                item.setDescription(event.getNewValue());
            }
            //if the new description is not valid, retains the old valid description
            else{
                listViewer.refresh();
            }
        });
        //connects item due dates to my table view
        dueDateViewer.setCellFactory(TextFieldTableCell.forTableColumn());
        dueDateViewer.setOnEditCommit(event ->
        {
            //will only allow editing if the new due date is valid
            if (dueDateIsValid(event.getNewValue())) {
                Item item = event.getRowValue();
                item.setDueDate(event.getNewValue());
            }
            //if the new due date is not valid, retains the old valid due date
            else{
                listViewer.refresh();
            }
        });
        //connects item status to my table view
        statusViewer.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
        statusViewer.setOnEditCommit(event -> {
            Item item = event.getRowValue();
            item.setComplete(event.getNewValue());
        });
    }

    @FXML
    void addItemButtonClicked(ActionEvent event) {
        //calls addItem(), displayItem(), and clearTextFields() only if the item description and due date are valid
        //the item description cannot be a duplicate item description
        if(descriptionIsValid(itemField.getText()) && dueDateIsValid(itemDueDateField.getText()) && isNotDuplicate(itemField.getText())){
            addItem();
            displayItem();
            clearTextFields();
        }
        //if the item description or due date entered are found invalid, shows an error message in both text fields
        else{
            itemField.setText("One or more invalid entries, please try again.");
            itemDueDateField.setText("One or more invalid entries, please try again.");
        }
    }

    //4. A user shall be able to add a new item to the list
    public void addItem() {
        //allows user to add an item to their list populated with the given item description, due date, and completion status
        list.addItem(itemField.getText(), itemDueDateField.getText(), completeCheckBox.isSelected());
    }

    //10. A user shall be able to display all of the existing items in the list
    private void displayItem(){
        //display the created item and add to the index
        itemViewer.setCellValueFactory(new PropertyValueFactory<>("description"));
        dueDateViewer.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        statusViewer.setCellValueFactory(new PropertyValueFactory<>("complete"));
        listViewer.getItems().add(list.getToDoList().get(index));
        index++;
    }

    //clears out any entry in the text field(s) and resets the checkbox
    //quality of life feature so the user does not have to empty or replace old text themselves when adding another item
    private void clearTextFields(){
        itemField.clear();
        itemDueDateField.clear();
        completeCheckBox.setSelected(false);
    }

    //6. A user shall be able to clear the list of all items
    //resets text fields, checkbox, index, and calls clearAllListItems(), separated for testing
    private void clear(){
        itemField.clear();
        itemDueDateField.clear();
        completeCheckBox.setSelected(false);
        listViewer.getItems().clear();
        index = 0;
        clearAllListItems();
    }

    @FXML
    void clearAllListItemsButtonClicked(ActionEvent event) {
        //calls clear() as an all-in-one all item clearing + list reset
        clear();
    }

    //6. A user shall be able to clear the list of all items
    public void clearAllListItems() {
        //removes all the items from the list
        list.getToDoList().clear();
    }

    @FXML
    void removeItemButtonClicked(ActionEvent event) {
        //calls removeItem()
        removeItem();
    }

    //5. A user shall be able to remove an item from the list
    public void removeItem() {
        //removes an item from the list
        Item selectedItem = listViewer.getSelectionModel().getSelectedItem();
        //ensures item is selected
        if(selectedItem != null){
            //removes item from list
            list.removeItem(selectedItem);
            //removes item from index
            index--;
            //removes item from table view
            listViewer.getItems().remove(selectedItem);
        }
    }

    @FXML
    void saveListButtonClicked(ActionEvent event) throws IOException {
        //calls saveList(writer)
        //allows user to choose where they want to save the text file
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Text File", "*.txt"));
            //actually writes the file, wow this took a lot of bug fixing
            FileWriter writer = new FileWriter(fileChooser.showSaveDialog(null));
            saveList(writer);

    }

    //13. A user shall be able to save the list (and all of its items) to external storage
    public void saveList(FileWriter writer) throws IOException {
        //saves the current list
        //makes sure a file is actually selected to avoid errors
        if(this.listViewer == null){
            return;
        }
        //for every item, writes the item description, due date, and completion status
        for(Item i : list.getToDoList()) {
            //format should look like description,YYYY-MM-DD,true/false
            //example: Finish Project,2021-11-15,true
            //if task "Finish Project" due on "2021-11-15" is completed "true"
            //adds a new line after each added item so there's one task per line
            writer.write(i.getDescription()+","+i.getDueDate()+","+i.getComplete()+"\n");
        }
        writer.close();
    }

    @FXML
    void loadListButtonClicked(ActionEvent event) throws IOException {
        //calls loadList(file)
        //allows user to pick the file location of the text file they want to load
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Text File", "*.txt"));
        File file = fileChooser.showOpenDialog(listViewer.getScene().getWindow());
        loadList(file);
    }

    //14. A user shall be able to load a list (and all of its items) from external storage
    public void loadList(File file) throws FileNotFoundException {
        //loads list selected by user
        clear();
        //makes sure a file is actually selected to avoid errors
        if(this.listViewer == null){
            return;
        }
        Scanner scanner = new Scanner(file);
        index = 0;
        while(scanner.hasNextLine()) {
            //splits up the different elements by the comma between them
            String[] array = scanner.nextLine().split(",");
            //array[0] = item description
            //array[1] = item due date
            //array[2] = completion status
            //for completion status, uses .equals("true") workaround for the boolean since the only alternative is "false"
            list.addItem(array[0], array[1], array[2].equals("true"));
            //displays the loaded list
            displayItem();
        }
    }

    @FXML
    void showCompleteItemsOnlyButtonClicked(ActionEvent event) {
        //calls showCompleteItemsOnly()
        showCompleteItemsOnly();
    }

    //12. A user shall be able to display only the completed items in the list
    public void showCompleteItemsOnly() {
        //only shows the completed items in the list viewer
        ObservableList<Item> completeList = FXCollections.observableArrayList();
        //initialize new ObservableList for complete items only
        if(!completeFlag)
        {
            //for loop each item from my main to-do list
            for(Item i : list.getToDoList()) {
                //if complete then add it to new list
                if(i.getComplete()){
                    completeList.add(i);
                }
            }
            //click "Show Complete Items Only" button to only display complete items
            //once toggled to see only complete items in list, the button text will change to "Show All Items"
            //click the newly appeared "Show All Items" button to display all the items again
            listViewer.setItems(completeList);
            showCompleteItemsOnlyButton.setText("Show All Items");
            completeFlag = true;
        }
        else
        {
            listViewer.setItems(list.getToDoList());
            showCompleteItemsOnlyButton.setText("Show Complete Items Only");
            completeFlag = false;

        }
    }

    @FXML
    void showIncompleteItemsOnlyButtonClicked(ActionEvent event) {
        //calls showIncompleteItemsOnly()
        showIncompleteItemsOnly();
    }


    //11. A user shall be able to display only the incomplete items in the list
    public void showIncompleteItemsOnly() {
        //only shows the incompleted items in the list viewer
            ObservableList<Item> incompleteList = FXCollections.observableArrayList();
            //initialize new ObservableList for incomplete items only
        if(!incompleteFlag)
        {
            //for loop each item from my main to-do list
            for(Item i : list.getToDoList()) {
                //if incomplete then add it to new list
                if(!i.getComplete()){
                    incompleteList.add(i);
                }
            }
            //click "Show Incomplete Items Only" button to only display incomplete items
            //once toggled to see only incomplete items in list, the button text will change to "Show All Items"
            //click the newly appeared "Show All Items" button to display all the items again
            listViewer.setItems(incompleteList);
            showIncompleteItemsOnlyButton.setText("Show All Items");
            incompleteFlag = true;
        }
        else
        {
            listViewer.setItems(list.getToDoList());
            showIncompleteItemsOnlyButton.setText("Show Incomplete Items Only");
            incompleteFlag = false;
        }
    }

    //prevents user from adding an item with a duplicated description
    public boolean isNotDuplicate(String desc){
        if (!list.getToDoList().isEmpty()) {
            for (Item item : list.getToDoList()) {
                if (item.getDescription().equals(desc)) {
                    return false;
                }
            }
        }
        return true;
    }

}