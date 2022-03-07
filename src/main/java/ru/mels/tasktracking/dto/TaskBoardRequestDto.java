package ru.mels.tasktracking.dto;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
public class TaskBoardRequestDto {
    Integer id;
    Integer title;

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }

}
