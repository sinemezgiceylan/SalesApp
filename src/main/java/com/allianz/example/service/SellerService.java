package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.SellerEntity;
import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.database.repository.SellerEntityRepository;
import com.allianz.example.database.repository.SettingsEntityRepository;
import com.allianz.example.mapper.SellerMapper;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.SellerDTO;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.SellerRequestDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.util.BaseService;
import com.allianz.example.util.IBaseMapper;
import com.allianz.example.util.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SellerService extends BaseService<SellerEntity, SellerDTO, SellerRequestDTO,
        IBaseMapper<SellerDTO, SellerEntity, SellerRequestDTO>,
        IBaseRepository<SellerEntity>> {

    @Autowired
    SellerEntityRepository sellerEntityRepository;

    @Autowired
    SellerMapper sellerMapper;


    @Override
    public SellerMapper getMapper() {
        return sellerMapper;
    }

    @Override
    public SellerEntityRepository getRepository() {
        return sellerEntityRepository;
    }
}
