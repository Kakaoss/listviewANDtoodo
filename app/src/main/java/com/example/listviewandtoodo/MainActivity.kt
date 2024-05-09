package com.example.listviewandtoodo

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var noteList: ArrayList<String>
    private lateinit var arrayAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteList = ArrayList()
        noteList.add("Zakupy: chleb, masło, ser")
        noteList.add("Do zrobienia: obiad, umyć podłogi")
        noteList.add("weekend: kino, spacer z psem")

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, noteList)

        val listView = findViewById<ListView>(R.id.listview)
        listView.adapter = arrayAdapter
    }

    fun onClick(view: View) {
        val editText = findViewById<EditText>(R.id.edittextDodajElement)
        val note = editText.text.toString()

        noteList.add(note)
        arrayAdapter.notifyDataSetChanged()
    }
}