package ru.mels.tasktracking.mapper.impl;

import ru.mels.tasktracking.dto.ProjectRequestDto;
import ru.mels.tasktracking.dto.ProjectResponseDto;
import ru.mels.tasktracking.entity.Project;
import ru.mels.tasktracking.mapper.ProjectMapper;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
public class ProjectMapperImpl implements ProjectMapper {
    @Override
    public Project fromRequestDto(ProjectRequestDto projectRequestDto) {
        Project project = new Project();
        project.setDescription(projectRequestDto.getDescription());
        project.setStatus(projectRequestDto.getStatus());
        project.setTitle(projectRequestDto.getTitle());
        return project;
    }

    @Override
    public ProjectResponseDto toResponseDto(Project project) {
        ProjectResponseDto projectResponseDto = new ProjectResponseDto();
        projectResponseDto.setId(project.getId());
        projectResponseDto.setStatus(projectResponseDto.getStatus());
        projectResponseDto.setTitle(projectResponseDto.getTitle());
        projectResponseDto.setDescription(projectResponseDto.getDescription());
        return projectResponseDto;
    }

    @Override
    public Project merge(Project target, Project source) {
        if(source.getTitle() != null){
            target.setTitle(source.getTitle());
        }
        if(source.getDescription() != null){
            target.setDescription(source.getDescription());
        }
        if(source.getStatus() != null){
            target.getStatus();
        }
        return target;
    }
}
