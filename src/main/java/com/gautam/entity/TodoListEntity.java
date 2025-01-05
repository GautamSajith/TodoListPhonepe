package com.gautam.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "com.gautam.entity.TodoListEntity.findAll",
                query = "SELECT t FROM TodoListEntity t"
        )

})
@Table(name = "task_list")
public class TodoListEntity {

    @Id
    @Column(name="id")
    private String id;

    @Column(name="task_id")
    @JsonProperty
    private String taskId;

    @Column(name="description")
    @JsonProperty
    private String description;

    @Column(name="status")
    @JsonProperty
    private String status; // TODO, WIP, DONE

    @Column(name="startDate")
    @JsonProperty
    private String startDate;

    @Column(name="targetDate")
    @JsonProperty
    private String targetDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }
// Getters and Setters...
}
