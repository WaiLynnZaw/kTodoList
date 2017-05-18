package me.wailynnzaw.ktodolist

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home.*

class MainActivity : AppCompatActivity() {
    lateinit var mAdapter: TodoAdapter
    var items: MutableList<Todo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        mAdapter = TodoAdapter(items)
        showData()

        fab_add.setOnClickListener {
            startActivityForResult(AddItemActivity.newIntent(this@MainActivity),100)
        }
    }

    private fun showData() {
        with(recyclerView) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mAdapter
        }

        items.add(Todo("hello", "kotlin"))
        items.add(Todo("kotlin", "is cool"))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 100 && resultCode == Activity.RESULT_OK){
            if (data != null) {
                items.add(data.getSerializableExtra("data") as Todo)
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
