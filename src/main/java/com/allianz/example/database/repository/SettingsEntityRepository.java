package com.allianz.example.database.repository;


import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.util.IBaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SettingsEntityRepository extends IBaseRepository<SettingsEntity> {

}
