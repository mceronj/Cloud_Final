/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  MonicaReto5.C3_Reto5.Services;


import MonicaReto5.C3_Reto5.Model.Reservation;
import MonicaReto5.C3_Reto5.ZReports.ClientsCounter;
import MonicaReto5.C3_Reto5.ZReports.ReservationsStatus;
import MonicaReto5.C3_Reto5.Repository.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository methodsCrud;
    
    public List<Reservation> getAll(){
        return methodsCrud.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId) {
        return methodsCrud.getReservation(reservationId);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return methodsCrud.save(reservation);
        }else{
            Optional<Reservation> e= methodsCrud.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return methodsCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= methodsCrud.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                methodsCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            methodsCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
  
    public ReservationsStatus reportStatusService (){
        List<Reservation>completed= methodsCrud.ReservationStatusRepository("completed");
        List<Reservation>cancelled= methodsCrud.ReservationStatusRepository("cancelled");
        
        return new ReservationsStatus(completed.size(), cancelled.size() );
    }
    
    public List<Reservation> reportServiceTime (String dateA, String dateB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date dateOne = new Date();
        Date dateTwo = new Date();
        
        try{
             dateOne = parser.parse(dateA);
             dateTwo = parser.parse(dateB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(dateOne.before(dateTwo)){
            return methodsCrud.ReservationTimeRepository(dateOne, dateTwo);
        }else{
            return new ArrayList<>();
        
        } 
    } 
     public List<ClientsCounter> reportClientsService(){
            return methodsCrud.getClientsRepository();
        } 
}
