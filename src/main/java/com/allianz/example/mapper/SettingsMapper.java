package com.allianz.example.mapper;

import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class SettingsMapper implements IBaseMapper<SettingsDTO, SettingsEntity, SettingsRequestDTO> {

    @Override
    public SettingsDTO entityToDTO(SettingsEntity entity) {

        SettingsDTO settingsDTO = new SettingsDTO();
        settingsDTO.setId(entity.getId());
        settingsDTO.setUuid(entity.getUuid());
        settingsDTO.setUpdatedDate(entity.getUpdatedDate());
        settingsDTO.setCreationDate(entity.getCreationDate());
        settingsDTO.setKey(entity.getKey());
        settingsDTO.setValue(entity.getValue());

        return settingsDTO;
    }

    @Override
    public SettingsEntity dtoToEntity(SettingsDTO dto) {

        SettingsEntity settingsEntity = new SettingsEntity();
        settingsEntity.setId(dto.getId());
        settingsEntity.setUuid(dto.getUuid());
        settingsEntity.setUpdatedDate(dto.getUpdatedDate());
        settingsEntity.setCreationDate(dto.getCreationDate());
        settingsEntity.setKey(dto.getKey());
        settingsEntity.setValue(dto.getValue());

        return settingsEntity;
    }

    @Override
    public List<SettingsDTO> entityListToDTOList(List<SettingsEntity> settingsEntities) {

        List<SettingsDTO> settingsDTOList = new ArrayList<>();

        for (SettingsEntity settings : settingsEntities) {
            settingsDTOList.add(entityToDTO(settings));
        }
        return settingsDTOList;
    }

    @Override
    public List<SettingsEntity> dtoListTOEntityList(List<SettingsDTO> settingsDTOS) {

        List<SettingsEntity> settingsEntityList = new ArrayList<>();

        for(SettingsDTO settings : settingsDTOS) {
            settingsEntityList.add(dtoToEntity(settings));
        }
        return settingsEntityList;
    }

    @Override
    public SettingsEntity requestDTOToEntity(SettingsRequestDTO dto) {

        SettingsEntity settingsEntity = new SettingsEntity();
        settingsEntity.setId(dto.getId());
        settingsEntity.setUuid(dto.getUuid());
        settingsEntity.setUpdatedDate(dto.getUpdatedDate());
        settingsEntity.setCreationDate(dto.getCreationDate());
        settingsEntity.setKey(dto.getKey());
        settingsEntity.setValue(dto.getValue());

        return settingsEntity;
    }

    @Override
    public List<SettingsEntity> requestDtoListTOEntityList(List<SettingsRequestDTO> settingsRequestDTOS) {
        return null;
    }
}
