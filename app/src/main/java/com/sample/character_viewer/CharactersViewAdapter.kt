package com.sample.character_viewer

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import com.sample.character_viewer.model.RelatedTopics


class CharactersViewAdapter(private var characterList: MutableList<RelatedTopics>) : RecyclerView.Adapter<CharactersViewAdapter.ViewHolder>(), View.OnClickListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //api does not provided character name field
        val characterName : String = characterList[position].firstURL
        holder.title.text = characterName.replace("https://duckduckgo.com/", "")
        holder.itemView.tag = position
        holder.itemView.setOnClickListener(this)

    }

    override fun getItemCount(): Int {
        return characterList.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title : TextView = view.findViewById(R.id.tv_title)

    }

    override fun onClick(v: View?) {
        val relatedTopics = characterList[v!!.tag as Int]
        relatedTopics.let {
            val directions =
                CharactersViewFragmentDirections.actionCharactersViewFragmentToDetailViewFragment(it)
            v.findNavController().navigate(directions)
        }
    }
    fun updateList(list:MutableList<RelatedTopics>) {
        characterList = list
        notifyDataSetChanged()
    }
}