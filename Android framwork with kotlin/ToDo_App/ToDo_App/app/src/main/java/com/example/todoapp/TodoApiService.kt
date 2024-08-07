package com.example.todoapp.network

import retrofit2.Call
import retrofit2.http.*

data class TodoItem(val id: String, val title: String, val completed: Boolean)

interface TodoApiService {
    @GET("/todos")
    fun getTodos(): Call<List<TodoItem>>

    @POST("/todos")
    fun createTodo(@Body todo: TodoItem): Call<TodoItem>

    @PUT("/todos/{id}")
    fun updateTodo(@Path("id") id: String, @Body todo: TodoItem): Call<TodoItem>

    @DELETE("/todos/{id}")
    fun deleteTodo(@Path("id") id: String): Call<Void>
}
