package ru.mels.tasktracking.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mels.tasktracking.dto.EmployeeRequestDto;
import ru.mels.tasktracking.dto.EmployeeResponseDto;
import ru.mels.tasktracking.entity.Employee;
import ru.mels.tasktracking.exception.EmployeeNotFoundException;
import ru.mels.tasktracking.repository.EmployeeRepository;
import ru.mels.tasktracking.service.EmployeeService;
import ru.mels.tasktracking.service.mapper.EmployeeMapper;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    @Transactional
    public EmployeeResponseDto create(EmployeeRequestDto employeeRequestDto) {
        return employeeMapper.toResponseDto(
                employeeRepository.save(
                        employeeMapper.fromRequestDto(employeeRequestDto)));
    }

    @Override
    public EmployeeResponseDto findById(Long id) {
        return employeeRepository.findById(id)
                .map(employeeMapper::toResponseDto)
                .orElseThrow(() ->new EmployeeNotFoundException(id));
    }

    @Override
    @Transactional
    public EmployeeResponseDto update(Long id, EmployeeRequestDto employeeRequestDto) {
        Employee current = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        Employee toUpdate = employeeMapper.merge(current, employeeMapper.fromRequestDto(employeeRequestDto));
        return employeeMapper.toResponseDto(employeeRepository.save(toUpdate));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Employee toDelete = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        employeeRepository.delete(toDelete);
    }
}
