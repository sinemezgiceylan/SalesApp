package com.allianz.example.mapper;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.util.IBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BillMapper implements IBaseMapper<BillDTO, BillEntity, BillRequestDTO> {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public BillDTO entityToDTO(BillEntity entity) {

        BillDTO billDTO = new BillDTO();
        billDTO.setId(entity.getId());
        billDTO.setUuid(entity.getUuid());
        billDTO.setBillNo(entity.getBillNo());
        billDTO.setCreationDate(entity.getCreationDate());
        billDTO.setUpdatedDate(entity.getUpdatedDate());
        billDTO.setBillDate(entity.getBillDate());
        billDTO.setTaxRate(entity.getTaxRate());
        billDTO.setTaxAmount(entity.getTaxAmount());
        billDTO.setTotalSellNetPrice(entity.getTotalSellNetPrice());
        billDTO.setTotalSellPrice(entity.getTotalSellPrice());
        billDTO.setOrder(orderMapper.entityToDTO(entity.getOrder()));

        return billDTO;
    }

    @Override
    public BillEntity dtoToEntity(BillDTO dto) {

        BillEntity billEntity = new BillEntity();
        billEntity.setId(dto.getId());
        billEntity.setUuid(dto.getUuid());
        billEntity.setBillNo(dto.getBillNo());
        billEntity.setCreationDate(dto.getCreationDate());
        billEntity.setUpdatedDate(dto.getUpdatedDate());
        billEntity.setBillDate(dto.getBillDate());
        billEntity.setTaxRate(dto.getTaxRate());
        billEntity.setTaxAmount(dto.getTaxAmount());
        billEntity.setTotalSellNetPrice(dto.getTotalSellNetPrice());
        billEntity.setTotalSellPrice(dto.getTotalSellPrice());
        billEntity.setOrder(orderMapper.dtoToEntity(dto.getOrder()));

        return billEntity;
    }

    @Override
    public List<BillDTO> entityListToDTOList(List<BillEntity> billEntities) {

        List<BillDTO> billDTOList = new ArrayList<>();

        for (BillEntity bill : billEntities) {
            billDTOList.add(entityToDTO(bill));
        }
        return billDTOList;
    }

    @Override
    public List<BillEntity> dtoListTOEntityList(List<BillDTO> billDTOS) {

        List<BillEntity> billEntityList = new ArrayList<>();

        for (BillDTO bill : billDTOS) {
            billEntityList.add(dtoToEntity(bill));
        }
        return billEntityList;
    }

    @Override
    public BillEntity requestDTOToEntity(BillRequestDTO dto) {

        BillEntity billEntity = new BillEntity();
        billEntity.setId(dto.getId());
        billEntity.setUuid(dto.getUuid());
        billEntity.setBillNo(dto.getBillNo());
        billEntity.setCreationDate(dto.getCreationDate());
        billEntity.setUpdatedDate(dto.getUpdatedDate());
        billEntity.setBillDate(dto.getBillDate());
        billEntity.setTaxRate(dto.getTaxRate());
        billEntity.setTaxAmount(dto.getTaxAmount());
        billEntity.setTotalSellNetPrice(dto.getTotalSellNetPrice());
        billEntity.setTotalSellPrice(dto.getTotalSellPrice());
        billEntity.setOrder(orderMapper.requestDTOToEntity(dto.getOrder()));

        return billEntity;
    }

    @Override
    public List<BillEntity> requestDtoListTOEntityList(List<BillRequestDTO> billRequestDTOS) {
        return null;
    }

    @Override
    public BillEntity requestDTOToExistEntity(BillRequestDTO billRequestDTO, BillEntity entity) {
        return null;
    }
}
