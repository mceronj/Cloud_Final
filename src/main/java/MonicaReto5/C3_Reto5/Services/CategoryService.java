/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  MonicaReto5.C3_Reto5.Services;


import MonicaReto5.C3_Reto5.Model.Category;
import MonicaReto5.C3_Reto5.Repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository methodsCrud;
    
    public List<Category> getAll(){
        return methodsCrud.getAll();
    }
    
    public Optional<Category> getCategory(int idCategory){
        return methodsCrud.getCategory(idCategory);
    }
    
    public Category save(Category category){
        if(category.getId()==null){
            return methodsCrud.save(category);
        }else{
            Optional<Category> evt=methodsCrud.getCategory(category.getId());
            if(evt.isEmpty()){
                return methodsCrud.save(category);
            }else{
                return category;
            }
        }
    }
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>g=methodsCrud.getCategory(category.getId());
            if(!g.isEmpty()){
                if(category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                return methodsCrud.save(g.get());
            }
        }
        return category;
    }
    public boolean deleteCategory(int categoryId){
        Boolean d=getCategory(categoryId).map(category -> {
            methodsCrud.delete(category);
            return true;
        }).orElse(false);
        return d;
    }
}
