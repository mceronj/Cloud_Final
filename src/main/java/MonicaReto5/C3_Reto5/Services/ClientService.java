/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  MonicaReto5.C3_Reto5.Services;


import MonicaReto5.C3_Reto5.Model.Client;
import MonicaReto5.C3_Reto5.Repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository methodsCrud;
    
    public List<Client> getAll(){
        return methodsCrud.getAll();
    }
    
    public Optional<Client> getClient(int clientId){
        return methodsCrud.getClient(clientId);
    }
    
    public Client save(Client client){
        if(client.getIdClient()==null){
            return methodsCrud.save(client);
        }else{
            Optional<Client> evt=methodsCrud.getClient(client.getIdClient());
            if(evt.isEmpty()){
                return methodsCrud.save(client);
            }else{
                return client;
            }
        
        }
    }    
     public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e= methodsCrud.getClient(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                methodsCrud.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            methodsCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
