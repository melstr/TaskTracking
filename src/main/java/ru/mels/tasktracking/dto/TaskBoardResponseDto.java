package ru.mels.tasktracking.dto;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
public class TaskBoardResponseDto {
    Integer id;
    Integer title;
    Integer projectId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
