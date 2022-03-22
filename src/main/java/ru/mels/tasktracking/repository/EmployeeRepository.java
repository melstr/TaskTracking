package ru.mels.tasktracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mels.tasktracking.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
