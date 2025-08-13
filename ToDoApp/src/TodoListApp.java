import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {

    private static ArrayList<String> tasks = new ArrayList<>();
    private static final String FILE_NAME = "tasks.txt";

    public static void main(String[] args) {
        loadTasks();

        Scanner scanner = new Scanner(System.in);
        String command = "";

        System.out.println("--- Console To-Do List Application ---");

        while (true) {
            System.out.println("\nAvailable commands: add, view, update, delete, exit");
            System.out.print("Enter a command: ");
            command = scanner.nextLine().toLowerCase();
            switch (command) {
                case "add":
                    addTask(scanner);
                    break;
                case "view":
                    viewTasks();
                    break;
                case "update":
                    updateTask(scanner);
                    break;
                case "delete":
                    deleteTask(scanner);
                    break;
                case "exit":
                    saveTasks();
                    System.out.println("Tasks saved. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }
    }
    private static void addTask(Scanner scanner) {
        System.out.print("Enter the task to add: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    private static void viewTasks() {
        System.out.println("\n--- Your To-Do List ---");
        if (tasks.isEmpty()) {
            System.out.println("Your to-do list is empty.");
        } else {
            // Display tasks with a 1-based index for user-friendliness
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
        System.out.println("-----------------------");
    }

    private static void updateTask(Scanner scanner) {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter the number of the task to mark as complete: ");
        try {
            int taskNumber = Integer.parseInt(scanner.nextLine());
            if (taskNumber > 0 && taskNumber <= tasks.size()) {
                String task = tasks.get(taskNumber - 1);
                // Prevent marking a task as complete multiple times
                if (!task.endsWith("[COMPLETED]")) {
                    tasks.set(taskNumber - 1, task + " [COMPLETED]");
                    System.out.println("Task marked as complete!");
                } else {
                    System.out.println("This task is already marked as complete.");
                }
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    private static void deleteTask(Scanner scanner) {
        viewTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Enter the number of the task to delete: ");
        try {
            int taskNumber = Integer.parseInt(scanner.nextLine());
            if (taskNumber > 0 && taskNumber <= tasks.size()) {
                tasks.remove(taskNumber - 1);
                System.out.println("Task deleted successfully!");
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    private static void loadTasks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No saved tasks file found. Starting with a new list.");
        } catch (IOException e) {
            System.out.println("Error: Could not load tasks from file. " + e.getMessage());
        }
    }

    private static void saveTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String task : tasks) {
                writer.write(task);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: Could not save tasks to file. " + e.getMessage());
        }
    }
}