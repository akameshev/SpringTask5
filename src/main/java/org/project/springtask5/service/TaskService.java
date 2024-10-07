package org.project.springtask5.service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.project.springtask5.model.Task;
import org.project.springtask5.model.TaskStatus;
import org.project.springtask5.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }
    public Task findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }
    public Task save(Task task) {
        return taskRepository.save(task);
    }
    public Task update(Long id,Task task) {
        Task taskToUpdate = findById(id);
        taskToUpdate.setName(task.getName());
        taskToUpdate.setStatus(task.getStatus());
        return taskRepository.save(taskToUpdate);
    }
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
    public List<Task> findByStatus(TaskStatus status) {
        List<Task> tasks = new ArrayList<>();
        for (Task task : findAll()) {
            if (task.getStatus() == status) {
                tasks.add(task);
            }
        }
        return tasks;
    }
}
