package ucf.assignments;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Rachel Cameron
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ToDoList {

    private final ObservableList<Item> toDoList = FXCollections.observableArrayList();

    public void addItem(String description, String dueDate, boolean complete){
        if(Item.descriptionIsValid(description)){
            toDoList.add(new Item(description, dueDate, complete));
        }
    }

    public void removeItem(Item item){
        toDoList.remove(item);
    }

    public void clearList(){
        toDoList.clear();
    }

    public ObservableList<Item> getToDoList(){
        return toDoList;
    }

}
