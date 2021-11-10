/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  MonicaReto5.C3_Reto5.Repository;


import MonicaReto5.C3_Reto5.Model.Cloud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import MonicaReto5.C3_Reto5.Interface.InterfaceCloud;




/**
 *
 * @author USUARIO
 */
@Repository
public class CloudRepository {
      @Autowired
    private InterfaceCloud crud;
    

    public List<Cloud> getAll(){
        return (List<Cloud>) crud.findAll();       
    }
    
    public Optional <Cloud> getCloud(int id){
        return crud.findById(id);
    }
    
    public Cloud save(Cloud cloud){
        return crud.save(cloud);
    }
     public void delete(Cloud cloud){
        crud.delete(cloud);
    }
    
}
