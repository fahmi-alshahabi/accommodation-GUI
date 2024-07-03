/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package accsystem.model;

import java.util.ArrayList;

/**
 *
 * @author Elliott Tomkings
 */
public class AccSystem {
    
    private ArrayList<Room> rooms;
    private ArrayList<Hall> halls;
    
    public AccSystem()
    {
        this.rooms = new ArrayList<Room>();
        halls = new ArrayList<Hall>();
    }

    public ArrayList<Hall> getHalls()
    {
        return this.halls;
    }
    
    public void addHall(Hall hall)
    {
        this.halls.add(hall);
    }
    
    public void initializeDummyData()
    {
        Hall Quantock = new Hall("Quantock");
        Hall Cotswold = new Hall("Cotswold");
        Hall Walscourt = new Hall("Walscourt");

        halls.add(Quantock);
        halls.add(Cotswold);
        halls.add(Walscourt);
    }
        public void addRoom(Room room)
    {
        this.rooms.add(room);
    }
        public ArrayList<Room> getRooms()
    {
        return this.rooms;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    }
    
}
