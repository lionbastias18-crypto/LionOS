package com.lionos

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // =====================================
        // USER MANAGER
        // =====================================

        val userManager = UserManager(this)

        userManager.saveUser("Lion")

        val userName =
            findViewById<TextView>(R.id.userName)

        userName.text =
            userManager.getUser()

        // =====================================
        // WIDGETS
        // =====================================

        val recycler =
            findViewById<RecyclerView>(
                R.id.widgetRecycler
            )

        recycler.layoutManager =
            GridLayoutManager(this, 2)

        val widgets = listOf(
            "Hora",
            "Clima",
            "RAM",
            "CPU",
            "Calendario",
            "Música"
        )

        recycler.adapter =
            WidgetAdapter(widgets)

        // =====================================
        // ICONOS
        // =====================================

        val binApp =
            findViewById<ImageView>(R.id.binApp)

        val filesApp =
            findViewById<ImageView>(R.id.filesApp)

        val storeApp =
            findViewById<ImageView>(R.id.storeApp)

        val settingsApp =
            findViewById<ImageView>(R.id.settingsApp)

        val browserApp =
            findViewById<ImageView>(R.id.browserApp)

        val musicApp =
            findViewById<ImageView>(R.id.musicApp)
            
        val notebookApp =
            findViewById<ImageView>(R.id.notebookApp)
            
        val calendarApp =
            findViewById<ImageView>(
            R.id.calendarApp
    )

        // =====================================
        // PAPELERA
        // =====================================

        binApp.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    BinActivity::class.java
                )
            )
        }

        // =====================================
        // ARCHIVOS
        // =====================================

        filesApp.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    FilesActivity::class.java
                )
            )
        }

        // =====================================
        // STORE
        // =====================================

        storeApp.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    StoreActivity::class.java
                )
            )
        }

        // =====================================
        // CONFIG
        // =====================================

        settingsApp.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    SettingsActivity::class.java
                )
            )
        }

        // =====================================
        // BROWSER
        // =====================================

        browserApp.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    BrowserActivity::class.java
                )
            )
        }

        // =====================================
        // MUSIC
        // =====================================

        musicApp.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    MusicActivity::class.java
                    
        notebookApp.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    NotebookActivity::class.java

        calendarApp.setOnClickListener {

            startActivity(
                Intent(
                     this,
                     CalendarActivity::class.java
        )
    )
}