package com.pintailconsultingllc.awsexplorer.controllers

import com.pintailconsultingllc.awsexplorer.AWSExplorerApplication
import com.pintailconsultingllc.awsexplorer.guice.GuiceFXMLLoader
import jakarta.inject.Inject
import jakarta.inject.Singleton
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import java.net.URL

@Singleton
class SceneManagerImpl : SceneManager {

    @Inject
    private lateinit var fxmlLoader: GuiceFXMLLoader

    private val screenMap = HashMap<String, Parent>()

    override fun configure() {
        screenMap[HELLO_VIEW] = AWSExplorerApplication::class.java.getResource("${HELLO_VIEW}.fxml")
            ?.let<URL, Parent> { fxmlLoader.load(it) }!!
        screenMap[MAIN_VIEW] =
            AWSExplorerApplication::class.java.getResource("${MAIN_VIEW}.fxml")
                ?.let<URL, Parent> { fxmlLoader.load(it) }!!
        screenMap[SIGN_IN_VIEW] =
            AWSExplorerApplication::class.java.getResource("${SIGN_IN_VIEW}.fxml")
                ?.let<URL, Parent> { fxmlLoader.load(it) }!!
    }

    override fun activateView(name: String, stage: Stage) {
        if (stage.scene == null) {
            stage.hide()
            stage.scene = Scene(screenMap[name], 1600.0, 1200.0)
            stage.show()
        } else {
            stage.scene.root = screenMap[name]
        }
    }
}