package com.ragabz.picsum.base

interface Reducer<S : State, A : Action> {
    fun reduce(currentState: S, action: A): S
}