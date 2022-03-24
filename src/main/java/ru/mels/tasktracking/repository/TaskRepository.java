package ru.mels.tasktracking.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import ru.mels.tasktracking.entity.Project;
import ru.mels.tasktracking.entity.Task;
import ru.mels.tasktracking.enums.TaskStatus;


public interface TaskRepository extends JpaRepository<Task, Long>,
        QuerydslPredicateExecutor<Task> {
    @Query("SELECT t FROM Task t " +
            "JOIN t.release r " +
            "JOIN r.taskBoard tb " +
            "WHERE tb.project = :project AND t.status <> 'DONE'")
    Page<Task> getAllUndoneTasksByProjectId(Project project, Pageable pageable);

    Long countByReleaseIdAndStatusNot(Long releaseId, TaskStatus status);
}
