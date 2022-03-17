package ru.mels.tasktracking.dto.filter;

import ru.mels.tasktracking.enums.TaskStatus;

/**
 * @author Meleshkin Alexandr
 * @since 20.03.2022
 */
public class TaskFilterDto {
    String description;
    TaskStatus status;
    String title;
    Long releaseId;
    Long assigneeId;
    Long reporterId;
    Long projectID;
    Long taskBoardID;

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

    public Long getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(Long releaseId) {
        this.releaseId = releaseId;
    }

    public Long getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(Long assigneeId) {
        this.assigneeId = assigneeId;
    }

    public Long getReporterId() {
        return reporterId;
    }

    public void setReporterId(Long reporterId) {
        this.reporterId = reporterId;
    }

    public Long getProjectID() {
        return projectID;
    }

    public void setProjectID(Long projectID) {
        this.projectID = projectID;
    }

    public Long getTaskBoardID() {
        return taskBoardID;
    }

    public void setTaskBoardID(Long taskBoardID) {
        this.taskBoardID = taskBoardID;
    }
}
