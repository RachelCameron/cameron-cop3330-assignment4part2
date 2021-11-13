package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Rachel Cameron
 */

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.File;

public class ListManagerController {

    private final ToDoList list = new ToDoList();

    //2. An item shall have a description
    // - A description shall be between 1 and 256 characters in length
    @FXML
    private TextField itemField;
    //requires user to describe what their item (task) is between 1 and 256 characters in length

    //3. An item shall have a due date
    // - A due date shall be a valid date within the Gregorian Calendar
    // - A due date shall be displayed to users in the format: YYYY-MM-DD
    @FXML
    private TextField itemDueDateField;
    //requires user to give their item a valid due date in the format of YYYY-MM-DD

    //9. A user shall be able to mark an item in the list as either complete or incomplete
    @FXML
    private CheckBox completeCheckBox;

    public void checkComplete() {
        //allows user to check an item on their list as complete
    }

    //1. The application shall manage a single list of items
    // - The list shall have the capacity to store at least 100 unique items
    //10. A user shall be able to display all of the existing items in the list
    @FXML
    private TableView<?> listViewer;
    //view of the list

    //7. A user shall be able to edit the description of an item within the list
    @FXML
    private TableColumn<?, ?> itemViewer;
    //view of the list items

    //8. A user shall be able to edit the due date of an item within the list
    @FXML
    private TableColumn<?, ?> dueDateViewer;
    //view of the list items' due dates

    @FXML
    private TableColumn<?, ?> statusViewer;
    //view of the list items' statuses (complete or incomplete)

    //4. A user shall be able to add a new item to the list
    @FXML
    private Button addItemButton;

    @FXML
    void addItemButtonClicked(ActionEvent event) {
        //calls addItem()
        list.addItem(itemField.getText(), itemDueDateField.getText(), completeCheckBox.isSelected());
    }

    public void addItem() {
        //allows user to add an item to their list populated with the above criteria (description and due date)

    }

    //6. A user shall be able to clear the list of all items
    @FXML
    private Button clearAllListItemsButton;

    @FXML
    void clearAllListItemsButtonClicked(ActionEvent event) {
        //calls clearAllListItems()
    }

    public void clearAllListItems() {
        //removes all the items from the list
    }

    //5. A user shall be able to remove an item from the list
    @FXML
    private Button removeItemButton;

    @FXML
    void removeItemButtonClicked(ActionEvent event) {
        //calls removeItem()
    }

    public void removeItem() {
        //removes an item from the list
    }

    //13. A user shall be able to save the list (and all of its items) to external storage
    @FXML
    private Button saveListButton;

    @FXML
    void saveListButtonClicked(ActionEvent event) {
        //calls saveList()
    }

    public void saveList(File fileName) {
        //saves the current list
    }

    //14. A user shall be able to load a list (and all of its items) from external storage
    @FXML
    private Button loadListButton;

    @FXML
    void loadListButtonClicked(ActionEvent event) {
        //calls loadList()
    }

    public void loadList(File fileName) {
        //loads list selected by user
    }

    //12. A user shall be able to display only the completed items in the list
    @FXML
    private Button showCompleteItemsOnlyButton;

    @FXML
    void showCompleteItemsOnlyButtonClicked(ActionEvent event) {
        //calls showCompleteItemsOnly()
    }

    public void showCompleteItemsOnly() {
        //only shows the completed items in the list viewer
    }

    //11. A user shall be able to display only the incomplete items in the list
    @FXML
    private Button showIncompleteItemsOnlyButton;

    @FXML
    void showIncompleteItemsOnlyButtonClicked(ActionEvent event) {
        //calls showIncompleteItemsOnly()
    }

    public void showIncompleteItemsOnly() {
        //only shows the incompleted items in the list viewer
    }

}