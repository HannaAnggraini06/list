package com.example.list

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private  lateinit var rvMakanan: RecyclerView
    private val list = ArrayList<Makanan>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMakanan = findViewById(R.id.rv_makanan)
        rvMakanan.setHasFixedSize(true)

        list.addAll(getListMakanan())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_listt -> {
                rvMakanan.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvMakanan.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("Recycle")
    private fun getListMakanan(): ArrayList<Makanan> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listMakanan = ArrayList<Makanan>()
        for (i in dataName.indices) {
            val makanan = Makanan(dataName[i], dataDesc[i], dataPhoto.getResourceId(i, -1))
            listMakanan.add(makanan)
        }
        return listMakanan
    }

    private fun showRecyclerList() {
        rvMakanan.layoutManager = LinearLayoutManager(this)
        val listMakananAdapter = ListMakananAdapter(list)
        rvMakanan.adapter = listMakananAdapter

        listMakananAdapter.setOnItemClickCallback(object  : ListMakananAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Makanan) {
                val intent = Intent(this@MainActivity, Detail::class.java)
                intent.putExtra(Detail.KEY_NAME, data.name)
                intent.putExtra(Detail.KEY_DESC, data.desc)
                intent.putExtra(Detail.KEY_IMAGE, data.photo)
                startActivity(intent)
            }
        })
    }

    private fun showSelectedMakanan(makanan: Makanan) {
        Toast.makeText(this, "Kamu memilih" + makanan.name, Toast.LENGTH_SHORT).show()
    }
}