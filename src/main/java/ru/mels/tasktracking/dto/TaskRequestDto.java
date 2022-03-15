package ru.mels.tasktracking.dto;

import ru.mels.tasktracking.enums.TaskStatus;

public class TaskRequestDto {

    String description;
    TaskStatus status;
    String title;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
