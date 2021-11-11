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

import java.io.File;

public class ListManagerController {

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

    //9. A user shall be able to mark an item in the list as either complete or incomplete
    public void checkComplete(String item, Object list) {
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

    //4. A user shall be able to add a new item to the list
    @FXML
    void addItemButtonClicked(ActionEvent event) {
        //calls addItem()
    }

    //4. A user shall be able to add a new item to the list
    public void addItem(String item, String itemDueDate, Object list) {
        //allows user to add an item to their list populated with the above criteria (description and due date)
    }

    //6. A user shall be able to clear the list of all items
    @FXML
    private Button clearAllListItemsButton;

    //6. A user shall be able to clear the list of all items
    @FXML
    void clearAllListItemsButtonClicked(ActionEvent event) {
        //calls clearAllListItems()
    }

    //6. A user shall be able to clear the list of all items
    public void clearAllListItems(String item, Object list) {
        //removes all the items from the list
    }

    //5. A user shall be able to remove an item from the list
    @FXML
    private Button removeItemButton;

    //5. A user shall be able to remove an item from the list
    @FXML
    void removeItemButtonClicked(ActionEvent event) {
        //calls removeItem()
    }

    //5. A user shall be able to remove an item from the list
    public void removeItem(String item, Object list) {
        //removes an item from the list
    }

    //13. A user shall be able to save the list (and all of its items) to external storage
    @FXML
    private Button saveListButton;

    //13. A user shall be able to save the list (and all of its items) to external storage
    @FXML
    void saveListButtonClicked(ActionEvent event) {
        //calls saveList()
    }

    //13. A user shall be able to save the list (and all of its items) to external storage
    public void saveList(File fileName) {
        //saves the current list
    }

    //14. A user shall be able to load a list (and all of its items) from external storage
    @FXML
    private Button loadListButton;

    //14. A user shall be able to load a list (and all of its items) from external storage
    @FXML
    void loadListButtonClicked(ActionEvent event) {
        //calls loadList()
    }

    //14. A user shall be able to load a list (and all of its items) from external storage
    public void loadList(File fileName) {
        //loads list selected by user
    }

    //12. A user shall be able to display only the completed items in the list
    @FXML
    private Button showCompleteItemsOnlyButton;

    //12. A user shall be able to display only the completed items in the list
    @FXML
    void showCompleteItemsOnlyButtonClicked(ActionEvent event) {
        //calls showCompleteItemsOnly()
    }

    //12. A user shall be able to display only the completed items in the list
    public void showCompleteItemsOnly(Object completeItems) {
        //only shows the completed items in the list viewer
    }

    //11. A user shall be able to display only the incomplete items in the list
    @FXML
    private Button showIncompleteItemsOnlyButton;

    //11. A user shall be able to display only the incomplete items in the list
    @FXML
    void showIncompleteItemsOnlyButtonClicked(ActionEvent event) {
        //calls showIncompleteItemsOnly()
    }

    //11. A user shall be able to display only the incomplete items in the list
    public void showIncompleteItemsOnly(Object incompleteItems) {
        //only shows the incompleted items in the list viewer
    }

}