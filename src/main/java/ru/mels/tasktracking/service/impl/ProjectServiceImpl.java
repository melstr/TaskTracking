package ru.mels.tasktracking.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mels.tasktracking.dto.ProjectRequestDto;
import ru.mels.tasktracking.dto.ProjectResponseDto;
import ru.mels.tasktracking.entity.Project;
import ru.mels.tasktracking.enums.ProjectStatus;
import ru.mels.tasktracking.exception.CannotCloseTheProjectException;
import ru.mels.tasktracking.exception.ProjectNotFoundException;
import ru.mels.tasktracking.repository.ProjectRepository;
import ru.mels.tasktracking.service.ProjectService;
import ru.mels.tasktracking.service.mapper.ProjectMapper;

import static ru.mels.tasktracking.enums.ProjectStatus.CLOSED;

@Service
@Transactional(readOnly = true)
public class ProjectServiceImpl implements ProjectService {
    private final ProjectMapper projectMapper;
    private final ProjectRepository projectRepository;
    ;
    public ProjectServiceImpl(ProjectMapper projectMapper,
                              ProjectRepository projectRepository) {
        this.projectMapper = projectMapper;
        this.projectRepository = projectRepository;
    }

    @Override
    @Transactional
    public ProjectResponseDto create(ProjectRequestDto projectRequestDto) {
        return projectMapper.toResponseDto(projectRepository.save(
                projectMapper.fromRequestDto(projectRequestDto)));
    }

    @Override
    public ProjectResponseDto findById(Long id) {
        return projectRepository.findById(id)
                .map(projectMapper::toResponseDto)
                .orElseThrow(() -> new ProjectNotFoundException(id));
    }

    @Override
    @Transactional
    public ProjectResponseDto update(Long id, ProjectRequestDto projectRequestDto) {
        Project current = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
        Project toUpdate = projectMapper.merge(current,
                projectMapper.fromRequestDto(projectRequestDto));
        return projectMapper.toResponseDto(
                projectRepository.save(toUpdate));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Project toDelete = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
        projectRepository.delete(toDelete);
    }

    @Override
    @Transactional
    public ProjectResponseDto updateStatus(Long id, ProjectStatus projectStatus) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
        Long undoneTasks = projectRepository.countUndoneTasks(project);
        if(undoneTasks != 0 && projectStatus.equals(CLOSED)){
            throw new CannotCloseTheProjectException(id, undoneTasks);
        }
        project.setStatus(projectStatus);
        return projectMapper.toResponseDto(projectRepository.save(project));
    }
}
