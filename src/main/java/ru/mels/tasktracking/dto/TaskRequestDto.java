package ru.mels.tasktracking.dto;

import ru.mels.tasktracking.enums.TaskStatus;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
public class TaskRequestDto {

    String description;
    TaskStatus status;
    String title;
    Integer releaseId;
    Integer taskBoardId;
    Integer assigneeId;
    Integer reporterId;

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

    public Integer getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(Integer releaseId) {
        this.releaseId = releaseId;
    }

    public Integer getTaskBoardId() {
        return taskBoardId;
    }

    public void setTaskBoardId(Integer taskBoardId) {
        this.taskBoardId = taskBoardId;
    }

    public Integer getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(Integer assigneeId) {
        this.assigneeId = assigneeId;
    }

    public Integer getReporterId() {
        return reporterId;
    }

    public void setReporterId(Integer reporterId) {
        this.reporterId = reporterId;
    }
}
