package me.wailynnzaw.ktodolist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater.from
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import kotlinx.android.synthetic.main.todo_item_layout.view.*

/**
 * Created by WaiLynnZaw on 5/18/17.
 */
class TodoAdapter(private val items: MutableList<Todo>) : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    private val mClickListener: View.OnClickListener

    init {
        mClickListener = View.OnClickListener { v ->
            val item = v.tag as Todo
            Toast.makeText(v.context, item.title, LENGTH_SHORT).show()
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun add(item: Todo){
        items.add(0,item)
        notifyItemInserted(0)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        if (holder != null){
            holder.title.text = items[position].title
            with(holder.touchView){
                tag = items[position]
                setOnClickListener(mClickListener)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutInflater = from(parent!!.context)
        return ViewHolder(layoutInflater.inflate(R.layout.todo_item_layout, parent, false))
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.txt_title!!
        val touchView = view.touch_view!!
    }

}