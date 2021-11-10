/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  MonicaReto5.C3_Reto5.Repository;


import MonicaReto5.C3_Reto5.Interface.InterfaceReservation;
import MonicaReto5.C3_Reto5.Model.Client;
import MonicaReto5.C3_Reto5.Model.Reservation;
import MonicaReto5.C3_Reto5.ZReports.ClientsCounter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



/**
 *
 * @author USUARIO
 */
@Repository
public class ReservationRepository {
     @Autowired
    private InterfaceReservation crud4;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) crud4.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return crud4.findById(id);
    }
    public Reservation save(Reservation reservation){
        return crud4.save(reservation);
    }
    public void delete(Reservation reservation){
        crud4.delete(reservation);
    }
     
   
    public List<Reservation> ReservationStatusRepository (String status){
       return crud4.findAllByStatus(status);

     }
     
    public List<Reservation> ReservationTimeRepository (Date dateOne, Date dateTwo){
         return crud4.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
     }
     

   public List<ClientsCounter> getClientsRepository(){
       List<ClientsCounter> res = new ArrayList<>();
       List<Object[]> report = crud4.countTotalReservationsByClient();
       for(int i=0; i<report.size(); i++){
             res.add(new ClientsCounter((Long)report.get(i)[1],(Client) report.get(i)[0]));
         }
         return res;
       
   }
}
