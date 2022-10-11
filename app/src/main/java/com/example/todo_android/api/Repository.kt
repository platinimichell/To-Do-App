package com.example.todo_android.api

import com.example.todo_android.model.Categoria
import com.example.todo_android.model.Tarefa
import retrofit2.Response

class Repository {

    suspend fun listCategoria(): Response<List<Categoria>>{
        return RetrofitIstance.api.listCategoria()
    }

    suspend fun addTarefa(tarefa: Tarefa): Response<Tarefa>{
        return RetrofitIstance.api.addTarefa(tarefa)
    }

    suspend fun listTarefa(): Response<List<Tarefa>>{
        return RetrofitIstance.api.listTarefa()
    }

    suspend fun updateTarefa(tarefa: Tarefa): Response<Tarefa>{
        return RetrofitIstance.api.updateTarefa(tarefa)
    }

    suspend fun deleteTarefa(id: Long): Response<Tarefa>{
        return RetrofitIstance.api.deleteTarefa(id)
    }

}