/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package classlist;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Bafana Bhuda
 */
public class ClassList {

    public static void main(String[] args) {
        String name;
        String surname;
        String studnum;
        String subject;
        
        
        List <Student> clasList = new ArrayList<>();;
        Student stud;
        
        do{  
            do {                
                name=JOptionPane.showInputDialog(null,"Enter your name or \"exit\":");
            } while (name.equals(""));
            
            if (!name.equalsIgnoreCase("exit")) {
                surname=JOptionPane.showInputDialog(null,"Enter your surname:");
                studnum=JOptionPane.showInputDialog(null,"Enter your student number:");
                List <String> subj = new ArrayList<>();
                do {                    
                    subject=JOptionPane.showInputDialog(null,"Enter your subjects or \"done\" to save and Exit:");
                    if (!subject.equalsIgnoreCase("Done")) {
                        subj.add(subject);
                    }
                    stud = new Student(name, surname, studnum, subj);
                } while (!subject.equalsIgnoreCase("Done") && !subject.equals(null));
                
        
                
                
                clasList.add(stud);
            }
            else{
                try {
                    if (!clasList.isEmpty()){
                   
                        JOptionPane.showMessageDialog(null, "The List is saved","List Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(null, "The List is empty","List Information", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }while(!name.equalsIgnoreCase("exit"));
        
        try {
            if (!clasList.isEmpty()) {
            String stOpt=JOptionPane.showInputDialog(null, "Select an Opt:\n\n"
                    + "1. Display all student.\n"
                    + "2. Remove a student.\n"
                    + "3. Search for a student.\n"
                    + "4. Update the Details of a student.\n"
                    + "5. Store the contents of list in a File\n"
                    + "6. exit.");
            
            int opt = Integer.parseInt(stOpt);
            
            switch (opt) {
                case 1:
                    String students="";
                    for (int i = 0; i < clasList.size(); i++) {
                        students+=clasList.get(i)+"\n\n";
                    }
                    JOptionPane.showMessageDialog(null, clasList.toString());
                    break;
                case 2:
                    String remove =JOptionPane.showInputDialog(null, "Which student you want to remove\n\nEnter student number?");
                    for (int i = 0; i < clasList.size(); i++) {
                        if ((clasList.get(i).studnum).equalsIgnoreCase(remove)) {
                            clasList.remove(i);
                        }
                        else;
                    }
                    JOptionPane.showMessageDialog(null,"New List: \n"+clasList,"New Class List",JOptionPane.PLAIN_MESSAGE);
                 
                    break;
                case 3:
                    String search =JOptionPane.showInputDialog(null, "Which student you want to remove\n\nEnter student number: ?");
                    String text="";
                    for (int i = 0; i < clasList.size(); i++) {
                        if ((clasList.get(i).studnum).equalsIgnoreCase(search)) {
                            text =search+" student is available";
                            break;
                        }
                        else{ 
                            text=search+" student is not available";
                            }
                    }
                    JOptionPane.showMessageDialog(null, text, "Searching for a Student", JOptionPane.PLAIN_MESSAGE);
                    break;
                case 4:
                    String studentNum = JOptionPane.showInputDialog(null, "Enter student number to update:");
                    if (studentNum != null) {
                        Student foundStudent = null;
                        for (Student student : clasList) {
                            if (student.getStudnum().equalsIgnoreCase(studentNum)) {
                                foundStudent = student;
                                break;
                            }
                        }
                        if (foundStudent != null) {
                            String part = JOptionPane.showInputDialog(null, "Which part you want to update: Name/Surname/Number/Subjects");
                            if (part != null) {
                                if (part.equalsIgnoreCase("name")) {
                                    String newName = JOptionPane.showInputDialog(null, "Enter new name:");
                                    if (newName != null && !newName.trim().isEmpty()) {
                                    foundStudent.setName(newName);
                                    }
                            }else if (part.equalsIgnoreCase("surname")) {
                                String newSurname = JOptionPane.showInputDialog(null, "Enter new surname:");
                                if (newSurname != null && !newSurname.trim().isEmpty()) {
                                    foundStudent.setSurname(newSurname);
                                }
                            } else if (part.equalsIgnoreCase("number")) {
                                String newNumber = JOptionPane.showInputDialog(null, "Enter new student number:");
                                if (newNumber != null && !newNumber.trim().isEmpty()) {
                                    foundStudent.setStudnum(newNumber);
                                }
                            } else if (part.equalsIgnoreCase("subjects")) {
                                List<String> newSubjects = new ArrayList<>();
                                String subj;
                                do {
                                    subj = JOptionPane.showInputDialog(null, "Enter subject or \"done\" to finish:");
                                    if (subj != null && !subj.equalsIgnoreCase("done") && !subj.trim().isEmpty()) {
                                        newSubjects.add(subj);
                                    }
                                } while (subj != null && !subj.equalsIgnoreCase("done"));
                                foundStudent.setSubj(newSubjects);
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid option. Please choose: Name, Surname, Number, or Subjects");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Student not found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                    text="";
                    for (int i = 0; i < clasList.size(); i++) {
                        if (clasList.get(i).studnum.equals(studentNum)) {
                            text=clasList.toString();
                        }
                    }
                    JOptionPane.showMessageDialog(null,text, "Upadated Student",JOptionPane.PLAIN_MESSAGE );
                    
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "The class list is Stored, Bye", "Store",JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Goodbye", "Closing",JOptionPane.PLAIN_MESSAGE);
                    break;
                
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Option", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
            
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Goodbye", "Closing",JOptionPane.PLAIN_MESSAGE);
        }
        
        
    }
}

    class Student {
        String name;
        String surname;
        String studnum;
        List<String> subj;

        public Student(String name, String surname, String studnum, List<String> subj) {
            this.name = name;
            this.surname = surname;
            this.studnum = studnum;
            this.subj = subj;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStudnum() {
        return studnum;
    }

    public void setStudnum(String studnum) {
        this.studnum = studnum;
    }

    public List<String> getSubj() {
        return subj;
    }

    public void setSubj(List<String> subj) {
        this.subj = subj;
    }

    @Override
    public String toString() {
        String text="Student full name: "+name+" "+surname+"\n"
                + "Student Nr: "+studnum+"\n"
                + "Subjects: "+subj+"\n\n";
        
        return text;
    }
        
        
    }
    

