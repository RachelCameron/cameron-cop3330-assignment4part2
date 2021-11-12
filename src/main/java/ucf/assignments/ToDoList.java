package ucf.assignments;

import javafx.beans.InvalidationListener;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ToDoList {

    private ObservableList<Item> toDoList;

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
