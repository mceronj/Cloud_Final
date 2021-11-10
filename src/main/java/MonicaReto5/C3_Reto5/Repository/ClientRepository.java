/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  MonicaReto5.C3_Reto5.Repository;


import MonicaReto5.C3_Reto5.Interface.InterfaceClient;
import MonicaReto5.C3_Reto5.Model.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



/**
 *
 * @author USUARIO
 */
@Repository
public class ClientRepository {
      @Autowired
    private InterfaceClient crud1;
    

    public List<Client> getAll(){
        return (List<Client>) crud1.findAll();       
    }
    
    public Optional <Client> getClient(int id){
        return crud1.findById(id);
    }
    
    public Client save(Client client){
        return crud1.save(client);
    }

    public void delete(Client client){
        crud1.delete(client);
    } 


}
