package com.tasktracker.controller;

import com.tasktracker.service.TaskService;
import java.io.IOException;
import java.util.Scanner;

public class TaskTracker {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println("\n=== TASK TRACKER ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> TaskService.addTask(sc);
                case 2 -> TaskService.viewTasks();
                case 3 -> TaskService.markDone(sc);
                case 4 -> TaskService.deleteTask(sc);
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
