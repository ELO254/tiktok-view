package com.example.titktokview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var vidolist = listOf(video(Uri.parse("android.resource://$packageName/${R.raw.video1}"), "video1", emptyList()))

        var recycler:RecyclerView = findViewById(R.id.recycler)
        var adapter = videoAdapter(vidolist){
            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            shareIntent.type = "text/plain"

            shareIntent.putExtra(Intent.EXTRA_TEXT, "this video:${it.video}")
            startActivity(shareIntent)
        }

        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)






    }
}