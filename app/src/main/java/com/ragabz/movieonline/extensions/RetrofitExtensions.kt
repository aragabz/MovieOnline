package com.ragabz.movieonline.extensions



import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import timber.log.Timber
import com.ragabz.picsum.base.Result

fun <T> Response<T>.toFlow() = flow {
    emit(
        when (isSuccessful) {
            true -> {
                val appResponse = body() as T
                Timber.i("body: ${body()}")
                Timber.i("appResponse: $appResponse")
                Result.Success(appResponse)
            }
            false -> {
                Timber.e("exception in network to flow() --> ${errorBody().toString()}")
                Result.Error("Api failed")
            }
        }
    )
}.catch { e ->
    Timber.e("exception: $e")
    emit(Result.Error(e.message))
}

fun <T> Response<T>.whenSuccess(action: (T) -> Unit) {
    if (isSuccessful) {
        action.invoke(body() as T)
    }
}

fun <T> Response<T>.whenError(action: (Exception) -> Unit) {
    if (!isSuccessful)
        action.invoke(Exception(message()))
}
