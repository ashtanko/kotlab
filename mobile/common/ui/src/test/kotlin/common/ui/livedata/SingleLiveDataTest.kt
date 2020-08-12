package common.ui.livedata

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LifecycleOwner
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import common.ui.extensions.observe
import dev.shtanko.testing.lifecycle.TestLifecycleOwner
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class SingleLiveDataTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var lifecycleOwner: LifecycleOwner

    @Before
    fun setUp() {
        lifecycleOwner = TestLifecycleOwner()
    }

    @Test
    fun `observing single live data when post string value should trigger one event`() {
        val singleLiveData = SingleLiveData<String>()
        val observerPostValue = "Event Value"
        val observer = mock<(String) -> Unit>()
        val observerCaptor = argumentCaptor<String>()
        lifecycleOwner.observe(singleLiveData, observer)
        singleLiveData.postValue(observerPostValue)

        Mockito.verify(observer).invoke(observerCaptor.capture())
        Assert.assertEquals(observerPostValue, observerCaptor.lastValue)
    }

    @Test
    fun `observing single live data when post multiple int value should trigger multiple times`() {
        val singleLiveData = SingleLiveData<Int>()
        val observerPostValue = 1
        val observer = mock<(Int) -> Unit>()
        val observerCaptor = argumentCaptor<Int>()

        lifecycleOwner.observe(singleLiveData, observer)
        singleLiveData.postValue(observerPostValue)
        singleLiveData.postValue(observerPostValue)

        Mockito.verify(observer, times(2)).invoke(observerCaptor.capture())
        Assert.assertEquals(observerPostValue, observerCaptor.lastValue)

        singleLiveData.postValue(observerPostValue)

        Mockito.verify(observer, times(3)).invoke(observerCaptor.capture())
        Assert.assertEquals(observerPostValue, observerCaptor.lastValue)
    }

    @Test
    fun `multiple observing single live data when post int value should trigger only first observer`() {
        val singleLiveData = SingleLiveData<String>()
        val observerPostValue = "Event Value"
        val observer1 = mock<(String) -> Unit>()
        val observer2 = mock<(String) -> Unit>()
        val observer3 = mock<(String) -> Unit>()
        val observer1Captor = argumentCaptor<String>()

        lifecycleOwner.observe(singleLiveData, observer1)
        lifecycleOwner.observe(singleLiveData, observer2)
        lifecycleOwner.observe(singleLiveData, observer3)
        singleLiveData.postValue(observerPostValue)

        Mockito.verify(observer1).invoke(observer1Captor.capture())
        Mockito.verify(observer2, Mockito.never()).invoke(Mockito.anyString())
        Mockito.verify(observer3, Mockito.never()).invoke(Mockito.anyString())

        Assert.assertEquals(observerPostValue, observer1Captor.lastValue)
    }

    @Test
    fun `observing single live data without post value should not trigger`() {
        val singleLiveData = SingleLiveData<Int>()
        val observer = mock<(Int) -> Unit>()

        lifecycleOwner.observe(singleLiveData, observer)

        Mockito.verify(observer, Mockito.never()).invoke(Mockito.anyInt())
    }
}
