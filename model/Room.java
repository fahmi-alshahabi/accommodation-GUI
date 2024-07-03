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

//default constructor 
public class Room {
    
    private String roomIsAvailable;
    private String roomDescription;
    public CleaningStatus cleaning;
    private String roomType;
    public RentalAgreement rentalAgreement;
    
    //create default constructor
    public Room(int roomNumIncrement, boolean hasRentalAgreement) {
        
        this.cleaning = new CleaningStatus();
        
        Random random = new Random();
        // Generate a random number between 0 and 1
        double randomNumber = random.nextDouble();
        // Half of the time, choose option 1, otherwise choose option 2
        if (randomNumber < 0.7) {
            this.roomType = "Standard";
            this.roomDescription = "Single bed, wardrobe, desk, chair, bookshelves, bedside cabinet, mirror, shared bathroom";
            //i think this is really dumb and stupid and i hate it and theres probably a better way but idk
                    if (hasRentalAgreement == true){
                    this.rentalAgreement = new RentalAgreement(roomNumIncrement, false, false);  
                } else{
                    this.rentalAgreement = new RentalAgreement(roomNumIncrement, true, false);
                }
        } else {
            this.roomType = "Superior";
            this.roomDescription = "Double bed, large wardrobe, extended desk, chair, bookshelves,bedside cabinet, walla mirror, ensuite wet room";
                    if (hasRentalAgreement == true){
                    this.rentalAgreement = new RentalAgreement(roomNumIncrement, false, true);  
                } else{
                    this.rentalAgreement = new RentalAgreement(roomNumIncrement, true, true);
                }
        } 
    }
    

    //create paramaterised constructor
    public Room(String roomIsAvailable, String roomDescription,
            CleaningStatus cleaning, RentalAgreement rentalAgreement){
        this.roomIsAvailable = roomIsAvailable;
        this.roomDescription = roomDescription;
        this.cleaning =  new CleaningStatus();
        this.rentalAgreement = rentalAgreement;
        
    }
    
    //appropriate getters and setters
    public String isRoomIsAvailable() {
        return roomIsAvailable;
    }

    public String getRoomNum() {
        return this.rentalAgreement.getRoomNumber();
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public String getCleaning() {
        return this.cleaning.getCleaningStatus();
    }

    public RentalAgreement getRentalAgreement() {
        return rentalAgreement;
    }
    
    public void setRentalAgreement(RentalAgreement rentalAgreement){
        this.rentalAgreement = rentalAgreement;
    }

    public void setRoomIsAvailable(String roomIsAvailable) {
        this.roomIsAvailable = roomIsAvailable;
    }

    public void setCleaning(CleaningStatus cleaning) {
        this.cleaning = cleaning;
    }
    
    public String getPrice(){
        return this.rentalAgreement.getPrice();
    }
    
    public String getType(){
        return this.roomType;
    }
    
    public String getFirstName(){
        return this.rentalAgreement.student.getStudentName();
    }
    
    
    public boolean hasRentalAgreement()
    {
        // If the guest booking is not NULL we have an associated booking.
        return (this.rentalAgreement != null);
    }
           
}

    

                

                                    
