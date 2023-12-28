package com.pintailconsultingllc.awsexplorer.controllers

import jakarta.inject.Inject
import jakarta.inject.Singleton
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.HBox
import javafx.stage.Stage

@Singleton
class MainController {
    @Inject
    private lateinit var sceneManager: SceneManager

    @FXML
    lateinit var bottomStatusView: HBox

    @FXML
    lateinit var signInView: AnchorPane

    fun exit(actionEvent: ActionEvent) {
        println("Exit")
    }

    fun about(actionEvent: ActionEvent) {
        TODO("Replace with about view")
        sceneManager.activateView(
            SIGN_IN_VIEW,
            (actionEvent.source as Node).scene.window as Stage
        )
    }

    fun signIn(actionEvent: ActionEvent) {
        sceneManager.activateView(
            SIGN_IN_VIEW,
            (actionEvent.source as Node).scene.window as Stage
        )
    }
}