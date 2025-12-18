package repository

import model.Client

object ClientRepository {
    val clients = mutableListOf<Client>()

    fun addClient (client: Client){
        clients.add(client)
    }
    fun modifyClient (index: Int, client: Client){
        clients[index] = client
    }
    fun deleteClient (index: Int){
        clients.removeAt(index)
    }
    fun getClient (index: Int) = clients[index]
}