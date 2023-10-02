package com.pintailconsultingllc.awsexplorer

import com.google.inject.Guice
import com.google.inject.Injector
import com.pintailconsultingllc.awsexplorer.modules.GuiceModule
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.scene.control.MenuItem
import javafx.scene.layout.VBox
import javafx.stage.Stage


class AWSExplorerApplication : Application() {


    private var injector: Injector? = null

    override fun start(stage: Stage) {
        injector = Guice.createInjector(GuiceModule())

        val menu = Menu("Menu 1")
        val signInMenuItem = MenuItem("Sign in...")
        signInMenuItem.setOnAction { _ -> println("Menu Item 1 Selected") }
        menu.items.add(signInMenuItem)

        val menuBar = MenuBar()
        menuBar.menus.add(menu)
        val vBox = VBox(menuBar)

        val scene = Scene(vBox, 1024.0, 768.0)
//        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
//        val scene = Scene(fxmlLoader.load(), 1024.0, 768.0)
        stage.title = "AWS Explorer"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(AWSExplorerApplication::class.java)
}