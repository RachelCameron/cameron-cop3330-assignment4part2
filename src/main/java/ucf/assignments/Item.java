package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Rachel Cameron
 */

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Item {
    private String description;
    private String dueDate;
    private boolean complete;

    public Item(String description, String dueDate, boolean complete){
        this.description = description;
        this.dueDate = dueDate;
        this.complete = complete;
    }

    public void setDescription(String description){
        if(descriptionIsValid(description)){
            this.description = description;
        }
    }

    public void setDueDate(String dueDate){
        if(dueDateIsValid(dueDate)){
            this.dueDate = dueDate;
        }
        else{
            this.dueDate = "Invalid Due Date";
        }
    }

    public void setComplete(boolean complete){
        this.complete = complete;
    }

    public String getDescription(){
        //used to get the description
        return description;
    }

    public String getDueDate(){
        return dueDate;
    }

    public boolean getComplete(){
        return complete;
    }

    public static boolean descriptionIsValid(String description){
        return description.length() >= 1 && description.length() <= 256 && !(description.equals("One or more invalid entries, please try again."));
    }

    public static boolean dueDateIsValid(String dueDate){
        try {
            LocalDate.parse((dueDate));
        } catch (DateTimeParseException e){
            return false;
        }
        return true;
    }

}
