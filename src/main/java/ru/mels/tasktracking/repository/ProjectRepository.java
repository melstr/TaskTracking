package ru.mels.tasktracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mels.tasktracking.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
