package com.example.titktokview

import android.content.Context
import android.content.Intent
import android.service.controls.actions.FloatAction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.MediaController
import android.widget.TextView
import android.widget.VideoView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class videoAdapter (var videoList:List<video>, var onshare:((video) -> Unit)):RecyclerView.Adapter<videoAdapter.ViewHolder>(){
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        var video:VideoView = view.findViewById(R.id.videoView2)
        var btnLike:FloatingActionButton = view.findViewById(R.id.btnlike)
        var txtlike:TextView = view.findViewById(R.id.txtlike)
        var btncomment:FloatingActionButton = view.findViewById(R.id.btncomment)
        var btnshare:FloatingActionButton = view.findViewById(R.id.btnshare)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.videolayout,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return videoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var d = videoList[position]

        holder.video.setVideoURI(d.video)
        var media = MediaController(holder.itemView.context)
        media.setAnchorView(holder.video)
        holder.video.setMediaController(media)
        holder.video.setOnPreparedListener{
            it.start()
        }



        holder.btnLike.setOnClickListener {
            holder.txtlike.text = likes.likesf().toString()
        }
        onshare.let { click->
            holder.btnshare.setOnClickListener { click(d) }
        }








    }
}