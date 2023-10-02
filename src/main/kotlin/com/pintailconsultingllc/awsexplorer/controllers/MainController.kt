package com.pintailconsultingllc.awsexplorer.controllers

import com.pintailconsultingllc.awsexplorer.AWSExplorerApplication
import javafx.event.ActionEvent
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.HBox

class MainController {
    lateinit var bottomStatusView: HBox
    lateinit var signInView: AnchorPane

    fun exit(actionEvent: ActionEvent) {
        println("Exit")
    }

    fun about(actionEvent: ActionEvent) {
        println("About")
    }

    fun signIn(actionEvent: ActionEvent) {
//        val fxmlLoader = FXMLLoader(AWSExplorerApplication::class.java.getResource("sign-in-view.fxml"))
//        val parent: Parent = fxmlLoader.load()

    }
}