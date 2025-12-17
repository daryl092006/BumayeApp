package denis.le.christ.darylles.mahougnon.gangnito.bumaye_app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import model._v_Client
import repository._v_ClientRepository

class _v_AddClientActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vadd_client)

        val _v_nomEtPrenom = findViewById<EditText>(R.id._v_nomEtPrenomEdt)

        val _v_phone = findViewById<EditText>(R.id._v_phoneEdt)

        val _v_Enregistrer = findViewById<Button>(R.id._v_btnEnregistrer)

        _v_Enregistrer.setOnClickListener {
            val _v_nom = _v_nomEtPrenom.text.toString()
            val _v_phone = _v_phone.text.toString()

            if (_v_nom.isNullOrEmpty() || _v_phone.isNullOrEmpty()) {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show()
            } else {
                val _v_client = _v_Client(
                    _v_nomPrenoms = _v_nom,
                    _v_telephone = _v_phone
                )
                _v_ClientRepository.addClient(_v_client)
                finish()
            }

        }
    }
}