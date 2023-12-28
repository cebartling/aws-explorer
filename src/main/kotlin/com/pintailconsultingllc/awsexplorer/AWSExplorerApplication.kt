package com.pintailconsultingllc.awsexplorer

import com.google.inject.AbstractModule
import com.google.inject.Guice
import com.google.inject.Injector
import com.pintailconsultingllc.awsexplorer.controllers.MAIN_VIEW
import com.pintailconsultingllc.awsexplorer.controllers.SceneManager
import com.pintailconsultingllc.awsexplorer.guice.GuiceFXMLLoader
import com.pintailconsultingllc.awsexplorer.modules.FoobarModule
import com.pintailconsultingllc.awsexplorer.modules.GuiceModule
import jakarta.inject.Provider
import javafx.application.Application
import javafx.stage.Stage


class AWSExplorerApplication : Application() {

//    @Inject
//    @Named("app-title-string")
//    private var appTitle: String? = null

    private var injector: Injector? = null

    override fun start(stage: Stage) {
        val instance = this
        val applicationModule = object : AbstractModule() {
            override fun configure() {
                bind(instance.javaClass).toProvider(Provider<AWSExplorerApplication?> { instance })
            }
        }
        injector = Guice.createInjector(GuiceModule(), FoobarModule(), applicationModule)
        val guiceFXMLLoader = injector!!.getInstance(GuiceFXMLLoader::class.java)
//        val scene = Scene(
//            AWSExplorerApplication::class.java.getResource("main-view.fxml")?.let { guiceFXMLLoader.load(it) },
//            1024.0,
//            768.0
//        )
        stage.title = "AWS Explorer"
        val sceneManager = injector!!.getInstance(SceneManager::class.java)
        sceneManager.configure()
        sceneManager.activateView(MAIN_VIEW, stage)
//        stage.scene = scene
//        stage.show()
    }
}

fun main() {
    Application.launch(AWSExplorerApplication::class.java)
}