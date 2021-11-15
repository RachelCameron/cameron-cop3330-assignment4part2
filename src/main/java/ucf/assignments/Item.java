package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Rachel Cameron
 */

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Item {
    //declaring item description
    private String description;
    //declaring item due date (string to handle the proper "YYYY-MM-DD" format's dashes)
    private String dueDate;
    //declaring completion status (boolean indicates if true/complete or false/incomplete)
    private boolean complete;

    //constructing an item, made up of a description, due date, and completion status
    public Item(String description, String dueDate, boolean complete){
        //adding item elements to item
        this.description = description;
        this.dueDate = dueDate;
        this.complete = complete;
    }

    //sets the description
    public void setDescription(String description){
        //will only set the description if valid
        if(descriptionIsValid(description)){
            this.description = description;
        }
    }

    //sets the due date
    public void setDueDate(String dueDate){
        //will only set the due date if valid
        if(dueDateIsValid(dueDate)){
            this.dueDate = dueDate;
        }
        else{
            this.dueDate = "Invalid Due Date";
        }
    }

    //sets the completion status
    public void setComplete(boolean complete){
        this.complete = complete;
    }

    //gets item description
    public String getDescription(){
        return description;
    }

    //gets item due date
    public String getDueDate(){
        return dueDate;
    }

    //gets item completion status
    public boolean getComplete(){
        return complete;
    }

    //for testing purposes
    public static boolean getCompleteTest(){
        return true;
    }


    //makes sure that the description is valid (between 1-256 characters and not an error message)
    public static boolean descriptionIsValid(String description){
        return description.length() >= 1 && description.length() <= 256 && !(description.equals("One or more invalid entries, please try again."));
    }

    //makes sure the due date is valid by checking it against LocalDate to determine if within the Gregorian Calendar and formatted as YYYY-MM-DD
    public static boolean dueDateIsValid(String dueDate){
        try {
            //i love LocalDate!
            LocalDate.parse((dueDate));
        } catch (DateTimeParseException e){
            return false;
        }
        return true;
    }

}
