/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  MonicaReto5.C3_Reto5.Repository;


import MonicaReto5.C3_Reto5.Interface.InterfaceMessage;
import MonicaReto5.C3_Reto5.Model.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



/**
 *
 * @author USUARIO
 */
@Repository
public class MessageRepository {
          @Autowired
    private InterfaceMessage crud3;
    public List<Message> getAll(){
        return (List<Message>) crud3.findAll();
    }
    public Optional<Message> getMessage(int id){
        return crud3.findById(id);
    }

    public Message save(Message message){
        return crud3.save(message);
    }
     public void delete(Message message){
        crud3.delete(message);
    }
    
}
