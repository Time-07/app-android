package br.com.ioasys.appcamp.commons.enum

enum class RegexEnum(
    val value: Regex
) {
    EMAIL("""^[a-z0-9_%+-]+([.-][a-z0-9]+)*@[a-z0-9]+([.-][a-z0-9]+)*\.[a-z]{2,3}$""".toRegex());

    fun match(text: String) = this.value.containsMatchIn(text)
}