package org.project.springtask5.model;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TaskStatus status;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false,nullable = false)
    private LocalDateTime createdAt;

}
