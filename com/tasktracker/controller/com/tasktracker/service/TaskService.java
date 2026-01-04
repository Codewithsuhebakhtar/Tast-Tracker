package com.tasktracker.service;

import com.tasktracker.dao.TaskRepository;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class TaskService {

    public static void addTask(Scanner sc) throws IOException {
        System.out.print("Enter task: ");
        String description = sc.nextLine();
        TaskRepository.saveTask("[ ] " + description);
        System.out.println("Task added successfully!");
    }

    public static void viewTasks() throws IOException {
        List<String> tasks = TaskRepository.getAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        int i = 1;
        for (String task : tasks) {
            System.out.println(i++ + ". " + task);
        }
    }

    public static void markDone(Scanner sc) throws IOException {
        List<String> tasks = TaskRepository.getAllTasks();
        viewTasks();

        System.out.print("Enter task number to mark done: ");
        int num = sc.nextInt();
        sc.nextLine();

        tasks.set(num - 1, tasks.get(num - 1).replace("[ ]", "[✓]"));
        TaskRepository.saveAllTasks(tasks);

        System.out.println("Task marked as done!");
    }

    public static void deleteTask(Scanner sc) throws IOException {
        List<String> tasks = TaskRepository.getAllTasks();
        viewTasks();

        System.out.print("Enter task number to delete: ");
        int num = sc.nextInt();
        sc.nextLine();

        tasks.remove(num - 1);
        TaskRepository.saveAllTasks(tasks);

        System.out.println("Task deleted!");
    }
}
