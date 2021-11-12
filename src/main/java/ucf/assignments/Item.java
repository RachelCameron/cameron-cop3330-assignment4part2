package ucf.assignments;

public class Item {
    private String description;
    private final String dueDate;
    private boolean complete;

    public Item(String description, String dueDate, boolean complete){
        this.description = description;
        if(dueDateIsValid(dueDate)){
            this.dueDate = dueDate;
        }
        else{
            this.dueDate = "No Due Date";
        }
        this.complete = complete;
    }

    public void setDescription(String description){
        if(descriptionIsValid(description)){
            this.description = description;
        }
    }

    public void setDueDate(String description){
        if(descriptionIsValid(description)){
            this.description = description;
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

    public boolean getCompleted(){
        return complete;
    }

    public static boolean descriptionIsValid(String dueDate){
        return true;
    }

    public static boolean dueDateIsValid(String dueDate){
        return true;
    }


}
