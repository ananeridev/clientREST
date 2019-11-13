package com.example.clienterest

import android.os.AsyncTask
import feign.Feign
import feign.gson.GsonDecoder

// void significa que eu estou ignorando o tipo da tarefa
class LerPostagemTask : AsyncTask<Int, Void, Postagem>() {

    override fun doInBackground(vararg params: Int?): Postagem? {
        val request = Feign.builder()
            .decoder(GsonDecoder())
            .target(
                RequisicoesPostagem::class.java,
                // poderia configurar com metodos estaticos tambem
                "https://jsonplaceholder.typicode.com/"
            )
        try {
            return request.getPostagem(params[0]!!)
        } catch (e:Exception) {
            return null
        }
    }
}