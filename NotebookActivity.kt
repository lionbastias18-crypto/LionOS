package com.lionos

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NotebookActivity : AppCompatActivity() {

    private lateinit var noteEditText: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notebook)

        noteEditText =
            findViewById(R.id.noteEditText)

        saveButton =
            findViewById(R.id.saveButton)

        val prefs =
            getSharedPreferences(
                "NotebookLion",
                Context.MODE_PRIVATE
            )

        // Cargar nota guardada

        noteEditText.setText(
            prefs.getString(
                "note",
                ""
            )
        )

        // Guardar nota

        saveButton.setOnClickListener {

            prefs.edit()
                .putString(
                    "note",
                    noteEditText.text.toString()
                )
                .apply()

            Toast.makeText(
                this,
                "Nota guardada",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}