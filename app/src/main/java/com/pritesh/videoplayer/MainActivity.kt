package com.pritesh.videoplayer

import android.widget.MediaController
import android.widget.VideoView
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.pritesh.videoplayer.databinding.ActivityMainBinding
import android.net.Uri // Add this import statement for Uri

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the VideoView class by its id
        val videoView = findViewById<VideoView>(R.id.testView)

        // Creating MediaController
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        // Specify the location of media file
        val uri = Uri.parse(
            "android.resource://" + packageName + "/raw/test"
        )

        // Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
    }
}
