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
public class Manager {
    
    private String name;
    private String phoneNumber;
    
    //create default constructor
    public Manager() {
        
        
        
        String[] names = {"Nicole Stokes", "Amy Sharpe", "Elliot Brennan", "Tom Stewart", "Ruby Adams", "Samantha Middleton", "Jake Griffiths", "Erin Baldwin", "Kyle Craig", "Zara Robertson", "Patrick Reid"};
        String[] phoneNumbers = {"01539 949247", "01697 751403", "01422 594305", "01837 365417" };
        // Generating a random index
        Random random = new Random();
        int randomIndex = random.nextInt(names.length);
        int randomIndex2 = random.nextInt(phoneNumbers.length);
        // Returning the random name
        String name = names[randomIndex];
        String number = phoneNumbers[randomIndex2];
        
        this.name = name;
        this.phoneNumber = number;

    
    }
    

    //create paramaterised constructor
    public Manager(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    //appropriate getters and setters
            public String getname(){
                return name;
            }
            public String getphoneNumber(){
                return phoneNumber;
            }
    
}
    

