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
public class Student {
    
    private String studentName;
    private String studentLastName;
    private String studentPhoneNo;
    private String ID;

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public void setStudentPhoneNo(String studentPhoneNo) {
        this.studentPhoneNo = studentPhoneNo;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


    public Student(String studentName, String studentNo, String ID) {
        this.studentName = studentName;
        this.studentPhoneNo = studentNo;
        this.ID = ID;
    }
    
    public Student(boolean studentIsEmpty){
        if (studentIsEmpty == false){
            
        String[] names = {"James", "Fahmi", "Harrison", "Elliott"};
        String[] lastnames = {"Hayes", "Alshahabi", "Newton", "Tomkings"};

        // Generating a random index
        Random random = new Random();
        int randomIndex = random.nextInt(names.length);

        // Returning the random name
        String name = names[randomIndex];
        String lastname = lastnames[randomIndex];
        
        String[] phoneNumbers = {"01539 949247", "01697 751403", "01422 594305", "01837 365417" };
        int randomIndex2 = random.nextInt(phoneNumbers.length);
        
        


        
        this.studentName = name;
        this.studentLastName = lastname;
        this.studentPhoneNo = phoneNumbers[randomIndex2];
        this.ID = "12345";
        } else{
            
            this.studentName = "";
            this.studentLastName = "";
            this.studentPhoneNo = "";
            this.ID = "";
        }
    }     
    public String getStudentName() {
        return studentName;
    }

    public String getStudentPhoneNo() {
        return studentPhoneNo;
    }

    public String getID() {
        return ID;
    }
    
    public String getStudentLastName(){
        return studentLastName;
    }
    
    
}
