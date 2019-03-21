package jp.yama.mvvm001

class MainViewModel(fn: (MainViewModelState) -> Unit): ViewModel<MainViewModelState> {

    var val1: String = "empty"
        private set
    var val2: Boolean = true
        private set

    override val stateDidUpdate: (MainViewModelState) -> Unit = fn

    fun updateVal1(value: String) {
        this.val1 = value
        this.stateDidUpdate(MainViewModelState.Lbl1ValueChanged)
    }

    fun updateVal2() {
        this.val2 = !this.val2
        this.stateDidUpdate(MainViewModelState.Lbl2ValueChanged)
    }

}