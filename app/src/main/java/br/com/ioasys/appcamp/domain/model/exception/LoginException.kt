package br.com.ioasys.appcamp.domain.model.exception

import kotlin.Exception

open class LoginException : Exception()

class InvalidPassword: LoginException()
class InvalidEmail: LoginException()
class EmptyInput: LoginException()