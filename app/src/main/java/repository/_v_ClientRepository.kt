package repository

import model._v_Client

object _v_ClientRepository {
    val _v_clients = mutableListOf<_v_Client>()

    fun addClient (client: _v_Client){
        _v_clients.add(client)
    }
    fun modifyClient (index: Int, client: _v_Client){
        _v_clients[index] = client
    }
    fun deleteClient (index: Int){
        _v_clients.removeAt(index)
    }
    fun getClient (index: Int) = _v_clients[index]
}