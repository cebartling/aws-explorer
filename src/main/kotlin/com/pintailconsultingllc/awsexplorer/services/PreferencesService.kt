package com.pintailconsultingllc.awsexplorer.services

import jakarta.inject.Singleton
import software.amazon.awssdk.regions.Region

interface PreferencesService {
    fun getRegion(): Region
}

@Singleton
class PreferencesServiceImpl : PreferencesService {

    override fun getRegion(): Region {
        return Region.US_EAST_1
    }
}