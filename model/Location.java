/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accsystem.model;
/**
 *
 * @author Elliott Tomkings
 */
public class Location{
    
    //create variables of Hall
    private String postcode;
    private String address;
    
    //create default constructor
    public Location() {}
    

    //create paramaterised constructor
    public Location(String postcode, String address){
        this.postcode = postcode;
        this.address = address;
        
    }
    
    //appropriate getters and setters
            public String getpostcode(){
                return postcode;
            }
            public String getaddress(){
                return address;
            }
    
}
