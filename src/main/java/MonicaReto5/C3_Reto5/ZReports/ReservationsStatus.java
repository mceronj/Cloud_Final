/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  MonicaReto5.C3_Reto5.ZReports;

/**
 *
 * @author Usuario
 */
public class ReservationsStatus {
    
    private int completed;
    private int cancelled;

    public ReservationsStatus(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
    
   }
