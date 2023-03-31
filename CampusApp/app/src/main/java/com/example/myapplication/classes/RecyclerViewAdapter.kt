package com.example.myapplication.classes

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.database.DatabaseInfo
import kotlinx.coroutines.NonDisposableHandle.parent

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    var itemTitles = arrayOf("Let's go to the cinema!")
    var itemDescription = arrayOf("A trip to the cinema is an entertaining and immersive experience to watch movies on the big screen.")
    var itemImages = intArrayOf(
        R.drawable.cinema
    )
/*    var itemTitles = emptyArray<String>()
    var itemDescription = emptyArray<String>()
    var itemImages = emptyArray<Int>()*/

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
        val db = DatabaseInfo(parent.context, null)
        val c = db.getEvents()
        c.moveToFirst()
        //val rva = RecyclerViewAdapter()
        while(c.moveToNext()){
            Log.d("aaaaaaaaaaaaaaaa", c.getString(1))
            if(!itemTitles.contains(c.getString(1))){
                itemTitles= itemTitles.plus(c.getString(1))
                itemDescription=itemDescription.plus(c.getString(5))
                when(c.getString(6)){
                    "Beach" -> itemImages=itemImages.plus(R.drawable.praia)
                    "Cinema" -> itemImages=itemImages.plus(R.drawable.cinema)
                    "Party" -> itemImages=itemImages.plus(R.drawable.festa)
                    "Sports" -> itemImages=itemImages.plus(R.drawable.desporto1)
                    "Game Night" -> itemImages=itemImages.plus(R.drawable.gamenightlogocolor)
                    "Concert" -> itemImages=itemImages.plus(R.drawable.concerto)
                }
            }
        }
        /*rva.notifyDataSetChanged()
        requireActivity().findViewById<RecyclerView>(R.id.recyclerView).adapter = rva*/
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.default_card, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return itemTitles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textTitle.text = itemTitles[position+1]
        holder.textDescription.text = itemDescription[position+1]
        holder.image.setImageResource(itemImages[position+1])
        holder.itemView.setOnClickListener { v: View ->
            Toast.makeText(v.context, "Clicked on the item", Toast.LENGTH_SHORT).show()
        }
    }

}