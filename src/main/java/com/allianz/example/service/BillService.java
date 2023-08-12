package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.repository.BillEntityRepository;
import com.allianz.example.mapper.BillMapper;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.util.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BillService extends BaseService<BillEntity, BillDTO, BillRequestDTO> {

    @Autowired
    BillEntityRepository billEntityRepository;

    @Autowired
    BillMapper billMapper;


    public BillEntity createBill(BillRequestDTO request) {
        BillEntity billEntity = new BillEntity();

        billEntity.setBillNo(request.getBillNo());
        billEntity.setBillDate(request.getBillDate());
        billEntity.setTaxRate(request.getTaxRate());
        billEntity.setTaxAmount(request.getTaxAmount());
        billEntity.setTotalSellNetPrice(request.getTotalSellNetPrice());
        billEntity.setTotalSellPrice(request.getTotalSellPrice());
        billEntity.setOrder(request.getOrder());

        billEntityRepository.save(billEntity);

        return billEntity;
    }

    public List<BillDTO> getAll() {
            List<BillEntity> billEntityList = billEntityRepository.findAll();
        return billMapper.entityListToDTOList(billEntityList);
    }

    public BillDTO getByUUID(UUID uuid) {

        Optional<BillEntity> billEntityOptional = billEntityRepository.findByUuid(uuid);

        return billEntityOptional.map(billEntity -> billMapper.entityToDTO(billEntity)).orElse(null);

    }


    @Transactional
    public boolean deleteBillByUuid(UUID uuid) {
        return deleteEntityByUuid(uuid);
    }

}
