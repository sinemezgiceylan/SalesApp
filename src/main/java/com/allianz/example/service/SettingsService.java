package com.allianz.example.service;

import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.database.repository.SettingsEntityRepository;
import com.allianz.example.mapper.SettingsMapper;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SettingsService extends BaseService<SettingsEntity, SettingsDTO, SettingsRequestDTO> {

    @Autowired
    SettingsEntityRepository settingsEntityRepository;

    @Autowired
    SettingsMapper settingsMapper;


    public SettingsEntity createSettings(String key, String value) {
        SettingsEntity settingsEntity = new SettingsEntity();

        settingsEntity.setKey(key);
        settingsEntity.setValue(value);

        settingsEntityRepository.save(settingsEntity);

        return settingsEntity;
    }

    public List<SettingsDTO> getAll() {
        List<SettingsEntity> settingsEntityList = settingsEntityRepository.findAll();
        return settingsMapper.entityListToDTOList(settingsEntityList);
    }

    public SettingsDTO getByUUID(UUID uuid) {

        Optional<SettingsEntity> settingsEntityOptional = settingsEntityRepository.findByUuid(uuid);

        return settingsEntityOptional.map(settingsEntity -> settingsMapper.entityToDTO(settingsEntity)).orElse(null);

    }
}
