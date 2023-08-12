package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.database.repository.SellerEntityRepository;
import com.allianz.example.mapper.SellerMapper;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SellerService extends BaseService<SellerEntity, SellerDTO, SellerRequestDTO> {

    @Autowired
    SellerEntityRepository sellerEntityRepository;

    @Autowired
    SellerMapper sellerMapper;

    public SellerEntity createSeller(SellerRequestDTO request) {
        SellerEntity sellerEntity = new SellerEntity();

        sellerEntity.setName(request.getName());
        sellerEntity.setSurname(request.getSurname());
        sellerEntity.setTc(request.getTc());
        sellerEntity.setEmail(request.getEmail());
        sellerEntity.setShopName(request.getShopName());
        sellerEntity.setTaxNumber(request.getTaxNumber());
        sellerEntity.setTaxOffice(request.getTaxOffice());

        sellerEntityRepository.save(sellerEntity);

        return sellerEntity;
    }

    public List<SellerDTO> getAll() {
        List<SellerEntity> sellerEntityList = sellerEntityRepository.findAll();
        return sellerMapper.entityListToDTOList(sellerEntityList);
    }

    public SellerDTO getByUUID(UUID uuid) {

        Optional<SellerEntity> sellerEntityOptional = sellerEntityRepository.findByUuid(uuid);

        return sellerEntityOptional.map(sellerEntity -> sellerMapper.entityToDTO(sellerEntity)).orElse(null);

    }


}
