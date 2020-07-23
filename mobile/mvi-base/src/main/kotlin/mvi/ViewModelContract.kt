package mvi

internal interface ViewModelContract<EVENT> {
    fun process(viewEvent: EVENT)
}
