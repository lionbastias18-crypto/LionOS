package com.lionos

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logo = findViewById<ImageView>(R.id.logoLion)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val loading = findViewById<TextView>(R.id.loadingText)

        val fade = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val pulse = AnimationUtils.loadAnimation(this, R.anim.pulse)

        logo.startAnimation(fade)
        loading.startAnimation(pulse)

        val mediaPlayer = MediaPlayer.create(this, R.raw.boot)
        mediaPlayer.start()

        Thread {

            val messages = arrayOf(
                "Inicializando LionOS...",
                "Cargando núcleo...",
                "Verificando memoria...",
                "Iniciando interfaz...",
                "Preparando sistema..."
            )

            for (i in 0..100 step 5) {

                Thread.sleep(200)

                runOnUiThread {

                    progressBar.progress = i

                    when {
                        i >= 20 -> loading.text = messages[1]
                        i >= 40 -> loading.text = messages[2]
                        i >= 60 -> loading.text = messages[3]
                        i >= 80 -> loading.text = messages[4]
                    }
                }
            }

            startActivity(Intent(this, LockScreenActivity::class.java))
            finish()

        }.start()
    }
}