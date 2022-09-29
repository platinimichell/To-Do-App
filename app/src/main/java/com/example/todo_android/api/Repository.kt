package com.example.todo_android.api

import com.example.todo_android.model.Categoria
import retrofit2.Response

class Repository {

    suspend fun listCategoria(): Response<List<Categoria>>{
        return RetrofitIstance.api.listCategoria()
    }

}