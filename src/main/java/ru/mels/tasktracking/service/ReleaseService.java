package ru.mels.tasktracking.service;

import ru.mels.tasktracking.dto.ReleaseRequestDto;
import ru.mels.tasktracking.dto.ReleaseResponseDto;


public interface ReleaseService {
    ReleaseResponseDto get(Long id);

    ReleaseResponseDto create(Long taskBoardId, ReleaseRequestDto releaseRequestDto);

    ReleaseResponseDto update(Long id, ReleaseRequestDto releaseRequestDto);

    void delete(Long id);
}
