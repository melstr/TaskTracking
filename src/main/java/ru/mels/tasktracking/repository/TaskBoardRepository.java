package ru.mels.tasktracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mels.tasktracking.entity.TaskBoard;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
public interface TaskBoardRepository extends JpaRepository<TaskBoard, Integer> {
}