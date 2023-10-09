package com.pintailconsultingllc.awsexplorer

import com.google.inject.Guice
import com.google.inject.Injector
import com.pintailconsultingllc.awsexplorer.modules.GuiceModule
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage


class AWSExplorerApplication : Application() {

    private var injector: Injector? = null

    override fun start(stage: Stage) {
        injector = Guice.createInjector(GuiceModule())
        val fxmlLoader = FXMLLoader(AWSExplorerApplication::class.java.getResource("main-view.fxml"))
        fxmlLoader.setControllerFactory { controllerClass -> injector!!.getInstance(controllerClass) }
        val scene = Scene(fxmlLoader.load(), 1024.0, 768.0)
        stage.title = "AWS Explorer"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(AWSExplorerApplication::class.java)
}