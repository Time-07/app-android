package br.com.ioasys.appcamp.domain.utils

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlin.coroutines.CoroutineContext

abstract class UseCase<in Params, out T>(
    private val scope: CoroutineScope
){
    abstract fun run(params: Params? = null): Flow<T>

    operator fun invoke(
        params: Params?,
        onSuccess: (T) -> Unit = {},
        onError: (Throwable) -> Unit = {}
    ){
        scope.launch(handleError(onError)) {
                run(params = params).collect {
                    onSuccess(it)
                }
        }
    }

    private fun handleError(onError: (Throwable) -> Unit): CoroutineContext {
        return CoroutineExceptionHandler { _, throwable -> onError(throwable) }
    }
}