package ru.mels.tasktracking.dto;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
public class TaskBoardResponseDto {
    Integer id;
    String title;
    Integer projectId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}
