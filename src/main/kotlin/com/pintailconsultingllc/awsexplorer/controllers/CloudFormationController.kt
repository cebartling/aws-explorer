package com.pintailconsultingllc.awsexplorer.controllers

import com.pintailconsultingllc.awsexplorer.services.CloudFormationService
import jakarta.inject.Inject
import javafx.event.ActionEvent

class CloudFormationController {

    @Inject
    private lateinit var cloudFormationService: CloudFormationService

    fun retrieveStacks(actionEvent: ActionEvent) {

    }

}