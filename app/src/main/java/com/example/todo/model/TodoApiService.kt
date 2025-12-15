package com.example.todo.model
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
const val BASE_URL = "https://jsonplaceholder.typicode.com/"
interface TodosApiService {
    @GET("todos")
    suspend fun getTodos(): List<Todo>
    companion object {
        var todosService: TodosApiService? = null
        fun getInstance(): TodosApiService {
            if (todosService === null) {
                todosService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(TodosApiService::class.java)
            }
            return todosService!!
        }
    }
}