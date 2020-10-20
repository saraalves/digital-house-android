package br.com.saraalves.exerciciorecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class MeuAdapter(private val dataSet: List<Conversa>) : RecyclerView.Adapter<MeuAdapter.MeuViewHolder>() {

    class MeuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nome: TextView = view.findViewById(R.id.txtNome)
        private val ultimaMensage: TextView = view.findViewById(R.id.txtUltimaMensagem)
        private val hora: TextView = view.findViewById(R.id.txtHora)

        fun bind(conversa: Conversa) {
            nome.text = conversa.nome
            ultimaMensage.text = conversa.ultimaMensagem
            hora.text = conversa.hora
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)

        return MeuViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }
}