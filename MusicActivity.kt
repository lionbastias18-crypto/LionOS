package com.lionos

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Timer
import java.util.TimerTask
import android.os.Handler
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.widget.Spinner

class MusicActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_music
        )

        // =====================================
        // COMPONENTES
        // =====================================

        val playButton =
            findViewById<Button>(R.id.playButton)

        val pauseButton =
            findViewById<Button>(R.id.pauseButton)
            
        val stopButton =
            findViewById<Button>(R.id.stopButton)

        val musicTitle =
            findViewById<TextView>(R.id.musicTitle)

        val seekBar =
            findViewById<SeekBar>(R.id.seekBar)

        val musicSeekBar =
            findViewById<SeekBar>(R.id.musicSeekBar)

        val songSpinner =
            findViewById<Spinner>(R.id.songSpinner)

        // =====================================
        // MP3
        // =====================================

        mediaPlayer =
            MediaPlayer.create(
                this,
                R.raw.lion_music
            )

        musicTitle.text =
            "Lion Music Player"

        seekBar.max =
            mediaPlayer.duration
            
            val songs = arrayOf(
    "Song",
    "Dance Playful",
    "Very"
)

val adapter = ArrayAdapter(
    this,
    android.R.layout.simple_spinner_item,
    songs
)

adapter.setDropDownViewResource(
    android.R.layout.simple_spinner_dropdown_item
)

songSpinner.adapter = adapter

songSpinner.onItemSelectedListener =
    
    object : AdapterView.OnItemSelectedListener {

        override fun onItemSelected(
            parent: AdapterView<*>?,
            view: android.view.View?,
            position: Int,
            id: Long
        ) {

            mediaPlayer = when(position) {

    0 -> {

        musicTitle.text = "Song"

        MediaPlayer.create(
            this@MusicActivity,
            R.raw.song
        )
    }

    1 -> {

        musicTitle.text = "Dance Playful"

        MediaPlayer.create(
            this@MusicActivity,
            R.raw.dance_playful
        )
    }

    else -> {

        musicTitle.text = "Very"

        MediaPlayer.create(
            this@MusicActivity,
            R.raw.very
        )
    }
}

            seekBar.max =
                mediaPlayer.duration
        }

        override fun onNothingSelected(
            parent: AdapterView<*>?
        ) {
        }
    }

        // =====================================
        // PLAY
        // =====================================

        playButton.setOnClickListener {

            mediaPlayer.start()
        }

        // =====================================
        // PAUSE
        // =====================================

        pauseButton.setOnClickListener {

            mediaPlayer.pause()
        }
    
    // =====================================
    // STOP
    // =====================================

       stopButton.setOnClickListener {

       if (mediaPlayer.isPlaying) {

        mediaPlayer.pause()
    }

    mediaPlayer.seekTo(0)

    seekBar.progress = 0
}
    
        // =====================================
        // SEEK BAR
        // =====================================

        seekBar.setOnSeekBarChangeListener(

            object : SeekBar.OnSeekBarChangeListener {

                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {

                    if (fromUser) {

                        mediaPlayer.seekTo(progress)
                    }
                }

                override fun onStartTrackingTouch(
                    seekBar: SeekBar?
                ) {
                }

                override fun onStopTrackingTouch(
                    seekBar: SeekBar?
                ) {
                }
            }
        )

        // =====================================
        // ACTUALIZAR BARRA
        // =====================================

        val timer = Timer()

        timer.scheduleAtFixedRate(

            object : TimerTask() {

                override fun run() {

                    seekBar.post {

                        seekBar.progress =
                            mediaPlayer.currentPosition
                    }
                }

            },

            0,
            1000
        )
    }

    override fun onDestroy() {

        super.onDestroy()

        mediaPlayer.release()
    }
}