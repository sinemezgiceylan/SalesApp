package com.allianz.example.mapper;

import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.model.PageDTO;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaxMapper implements IBaseMapper<TaxDTO, TaxEntity, TaxRequestDTO> {

    @Override
    public TaxDTO entityToDTO(TaxEntity entity) {

        TaxDTO taxDTO = new TaxDTO();
        taxDTO.setId(entity.getId());
        taxDTO.setUuid(entity.getUuid());
        taxDTO.setCreationDate(entity.getCreationDate());
        taxDTO.setUpdatedDate(entity.getUpdatedDate());
        taxDTO.setName(entity.getName());
        taxDTO.setCode(entity.getCode());
        taxDTO.setRate(entity.getRate());

        return taxDTO;
    }

    @Override
    public TaxEntity dtoToEntity(TaxDTO dto) {

        TaxEntity taxEntity = new TaxEntity();
        taxEntity.setId(dto.getId());
        taxEntity.setUuid(dto.getUuid());
        taxEntity.setCreationDate(dto.getCreationDate());
        taxEntity.setUpdatedDate(dto.getUpdatedDate());
        taxEntity.setName(dto.getName());
        taxEntity.setCode(dto.getCode());
        taxEntity.setRate(dto.getRate());

        return taxEntity;
    }

    @Override
    public List<TaxDTO> entityListToDTOList(List<TaxEntity> taxEntities) {

        List<TaxDTO> taxDTOList = new ArrayList<>();

        for (TaxEntity tax : taxEntities) {
            taxDTOList.add(entityToDTO(tax));
        }

        return taxDTOList;
    }

    @Override
    public List<TaxEntity> dtoListTOEntityList(List<TaxDTO> taxDTOS) {

        List<TaxEntity> taxEntityList = new ArrayList<>();

        for (TaxDTO tax : taxDTOS) {
            taxEntityList.add(dtoToEntity(tax));
        }
        return taxEntityList;
    }

    @Override
    public TaxEntity requestDTOToEntity(TaxRequestDTO dto) {

        TaxEntity taxEntity = new TaxEntity();
        taxEntity.setId(dto.getId());
        taxEntity.setUuid(dto.getUuid());
        taxEntity.setCreationDate(dto.getCreationDate());
        taxEntity.setUpdatedDate(dto.getUpdatedDate());
        taxEntity.setName(dto.getName());
        taxEntity.setCode(dto.getCode());
        taxEntity.setRate(dto.getRate());

        return taxEntity;
    }

    @Override
    public List<TaxEntity> requestDtoListTOEntityList(List<TaxRequestDTO> taxRequestDTOS) {
        return null;
    }

    @Override
    public TaxEntity requestDTOToExistEntity(TaxRequestDTO taxRequestDTO, TaxEntity entity) {
        entity.setCode(taxRequestDTO.getCode());
        entity.setName(taxRequestDTO.getName());
        entity.setRate(taxRequestDTO.getRate());

        return entity;
    }

    @Override
    public PageDTO<TaxDTO> pageEntityToPageDTO(Page<TaxEntity> taxEntities) {

        PageDTO<TaxDTO> taxDTOPageDTO = new PageDTO<>();
        taxDTOPageDTO.setContent(entityListToDTOList(taxEntities.getContent()));
        taxDTOPageDTO.setTotalPage(taxEntities.getTotalPages());
        taxDTOPageDTO.setSize(taxEntities.getSize());
        taxDTOPageDTO.setNumber(taxEntities.getNumber());
        taxDTOPageDTO.setSort(taxEntities.getSort());
        taxDTOPageDTO.setNumberOfElement(taxEntities.getTotalPages());
        taxDTOPageDTO.setTotalElements(taxEntities.getTotalElements());

        return taxDTOPageDTO;
    }
}
