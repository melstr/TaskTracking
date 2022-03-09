package ru.mels.tasktracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mels.tasktracking.entity.Employee;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
