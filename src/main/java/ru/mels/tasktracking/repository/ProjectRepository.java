package ru.mels.tasktracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.mels.tasktracking.entity.Project;
import ru.mels.tasktracking.entity.Task;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Task t " +
            "JOIN t.release r " +
            "JOIN r.taskBoard tb " +
            "JOIN tb.project p")
    Project getProjectByTask(Task task);

    @Query("SELECT COUNT(t) FROM Task t " +
            "JOIN t.release r " +
            "JOIN r.taskBoard tb " +
            "WHERE tb.project = :project AND t.status <> 'DONE'")
    Long countUndoneTasks(Project project);
}
