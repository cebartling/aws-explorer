package com.pintailconsultingllc.awsexplorer.controllers

import com.pintailconsultingllc.awsexplorer.services.IdentityService
import com.pintailconsultingllc.awsexplorer.services.PreferencesService
import jakarta.inject.Inject
import jakarta.inject.Singleton
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.TextField

@Singleton
class SignInController {

    @FXML
    lateinit var passwordTextField: TextField

    @FXML
    private lateinit var usernameTextField: TextField

    @Inject
    private lateinit var identityService: IdentityService

    @Inject
    private lateinit var preferencesService: PreferencesService

    fun submit(actionEvent: ActionEvent) {
        println("Identity Service: $identityService")
        println("Preferences Service: $preferencesService")
        println("Username: ${usernameTextField.text}")
        println("Password: ${passwordTextField.text}")
        println("Submit")
    }
}