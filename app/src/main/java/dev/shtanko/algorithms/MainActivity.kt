package dev.shtanko.algorithms

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.TooltipCompat
import dev.shtanko.algorithms.databinding.ActivityMainBinding
import dev.shtanko.algorithms.extensions.isDarkTheme

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        private const val TOOLBAR_ANIM_DELAY = 800L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbar)

        setupToolbar()
    }

    private fun setupToolbar() {
        with(binding) {
            toolbar.inflateMenu(R.menu.main)
            val toggleTheme = toolbar.menu.findItem(R.id.menu_theme)
            val actionView = toggleTheme.actionView
            (actionView as AppCompatCheckBox?)?.apply {
                setButtonDrawable(R.drawable.asl_theme)
                isChecked = isDarkTheme()
                jumpDrawablesToCurrentState()
                setOnCheckedChangeListener { _, isChecked ->
                    // delay to allow the toggle anim to run
                    postDelayed(
                        {
                            AppCompatDelegate.setDefaultNightMode(
                                if (isChecked)
                                    AppCompatDelegate.MODE_NIGHT_YES
                                else
                                    AppCompatDelegate.MODE_NIGHT_NO
                            )
                            delegate.applyDayNight()
                        },
                        TOOLBAR_ANIM_DELAY
                    )
                }
                TooltipCompat.setTooltipText(this, getString(R.string.theme))
            }
        }
    }
}
