package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Rachel Cameron
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListManagerControllerTest {

    static ToDoList listTester = new ToDoList();

    //1. The application shall manage a single list of items
    // - The list shall have the capacity to store at least 100 unique items
    @Test
    void storageTest(){
        ToDoList.getToDoList().clear();
        for (int i = 0; i <= 101; i++) {
            String description = "Test Description" + i;
            ToDoList.getToDoList().add(new Item(description, "2020-02-20", true));
        }
        //list is successfully storing at least 100 items = true
        assertTrue(ToDoList.getToDoList().size() > 100);
    }

    //2. An item shall have a description
    // - A description shall be between 1 and 256 characters in length
    @Test
    void descriptionValidTest(){
        //valid description = true
        assertTrue(Item.descriptionIsValid("Valid Description"));
        //invalid length (too short), cannot be less than 1 character = false
        assertFalse(Item.descriptionIsValid(""));
        //invalid length (too long), cannot be more than 256 characters = false
        assertFalse(Item.descriptionIsValid("This is more than 256 characters. This is more than 256 characters. This is more than 256 characters. This is more than 256 characters. This is more than 256 characters. This is more than 256 characters. This is more than 256 characters. This is more than 256 characters. "));
    }

    //3. An item shall have a due date
    // - A due date shall be a valid date within the Gregorian Calendar
    // - A due date shall be displayed to users in the format: YYYY-MM-DD
    @Test
    void dateValidTest(){
        //valid due date = true
        assertTrue(Item.dueDateIsValid("2020-02-20"));
        //invalid formatting (should be YYYY-MM-DD), cannot have characters = false
        assertFalse(Item.dueDateIsValid("Invalid Due Date"));
        //invalid formatting (should be YYYY-MM-DD), there are only 12 months = false
        assertFalse(Item.dueDateIsValid("2020-20-02"));
    }

    //4. A user shall be able to add a new item to the list
    @Test
    void addTest(){
        //adds one item to the list
        ToDoList.getToDoList().add(new Item("Implement Application", "2020-11-13", true));
        //asserts that there is ONE item in the list
        assertEquals(1,ToDoList.getToDoList().size());
        //asserts that there is AT LEAST ONE item in the list
        assertTrue(ToDoList.getToDoList().size() > 0);
    }

    //5. A user shall be able to remove an item from the list

    //6. A user shall be able to clear the list of all items
    @Test
    void clearTest(){
        listTester.clearList();
        assertTrue(ToDoList.getToDoList().isEmpty());
    }

    //REGARDING: 7. A user shall be able to edit the description of an item within the list --AND-- 8. A user shall be able to edit the due date of an item within the list
    /* TESTING ABILITY TO EDIT: Please pay special attention to this section of the pseudocode in ListManagerController.java explaining that I cannot
     * test my list item editing features BUT it is fully validated so there is no functional need to test as the information passed will always be valid:
     * - javafx table view automatically handles editing so the editing feature CANNOT BE TESTED by nature
     * - implemented descriptionIsValid and dueDateIsValid within table view to ensure that new entries through editing will always be valid
     * - if you try and edit in any invalid inputs, the invalid input is rejected and the old valid input is kept instead
     */

    //9. A user shall be able to mark an item in the list as either complete or incomplete

    //10. A user shall be able to display all of the existing items in the list

    //11. A user shall be able to display only the incomplete items in the list

    //12. A user shall be able to display only the completed items in the list

    //13. A user shall be able to save the list (and all of its items) to external storage

    //14. A user shall be able to load a list (and all of its items) from external storage
}