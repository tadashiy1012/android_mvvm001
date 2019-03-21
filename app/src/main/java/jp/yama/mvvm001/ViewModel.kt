package jp.yama.mvvm001

interface ViewModel<T> {
    val stateDidUpdate: ((T) -> Unit)
}