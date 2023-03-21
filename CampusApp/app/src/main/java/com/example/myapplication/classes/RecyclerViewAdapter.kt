package com.example.myapplication.classes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private val itemTitles = arrayOf("Let's go to the cinema!", "Game Night!!!!", "Post Malone's concert!", "Someone to join me on a 1v1 in football?", "Neon Part!", "Trip to the beach")
    private val itemDescription = arrayOf("A trip to the cinema is an entertaining and immersive experience to watch movies on the big screen.","Game night is a fun and social event where friends or family gather to play games and enjoy each other's company.","A concert is a live music performance where people come together to enjoy the music, atmosphere and energy of the event.","A sport is a physical activity or game that involves skill, strategy, and competition, often played individually or in teams for entertainment or fitness.", "A neon party is a vibrant and colorful event where guests dress up in bright neon colors and dance under ultraviolet lights for a visually striking and energetic experience.","A trip to the beach offers a relaxing escape with sun, sand, and sea.")

    private val itemImages = intArrayOf(
        R.drawable.cinema,
        R.drawable.gamenightlogocolor,
        R.drawable.concerto,
        R.drawable.desporto1,
        R.drawable.festa,
        R.drawable.praia
    )

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var image : ImageView
        var textTitle : TextView
        var textDescription : TextView

        init {
            image = itemView.findViewById(R.id.item_image)
            textTitle = itemView.findViewById(R.id.item_title)
            textDescription = itemView.findViewById(R.id.item_description)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_dashboard, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return itemTitles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textTitle.text = itemTitles[position]
        holder.textDescription.text = itemDescription[position]
        holder.image.setImageResource(itemImages[position])

        holder.itemView.setOnClickListener{v: View ->
            Toast.makeText(v.context, "Clicked on the item", Toast.LENGTH_SHORT).show()
        }
    }
}