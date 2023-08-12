package com.allianz.example.service;

import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.database.repository.TaxEntityRepository;
import com.allianz.example.mapper.TaxMapper;
import com.allianz.example.model.TaxDTO;
import com.allianz.example.model.requestDTO.TaxRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaxService extends BaseService<TaxEntity, TaxDTO, TaxRequestDTO> {

    @Autowired
    TaxEntityRepository taxEntityRepository;

    @Autowired
    TaxMapper taxMapper;

    public TaxEntity createTax(String name, String code, BigDecimal rate){
        TaxEntity tax = new TaxEntity();

        tax.setName(name);
        tax.setCode(code);
        tax.setRate(rate);

        taxEntityRepository.save(tax);

        return tax;
    }

    public List<TaxDTO> getAll() {
        List<TaxEntity> taxEntityList = taxEntityRepository.findAll();
        return taxMapper.entityListToDTOList(taxEntityList);
    }

    public TaxDTO getByUUID(UUID uuid) {

        Optional<TaxEntity> taxEntityOptional = taxEntityRepository.findByUuid(uuid);

        return taxEntityOptional.map(taxEntity -> taxMapper.entityToDTO(taxEntity)).orElse(null);

    }
}
