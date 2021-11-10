/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  MonicaReto5.C3_Reto5.Repository;

import MonicaReto5.C3_Reto5.Interface.InterfaceCategory;
import MonicaReto5.C3_Reto5.Model.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



/**
 *
 * @author USUARIO
 */
@Repository
public class CategoryRepository {
       @Autowired
    private InterfaceCategory crud2;
    
     public List<Category> getAll(){
        return (List<Category>) crud2. findAll();       
    }
    
    public Optional <Category> getCategory(int id){
        return crud2.findById(id);
    }
    
    public Category save(Category category){
        return crud2.save(category);
    }
     public void delete(Category category){
        crud2.delete(category);
    }

}

