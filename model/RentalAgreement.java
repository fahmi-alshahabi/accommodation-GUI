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
public class RentalAgreement {
    
    private String leaseNumber;
    private String roomNumber;
    private String price;
    public Student student;
    boolean rentalAgreementIsEmpty;
    
    
    //default constructor generates dummy data
    public RentalAgreement(int roomNumIncrement, boolean rentalAgreementIsEmpty, boolean roomIsSuperior){
        
        if (roomIsSuperior == true){
            this.price = "950";
        }
        else{
            this.price = "600";
        }
        
        if (rentalAgreementIsEmpty == false){
            
            this.rentalAgreementIsEmpty = rentalAgreementIsEmpty;
            this.leaseNumber = roomNumIncrement+"";
            
            
            
            
            String roomNumIncrementStr = roomNumIncrement+"";
            this.roomNumber = roomNumIncrementStr;


            this.student = new Student(false);
            
        }
        else{
            this.rentalAgreementIsEmpty = rentalAgreementIsEmpty;
            this.leaseNumber = "";
            String roomNumIncrementStr = roomNumIncrement+"";
            this.roomNumber = roomNumIncrementStr;
            this.student = new Student(true);
        }

    }

    public void setLeaseNumber(String leaseNumber) {
        this.leaseNumber = leaseNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRentalAgreementIsEmpty(boolean rentalAgreementIsEmpty) {
        this.rentalAgreementIsEmpty = rentalAgreementIsEmpty;
    }
    
    public RentalAgreement(String leaseNumber, String roomNumber, String price, Student student) {
        this.leaseNumber = leaseNumber;
        this.roomNumber = roomNumber;
        this.price = price;
        this.student = student;
        this.rentalAgreementIsEmpty = false;
    }

    public String getLeaseNumber() {
        return leaseNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getPrice() {
        return price;
    }

    public Student getStudent() {
        return student;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    public boolean getRentalAgreementIsEmpty(){
        return rentalAgreementIsEmpty;
    }
    

    
    
    
}
