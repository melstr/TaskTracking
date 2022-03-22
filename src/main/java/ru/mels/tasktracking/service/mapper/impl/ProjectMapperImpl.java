package ru.mels.tasktracking.service.mapper.impl;

import org.springframework.stereotype.Component;
import ru.mels.tasktracking.dto.ProjectRequestDto;
import ru.mels.tasktracking.dto.ProjectResponseDto;
import ru.mels.tasktracking.entity.Project;
import ru.mels.tasktracking.service.mapper.ProjectMapper;

@Component
public class ProjectMapperImpl implements ProjectMapper {
    @Override
    public Project fromRequestDto(ProjectRequestDto projectRequestDto) {
        Project project = new Project();
        project.setDescription(projectRequestDto.getDescription());
        project.setTitle(projectRequestDto.getTitle());
        return project;
    }

    @Override
    public ProjectResponseDto toResponseDto(Project source) {
        ProjectResponseDto projectResponseDto = new ProjectResponseDto();
        projectResponseDto.setId(source.getId());
        projectResponseDto.setStatus(source.getStatus());
        projectResponseDto.setTitle(source.getTitle());
        projectResponseDto.setDescription(source.getDescription());
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
            target.setStatus(source.getStatus());
        }
        return target;
    }
}
