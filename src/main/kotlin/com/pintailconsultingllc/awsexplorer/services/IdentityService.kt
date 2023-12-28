package com.pintailconsultingllc.awsexplorer.services

import jakarta.inject.Singleton


interface IdentityService {
    fun signIn(username: String, password: String)
}

@Singleton
class IdentityServiceImpl : IdentityService {

    override fun signIn(username: String, password: String) {
        println("Signing in with username: $username and password: $password")
    }
}