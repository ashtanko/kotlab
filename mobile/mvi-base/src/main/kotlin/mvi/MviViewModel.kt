package mvi

import androidx.annotation.CallSuper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import common.ui.livedata.SingleLiveData
import timber.log.Timber

open class MviViewModel<STATE, SIDE_EFFECT, EVENT> : ViewModel(), ViewModelContract<EVENT> {

    private val _viewStates: MutableLiveData<STATE> = MutableLiveData()
    fun viewStates(): LiveData<STATE> = _viewStates

    private var _viewState: STATE? = null
    protected var viewState: STATE
        get() = _viewState
            ?: throw UninitializedPropertyAccessException("\"viewState\" was queried before being initialized")
        set(value) {
            Timber.d("setting viewState : $value")
            _viewState = value
            _viewStates.value = value
        }

    private val _viewEffects: SingleLiveData<SIDE_EFFECT> = SingleLiveData()
    fun viewEffects(): SingleLiveData<SIDE_EFFECT> = _viewEffects

    private var _viewEffect: SIDE_EFFECT? = null
    protected var viewEffect: SIDE_EFFECT
        get() = _viewEffect
            ?: throw UninitializedPropertyAccessException("\"viewEffect\" was queried before being initialized")
        set(value) {
            Timber.d("setting viewEffect : $value")
            _viewEffect = value
            _viewEffects.value = value
        }

    @CallSuper
    override fun process(viewEvent: EVENT) {
        if (!viewStates().hasObservers()) {
            throw NoObserverAttachedException("No observer attached. In case of custom View \"startObserving()\" function needs to be called manually.")
        }
        Timber.d("processing viewEvent: $viewEvent")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleared")
    }
}
