package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import denis.le.christ.darylles.mahougnon.gangnito.bumaye_app.R
import model.Client


class ClientAdapter(
    private val clients: List<Client>
) : RecyclerView.Adapter<ClientAdapter.ClientViewHolder>() {
    inner class ClientViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val nomTv: TextView = itemView.findViewById(R.id.nomTv)
        val mT: TextView = itemView.findViewById(R.id.totalTv)
        val avance: TextView = itemView.findViewById(R.id.avanceTv)
        val reste: TextView = itemView.findViewById(R.id.resteTv)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ClientViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.client_item, parent, false)
        return ClientViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ClientViewHolder,
        position: Int
    ) {
        val client = clients[position]
        holder.nomTv.text = client.nomPrenoms // ou client.nomComplet selon ton modèle
        holder.mT.text = "Total : ${client.sommeTotale}"
        holder.avance.text = "Avance : ${client.avance}"
        holder.reste.text = "Reste : ${client.reste}"
    }

    override fun getItemCount(): Int {
        return clients.size
    }
}
