package common.ui.extensions

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.times
import dev.shtanko.testing.lifecycle.TestLifecycleOwner
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class LifecycleOwnerExtensionsTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var lifecycleOwner: LifecycleOwner

    @Before
    fun setUp() {
        lifecycleOwner = TestLifecycleOwner()
    }

    @Test
    fun `observing mutable live data when post string value should trigger`() {
        val mutableLiveData = MutableLiveData<String>()
        val observerPostValue = "Event Value"
        val observer = mock<(String) -> Unit>()
        val observerCaptor = argumentCaptor<String>()

        lifecycleOwner.observe(mutableLiveData, observer)
        mutableLiveData.postValue(observerPostValue)

        Mockito.verify(observer).invoke(observerCaptor.capture())
        Assert.assertEquals(observerPostValue, observerCaptor.lastValue)
    }

    @Test
    fun `observing mutable live data when post multiple int value should trigger multiple times`() {
        val mutableLiveData = MutableLiveData<Int>()
        val observerPostValue = 3
        val observer = mock<(Int) -> Unit>()
        val observerCaptor = argumentCaptor<Int>()

        lifecycleOwner.observe(mutableLiveData, observer)
        mutableLiveData.postValue(observerPostValue)
        mutableLiveData.postValue(observerPostValue)

        Mockito.verify(observer, times(2)).invoke(observerCaptor.capture())
        Assert.assertEquals(observerPostValue, observerCaptor.lastValue)

        mutableLiveData.postValue(observerPostValue)

        Mockito.verify(observer, times(3)).invoke(observerCaptor.capture())
        Assert.assertEquals(observerPostValue, observerCaptor.lastValue)
    }

    @Test
    fun `observing mutable live data when post null value should not trigger`() {
        val mutableLiveData = MutableLiveData<Int>()
        val observer = mock<(Int) -> Unit>()

        lifecycleOwner.observe(mutableLiveData, observer)
        mutableLiveData.postValue(null)

        Mockito.verify(observer, never()).invoke(Mockito.anyInt())
    }

    @Test
    fun `observing mutable live data without post value should not trigger`() {
        val mutableLiveData = MutableLiveData<Int>()
        val observer = mock<(Int) -> Unit>()

        lifecycleOwner.observe(mutableLiveData, observer)

        Mockito.verify(observer, never()).invoke(Mockito.anyInt())
    }

    @Test
    fun `observing live data when post string value should trigger`() {
        val mutableLiveData = MutableLiveData<String>()
        val liveData: LiveData<String> = mutableLiveData
        val observerPostValue = "Event Value"
        val observer = mock<(String) -> Unit>()
        val observerCaptor = argumentCaptor<String>()

        lifecycleOwner.observe(liveData, observer)
        mutableLiveData.postValue(observerPostValue)

        Mockito.verify(observer).invoke(observerCaptor.capture())
        Assert.assertEquals(observerPostValue, observerCaptor.lastValue)
    }

    @Test
    fun `observing live data when post multiple int value should trigger multiple times`() {
        val mutableLiveData = MutableLiveData<Int>()
        val liveData: LiveData<Int> = mutableLiveData
        val observerPostValue = 3
        val observer = mock<(Int) -> Unit>()
        val observerCaptor = argumentCaptor<Int>()

        lifecycleOwner.observe(liveData, observer)
        mutableLiveData.postValue(observerPostValue)
        mutableLiveData.postValue(observerPostValue)

        Mockito.verify(observer, times(2)).invoke(observerCaptor.capture())
        Assert.assertEquals(observerPostValue, observerCaptor.lastValue)

        mutableLiveData.postValue(observerPostValue)

        Mockito.verify(observer, times(3)).invoke(observerCaptor.capture())
        Assert.assertEquals(observerPostValue, observerCaptor.lastValue)
    }

    @Test
    fun `observing live data when post null value should not trigger`() {
        val mutableLiveData = MutableLiveData<Int>()
        val liveData: LiveData<Int> = mutableLiveData
        val observer = mock<(Int) -> Unit>()

        lifecycleOwner.observe(liveData, observer)
        mutableLiveData.postValue(null)

        Mockito.verify(observer, never()).invoke(Mockito.anyInt())
    }

    @Test
    fun `observing live data without post value should not trigger`() {
        val mutableLiveData = MutableLiveData<Int>()
        val liveData: LiveData<Int> = mutableLiveData
        val observer = mock<(Int) -> Unit>()

        lifecycleOwner.observe(liveData, observer)

        Mockito.verify(observer, never()).invoke(Mockito.anyInt())
    }
}
