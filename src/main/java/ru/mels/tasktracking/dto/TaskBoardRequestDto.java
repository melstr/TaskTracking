package ru.mels.tasktracking.dto;

public class TaskBoardRequestDto {
    Long id;
    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
