package com.tasktracker.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private static final String FILE_NAME = "tasks.txt";

    // Save single task
    public static void saveTask(String task) throws IOException {
        FileWriter fw = new FileWriter(FILE_NAME, true);
        fw.write(task + System.lineSeparator());
        fw.close();
    }

    // Read all tasks
    public static List<String> getAllTasks() throws IOException {
        List<String> tasks = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return tasks;
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            tasks.add(line);
        }
        br.close();

        return tasks;
    }

    // Overwrite all tasks (used for update/delete)
    public static void saveAllTasks(List<String> tasks) throws IOException {
        FileWriter fw = new FileWriter(FILE_NAME);
        for (String task : tasks) {
            fw.write(task + System.lineSeparator());
        }
        fw.close();
    }
}
