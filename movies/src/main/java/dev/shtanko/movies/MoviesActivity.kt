package dev.shtanko.movies

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.TooltipCompat
import dev.shtanko.algorithms.R
import dev.shtanko.algorithms.databinding.ActivityMoviesBinding
import dev.shtanko.core.extensions.isDarkTheme

class MoviesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMoviesBinding

    companion object {
        private const val TOOLBAR_ANIM_DELAY = 500L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbar)

        setupToolbar()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        setupToolbar()
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        return true
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
