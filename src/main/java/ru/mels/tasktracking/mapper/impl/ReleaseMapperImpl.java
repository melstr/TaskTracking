package ru.mels.tasktracking.mapper.impl;

import org.springframework.stereotype.Component;
import ru.mels.tasktracking.dto.ReleaseRequestDto;
import ru.mels.tasktracking.dto.ReleaseResponseDto;
import ru.mels.tasktracking.entity.Release;
import ru.mels.tasktracking.mapper.ReleaseMapper;

/**
 * @author Meleshkin Alexandr
 * @since 07.03.2022
 */
@Component
public class ReleaseMapperImpl implements ReleaseMapper {
    @Override
    public Release fromRequestDto(ReleaseRequestDto source) {
        Release release = new Release();
        release.setDescription(source.getDescription());
        release.setStartDateTime(source.getStartDateTime());
        release.setEndDateTime(source.getEndDateTime());
        release.setVersion(source.getVersion());
        return release;
    }

    @Override
    public ReleaseResponseDto toResponseDto(Release source) {
        ReleaseResponseDto releaseResponseDto = new ReleaseResponseDto();
        releaseResponseDto.setId(source.getId());
        releaseResponseDto.setDescription(source.getDescription());
        releaseResponseDto.setVersion(source.getVersion());
        releaseResponseDto.setStartDateTime(source.getStartDateTime());
        releaseResponseDto.setEndDateTime(source.getEndDateTime());
        return releaseResponseDto;
    }

    @Override
    public Release merge(Release target, Release source) {
        if(source.getDescription() != null){
            target.setDescription(source.getDescription());
        }
        if(source.getVersion() != null){
            target.setVersion(source.getVersion());
        }
        if(source.getStartDateTime() != null){
            target.setStartDateTime(source.getStartDateTime());
        }
        if(source.getEndDateTime() != null){
            target.setEndDateTime(source.getEndDateTime());
        }
        return target;
    }
}
