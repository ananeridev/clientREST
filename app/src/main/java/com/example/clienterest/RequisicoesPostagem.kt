package com.example.clienterest

import feign.Param
import feign.RequestLine


//interface eh onde os metodos nao tem corpo
interface RequisicoesPostagem {

    // : <--  eh o retorno do metodo

    @RequestLine("GET /posts/{id}")
    fun getPostagem(@Param("id") id: Int): Postagem?


}