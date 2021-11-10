/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  MonicaReto5.C3_Reto5.Services;


import MonicaReto5.C3_Reto5.Model.Message;
import MonicaReto5.C3_Reto5.Repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository methodsCrud;
    
    public List<Message> getAll(){
        return methodsCrud.getAll();
    }

    public Optional<Message> getMessage(int messageId) {
        return methodsCrud.getMessage(messageId);
    }
    
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return methodsCrud.save(message);
        }else{
            Optional<Message> evt= methodsCrud.getMessage(message.getIdMessage());
            if(evt.isEmpty()){
                return methodsCrud.save(message);
            }else{
                return message;
            }
        }
    }
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> e= methodsCrud.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                methodsCrud.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            methodsCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
