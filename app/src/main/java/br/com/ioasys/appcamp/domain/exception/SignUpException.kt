package br.com.ioasys.appcamp.domain.exception

import kotlin.Exception

open class SignUpException : Exception()

class InvalidPasswordException: SignUpException()
class InvalidEmailException: SignUpException()
class EmptyInputException: SignUpException()