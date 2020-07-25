package dev.shtanko.hawk.ui.profile

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import dev.shtanko.hawk.repository.ProfileRepository
import dev.shtanko.hawk.ui.profile.mapper.UserMapper
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import testing.CoroutineRule

class ProfileViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutineRule()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @MockK(relaxed = true)
    lateinit var profileRepository: ProfileRepository

    @MockK
    lateinit var userMapper: UserMapper

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }
}
