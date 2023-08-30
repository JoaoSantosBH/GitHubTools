package com.carrefour.desafio.android.githubtools

import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.carrefour.desafio.android.githubtools.core.navigation.AppNavigation
import com.carrefour.desafio.android.githubtools.ui.theme.AppTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    var counter = 0
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        delaySplash()
        setContent {
            AppTheme {
                val navController = rememberAnimatedNavController()
                AppNavigation(navController = navController)
            }
            val content: View = findViewById(android.R.id.content)
            content.viewTreeObserver.addOnPreDrawListener(
                object : ViewTreeObserver.OnPreDrawListener {
                    override fun onPreDraw(): Boolean {
                        return if (counter == 1) {
                            content.viewTreeObserver.removeOnPreDrawListener(this)
                            true
                        } else { false }
                    }
                }
            )
        }
    }

    private fun delaySplash() {
        lifecycleScope.launch {
            delay(2000)
            counter = 1
        }
    }
}