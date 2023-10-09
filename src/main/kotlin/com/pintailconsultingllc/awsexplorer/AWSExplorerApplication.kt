package com.pintailconsultingllc.awsexplorer

import com.google.inject.Guice
import com.google.inject.Injector
import com.pintailconsultingllc.awsexplorer.modules.GuiceFXMLLoader
import com.pintailconsultingllc.awsexplorer.modules.GuiceModule
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage


class AWSExplorerApplication : Application() {

    private var injector: Injector? = null

    override fun start(stage: Stage) {
        injector = Guice.createInjector(GuiceModule())
        val resourceUrl = AWSExplorerApplication::class.java.getResource("main-view.fxml")
        val guiceFXMLLoader = injector!!.getInstance(GuiceFXMLLoader::class.java)
        val scene = Scene(resourceUrl?.let { guiceFXMLLoader.load(it) }, 1024.0, 768.0)
        stage.title = "AWS Explorer"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(AWSExplorerApplication::class.java)
}