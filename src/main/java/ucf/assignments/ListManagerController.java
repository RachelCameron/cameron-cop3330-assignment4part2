package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Rachel Cameron
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.BooleanStringConverter;
import java.io.File;

import static ucf.assignments.Item.descriptionIsValid;
import static ucf.assignments.Item.dueDateIsValid;

public class ListManagerController {

    private final ToDoList list = new ToDoList();

    //2. An item shall have a description
    // - A description shall be between 1 and 256 characters in length
    @FXML private TextField itemField;
    //requires user to describe what their item (task) is between 1 and 256 characters in length

    //3. An item shall have a due date
    // - A due date shall be a valid date within the Gregorian Calendar
    // - A due date shall be displayed to users in the format: YYYY-MM-DD
    @FXML private TextField itemDueDateField;
    //requires user to give their item a valid due date in the format of YYYY-MM-DD

    @FXML private Button addItemButton;

    @FXML private Button clearAllListItemsButton;

    @FXML private Button removeItemButton;

    @FXML private Button saveListButton;

    @FXML private Button loadListButton;

    @FXML private Button showCompleteItemsOnlyButton;

    @FXML private Button showIncompleteItemsOnlyButton;

    @FXML private CheckBox completeCheckBox;

    //9. A user shall be able to mark an item in the list as either complete or incomplete
    public void checkComplete() {
        //allows user to check an item on their list as complete
    }

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

    @FXML
    void initialize() {
        itemViewer.setCellFactory(TextFieldTableCell.forTableColumn());
        itemViewer.setOnEditCommit(event ->
        {
            if (descriptionIsValid(event.getNewValue())) {
                Item item = event.getRowValue();
                item.setDescription(event.getNewValue());
            }
            else{
                listViewer.refresh();
            }
        });
        dueDateViewer.setCellFactory(TextFieldTableCell.forTableColumn());
        dueDateViewer.setOnEditCommit(event ->
        {
            if (dueDateIsValid(event.getNewValue())) {
                Item item = event.getRowValue();
                item.setDueDate(event.getNewValue());
            }
            else{
                listViewer.refresh();
            }
        });
        statusViewer.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
        statusViewer.setOnEditCommit(event -> {
            Item item = event.getRowValue();
            item.setComplete(event.getNewValue());
        });
    }

    @FXML
    void addItemButtonClicked(ActionEvent event) {
        //calls addItem()
        if(descriptionIsValid(itemField.getText()) && dueDateIsValid(itemDueDateField.getText()) && isNotDuplicate(itemField.getText())){
            addItem();
            displayItem();
            clear();
        }
        else{
            itemField.setText("One or more invalid entries, please try again.");
            itemDueDateField.setText("One or more invalid entries, please try again.");
        }
    }

    //4. A user shall be able to add a new item to the list
    public void addItem() {
        //allows user to add an item to their list populated with the above criteria (description and due date)
        list.addItem(itemField.getText(), itemDueDateField.getText(), completeCheckBox.isSelected());
    }

    private void displayItem(){
        //display the created item and add to the index
        itemViewer.setCellValueFactory(new PropertyValueFactory<>("item"));
        dueDateViewer.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        statusViewer.setCellValueFactory(new PropertyValueFactory<>("status"));
        listViewer.getItems().add(list.getToDoList().get(index));
        index++;
    }

    private void clear(){
        //clears the text fields
        itemField.clear();
        itemDueDateField.clear();
        completeCheckBox.setSelected(false);
    }

    @FXML
    void clearAllListItemsButtonClicked(ActionEvent event) {
        //calls clearAllListItems()
        clearAllListItems();
    }

    //6. A user shall be able to clear the list of all items
    public void clearAllListItems() {
        //removes all the items from the list
        list.getToDoList().clear();
        listViewer.getItems().clear();
        index = 0;
        clear();
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
        if(selectedItem != null){
            list.removeItem(selectedItem);
            index--;
            listViewer.getItems().remove(selectedItem);
        }
    }

    @FXML
    void saveListButtonClicked(ActionEvent event) {
        //calls saveList()
    }

    //13. A user shall be able to save the list (and all of its items) to external storage
    public void saveList(File fileName) {
        //saves the current list
    }

    @FXML
    void loadListButtonClicked(ActionEvent event) {
        //calls loadList()
    }

    //14. A user shall be able to load a list (and all of its items) from external storage
    public void loadList(File fileName) {
        //loads list selected by user
    }

    @FXML
    void showCompleteItemsOnlyButtonClicked(ActionEvent event) {
        //calls showCompleteItemsOnly()
    }

    //12. A user shall be able to display only the completed items in the list
    public void showCompleteItemsOnly() {
        //only shows the completed items in the list viewer
    }

    @FXML
    void showIncompleteItemsOnlyButtonClicked(ActionEvent event) {
        //calls showIncompleteItemsOnly()
    }

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

    //11. A user shall be able to display only the incomplete items in the list
    public void showIncompleteItemsOnly() {
        //only shows the incompleted items in the list viewer
    }

}