package com.pintailconsultingllc.awsexplorer.controllers

import com.pintailconsultingllc.awsexplorer.services.PreferencesService
import jakarta.inject.Inject
import jakarta.inject.Singleton
import javafx.fxml.FXML
import javafx.scene.control.Label

@Singleton
class BottomStatusController {

    @Inject
    private lateinit var preferencesService: PreferencesService

    @FXML
    lateinit var statusLabel: Label
}