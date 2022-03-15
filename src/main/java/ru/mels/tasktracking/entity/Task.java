package ru.mels.tasktracking.entity;

import ru.mels.tasktracking.enums.TaskStatus;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "task")
public class Task extends BaseEntity{
    private String title;
    private String description;

    @ManyToOne(fetch = LAZY)
    Employee reporter;

    @ManyToOne(fetch = LAZY)
    Employee assignee;

    @Enumerated(STRING)
    private TaskStatus status;

    @ManyToOne(fetch = LAZY)
    private Release release;

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

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Release getRelease() {
        return release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }

    public Employee getReporter() {
        return reporter;
    }

    public void setReporter(Employee reporter) {
        this.reporter = reporter;
    }

    public Employee getAssignee() {
        return assignee;
    }

    public void setAssignee(Employee assignee) {
        this.assignee = assignee;
    }
}
