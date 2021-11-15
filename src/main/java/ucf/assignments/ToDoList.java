package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Rachel Cameron
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ToDoList {

    //makes ObservableList toDoList
    private static final ObservableList<Item> toDoList = FXCollections.observableArrayList();

    //puts item together if description is valid
    public void addItem(String description, String dueDate, boolean complete){
        if(Item.descriptionIsValid(description)){
            toDoList.add(new Item(description, dueDate, complete));
        }
    }

    //for testing purposes
    public void clearList(){
        toDoList.clear();
    }

    //removes item from list
    public void removeItem(Item item){
        toDoList.remove(item);
    }

    //gets toDoList
    public static ObservableList<Item> getToDoList(){
        return toDoList;
    }

}
