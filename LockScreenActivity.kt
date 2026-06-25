package com.lionos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LockScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lock)

        val unlock = findViewById<Button>(R.id.unlockButton)

        unlock.setOnClickListener {

            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }
    }
}