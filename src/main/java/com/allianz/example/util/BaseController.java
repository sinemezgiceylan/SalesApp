package com.allianz.example.util;
import com.allianz.example.model.PageDTO;
import com.allianz.example.util.dbutil.BaseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public abstract class BaseController<
        Entity extends BaseEntity,
        DTO extends BaseDTO,
        RequestDto extends BaseDTO,
        Mapper extends IBaseMapper<DTO, Entity, RequestDto>,
        Repository extends IBaseRepository<Entity>,
        Service extends BaseService<Entity, DTO, RequestDto, Mapper, Repository>> {

    protected abstract Service getService();

    @PostMapping
    public ResponseEntity<DTO> save(@RequestBody RequestDto requestDTO) {
        return new ResponseEntity<>(getService().save(requestDTO), HttpStatus.CREATED);
    }

    @GetMapping("page-number/{pNum}/page-size/{pSize}")
    public ResponseEntity<PageDTO<DTO>> getAll(@RequestBody BaseFilterRequestDTO baseFilterRequestDTO) {
        return new ResponseEntity<>(getService().getAll(baseFilterRequestDTO), HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<DTO> getByUUID(@PathVariable UUID uuid) {
        DTO dto = getService().getByUuid(uuid);
        if (dto == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<DTO> update(@PathVariable UUID uuid, @RequestBody RequestDto requestDTO) {
        if (getService().update(uuid, requestDTO) != null) {
            return new ResponseEntity<>(getService().update(uuid, requestDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{uuid}")
    public ResponseEntity<Boolean> deleteByUuid(@PathVariable UUID uuid) {
        Boolean isDeleted = getService().deleteByUuid(uuid);
        if (isDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

}
