package com.allianz.example.database.repository;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SellerEntityRepository extends JpaRepository<SellerEntity, Long> {

    Optional<SellerEntity> findByUuid(UUID uuid);

}
