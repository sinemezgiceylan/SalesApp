package com.allianz.example.controller;


import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.SettingsRequestDTO;
import com.allianz.example.service.SettingsService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("settings")
public class SettingsController extends BaseController<SettingsEntity, SettingsDTO, SettingsRequestDTO, SettingsService> {

    @Autowired
    SettingsService settingsService;


    @Override
    protected SettingsService getService() {
        return settingsService;
    }
}
