package ru.mels.tasktracking.entity;

import ru.mels.tasktracking.enums.ProjectStatus;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
@Entity
@Table(name = "project")
public class Project extends BaseEntity{
    private String title;
    private String description;
    @Enumerated(STRING)
    private ProjectStatus status;
    @OneToOne(fetch = LAZY, mappedBy = "project", optional = false)
    private TaskBoard taskBoard;

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

    public TaskBoard getTaskBoard() {
        return taskBoard;
    }

    public void setTaskBoard(TaskBoard taskBoard) {
        this.taskBoard = taskBoard;
    }

}
