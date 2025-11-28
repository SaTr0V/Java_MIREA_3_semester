package com.example.todo_app.service;

import com.example.todo_app.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    public TaskService() {
        // Добавляем несколько тестовых задач
        tasks.add(new Task(counter.getAndIncrement(), "task 1", false));
        tasks.add(new Task(counter.getAndIncrement(), "task 2", true));
        tasks.add(new Task(counter.getAndIncrement(), "task 3", false));
    }

    // Получить все задачи
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    // Добавить новую задачу
    public Task addTask(Task task) {
        task.setId(counter.getAndIncrement());
        if (task.getCompleted() == null) {
            task.setCompleted(false);
        }
        tasks.add(task);
        return task;
    }

    // Удалить задачу по ID
    public boolean deleteTask(Long id) {
        return tasks.removeIf(task -> task.getId().equals(id));
    }

    // Найти задачу по ID (вспомогательный метод)
    public Task findTaskById(Long id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}