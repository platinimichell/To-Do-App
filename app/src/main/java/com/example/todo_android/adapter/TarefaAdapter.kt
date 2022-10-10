package com.example.todo_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_android.MainViewModel
import com.example.todo_android.databinding.CardLayoutBinding
import com.example.todo_android.model.Tarefa
import java.text.SimpleDateFormat

class TarefaAdapter (
    val taskClickListener: TaskClickListener,
    val mainViewModel: MainViewModel,
        ) : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>(){

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
        val formatter = SimpleDateFormat("yyyy-mm-dd")
        val date = formatter.parse(tarefa.data)
        holder.biding.textData.text = formatter.format(date!!)
        holder.biding.switchAtivo.isChecked = tarefa.status
        holder.biding.textCategoria.text = tarefa.categoria.descricao

        holder.itemView.setOnClickListener{
            taskClickListener.onTaskClickListener(tarefa)
        }

        holder.biding.switchAtivo.setOnCheckedChangeListener { compoundButton, ativo ->
            tarefa.status = ativo
            mainViewModel.updateTarefa(tarefa)
        }

    }

    override fun getItemCount(): Int {
        return listTarefa.size
    }

    fun setList(list: List<Tarefa>){
        listTarefa = list.sortedByDescending { it.id }
        notifyDataSetChanged()

    }

}