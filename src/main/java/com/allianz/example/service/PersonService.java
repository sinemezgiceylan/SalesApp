package com.allianz.example.service;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.mapper.PersonMapper;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.util.BaseService;
import com.allianz.example.util.IBaseMapper;
import com.allianz.example.util.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//bean
@Service
public class PersonService extends BaseService<PersonEntity, PersonDTO, PersonRequestDTO,
        IBaseMapper<PersonDTO, PersonEntity, PersonRequestDTO>,
        IBaseRepository<PersonEntity>> {


    @Value("${gizem:25}")
    int value;

    @Autowired
    PersonMapper personMapper;
    @Autowired
    PersonEntityRepository personEntityRepository;


    @Override
    public PersonMapper getMapper() {
        return personMapper;
    }

    @Override
    public PersonEntityRepository getRepository() {
        return personEntityRepository;
    }
}
