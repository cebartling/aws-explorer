package com.pintailconsultingllc.awsexplorer.controllers

import com.pintailconsultingllc.awsexplorer.services.CloudFormationService
import jakarta.inject.Inject
import jakarta.inject.Singleton
import javafx.event.ActionEvent

@Singleton
class CloudFormationController {

    @Inject
    private lateinit var cloudFormationService: CloudFormationService

    fun retrieveStacks(actionEvent: ActionEvent) {

    }

}