package ru.mels.tasktracking.service.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.mels.tasktracking.dto.ReleaseRequestDto;
import ru.mels.tasktracking.dto.ReleaseResponseDto;
import ru.mels.tasktracking.entity.Release;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper
public interface ReleaseMapper {
    @Mapping(target = "taskBoard", ignore = true)
    @Mapping(target = "tasks", ignore = true)
    Release fromRequestDto(ReleaseRequestDto releaseRequestDto);

    @Mapping(target = "taskBoardId", expression = "java(release.getTaskBoard().getId())")
    ReleaseResponseDto toResponseDto(Release release);

    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    Release merge(@MappingTarget Release target, Release source);
}
