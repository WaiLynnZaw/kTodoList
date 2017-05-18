package me.wailynnzaw.ktodolist

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import kotlinx.android.synthetic.main.activity_add_item.*

class AddItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)

        btn_add.setOnClickListener {
            if (et_title.text.isEmpty() || et_desc.text.isEmpty()){
                Toast.makeText(this@AddItemActivity,"Please fill data!", LENGTH_SHORT).show()
            } else {
                val intent = Intent()
                intent.putExtra("data",Todo(et_title.text.toString(), et_desc.text.toString()))
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, AddItemActivity::class.java)
            return intent
        }
    }
}
