package denis.le.christ.darylles.mahougnon.gangnito.bumaye_app

import adapter.ClientAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import repository.ClientRepository

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ClientAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab = findViewById<FloatingActionButton>(R.id.fabAjouter)
        val recyclerView = findViewById<RecyclerView>(R.id.clientTv)

        recyclerView.layoutManager = LinearLayoutManager(this)

        // Déclaration ici mais accessible dans onResume
        adapter = ClientAdapter(ClientRepository.clients)
        recyclerView.adapter = adapter

        fab.setOnClickListener {
            val intent = Intent(this, AddClientActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}
