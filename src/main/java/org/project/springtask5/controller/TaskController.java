package org.project.springtask5.controller;

import lombok.AllArgsConstructor;
import org.project.springtask5.model.Task;
import org.project.springtask5.model.TaskStatus;
import org.project.springtask5.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public Iterable<Task> getTasks() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public Task getTasksById(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.save(task);
    }

    @DeleteMapping("/id")
    public void deleteTaskById(@PathVariable Long id) {
        taskService.delete(id);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskService.findByStatus(status);
    }

    @PutMapping("/setstatus/{id}/{status}")
    public ResponseEntity<Task> setTaskStatus(@PathVariable Long id, @PathVariable TaskStatus status) {
        Optional<Task> optionalTask = Optional.ofNullable(taskService.findById(id));

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setStatus(status);
            Task updatedTask = taskService.save(task);
            return ResponseEntity.ok(updatedTask);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
