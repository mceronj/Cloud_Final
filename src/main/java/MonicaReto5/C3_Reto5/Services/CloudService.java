/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  MonicaReto5.C3_Reto5.Services;


import MonicaReto5.C3_Reto5.Model.Cloud;
import MonicaReto5.C3_Reto5.Repository.CloudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class CloudService {
    @Autowired
    private CloudRepository methodsCrud;
    
    public List<Cloud> getAll(){
        return methodsCrud.getAll();
    }
    
    public Optional<Cloud> getCloud(int idCloud){
        return methodsCrud.getCloud(idCloud);
    }
    
    public Cloud save(Cloud cloud){
        if(cloud.getId()==null){
            return methodsCrud.save(cloud);
        }else{
            Optional<Cloud> evt=methodsCrud.getCloud(cloud.getId());
            if(evt.isEmpty()){
                return methodsCrud.save(cloud);
            }else{
                return cloud;
            }
        }
    }
    public Cloud update(Cloud cloud){
        if(cloud.getId()!=null){
            Optional<Cloud> e=methodsCrud.getCloud(cloud.getId());
            if(!e.isEmpty()){
                if(cloud.getName()!=null){
                    e.get().setName(cloud.getName());
                }
                if(cloud.getBrand()!=null){
                    e.get().setBrand(cloud.getBrand());
                }
                if(cloud.getYear()!=null){
                    e.get().setYear(cloud.getYear());
                }
                if(cloud.getDescription()!=null){
                    e.get().setDescription(cloud.getDescription());
                }
                if(cloud.getCategory()!=null){
                    e.get().setCategory(cloud.getCategory());
                }
               methodsCrud.save(e.get());
                return e.get();
            }else{
                return cloud;
            }
        }else{
            return cloud;
        }
    }


    public boolean deleteCloud(int cloudId) {
        Boolean aBoolean = getCloud(cloudId).map(cloud -> {
           methodsCrud.delete(cloud);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}
