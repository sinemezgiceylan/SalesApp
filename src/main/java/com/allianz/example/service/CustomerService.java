package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.database.repository.CustomerEntityRepository;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.mapper.CustomerMapper;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.CustomerDTO;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.CustomerRequestDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.util.BaseService;
import com.allianz.example.util.IBaseMapper;
import com.allianz.example.util.IBaseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService extends BaseService<CustomerEntity, CustomerDTO, CustomerRequestDTO,
        CustomerMapper, CustomerEntityRepository> {

    @Autowired
    CustomerEntityRepository customerEntityRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    PersonEntityRepository personEntityRepository;


    @Override
    public CustomerMapper getMapper() {
        return customerMapper;
    }

    @Override
    public CustomerEntityRepository getRepository() {
        return customerEntityRepository;
    }
}
