package dev.shtanko.hawk.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.TooltipCompat
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.SpotifyAppRemote
import dev.shtanko.core.extensions.isDarkTheme
import dev.shtanko.hawk.R
import dev.shtanko.hawk.databinding.ActivityMusicBinding
import dev.shtanko.hawk.di.connectionParams
import dev.shtanko.hawk.ui.profile.ProfileActivity

class MusicActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMusicBinding

    companion object {
        private const val TOOLBAR_ANIM_DELAY = 500L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbar)

        setupToolbar()

        SpotifyAppRemote.connect(this, connectionParams, object : Connector.ConnectionListener {
            override fun onFailure(p0: Throwable?) {
                p0?.printStackTrace()
            }

            override fun onConnected(p0: SpotifyAppRemote?) {
                TODO("Not yet implemented")
            }
        })
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

            val profileItem = toolbar.menu.findItem(R.id.menu_profile)

            profileItem.setOnMenuItemClickListener {
                val intent = Intent(this@MusicActivity, ProfileActivity::class.java)
                startActivity(intent)
                true
            }

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
