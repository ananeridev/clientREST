package com.example.clienterest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun pesquisar(v:View) {
        val id = editId.getText().toString().toInt()

        val task = LerPostagemTask()
        val postagem: Postagem? = task.execute(id).get()

        tvTitulo.setText(postagem?.title)
        tvConteudo.setText(postagem?.body)
    }
}
