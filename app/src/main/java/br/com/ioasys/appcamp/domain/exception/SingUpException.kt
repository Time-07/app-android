package br.com.ioasys.appcamp.domain.exception

import kotlin.Exception

open class SingUpException : Exception()

class InvalidPasswordException: SingUpException()
class InvalidEmailException: SingUpException()
class EmptyInputException: SingUpException()