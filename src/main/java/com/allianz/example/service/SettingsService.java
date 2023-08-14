package com.allianz.example.service;

import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.SettingsEntityRepository;
import com.allianz.example.mapper.SettingsMapper;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.util.BaseService;
import com.allianz.example.util.IBaseMapper;
import com.allianz.example.util.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SettingsService extends BaseService<SettingsEntity, SettingsDTO, SettingsRequestDTO,
        IBaseMapper<SettingsDTO, SettingsEntity, SettingsRequestDTO>,
        IBaseRepository<SettingsEntity>>  {

    @Autowired
    SettingsMapper settingsMapper;
    @Autowired
    SettingsEntityRepository settingsEntityRepository;

    @Override
    public SettingsMapper getMapper() {
        return settingsMapper;
    }

    @Override
    public SettingsEntityRepository getRepository() {
        return settingsEntityRepository;
    }
}
