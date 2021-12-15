package com.ragabz.picsum.base

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import timber.log.Timber

class Store<S : State, A : Action>(
    initialState: S,
    private val reducer: Reducer<S, A>
) {
    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<S> = _state

    fun dispatch(action: A) {
        val currentState = _state.value
        val newState = reducer.reduce(currentState, action)
        Timber.i("dispatch() --> newState: ${newState.toString()}")
        _state.value = newState
    }
}