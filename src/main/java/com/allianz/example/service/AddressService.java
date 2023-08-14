package com.allianz.example.service;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.database.repository.AddressEntityRepository;
import com.allianz.example.mapper.AddressMapper;
import com.allianz.example.model.AddressDTO;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.AddressRequestDTO;
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
public class AddressService extends BaseService<AddressEntity, AddressDTO, AddressRequestDTO,
        IBaseMapper<AddressDTO, AddressEntity, AddressRequestDTO>,
        IBaseRepository<AddressEntity>> {

    @Autowired
    AddressEntityRepository addressEntityRepository;

    @Autowired
    AddressMapper addressMapper;


    @Override
    public AddressMapper getMapper() {
        return addressMapper;
    }

    @Override
    public AddressEntityRepository getRepository() {
        return addressEntityRepository;
    }
}
