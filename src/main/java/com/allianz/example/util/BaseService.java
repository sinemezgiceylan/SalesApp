package com.allianz.example.util;

import com.allianz.example.database.entity.AddressEntity;
import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.model.PageDTO;
import com.allianz.example.util.dbutil.BaseEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class BaseService<Entity extends BaseEntity, DTO extends BaseDTO,
        RequestDTO extends BaseDTO, Mapper extends IBaseMapper<DTO, Entity, RequestDTO>,
        Repository extends IBaseRepository<Entity>> {

    public abstract Mapper getMapper();

    public abstract Repository getRepository();

    public DTO save(RequestDTO dto) {
        Entity entity = getMapper().requestDTOToEntity(dto);
        getRepository().save(entity);
        return getMapper().entityToDTO(entity);
    }

    public DTO update(UUID uuid, RequestDTO dto) {
        Entity entity = getRepository().findByUuid(uuid).orElse(null);

        if (entity != null) {
            entity = getMapper().requestDTOToExistEntity(dto, entity);
            getRepository().save(entity);
            return getMapper().entityToDTO(entity);
        } else {
            return null;
        }
    }

    public boolean deleteByUuid(UUID uuid) {
        Optional<Entity> optionalEntity = getRepository().findByUuid(uuid);
        if (optionalEntity.isPresent()) {
            getRepository().deleteById(optionalEntity.get().getId());
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public DTO getByUuid(UUID uuid) {
        Optional<Entity> optionalEntity = getRepository().findByUuid(uuid);
        if (optionalEntity.isPresent()) {
            return getMapper().entityToDTO(optionalEntity.get());
        } else {
            return null;
        }
    }


        public PageDTO<DTO> getAll(BaseFilterRequestDTO baseFilterRequestDTO) {
            Pageable pageable = null;
            if (baseFilterRequestDTO.getSortDTO() != null) {
                if (baseFilterRequestDTO.getSortDTO().getDirectionEnum() == Sort.Direction.DESC)
                {
                    pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(),
                            baseFilterRequestDTO.getPageSize(),
                            Sort.by(baseFilterRequestDTO.getSortDTO().getColumnName()).descending());
                } else {
                    pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(),
                            baseFilterRequestDTO.getPageSize(),
                            Sort.by(baseFilterRequestDTO.getSortDTO().getColumnName()).ascending());
                }
            } else {
                pageable = PageRequest.of(baseFilterRequestDTO.getPageNumber(),
                        baseFilterRequestDTO.getPageSize(),
                        Sort.by("id").ascending());
            }

            Page<Entity> entityPage = getRepository().findAll(pageable);


            return getMapper().pageEntityToPageDTO(entityPage);
        };

}
