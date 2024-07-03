/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accsystem.gui;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author james
 */
public class RoomRow{

    private final SimpleStringProperty number;
    private final SimpleStringProperty type;
    private final SimpleStringProperty price;
    private final SimpleStringProperty availability;
    private final SimpleStringProperty cleaningStatus;
    
    public RoomRow(String strNumber,
                   String strType,
                   String strPrice,
                   String strAvailability,
                   String strCleaningStatus)
    {
        this.number = new SimpleStringProperty(strNumber);
        this.type = new SimpleStringProperty(strType);
        this.price = new SimpleStringProperty(strPrice);
        this.availability = new SimpleStringProperty(strAvailability);
        this.cleaningStatus = new SimpleStringProperty(strCleaningStatus);
    }

    public String getNumber() {
        return number.get();
    }

    public String getType() {
        return type.get();
    }

    public String getPrice() {
        return price.get();
    }

    public String getAvailability() {
        return availability.get();
    }

    public String getCleaningStatus() {
        return cleaningStatus.get();
    }
            
    }
    
    
    
  


