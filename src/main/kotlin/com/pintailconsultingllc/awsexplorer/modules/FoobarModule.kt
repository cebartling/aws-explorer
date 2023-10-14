package com.pintailconsultingllc.awsexplorer.modules

import com.google.inject.AbstractModule
import com.google.inject.name.Names

class FoobarModule : AbstractModule() {

    override fun configure() {
        bind(String::class.java).annotatedWith(Names.named("app-title-string"))
            .toInstance("AWS Explorer")
        bind(String::class.java).annotatedWith(Names.named("hello-world-string"))
            .toInstance("Hello World!")
    }
}