package com.pintailconsultingllc.awsexplorer.services

import jakarta.inject.Inject
import jakarta.inject.Singleton
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider
import software.amazon.awssdk.services.cloudformation.CloudFormationClient
import software.amazon.awssdk.services.cloudformation.model.CloudFormationException
import software.amazon.awssdk.services.cloudformation.model.DescribeStacksResponse
import software.amazon.awssdk.services.cloudformation.model.Stack


interface CloudFormationService {
    fun listStacks(): List<Stack>
}

@Singleton
class CloudFormationServiceImpl : CloudFormationService {

    @Inject
    private lateinit var preferencesService: PreferencesService

    override fun listStacks(): List<Stack> {

        val cloudFormationClient: CloudFormationClient = CloudFormationClient.builder()
            .region(preferencesService.getRegion())
            .credentialsProvider(ProfileCredentialsProvider.create())
            .build()

        try {
            val stacksResponse: DescribeStacksResponse = cloudFormationClient.describeStacks()
            return stacksResponse.stacks()
        } catch (e: CloudFormationException) {
            e.printStackTrace()
        } finally {
            cloudFormationClient.close()
        }
        return emptyList()
    }
}