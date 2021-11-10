/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MonicaReto5.C3_Reto5.Controller;


import MonicaReto5.C3_Reto5.Model.Reservation;
import MonicaReto5.C3_Reto5.ZReports.ClientsCounter;
import MonicaReto5.C3_Reto5.ZReports.ReservationsStatus;
import MonicaReto5.C3_Reto5.Services.ReservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {
    @Autowired
    private ReservationService services;
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return services.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int reservationId) {
        return services.getReservation(reservationId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return services.save(reservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return services.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return services.deleteReservation(reservationId);
    }
    
    @GetMapping("/report-status")
    public ReservationsStatus getReservation(){
        return services.reportStatusService();
    }
    
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
     public List<Reservation> getReservationTime (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo ){
         return services.reportServiceTime(dateOne, dateTwo);
     }
     
     @GetMapping("/report-clients")
     public List<ClientsCounter> getClients(){
         return services.reportClientsService();
     }

}
