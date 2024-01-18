//CSC 223
//Piper Howell

public class ToDoItem implements Comparable<ToDoItem> {
    private String description;
    private int priority;

    public ToDoItem(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(ToDoItem other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Description: " + description + ", Priority: " + priority;
    }
}
