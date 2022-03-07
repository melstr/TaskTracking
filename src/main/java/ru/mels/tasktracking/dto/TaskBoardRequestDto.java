package ru.mels.tasktracking.dto;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
public class TaskBoardRequestDto {
    Integer id;
    Integer title;
    Integer projectId;

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
