package common.ui.bindings

import android.view.View
import common.ui.binding.gone
import common.ui.binding.invisible
import common.ui.binding.visible
import dev.shtanko.testing.robolectric.TestRobolectric
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ViewBindingsTest : TestRobolectric() {

    private lateinit var view: View

    @Before
    fun setUp() {
        view = View(context)
    }

    @Test
    fun `on view visibility visible should be visible`() {
        view.visibility = View.VISIBLE
        Assert.assertTrue(view.visible)
        Assert.assertFalse(view.invisible)
        Assert.assertFalse(view.gone)
    }

    @Test
    fun `on view visibility invisible should be invisible`() {
        view.visibility = View.INVISIBLE
        Assert.assertTrue(view.invisible)
        Assert.assertFalse(view.visible)
        Assert.assertFalse(view.gone)
    }

    @Test
    fun `on view visibility gone should be gone`() {
        view.visibility = View.GONE
        Assert.assertTrue(view.gone)
        Assert.assertFalse(view.visible)
        Assert.assertFalse(view.invisible)
    }

    @Test
    fun `force view visibility as visible`() {
        view.visible = true
        Assert.assertTrue(view.visibility == View.VISIBLE)
    }

    @Test
    fun `force view visibility as non visible`() {
        view.visible = false
        Assert.assertTrue(view.visibility == View.GONE)
    }

    @Test
    fun `force view visibility as invisible`() {
        view.invisible = true
        Assert.assertTrue(view.visibility == View.INVISIBLE)
    }

    @Test
    fun `force view visibility as non invisible`() {
        view.invisible = false
        Assert.assertTrue(view.visibility == View.VISIBLE)
    }

    @Test
    fun `force view visibility as gone`() {
        view.gone = true
        Assert.assertTrue(view.visibility == View.GONE)
    }

    @Test
    fun `force view visibility as non gone`() {
        view.gone = false
        Assert.assertTrue(view.visibility == View.VISIBLE)
    }
}
