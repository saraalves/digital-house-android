package com.example.splashscreendemo

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.TextView

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        colocarActivityEmFullScreen()

        animaTexto()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000)
    }

    private fun animaTexto() {
        val appName = findViewById<TextView>(R.id.appName)
        appName.alpha = 0f
        appName.y = 1000f

        appName.animate()
            .alpha(1f)
            .y(800f)
            .setDuration(1500)
            .setListener(null)

    }

    @Suppress("DEPRECATION")
    private fun colocarActivityEmFullScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }
}