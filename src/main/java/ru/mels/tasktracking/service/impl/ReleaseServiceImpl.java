package ru.mels.tasktracking.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mels.tasktracking.dto.ReleaseRequestDto;
import ru.mels.tasktracking.dto.ReleaseResponseDto;
import ru.mels.tasktracking.entity.Release;
import ru.mels.tasktracking.exception.ReleaseNotFoundException;
import ru.mels.tasktracking.exception.TaskBoardNotFoundException;
import ru.mels.tasktracking.repository.ReleaseRepository;
import ru.mels.tasktracking.repository.TaskBoardRepository;
import ru.mels.tasktracking.service.ReleaseService;
import ru.mels.tasktracking.service.mapper.ReleaseMapper;

@Transactional(readOnly = true)
@Service
public class ReleaseServiceImpl implements ReleaseService {
    private final ReleaseRepository releaseRepository;
    private final ReleaseMapper releaseMapper;
    private final TaskBoardRepository taskBoardRepository;

    public ReleaseServiceImpl(ReleaseRepository releaseRepository,
                              ReleaseMapper releaseMapper, TaskBoardRepository taskBoardRepository) {
        this.releaseRepository = releaseRepository;
        this.releaseMapper = releaseMapper;
        this.taskBoardRepository = taskBoardRepository;
    }

    @Override
    public ReleaseResponseDto findById(Long id) {
        return releaseMapper.toResponseDto(releaseRepository.findById(id)
                .orElseThrow(() -> new ReleaseNotFoundException(id)));
    }

    @Override
    @Transactional
    public ReleaseResponseDto create(Long taskBoardId, ReleaseRequestDto releaseRequestDto) {
        Release release = releaseMapper.fromRequestDto(releaseRequestDto);
        release.setTaskBoard(taskBoardRepository.findById(taskBoardId)
                .orElseThrow(() -> new TaskBoardNotFoundException(taskBoardId)));
        return releaseMapper.toResponseDto(releaseRepository.save(release));
    }

    @Override
    @Transactional
    public ReleaseResponseDto update(Long id, ReleaseRequestDto releaseRequestDto) {
        Release current = releaseRepository.findById(id)
                .orElseThrow(() -> new ReleaseNotFoundException(id));
        Release toUpdate = releaseMapper.merge(current, releaseMapper.fromRequestDto(releaseRequestDto));
        return releaseMapper.toResponseDto(releaseRepository.save(toUpdate));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        releaseRepository.delete(releaseRepository.findById(id)
                .orElseThrow(() -> new ReleaseNotFoundException(id)));
    }
}
