/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accsystem.model;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Elliott Tomkings
 */
public class Hall {
    
    //create variables of Hall
    private final String hallName;
    private final int numOfRoom = 0;
    public Manager manager;
    private Location location;    
    private final ArrayList<Room> rooms = new ArrayList<Room>();
    
    //create default constructor
    
    //create paramaterised constructor
    public Hall(String hallName){
        this.hallName = hallName;
        this.manager = new Manager();
        for (int i=1; i<10; i++)
        {
            Random random = new Random();
            // Generate a random number between 0 and 1
            double randomNumber = random.nextDouble();

            // Half of the time, choose option 1, otherwise choose option 2
            if (randomNumber < 0.5) {
                Room room = new Room(i, true);
                            addRoom(room);


            } else{
                Room room = new Room(i, false);
                addRoom(room);
        }
        }

    }
    
    //appropriate getters and setters
            public String getHallName(){
                return hallName;
            }
            public int getnumOfRoom(){
                return numOfRoom;
            }
            public Manager getManager(){
                return manager;
            }
            public Location getLocation(){
                return location;
            }
            public ArrayList<Room> getRooms(){
                return rooms;
            }
       
    public void addRoom(Room room){
        rooms.add(room);
    }
    
    
}
