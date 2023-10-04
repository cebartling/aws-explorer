package com.pintailconsultingllc.awsexplorer.modules

import com.google.inject.AbstractModule
import com.pintailconsultingllc.awsexplorer.services.IdentityService
import com.pintailconsultingllc.awsexplorer.services.IdentityServiceImpl
import com.pintailconsultingllc.awsexplorer.services.PreferencesService
import com.pintailconsultingllc.awsexplorer.services.PreferencesServiceImpl


class GuiceModule : AbstractModule() {
    override fun configure() {
        bind(IdentityService::class.java).to(IdentityServiceImpl::class.java)
        bind(PreferencesService::class.java).to(PreferencesServiceImpl::class.java)

//        bind(Communicator::class.java)
//            .annotatedWith(Names.named("DefaultCommunicator"))
//            .to(DefaultCommunicatorImpl::class.java)
    }
}
