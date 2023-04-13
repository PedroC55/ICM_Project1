package com.example.myapplication.classes

import android.app.Activity
import android.content.Context
import android.database.Cursor
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.database.DatabaseInfo
import com.example.myapplication.fragments.MainActivity
import kotlin.properties.Delegates


class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    var itemTitles = arrayOf("Porcos!")
    var itemDescription =
        arrayOf("A trip to the cinema is an entertaining and immersive experience to watch movies on the big screen.")
    var itemImages = intArrayOf(
        com.example.myapplication.R.drawable.cinema
    )

    lateinit var navCo: NavController
    var tag1 = "All"
    var itemid: Int = -1
/*    var itemTitles = emptyArray<String>()
    var itemDescription = emptyArray<String>()
    var itemImages = emptyArray<Int>()*/

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var textTitle: TextView
        var textDescription: TextView

        init {
            image = itemView.findViewById(com.example.myapplication.R.id.item_image)
            textTitle = itemView.findViewById(com.example.myapplication.R.id.item_title)
            textDescription = itemView.findViewById(com.example.myapplication.R.id.item_description)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("passseeeiii aquiiii", "passssssssssssssssssssss")
        val db = DatabaseInfo(parent.context, null)
        val c = db.getEventsByTag(tag1)
        c.moveToFirst()
        //if (c.count>0)
        itemTitles[0] = c.getString(1)
        itemDescription[0] = c.getString(5)
        when (c.getString(6)) {
            "Beach" -> itemImages[0] = (com.example.myapplication.R.drawable.praia)
            "Cinema" -> itemImages[0] = (com.example.myapplication.R.drawable.cinema)
            "Party" -> itemImages[0] = (com.example.myapplication.R.drawable.festa)
            "Sports" -> itemImages[0] = (com.example.myapplication.R.drawable.desporto1)
            "Game Night" -> itemImages[0] =
                (com.example.myapplication.R.drawable.gamenightlogocolor)
            "Concert" -> itemImages[0] = (com.example.myapplication.R.drawable.concerto)
        }
        while (c.moveToNext()) {
            if (!itemTitles.contains(c.getString(1))) {
                itemTitles = itemTitles.plus(c.getString(1))
                itemDescription = itemDescription.plus(c.getString(5))
                when (c.getString(6)) {
                    "Beach" -> itemImages =
                        itemImages.plus(com.example.myapplication.R.drawable.praia)
                    "Cinema" -> itemImages =
                        itemImages.plus(com.example.myapplication.R.drawable.cinema)
                    "Party" -> itemImages =
                        itemImages.plus(com.example.myapplication.R.drawable.festa)
                    "Sports" -> itemImages =
                        itemImages.plus(com.example.myapplication.R.drawable.desporto1)
                    "Game Night" -> itemImages =
                        itemImages.plus(com.example.myapplication.R.drawable.gamenightlogocolor)
                    "Concert" -> itemImages =
                        itemImages.plus(com.example.myapplication.R.drawable.concerto)
                }
            }
        }
        /*rva.notifyDataSetChanged()
        requireActivity().findViewById<RecyclerView>(R.id.recyclerView).adapter = rva*/
        val v = LayoutInflater.from(parent.context)
            .inflate(com.example.myapplication.R.layout.default_card, parent, false)
        return ViewHolder(v)
    }

    fun setNav(nav: NavController) {
        navCo = nav
    }

    fun getitemid(): Int {
        return itemid + 1
    }

    var u by Delegates.notNull<Int>()
    var ts by Delegates.notNull<Int>()
    var num by Delegates.notNull<Int>()

    fun setProfile(n: Int) {
        num = n
    }

    fun getProfile(): Int {
        return num
    }

    fun setCurrentUser(user: Int) {
        u = user
    }

    fun getCurrentUser(): Int {
        return u
    }

    fun setUserToSee(user: Int) {
        ts = user
    }

    fun getUserToSee(): Int {
        return ts
    }

    override fun getItemCount(): Int {
        return itemTitles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textTitle.text = itemTitles[position]
        holder.textDescription.text = itemDescription[position]
        holder.image.setImageResource(itemImages[position])
        holder.itemView.setOnClickListener { v: View ->
            Toast.makeText(
                v.context,
                "Clicked on the item: " + holder.textTitle.text.toString(),
                Toast.LENGTH_SHORT
            ).show()
            navCo.navigate(R.id.action_dashboardFragment_to_nearByEventsFragment)
            itemid = position
        }
    }

    fun hasTag(tag: String, db : DatabaseInfo) {
        tag1 = tag
        itemDescription = arrayOf()
        itemTitles = arrayOf()
        itemImages = intArrayOf()
        val c = db.getEventsByTag(tag)
        c.moveToFirst()
        if(c.count>0){
            itemTitles = itemTitles.plus(c.getString(1))
            itemDescription = itemDescription.plus(c.getString(5))
            Log.d("taggg", c.getString(6))
            when (c.getString(6)) {
                "Beach" -> itemImages =
                    itemImages.plus(com.example.myapplication.R.drawable.praia)
                "Cinema" -> itemImages =
                    itemImages.plus(com.example.myapplication.R.drawable.cinema)
                "Party" -> itemImages =
                    itemImages.plus(com.example.myapplication.R.drawable.festa)
                "Sports" -> itemImages =
                    itemImages.plus(com.example.myapplication.R.drawable.desporto1)
                "Game Night" -> itemImages =
                    itemImages.plus(com.example.myapplication.R.drawable.gamenightlogocolor)
                "Concert" -> itemImages =
                    itemImages.plus(com.example.myapplication.R.drawable.concerto)
            }
            while (c.moveToNext()) {
                if (!itemTitles.contains(c.getString(1))) {
                    itemTitles = itemTitles.plus(c.getString(1))
                    itemDescription = itemDescription.plus(c.getString(5))
                    when (c.getString(6)) {
                        "Beach" -> itemImages =
                            itemImages.plus(com.example.myapplication.R.drawable.praia)
                        "Cinema" -> itemImages =
                            itemImages.plus(com.example.myapplication.R.drawable.cinema)
                        "Party" -> itemImages =
                            itemImages.plus(com.example.myapplication.R.drawable.festa)
                        "Sports" -> itemImages =
                            itemImages.plus(com.example.myapplication.R.drawable.desporto1)
                        "Game Night" -> itemImages =
                            itemImages.plus(com.example.myapplication.R.drawable.gamenightlogocolor)
                        "Concert" -> itemImages =
                            itemImages.plus(com.example.myapplication.R.drawable.concerto)
                    }
                }
            }
        }

    }
}
