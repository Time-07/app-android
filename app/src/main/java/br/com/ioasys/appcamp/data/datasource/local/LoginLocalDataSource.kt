package br.com.ioasys.appcamp.data.datasource.local

interface LoginLocalDataSource {

    fun saveAccessToken(accessToken: String)
}