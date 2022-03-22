package ru.mels.tasktracking.service.mapper;

import ru.mels.tasktracking.dto.ReleaseRequestDto;
import ru.mels.tasktracking.dto.ReleaseResponseDto;
import ru.mels.tasktracking.entity.Release;

public interface ReleaseMapper {
    Release fromRequestDto(ReleaseRequestDto releaseRequestDto);

    ReleaseResponseDto toResponseDto(Release release);

    Release merge(Release target, Release source);
}
