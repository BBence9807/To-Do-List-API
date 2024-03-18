package hu.bb.todolist.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "taskType")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskType extends BaseEntity{

    @Column(name = "tt_name",nullable = false,unique = true)
    private String name;
}
