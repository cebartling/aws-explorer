package com.pintailconsultingllc.awsexplorer.modules

import com.google.inject.AbstractModule
import com.pintailconsultingllc.awsexplorer.controllers.SceneManager
import com.pintailconsultingllc.awsexplorer.controllers.SceneManagerImpl
import com.pintailconsultingllc.awsexplorer.guice.GuiceFXMLLoader
import com.pintailconsultingllc.awsexplorer.guice.GuiceFXMLLoaderImpl
import com.pintailconsultingllc.awsexplorer.services.*

class GuiceModule : AbstractModule() {
    override fun configure() {
        bind(GuiceFXMLLoader::class.java).to(GuiceFXMLLoaderImpl::class.java)
        bind(SceneManager::class.java).to(SceneManagerImpl::class.java)
        bind(IdentityService::class.java).to(IdentityServiceImpl::class.java)
        bind(PreferencesService::class.java).to(PreferencesServiceImpl::class.java)
        bind(CloudFormationService::class.java).to(CloudFormationServiceImpl::class.java)
    }
}
