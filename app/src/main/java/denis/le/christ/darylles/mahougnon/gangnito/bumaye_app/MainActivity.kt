package denis.le.christ.darylles.mahougnon.gangnito.bumaye_app

import adapter._v_ClientAdapter
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import repository._v_ClientRepository

class MainActivity : AppCompatActivity() {

    private lateinit var _v_adapter: _v_ClientAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val _v_fab = findViewById<FloatingActionButton>(R.id._v_fabAjouter)
        val _v_recyclerView = findViewById<RecyclerView>(R.id._v_clientRv)

        _v_recyclerView.layoutManager = LinearLayoutManager(this)

        // Déclaration ici mais accessible dans onResume
        _v_adapter = _v_ClientAdapter(_v_ClientRepository._v_clients)
        _v_recyclerView.adapter = _v_adapter

        _v_fab.setOnClickListener {
            val intent = Intent(this, _v_AddClientActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        _v_adapter.notifyDataSetChanged()
    }
}
