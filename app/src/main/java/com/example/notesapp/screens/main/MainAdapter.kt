package com.example.notesapp.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.model.AppNote
import kotlinx.android.synthetic.main.note_item.view.*

class MainAdapter:RecyclerView.Adapter<MainAdapter.MainHolder>() {

    private var mListNotes = emptyList<AppNote>()

    override fun onViewAttachedToWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener {
            MainFragment.click(mListNotes[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    fun setList(list: List<AppNote>) {
        mListNotes = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.name_note.text = mListNotes[position].name
        holder.text_note.text = mListNotes[position].text
    }

    override fun getItemCount() = mListNotes.size

    class MainHolder(view:View): RecyclerView.ViewHolder(view) {
        val name_note: TextView = view.item_note_name
        val text_note: TextView = view.item_note_text
    }
}