package br.com.ioasys.appcamp.data.data_local.datasource

import br.com.ioasys.appcamp.data.data_local.utils.LocalConstants.ACCESS_TOKEN_KEY
import br.com.ioasys.appcamp.data_local.utils.SharedPreferencesHelper
import br.com.ioasys.appcamp.data.datasource.local.LoginLocalDataSource

class LoginLocalDataSourceImpl(
    private val sharedPreferencesHelper: SharedPreferencesHelper
): LoginLocalDataSource {
    override fun saveAccessToken(accessToken: String) = sharedPreferencesHelper.saveString(
        key = ACCESS_TOKEN_KEY,
        value = accessToken
    )

}