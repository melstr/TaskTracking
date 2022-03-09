package ru.mels.tasktracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mels.tasktracking.entity.Task;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
