package ru.mels.tasktracking.mapper;

import ru.mels.tasktracking.dto.ReleaseRequestDto;
import ru.mels.tasktracking.dto.ReleaseResponseDto;
import ru.mels.tasktracking.entity.Release;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
public interface ReleaseMapper {
    Release fromRequestDto(ReleaseRequestDto releaseRequestDto);

    ReleaseResponseDto toResponseDto(Release release);

    Release merge(Release target, Release source);
}
