package br.com.ioasys.appcamp.commons.extensions

import br.com.ioasys.appcamp.commons.enum.RegexEnum

fun String.isEmail() = RegexEnum.EMAIL.match(this)
fun String.isNotEmail() = this.isEmail().not()