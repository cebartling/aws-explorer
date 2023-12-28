package com.pintailconsultingllc.awsexplorer.controllers

import com.google.inject.Inject
import com.pintailconsultingllc.awsexplorer.services.IdentityService
import jakarta.inject.Singleton
import javafx.fxml.FXML
import javafx.scene.control.Label

@Singleton
class HelloController {

    @Inject
    private lateinit var identityService: IdentityService

    @FXML
    private lateinit var welcomeText: Label

    @FXML
    private fun onHelloButtonClick() {
        welcomeText.text = "Welcome to JavaFX Application!"
    }
}