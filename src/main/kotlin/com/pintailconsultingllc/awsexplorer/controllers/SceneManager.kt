package com.pintailconsultingllc.awsexplorer.controllers

import javafx.stage.Stage

const val HELLO_VIEW = "hello-view"
const val MAIN_VIEW = "main-view"
const val SIGN_IN_VIEW = "sign-in-view"

interface SceneManager {
    fun activateView(name: String, stage: Stage)
    fun configure()
}