package com.example.todoapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapp.network.TodoApiService
import com.example.todoapp.network.TodoItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TodoActivity : AppCompatActivity() {

    private val todoList = mutableListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var todoApiService: TodoApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:5000") // Use 10.0.2.2 to access localhost from AVD
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        todoApiService = retrofit.create(TodoApiService::class.java)

        val etTodo: EditText = findViewById(R.id.etTodo)
        val btnAddTodo: Button = findViewById(R.id.btnAddTodo)
        val lvTodos: ListView = findViewById(R.id.lvTodos)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todoList)
        lvTodos.adapter = adapter

        fetchTodos()

        btnAddTodo.setOnClickListener {
            val todoTitle = etTodo.text.toString()
            if (todoTitle.isNotEmpty()) {
                val todo = TodoItem("", todoTitle, false)
                createTodo(todo)
                etTodo.text.clear()
            }
        }
    }

    private fun fetchTodos() {
        todoApiService.getTodos().enqueue(object : Callback<List<TodoItem>> {
            override fun onResponse(call: Call<List<TodoItem>>, response: Response<List<TodoItem>>) {
                response.body()?.let { todos ->
                    todoList.clear()
                    todoList.addAll(todos.map { it.title })
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<TodoItem>>, t: Throwable) {
                // Handle error
            }
        })
    }

    private fun createTodo(todo: TodoItem) {
        todoApiService.createTodo(todo).enqueue(object : Callback<TodoItem> {
            override fun onResponse(call: Call<TodoItem>, response: Response<TodoItem>) {
                response.body()?.let {
                    todoList.add(it.title)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<TodoItem>, t: Throwable) {
                // Handle error
            }
        })
    }
}
