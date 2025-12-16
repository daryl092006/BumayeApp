package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import denis.le.christ.darylles.mahougnon.gangnito.bumaye_app.R
import model._v_Client


class _v_ClientAdapter(
    private val _v_clients: List<_v_Client>
) : RecyclerView.Adapter<_v_ClientAdapter._v_ClientViewHolder>() {
    inner class _v_ClientViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val _v_mT: TextView = itemView.findViewById(R.id._v_mT)
        val _v_avance: TextView = itemView.findViewById(R.id._v_avance)
        val _v_reste: TextView = itemView.findViewById(R.id._v_reste)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): _v_ClientViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout._v_client_item, parent, false)
        return _v_ClientViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: _v_ClientViewHolder,
        position: Int
    ) {
        val _v_client = _v_clients[position]

        holder._v_mT.text = "Total : ${_v_client._v_sommeTotale}"
        holder._v_avance.text = "Avance : ${_v_client._v_avance}"
        holder._v_reste.text = "Reste : ${_v_client._v_reste}"
    }

    override fun getItemCount(): Int {
        return _v_clients.size
    }
}
