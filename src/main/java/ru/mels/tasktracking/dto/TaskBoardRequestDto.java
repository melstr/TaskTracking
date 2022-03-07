package ru.mels.tasktracking.dto;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
public class TaskBoardRequestDto {
    Integer id;
    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
