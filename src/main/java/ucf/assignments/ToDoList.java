package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

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
        ObservableList<Item> toDoList = FXCollections.observableArrayList();
        return toDoList;
    }

}
