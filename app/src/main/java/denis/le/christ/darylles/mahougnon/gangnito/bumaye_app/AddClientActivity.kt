package denis.le.christ.darylles.mahougnon.gangnito.bumaye_app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import model.Client
import repository.ClientRepository
import java.text.SimpleDateFormat
import java.util.*

class AddClientActivity : AppCompatActivity() {

    private val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vadd_client)

        val nomEtPrenom = findViewById<EditText>(R.id.nomEtPrenomEdt)
        val phone = findViewById<EditText>(R.id.phoneEdt)

        val epaule = findViewById<EditText>(R.id.epauleEdt)
        val poitrine = findViewById<EditText>(R.id.poitrineEdt)
        val longueurTaille = findViewById<EditText>(R.id.longueurTailleEdt)
        val tourVentrale = findViewById<EditText>(R.id.tourVentraleEdt)
        val hanche = findViewById<EditText>(R.id.hancheEdt)
        val longueurCorsage = findViewById<EditText>(R.id.longueurCorsageEdt)
        val ceinture = findViewById<EditText>(R.id.ceintureEdt)
        val longueurJupe = findViewById<EditText>(R.id.longueurJupeEdt)
        val longueurRobe = findViewById<EditText>(R.id.longueurRobeEdt)
        val longueurManche = findViewById<EditText>(R.id.longueurMancheEdt)
        val tailleManche = findViewById<EditText>(R.id.tailleMancheEdt)
        val longueurPantalon = findViewById<EditText>(R.id.longueurPantalonEdt)
        val longueurRobeCourte = findViewById<EditText>(R.id.longueurRobeCourteEdt)
        val tourCuisses = findViewById<EditText>(R.id.tourCuissesEdt)
        val longueurGenoux = findViewById<EditText>(R.id.longueurGenouxEdt)
        val tourGenoux = findViewById<EditText>(R.id.tourGenouxEdt)
        val bas = findViewById<EditText>(R.id.basEdt)
        val autresMesures = findViewById<EditText>(R.id.autresMesuresEdt)

        val dateCommande = findViewById<EditText>(R.id.dateCommandeEdt)
        val dateLivraison = findViewById<EditText>(R.id.dateLivraisonEdt)

        val sommeTotale = findViewById<EditText>(R.id.sommeTotaleEdt)
        val avance = findViewById<EditText>(R.id.avanceEdt)
        val reste = findViewById<EditText>(R.id.resteEdt)

        val btnEnregistrer = findViewById<Button>(R.id.btnEnregistrer)

        // Calcul automatique du reste
        sommeTotale.setOnFocusChangeListener { _, _ -> calculerReste(sommeTotale, avance, reste) }
        avance.setOnFocusChangeListener { _, _ -> calculerReste(sommeTotale, avance, reste) }

        btnEnregistrer.setOnClickListener {
            val nomValue = nomEtPrenom.text.toString().trim()
            val phoneValue = phone.text.toString().trim()

            // Validation Nom et Téléphone
            if (nomValue.isEmpty()) {
                nomEtPrenom.error = "Nom obligatoire"
                nomEtPrenom.requestFocus()
                return@setOnClickListener
            }
            if (!phoneValue.matches(Regex("\\d{8,12}"))) {
                phone.error = "Numéro invalide (8 à 12 chiffres)"
                phone.requestFocus()
                return@setOnClickListener
            }

            // Validation Dates
            val dateCommandeValue = dateCommande.text.toString().trim()
            val dateLivraisonValue = dateLivraison.text.toString().trim()
            try {
                val dCommande = sdf.parse(dateCommandeValue)
                val dLivraison = sdf.parse(dateLivraisonValue)
                if (dCommande == null || dLivraison == null) {
                    Toast.makeText(this, "Format de date invalide", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if (dLivraison.before(dCommande)) {
                    dateLivraison.error = "La livraison doit être après la commande"
                    dateLivraison.requestFocus()
                    return@setOnClickListener
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Format de date invalide", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validation Somme et Avance
            val sommeValue = sommeTotale.text.toString().trim().toDoubleOrNull()
            val avanceValue = avance.text.toString().trim().toDoubleOrNull()
            if (sommeValue == null || sommeValue <= 0) {
                sommeTotale.error = "Somme positive obligatoire"
                sommeTotale.requestFocus()
                return@setOnClickListener
            }
            if (avanceValue == null || avanceValue < 0) {
                avance.error = "Avance positive obligatoire"
                avance.requestFocus()
                return@setOnClickListener
            }

            // Calcul automatique du reste
            reste.setText((sommeValue - avanceValue).toString())

            // Créer l’objet Client
            val client = Client(
                nomPrenoms = nomValue,
                telephone = phoneValue,
                epaule = epaule.text.toString(),
                poitrine = poitrine.text.toString(),
                longueurTaille = longueurTaille.text.toString(),
                tourVentrale = tourVentrale.text.toString(),
                hanche = hanche.text.toString(),
                longueurCorsage = longueurCorsage.text.toString(),
                ceinture = ceinture.text.toString(),
                longueurJupe = longueurJupe.text.toString(),
                longueurRobe = longueurRobe.text.toString(),
                longueurManche = longueurManche.text.toString(),
                tailleManche = tailleManche.text.toString(),
                longueurPantalon = longueurPantalon.text.toString(),
                longueurRobeCourte = longueurRobeCourte.text.toString(),
                tourCuisses = tourCuisses.text.toString(),
                longueurGenoux = longueurGenoux.text.toString(),
                tourGenoux = tourGenoux.text.toString(),
                bas = bas.text.toString(),
                autresMesures = autresMesures.text.toString(),
                dateCommande = dateCommandeValue,
                dateLivraison = dateLivraisonValue,
                sommeTotale = sommeValue,
                avance = avanceValue,
                reste = sommeValue - avanceValue
            )

            // Ajouter le client dans le repository
            ClientRepository.addClient(client)

            Toast.makeText(this, "Client enregistré avec succès !", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    private fun calculerReste(somme: EditText, avance: EditText, reste: EditText) {
        val sommeVal = somme.text.toString().toDoubleOrNull()
        val avanceVal = avance.text.toString().toDoubleOrNull()
        if (sommeVal != null && avanceVal != null) {
            reste.setText((sommeVal - avanceVal).toString())
        }
    }
}
