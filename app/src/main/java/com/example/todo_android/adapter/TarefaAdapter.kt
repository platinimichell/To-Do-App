package com.example.todo_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_android.databinding.CardLayoutBinding
import com.example.todo_android.model.Tarefa

class TarefaAdapter : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>(){

    private var listTarefa = emptyList<Tarefa>()

    class TarefaViewHolder (val biding: CardLayoutBinding) : RecyclerView.ViewHolder(biding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        return TarefaViewHolder(CardLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val tarefa = listTarefa[position]

        holder.biding.textNome.text = tarefa.nome
        holder.biding.textDescricao.text = tarefa.descricao
        holder.biding.textResponsavel.text = tarefa.responsavel
        holder.biding.textData.text = tarefa.data
        holder.biding.switchAtivo.isChecked = tarefa.status
        holder.biding.textCategoria.text = tarefa.categoria.descricao
    }

    override fun getItemCount(): Int {
        return listTarefa.size
    }

    fun setList(list: List<Tarefa>){
        listTarefa = list
        notifyDataSetChanged()

    }

}