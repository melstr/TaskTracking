package ru.mels.tasktracking.entity;

import ru.mels.tasktracking.enums.EmployeeRole;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

import static javax.persistence.CascadeType.*;
import static javax.persistence.EnumType.STRING;
import static ru.mels.tasktracking.enums.EmployeeRole.USER;

@Entity
@Table(name = "employee")
public class Employee extends BaseEntity{
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String nickname;
    private String password;
    @Enumerated(STRING)
    private EmployeeRole role = USER;

    public EmployeeRole getRole() {
        return role;
    }

    public void setRole(EmployeeRole role) {
        this.role = role;
    }

    @OneToMany(mappedBy = "reporter",
            orphanRemoval = true,
            cascade = {PERSIST, MERGE, DETACH, REFRESH}
    )
    private Set<Task> createdTasks;

    @OneToMany(mappedBy = "assignee",
            orphanRemoval = true,
            cascade = {PERSIST, MERGE, DETACH, REFRESH}
    )
    private Set<Task> assignedTasks;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Task> getCreatedTasks() {
        return createdTasks;
    }

    public void setCreatedTasks(Set<Task> createdTasks) {
        this.createdTasks = createdTasks;
    }

    public Set<Task> getAssignedTasks() {
        return assignedTasks;
    }

    public void setAssignedTasks(Set<Task> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }
}
