package com.allianz.example.database.repository;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.TaxEntity;
import com.allianz.example.util.IBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaxEntityRepository extends IBaseRepository<TaxEntity> {

}
