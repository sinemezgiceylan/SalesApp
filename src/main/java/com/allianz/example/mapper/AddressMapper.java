package com.allianz.example.mapper;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.PageDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressMapper implements IBaseMapper<AddressDTO, AddressEntity, AddressRequestDTO> {
    @Override
    public AddressDTO entityToDTO(AddressEntity entity) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCreationDate(entity.getCreationDate());
        addressDTO.setUuid(entity.getUuid());
        addressDTO.setId(entity.getId());
        addressDTO.setAddress(entity.getAddress());
        addressDTO.setTitle(entity.getTitle());
        addressDTO.setUpdatedDate(entity.getUpdatedDate());

        return addressDTO;
    }

    @Override
    public AddressEntity dtoToEntity(AddressDTO dto) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setUuid(dto.getUuid());
        addressEntity.setCreationDate(dto.getCreationDate());
        addressEntity.setUpdatedDate(dto.getUpdatedDate());
        addressEntity.setId(dto.getId());
        addressEntity.setTitle(dto.getTitle());
        addressEntity.setAddress(dto.getAddress());

        return addressEntity;
    }

    @Override
    public List<AddressDTO> entityListToDTOList(List<AddressEntity> addressEntities) {
        List<AddressDTO> addressDTOList = new ArrayList<>();

        for (AddressEntity addressEntity:addressEntities) {
            addressDTOList.add(entityToDTO(addressEntity));
        }
        
        return addressDTOList;
    }

    @Override
    public List<AddressEntity> dtoListTOEntityList(List<AddressDTO> addressDTOS) {
        List<AddressEntity> addressEntityList = new ArrayList<>();

        for (AddressDTO address : addressDTOS) {
            addressEntityList.add(dtoToEntity(address));
        }
        return addressEntityList;
    }

    @Override
    public AddressEntity requestDTOToEntity(AddressRequestDTO dto) {
        AddressEntity entity = new AddressEntity();

        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdatedDate(dto.getUpdatedDate());

        return entity;
    }

    @Override
    public List<AddressEntity> requestDtoListTOEntityList(List<AddressRequestDTO> addressRequestDTOS) {
        return null;
    }

    @Override
    public AddressEntity requestDTOToExistEntity(AddressRequestDTO addressRequestDTO, AddressEntity entity) {
        return null;
    }

    @Override
    public PageDTO<AddressDTO> pageEntityToPageDTO(Page<AddressEntity> addressEntities) {
        return null;
    }
}
