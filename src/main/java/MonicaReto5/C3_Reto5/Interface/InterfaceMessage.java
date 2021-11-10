/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  MonicaReto5.C3_Reto5.Interface;


import MonicaReto5.C3_Reto5.Model.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Usuario
 */
public interface InterfaceMessage extends CrudRepository<Message,Integer>{
    
}
