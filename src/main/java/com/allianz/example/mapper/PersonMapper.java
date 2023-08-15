package com.allianz.example.mapper;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.model.PageDTO;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonMapper implements IBaseMapper<PersonDTO, PersonEntity, PersonRequestDTO> {


    @Override
    public PersonDTO entityToDTO(PersonEntity entity) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setTc(entity.getTc());
        personDTO.setName(entity.getName());
        personDTO.setSurname(entity.getSurname());
        personDTO.setId(entity.getId());
        personDTO.setUuid(entity.getUuid());
        personDTO.setBirthYear(entity.getBirthYear());
        personDTO.setCreationDate(entity.getCreationDate());
        personDTO.setUpdatedDate(entity.getUpdatedDate());

        return personDTO;
    }

    @Override
    public PersonEntity dtoToEntity(PersonDTO dto) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setTc(dto.getTc());
        personEntity.setName(dto.getName());
        personEntity.setSurname(dto.getSurname());
        personEntity.setId(dto.getId());
        personEntity.setUuid(dto.getUuid());
        personEntity.setBirthYear(dto.getBirthYear());
        personEntity.setCreationDate(dto.getCreationDate());
        personEntity.setUpdatedDate(dto.getUpdatedDate());

        return personEntity;
    }

    @Override
    public List<PersonDTO> entityListToDTOList(List<PersonEntity> personEntities) {
        List<PersonDTO> personDTOList = new ArrayList<>();
        for (PersonEntity person : personEntities) {
            personDTOList.add(entityToDTO(person));
        }
        return personDTOList;
    }

    @Override
    public List<PersonEntity> dtoListTOEntityList(List<PersonDTO> personDTOS) {
        List<PersonEntity> personEntityList = new ArrayList<>();
        for (PersonDTO person : personDTOS) {
            personEntityList.add(dtoToEntity(person));
        }
        return personEntityList;
    }

    @Override
    public PersonEntity requestDTOToEntity(PersonRequestDTO dto) {
        PersonEntity personEntity1 = new PersonEntity();
        personEntity1.setTc(dto.getTc());
        personEntity1.setName(dto.getName());
        personEntity1.setSurname(dto.getSurname());
        personEntity1.setId(dto.getId());
        personEntity1.setUuid(dto.getUuid());
        personEntity1.setBirthYear(dto.getBirthYear());
        personEntity1.setCreationDate(dto.getCreationDate());
        personEntity1.setUpdatedDate(dto.getUpdatedDate());

        return personEntity1;
    }

    @Override
    public List<PersonEntity> requestDtoListTOEntityList(List<PersonRequestDTO> personRequestDTOS) {
        return null;
    }

    @Override
    public PersonEntity requestDTOToExistEntity(PersonRequestDTO personRequestDTO, PersonEntity entity) {
        return null;
    }

    @Override
    public PageDTO<PersonDTO> pageEntityToPageDTO(Page<PersonEntity> personEntities) {
        return null;
    }
}
