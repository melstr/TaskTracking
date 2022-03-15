package ru.mels.tasktracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mels.tasktracking.entity.Release;

public interface ReleaseRepository extends JpaRepository<Release, Long> {
}
