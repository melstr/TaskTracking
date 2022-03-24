package ru.mels.tasktracking.repository;


import ru.mels.tasktracking.dto.filter.TaskFilterDto;
import ru.mels.tasktracking.entity.Task;

import java.util.List;

/**
 * @author Meleshkin Alexandr
 * @since 20.03.2022
 */
public interface TaskCustomRepository {
    List<Task> findByFilter(TaskFilterDto taskFilterDto);
}
