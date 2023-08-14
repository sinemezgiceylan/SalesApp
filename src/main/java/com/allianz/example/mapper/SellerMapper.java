package com.allianz.example.mapper;

import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SellerMapper implements IBaseMapper<SellerDTO, SellerEntity, SellerRequestDTO> {
    @Override
    public SellerDTO entityToDTO(SellerEntity entity) {

        SellerDTO sellerDTO = new SellerDTO();
        sellerDTO.setId(entity.getId());
        sellerDTO.setUuid(entity.getUuid());
        sellerDTO.setCreationDate(entity.getCreationDate());
        sellerDTO.setUpdatedDate(entity.getUpdatedDate());
        sellerDTO.setName(entity.getName());
        sellerDTO.setEmail(entity.getEmail());
        sellerDTO.setShopName(entity.getShopName());
        sellerDTO.setSurname(entity.getSurname());
        sellerDTO.setTaxNumber(entity.getTaxNumber());
        sellerDTO.setTaxOffice(entity.getTaxOffice());
        sellerDTO.setTc(entity.getTc());

        return sellerDTO;
    }

    @Override
    public SellerEntity dtoToEntity(SellerDTO dto) {

        SellerEntity sellerEntity = new SellerEntity();
        sellerEntity.setId(dto.getId());
        sellerEntity.setUuid(dto.getUuid());
        sellerEntity.setCreationDate(dto.getCreationDate());
        sellerEntity.setUpdatedDate(dto.getUpdatedDate());
        sellerEntity.setName(dto.getName());
        sellerEntity.setEmail(dto.getEmail());
        sellerEntity.setShopName(dto.getShopName());
        sellerEntity.setSurname(dto.getSurname());
        sellerEntity.setTaxNumber(dto.getTaxNumber());
        sellerEntity.setTaxOffice(dto.getTaxOffice());
        sellerEntity.setTc(dto.getTc());

        return sellerEntity;
    }

    @Override
    public List<SellerDTO> entityListToDTOList(List<SellerEntity> sellerEntities) {

        List<SellerDTO> sellerDTOList = new ArrayList<>();

        for (SellerEntity seller : sellerEntities) {
            sellerDTOList.add(entityToDTO(seller));
        }
        return sellerDTOList;
    }

    @Override
    public List<SellerEntity> dtoListTOEntityList(List<SellerDTO> sellerDTOS) {

        List<SellerEntity> sellerEntityList = new ArrayList<>();

        for (SellerDTO seller : sellerDTOS) {
            sellerEntityList.add(dtoToEntity(seller));
        }
        return sellerEntityList;
    }

    @Override
    public SellerEntity requestDTOToEntity(SellerRequestDTO dto) {

        SellerEntity sellerEntity = new SellerEntity();
        sellerEntity.setId(dto.getId());
        sellerEntity.setUuid(dto.getUuid());
        sellerEntity.setCreationDate(dto.getCreationDate());
        sellerEntity.setUpdatedDate(dto.getUpdatedDate());
        sellerEntity.setName(dto.getName());
        sellerEntity.setEmail(dto.getEmail());
        sellerEntity.setShopName(dto.getShopName());
        sellerEntity.setSurname(dto.getSurname());
        sellerEntity.setTaxNumber(dto.getTaxNumber());
        sellerEntity.setTaxOffice(dto.getTaxOffice());
        sellerEntity.setTc(dto.getTc());

        return sellerEntity;
    }

    @Override
    public List<SellerEntity> requestDtoListTOEntityList(List<SellerRequestDTO> sellerRequestDTOS) {
        return null;
    }

    @Override
    public SellerEntity requestDTOToExistEntity(SellerRequestDTO sellerRequestDTO, SellerEntity entity) {
        return null;
    }
}
