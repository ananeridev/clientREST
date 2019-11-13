package com.example.clienterest

import android.os.AsyncTask
import feign.Feign
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder

class CriarPostagemTask: AsyncTask<Postagem, Void, Void>() {
    override fun doInBackground(vararg params: Postagem?): Void {
            val request = Feign.builder()
                    //encoder transforma kotlin em json
                .encoder(GsonEncoder())
                .target(
                    RequisicoesPostagem::class.java,
                    // poderia configurar com metodos estaticos tambem
                    "https://jsonplaceholder.typicode.com/"
                )
            try {
               request.criarPostagem(params[0]!!)
            } catch (e:Exception) {
                e.printStackTrace()
            }
            return null!!;
        }
    }
