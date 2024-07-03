/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package accsystem.gui;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import accsystem.model.Room;
import accsystem.model.AccSystem;
import accsystem.model.Hall;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


/**
 * FXML Controller class
 *
 * @author james
 */
public class FXMLAccSystemGUIController implements Initializable {
    @FXML
    private TableView<RoomRow> fxAccomSummaryTab;
    @FXML
    private TableColumn<RoomRow, String> fxAccomNumCol;
    @FXML
    private TableColumn<RoomRow, String> fxAccomTypeCol;
    @FXML
    private TableColumn<RoomRow, String> fxPriceCol;
    @FXML
    private TableColumn<RoomRow, String> fxAvaliCol;
    @FXML
    private TableColumn<RoomRow, String> fxCleaningStatCol;
    private AccSystem accSystem = null;
    @FXML
    private TextField fxLeaseNum;
    @FXML
    private TextField fxFirstName;
    @FXML
    private TextField fxTotalRooms;
    @FXML
    private TextField fxAvailability;
    @FXML
    private TextField fxRequiresCleaning;
    @FXML
    private Text fxHallName;
    @FXML
    private ChoiceBox<String> fxHallChoice;
    @FXML
    private TextField fxTelNo;
    @FXML
    private TextField fxManagerName;
    private ObservableList<RoomRow> tableData = FXCollections.observableArrayList();
    @FXML
    private TextField fxLastName;
    @FXML
    private Text fxAccommodationInfTitle;
    @FXML
    private TextField fxAccommNumber;
    @FXML
    private TextField fxAccommOcc;
    @FXML
    private TextField fxAccommPrice;
    @FXML
    private TextField fxAccommType;
    @FXML
    private Text fxAccommodationInfTitle1;
    @FXML
    private TextField fxMobileNum;
    @FXML
    private TextField fxStudentNum;
    @FXML
    private Text fxAccommodationInfTitle11;
    @FXML
    private ChoiceBox<String> fxCleaningStatusChoice;
    @FXML
    private Text fxAccommodationInfTitle111;
    @FXML
    private TextField fxRoomInventory;
    @FXML
    private TextField fxOffline;
    private TextField fxBooga;
    @FXML
    private TextField fxMobileNum2;
    @FXML
    private TextField fxStudentNum2;
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        System.out.println("DEBUG: Initialize() called");
        
        fxAccomNumCol.setCellValueFactory(new PropertyValueFactory<RoomRow, String>("number"));
        fxAccomTypeCol.setCellValueFactory(new PropertyValueFactory<RoomRow, String>("type"));
        fxPriceCol.setCellValueFactory(new PropertyValueFactory<RoomRow, String>("price"));
        fxAvaliCol.setCellValueFactory(new PropertyValueFactory<RoomRow, String>("availability"));
        fxCleaningStatCol.setCellValueFactory(new PropertyValueFactory<RoomRow, String>("cleaningStatus"));
        
        fxTotalRooms.setEditable(false);
        fxAvailability.setEditable(false);
        fxOffline.setEditable(false);
        fxRequiresCleaning.setEditable(false);

        //add options for hallchoice
        fxHallChoice.getItems().addAll("Quantock", "Cotswold", "Walscourt");
        //set default value
        fxHallChoice.setValue("Quantock");
        
        //add options for cleaning choice
        fxCleaningStatusChoice.getItems().addAll("Clean", "Dirty", "Offline");
        
        // INITIALIZE THE ACCOMMODATION SYSTEM AND LOAD WITH DUMMY DATA
        // Store the accommodation system in a state variable so can reuse throughout GUI
        AccSystem accSystem = new AccSystem();
        accSystem.initializeDummyData();
        
        // Store the accommodation system
        setAccSystem(accSystem);

        // POPULATE THE TABLE WITH THE DUMMY DATA
        populateTable();
        
