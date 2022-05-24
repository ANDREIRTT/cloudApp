package com.mal.cloud.state

sealed interface UIState<T> {
    class Loading<T> : UIState<T>
    class Error<T>(val error: String?) : UIState<T>
    class Success<T>(val data: T) : UIState<T>
}