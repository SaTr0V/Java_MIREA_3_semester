package com.example.todo_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoAppApplication.class, args);
    }

	// Тестирование производится с помощью команд

	// Отслеживать задачи можно либо командой
	// curl -X GET http://localhost:8080/tasks
	// либо открыв http://localhost:8080/tasks в браузере

	// Добавить задачу
	// curl -X POST http://localhost:8080/tasks -H "Content-Type: application/json" -d '{"title": "New task", "completed": false}'

	// Удалить задачу
	// curl -X DELETE http://localhost:8080/tasks/<task_id>
}