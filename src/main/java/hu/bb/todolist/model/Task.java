package hu.bb.todolist.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "task")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task extends BaseEntity{

    @Column(name = "t_title", nullable = false)
    private String title;

    @Column(name = "t_description")
    private String description;

    @Column(name = "t_due_date",nullable = false)
    private Date dueDate;

    @Column(name = "t_completed",nullable = false)
    private Boolean completed;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "t_task_type_id",nullable = false)
    private TaskType taskType;

}
