package ru.mels.tasktracking.dto;

import ru.mels.tasktracking.enums.ProjectStatus;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
public class ProjectRequestDto {
    private String title;
    private String description;
    private ProjectStatus status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }
}
