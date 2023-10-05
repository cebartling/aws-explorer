package com.pintailconsultingllc.awsexplorer.services

import software.amazon.awssdk.regions.Region

interface PreferencesService {
    fun getRegion(): Region
}

class PreferencesServiceImpl : PreferencesService {

    override fun getRegion(): Region {
        return Region.US_EAST_1
    }
}