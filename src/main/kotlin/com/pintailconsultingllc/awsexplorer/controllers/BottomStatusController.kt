package com.pintailconsultingllc.awsexplorer.controllers

import com.pintailconsultingllc.awsexplorer.services.PreferencesService
import jakarta.inject.Inject
import javafx.fxml.FXML
import javafx.scene.control.Label

class BottomStatusController {

    @Inject
    private lateinit var preferencesService: PreferencesService

    @FXML
    lateinit var statusLabel: Label
}