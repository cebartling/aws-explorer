package com.pintailconsultingllc.awsexplorer.services


interface IdentityService {
    fun signIn(username: String, password: String)
}

class IdentityServiceImpl : IdentityService {

    override fun signIn(username: String, password: String) {
        println("Signing in with username: $username and password: $password")
    }
}