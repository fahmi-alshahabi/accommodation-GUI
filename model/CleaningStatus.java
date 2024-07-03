/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accsystem.model;

import java.util.Random;

/**
 *
 * @author Elliott Tomkings
 */
public class CleaningStatus {
    
    private String cleaningStatus;

    public void setCleaningStatus(String cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
    }
    
    public String getCleaningStatus(){
        return cleaningStatus;
    }


    public CleaningStatus() {
        
        Random random = new Random();
        
        // Generate a random number between 0 and 1
        double randomNumber = random.nextDouble();
        
        // Half of the time, choose option 1, otherwise choose option 2
        if (randomNumber < 0.2) {
            this.cleaningStatus = "Dirty";
        } else if (randomNumber > 0.2 & randomNumber < 0.7) {
            this.cleaningStatus = "Clean";
        }
        else {
                this.cleaningStatus = "Offline";
                }
                
        this.cleaningStatus = cleaningStatus;
        
    }
    
    
    
    
}
