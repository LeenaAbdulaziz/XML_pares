package com.example.xml_pares

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    lateinit var stu: List<Student_details>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.rv)

        try {
            val parser = XmlPullParserHandler()
            val istream = assets.open("students.xml")
            stu=  parser.parse(istream)

            recyclerView.adapter = RVAdapter(stu)
            recyclerView.layoutManager = LinearLayoutManager(this)

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
