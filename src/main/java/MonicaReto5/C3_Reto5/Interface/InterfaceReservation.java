/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  MonicaReto5.C3_Reto5.Interface;


import java.util.Date;
import java.util.List;
import MonicaReto5.C3_Reto5.Model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Usuario
 */
public interface InterfaceReservation extends CrudRepository<Reservation,Integer>{
    
    public List<Reservation> findAllByStatus (String status);
    
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    // SELECT clientid, COUNT(*) AS total FROM reservacion group by clientid order by desc;
    @Query ("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByClient();
    
}
