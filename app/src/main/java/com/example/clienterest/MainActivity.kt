package com.example.clienterest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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

    fun cadastrar(v: View) {
        // Id de post e autor qualquer
        val novaPostagem = Postagem(0, 1, editNovoTitulo.text.toString(), editNovoCorpo.text.toString())

        val task = CriarPostagemTask()
        task.execute(novaPostagem)

        Toast.makeText(this, "Postagem criada com sucesso bro", Toast.LENGTH_SHORT).show()
    }
}
