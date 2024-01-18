//CSC 223
//Piper Howell

import java.util.Scanner;

public class ToDoList {
    private static final int MAX_ITEMS = 100;
    private PriorityQueue<ToDoItem> priorityQueue;
    private int itemCount;

    public ToDoList() {
        priorityQueue = new PriorityQueue<>(MAX_ITEMS);
        itemCount = 0;
    }

    public void addItem(String description, int priority) throws PriQOverflowException {
        ToDoItem newItem = new ToDoItem(description, priority);
        priorityQueue.enqueue(newItem);
        itemCount++;
        System.out.println("New item added: " + newItem);
    }

    public void printList() {
        System.out.println("ToDo List:");
        System.out.println("----------");
        ToDoItem[] items = priorityQueue.toArray();
        for (ToDoItem item : items) {
            System.out.println(item);
        }
        System.out.println("----------");
    }

    public void promoteTask(String description, int priority) {
        ToDoItem[] items = priorityQueue.toArray();
        for (ToDoItem item : items) {
            if (item.getDescription().equals(description)) {
                int newPriority = item.getPriority() - priority;
                item.setPriority(newPriority);
                System.out.println("Task '" + item.getDescription() + "' promoted to priority " + newPriority);
                return;
            }
        }
        System.out.println("Task '" + description + "' not found.");
    }

    public void demoteTask(String description, int priority) {
        ToDoItem[] items = priorityQueue.toArray();
        for (ToDoItem item : items) {
            if (item.getDescription().equals(description)) {
                int newPriority = item.getPriority() + priority;
                item.setPriority(newPriority);
                System.out.println("Task '" + item.getDescription() + "' demoted to priority " + newPriority);
                return;
            }
        }
        System.out.println("Task '" + description + "' not found.");
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Menu:");
            System.out.println("1. Add a new item");
            System.out.println("2. Print the entire list");
            System.out.println("3. Promote a task");
            System.out.println("4. Demote a task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter item priority: ");
                    int priority = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    try {
                        toDoList.addItem(description, priority);
                    } catch (PriQOverflowException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    toDoList.printList();
                    break;
                case 3:
                    System.out.print("Enter the description of the task to promote: ");
                    String promoteDescription = scanner.nextLine();
                    System.out.print("Enter the priority to promote: ");
                    int promotePriority = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    toDoList.promoteTask(promoteDescription, promotePriority);
                    break;
                case 4:
                    System.out.print("Enter the description of the task to demote: ");
                    String demoteDescription = scanner.nextLine();
                    System.out.print("Enter the priority to demote: ");
                    int demotePriority = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    toDoList.demoteTask(demoteDescription, demotePriority);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
