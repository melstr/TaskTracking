package ru.mels.tasktracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.mels.tasktracking.entity.Task;
import ru.mels.tasktracking.enums.TaskStatus;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
