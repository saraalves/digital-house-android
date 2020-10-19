package br.com.saraalves.aula22

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MeuAdapter(private val dateSet: List<String>) : RecyclerView.Adapter<MeuAdapter.MeuViewHolder>() {

    class MeuViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val meuTexto by lazy { view.findViewById<TextView>(R.id.meuTexto) }

        fun bind(string: String) {
            meuTexto.text = string
        }
    }

    // Infla a nossa linha, infla o xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)

        return MeuViewHolder(view)
    }

    //Quantidade de itens do meu DataSet
    override fun getItemCount() = dateSet.size

    // Vai ser chamado a cada item do DataSet
    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {
        holder.bind(dateSet[position])
    }
}