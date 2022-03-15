package ru.mels.tasktracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mels.tasktracking.entity.TaskBoard;

public interface TaskBoardRepository extends JpaRepository<TaskBoard, Long> {
}
