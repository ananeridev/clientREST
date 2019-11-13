package com.example.clienterest

import feign.Param
import feign.RequestLine


//interface eh onde os metodos nao tem corpo
interface RequisicoesPostagem {

    // : <--  eh o retorno do metodo

    @RequestLine("GET /posts/{id}")
    fun getPostagem(@Param("id") id: Int): Postagem?

    //exemplo GET que traz uma lista
    @RequestLine("GET /posts")
    fun getPostagens(): List<Postagem>

    @RequestLine("POST /posts")
    fun criarPostagem(postagem: Postagem)

    @RequestLine("DELETE /posts/{id}")
    fun deletePostagem(@Param("id") id: Int?)




}