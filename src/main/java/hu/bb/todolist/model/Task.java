package hu.bb.todolist.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Task{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "t_title", nullable = false)
    private String title;

    @Column(name = "t_description")
    private String description;

    @Column(name = "t_due_date",nullable = false)
    private Date dueDate;

    @Column(name = "t_completed",nullable = false)
    private Boolean completed;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "t_task_type_id")
    private TaskType taskType;

}