        //this adds a listener to the hallchoice dropdown that returns a bunch of shit when the options change
        fxHallChoice.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> {
            populateTable();
        });
        
        fxCleaningStatusChoice.setValue("Quantock");

        //this is the same as above but for the cleaning status
        // i think you need to add a set button and have that change it 
        // because when you click on a row it updates the value of the choicebox to display the new one correctly
        // but that update is triggering this listener which is updating it to the same thing (harmless) and making it weird to naviagate (annoying)
        // use  stack overflow save to make silent changer???
    }
    
    private void setAccSystem(AccSystem accSystem)
    {
        this.accSystem = accSystem;
    }
    
    private AccSystem getAccSystem()
    {
        return this.accSystem;
    }
    
    private ArrayList roomsFromHallChoiceBox(){
        
        int hallChoiceIndex = 0;
        
        // uhh so basically this converts the string from the choicebox drop down thing into an index
        // the hall is then chosen based off the index because theyre always stored in the same order
        // so eg quantock is stored at index 0 and walscourt at index 2
        
        String selectedOption = fxHallChoice.getValue();
        
        switch (selectedOption) {
            case "Quantock":
                break;
            case "Cotswold":
                hallChoiceIndex = 1;
                break;
            case "Walscourt":
                hallChoiceIndex = 2;
                break;
        }
        
        // this gets the arraylist of all the halls from acc system
        ArrayList<Hall> halls = getAccSystem().getHalls();
        // this gets the hall selected in the dropdown using .get on the arraylist, selecting the element at the index
        Hall selectedHall = halls.get(hallChoiceIndex);
        // and then finally gets the rooms from the hall chosen and adds it to the final arraylist to be added to the table in the for loop
        ArrayList<Room> rooms = selectedHall.getRooms();
        
        return rooms;
         
    }
    
    
    private void populateTable() 
    {
        System.out.println("populateTableCalled");
        
        int incrementTotal = 0;
        int incrementDirty = 0;
        int incrementAvaliable = 0;
        int incrementOffline = 0;
        

        // Initially clear the table
        tableData.clear();
        
        // iterate through each room in the array and set appropriate values
        // also transfers each room and adds it into RoomRow to add to the table later
        
        ArrayList<Room> rooms = roomsFromHallChoiceBox();
        
        
        for (Room room : rooms) 
        {
        
            //increments variable used to display total rooms
            incrementTotal += 1;
            
            //Check if dirty and increment if it is
            String roomCleaning = room.getCleaning();
            if (roomCleaning.equals("Dirty")){
                incrementDirty += 1;
            }
            
            if (roomCleaning.equals("Offline")){
                incrementOffline += 1;
            }
                        
            //this is really dumb but it didnt like it when i put a string and two booleans in an if statement
            //so here im just turnign the strings from the getters into booleans
            //all of these getters should probably be set to booleans but i really dont want to change them all now so im doing this
            //I think i made them all return strings ages ago because it didnt like booleans being passed into the table
            //but i probably should have just converted them into strings right before putting them into the table and kept them as booleans in the objects
            // OH WELL!!!
            
            boolean roomisOffline;
            if ("Offline".equals(room.cleaning.getCleaningStatus())){
                roomisOffline = true;
            } else {
                roomisOffline = false;
            }
            
            boolean roomisClean;
            if ("Clean".equals(room.cleaning.getCleaningStatus())){
                roomisClean = true;
            } else {
                roomisClean = false;
            }
            
            //if the rental agreement is empty and the room is clean, make it available
            if (room.rentalAgreement.getRentalAgreementIsEmpty() == true & roomisOffline == false & roomisClean == true){
                   room.setRoomIsAvailable("Available");  
                   incrementAvaliable += 1;

            } else{
                   room.setRoomIsAvailable("Unvailable");

            }
            
            // this getter name is stupid and dumb but i cba to change it now
            // check if room is avalaible and increment if it is
            //String roomAvaliable = room.isRoomIsAvailable();
            //if (roomAvaliable.equals("Avaliable")){
            //}
            

            tableData.add(new RoomRow(room.getRoomNum(),
                    room.getType(),
                    room.getPrice(),
                    room.isRoomIsAvailable(),
                    room.getCleaning()));
        }
        
       int hallChoiceIndex = 0;
       
       ArrayList<Hall> halls = getAccSystem().getHalls();
       Hall selectedHall = halls.get(hallChoiceIndex);

        
        String selectedOption = fxHallChoice.getValue();
        
        switch (selectedOption) {
            case "Quantock":     
                selectedHall = halls.get(hallChoiceIndex);
                break;
            case "Cotswold":
                hallChoiceIndex = 1;
                selectedHall = halls.get(hallChoiceIndex);
                break;
            case "Walscourt":
                hallChoiceIndex = 2;
                selectedHall = halls.get(hallChoiceIndex);
                break;
        }
        
               fxManagerName.setText(selectedHall.manager.getname());
               fxTelNo.setText(selectedHall.manager.getphoneNumber());

        
        // Set the table with the new data to show
        fxAccomSummaryTab.setItems(tableData);
        // Set info numbers text
        fxTotalRooms.setText(incrementTotal+"");
        fxRequiresCleaning.setText(incrementDirty+"");
        fxAvailability.setText(incrementAvaliable+"");
        fxOffline.setText(incrementOffline+"");
    }

    // Based on an room number, find the associated room object.
    private Room getRoom(int accommNo)
    {
        ArrayList<Room> rooms = roomsFromHallChoiceBox();

        Room foundRoom = null;

        for (Room room : rooms) 
        {
            if (Integer.valueOf(room.getRoomNum()) == accommNo)
            {
                // Found the object
                foundRoom = room;
                break;
            }
        }
        
        return foundRoom;
    }
    
    
    
    
    // this sets the value of the little boxes that show extra details. EG when i click a new room row the boxes for lease num and name change
    @FXML
     private void onTableClicked(MouseEvent event) throws InterruptedException {
        
        // we need to reset the fields for the place where there may sometimes not be a value
        // this is only on the rental agreement info page, because sometimes there might not be a rental agreement
        
        fxLeaseNum.setText("");
        fxFirstName.setText("");
        fxLastName.setText("");
        fxStudentNum2.setText("");
        fxMobileNum2.setText("");
        fxRoomInventory.setText("");
        
        RoomRow roomRow = fxAccomSummaryTab.getSelectionModel().getSelectedItem();
        
        
        if (roomRow != null) 
        {
            // Retrieve the accommodation number of the selected row
            // and find the associated accommodation object in the system.
            // Then set the text fields with the values.
            
            System.out.println(roomRow.getNumber());
            
            // Retrieve the values from the Accommodation Row for the selected row
            int accommNo = Integer.valueOf(roomRow.getNumber());
           
            // Find the associated accommodation object based on the unique
            // accommodation number
            
            Room selectedRoom = getRoom(accommNo);
            
                String leaseNum = selectedRoom.rentalAgreement.getLeaseNumber();
                fxLeaseNum.setText(leaseNum);

                String firstName = selectedRoom.rentalAgreement.student.getStudentName();
                fxFirstName.setText(firstName);

                String lastName = selectedRoom.rentalAgreement.student.getStudentLastName();
                fxLastName.setText(lastName);
                            
                String accNumber = selectedRoom.rentalAgreement.getRoomNumber();
                fxAccommNumber.setText(accNumber);
                
                String accType = selectedRoom.getType();
                fxAccommType.setText(accType);
                
                String accPrice = selectedRoom.rentalAgreement.getPrice();
                fxAccommPrice.setText(accPrice);
                
                String studentNum = selectedRoom.rentalAgreement.student.getID();
                fxStudentNum2.setText(studentNum);
                
                String mobileNum = selectedRoom.rentalAgreement.student.getStudentPhoneNo();
                fxMobileNum2.setText(mobileNum);
                
                fxRoomInventory.setText(selectedRoom.getRoomDescription());
                

                
                // I NEED TO CHANGE THIS LATER BECAUSE EVERY ROOM STARTS WITH A RENTAL AGREEMENT
                // WHICH IS WRONG!!!
                
                if (selectedRoom.rentalAgreement.getRentalAgreementIsEmpty() == true){
                   fxAccommOcc.setText("Unoccupied");   
                }
                else {
                   fxAccommOcc.setText("Occupied");
                }
                
                //set the value of the choicebox dropdown to whatever the room is
                
                fxCleaningStatusChoice.setValue(selectedRoom.cleaning.getCleaningStatus());
                Thread.sleep(200);

                
            }
            
            // Set the text field
            //fxAccomNumCol.setText(String.valueOf(accommNo));

        }
     
     
    private void refreshLeaseFields(){
        // we need to reset the fields for the place where there may sometimes not be a value
        // this is only on the rental agreement info page, because sometimes there might not be a rental agreement
        
        fxLeaseNum.setText("");
        fxFirstName.setText("");
        fxLastName.setText("");

        
        RoomRow roomRow = fxAccomSummaryTab.getSelectionModel().getSelectedItem();
        
        
        if (roomRow != null) 
        {
            // Retrieve the accommodation number of the selected row
            // and find the associated accommodation object in the system.
            // Then set the text fields with the values.
            
            System.out.println(roomRow.getNumber());
            
            // Retrieve the values from the Accommodation Row for the selected row
            int accommNo = Integer.valueOf(roomRow.getNumber());
           
            // Find the associated accommodation object based on the unique
            // accommodation number
            
            Room selectedRoom = getRoom(accommNo);
            
                String leaseNum = selectedRoom.rentalAgreement.getLeaseNumber();
                fxLeaseNum.setText(leaseNum);

                String firstName = selectedRoom.rentalAgreement.student.getStudentName();
                fxFirstName.setText(firstName);

                String lastName = selectedRoom.rentalAgreement.student.getStudentLastName();
                fxLastName.setText(lastName);
                            
                String accNumber = selectedRoom.rentalAgreement.getRoomNumber();
                fxAccommNumber.setText(accNumber);
                
                String accType = selectedRoom.getType();
                fxAccommType.setText(accType);
                
                String accPrice = selectedRoom.rentalAgreement.getPrice();
                fxAccommPrice.setText(accPrice);
                
                String studentNum = selectedRoom.rentalAgreement.student.getID();
                fxStudentNum2.setText(studentNum);
                
                String mobileNum = selectedRoom.rentalAgreement.student.getStudentPhoneNo();
                fxMobileNum2.setText(mobileNum);
                
                
                // I NEED TO CHANGE THIS LATER BECAUSE EVERY ROOM STARTS WITH A RENTAL AGREEMENT
                // WHICH IS WRONG!!!
                
                if (selectedRoom.rentalAgreement.getRentalAgreementIsEmpty() == true){
                   fxAccommOcc.setText("Unoccupied");   
                }
                else {
                   fxAccommOcc.setText("Occupied");
                }
                
                //set the value of the choicebox dropdown to whatever the room is
                
                //fxCleaningStatusChoice.setValue(selectedRoom.cleaning.getCleaningStatus());
                
                
            }
            
            // Set the text field
            //fxAccomNumCol.setText(String.valueOf(accommNo));

         
    }
             
    @FXML
    private void onUpdateClicked(MouseEvent event) {
        
        
        RoomRow roomRow = fxAccomSummaryTab.getSelectionModel().getSelectedItem();
        
        if(roomRow != null){
        System.out.println("row found");
                
        int accommNo = Integer.valueOf(roomRow.getNumber());
        Room selectedRoom = getRoom(accommNo);
        int checks = 0;
        String wtf = (fxStudentNum.getText());
        

        if (selectedRoom.cleaning.getCleaningStatus() == "Dirty" || selectedRoom.cleaning.getCleaningStatus() == "Offline"){
            
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Rental agreement creation error!");
            alert.setContentText("You cannot add a rental agreement to a room which is offline or dirty!");
            refreshLeaseFields();
            alert.showAndWait();
            
        } else {
                    //input validation for lease number - must only contain numbers
                    if (fxLeaseNum.getText().matches("\\d+")) {
                    selectedRoom.rentalAgreement.setLeaseNumber(fxLeaseNum.getText());
                    checks +=1;
                    
                    } else {                    
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.setTitle("Error Dialog");
                                alert.setHeaderText("Rental agreement creation error!");
                                alert.setContentText("Lease number must contain only numbers!");
                                alert.showAndWait();
                    }
                    
                    System.out.println("First reached");
        
                    //input validation for first name - must only contain letters and spaces
                    if (fxFirstName.getText().matches("[a-zA-Z ]+")) {
                    selectedRoom.rentalAgreement.student.setStudentName(fxFirstName.getText());
                    checks +=1;
                    } else {                    
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.setTitle("Error Dialog");
                                alert.setHeaderText("Rental agreement creation error!");
                                alert.setContentText("Student first name must contain only letters!");
                                alert.showAndWait();
                    }
                    
                    //input validation for last name - must only contain letters and spaces
                    if (fxLastName.getText().matches("[a-zA-Z ]+")) {
                    selectedRoom.rentalAgreement.student.setStudentLastName(fxLastName.getText());
                    checks +=1;

                    
                    } else {                    
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.setTitle("Error Dialog");
                                alert.setHeaderText("Rental agreement creation error!");
                                alert.setContentText("Student last name must contain only letters!");
                                alert.showAndWait();
                    }
                    
                    
                    //TODO RE-ADD VERIFICATION CAUSE IT WILL WORK NOW
                    
                    if (fxStudentNum2.getText().matches("[0-9 ]+")) {
                    selectedRoom.rentalAgreement.student.setID(fxStudentNum2.getText());
                    checks +=1;
                    } else {
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.setTitle("Error Dialog");
                                alert.setHeaderText("Rental agreement creation error!");
                                alert.setContentText("Student number must only contain numbers!");
                                alert.showAndWait();
                    }
                    
                    if (fxMobileNum2.getText().matches("[0-9 ]+")) {
                    selectedRoom.rentalAgreement.student.setStudentPhoneNo(fxMobileNum2.getText());
                    checks +=1;
                    } else {
                                Alert alert = new Alert(AlertType.ERROR);
                                alert.setTitle("Error Dialog");
                                alert.setHeaderText("Rental agreement creation error!");
                                alert.setContentText("Phone number must only contain numbers!");
                                alert.showAndWait();
                    }
                    
                    
                    //i tried to fix this verification for like 3 hours and had no idea why it wasnt workijng so im just not gonna verify these ones
                    
                   // System.out.println("line before setting");
                   // String godsaveme1 = fxStudentNum2.getText();
                    //System.out.println(godsaveme1);
                    

                            
                    
                    //String godsaveme2 = fxMobileNum2.getText();
                    //System.out.println(godsaveme2);

                    
                    System.out.println("line after setting");

                    

                   

                    }
        
        
            if (checks == 5){
                selectedRoom.rentalAgreement.setRentalAgreementIsEmpty(false);

            }
               
            refreshLeaseFields();
            
        }}
    

    @FXML
    private void onDeleteClicked(MouseEvent event) {
        RoomRow roomRow = fxAccomSummaryTab.getSelectionModel().getSelectedItem();
        
        if(roomRow != null){
        int accommNo = Integer.valueOf(roomRow.getNumber());
        Room selectedRoom = getRoom(accommNo);
        
        selectedRoom.rentalAgreement.setLeaseNumber("");
        selectedRoom.rentalAgreement.student.setStudentName("");
        selectedRoom.rentalAgreement.student.setStudentLastName("");
        selectedRoom.rentalAgreement.student.setID("");
        selectedRoom.rentalAgreement.student.setStudentPhoneNo("");
        selectedRoom.rentalAgreement.setRentalAgreementIsEmpty(true);
        
        refreshLeaseFields();
        populateTable();
        }
    }
        

    

    @FXML
    private void onSubmitClicked(MouseEvent event) {
        
        RoomRow roomRow = fxAccomSummaryTab.getSelectionModel().getSelectedItem();
        if(roomRow != null){
        int accommNo = Integer.valueOf(roomRow.getNumber());
        Room selectedRoom = getRoom(accommNo);
        
        String selectedCleaning =  fxCleaningStatusChoice.getValue();
        
        selectedRoom.cleaning.setCleaningStatus(selectedCleaning);
        
        populateTable();
            
        }
    }

        
    }
    

