package college.management.system;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

 
public class Project extends JFrame implements ActionListener{
    Project()
    {
        setSize(1540,850);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./icons/College4.jpg"));
        Image i2 =i1.getImage().getScaledInstance(1500, 750,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        add(image);
        
        JMenuBar mb= new JMenuBar();
        
       
        JMenu newInformation = new JMenu ("New Information");
         newInformation.setForeground(Color.BLUE);
         mb.add(newInformation);
         setJMenuBar(mb);
         setVisible(true);
         //new information
         JMenuItem facultyinfo = new JMenuItem("New Faculty Information");
         newInformation.add(facultyinfo);
         facultyinfo.setBackground(Color.WHITE );
         facultyinfo.addActionListener(this);
         
         
         JMenuItem studentinfo = new JMenuItem("New Student Information");
         newInformation.add(studentinfo);
         studentinfo.setBackground(Color.WHITE );
         studentinfo.addActionListener(this);
         
         //details
         JMenu details= new JMenu ("View Details");
         details.setForeground(Color.RED);
         mb.add(details);
         
         
         JMenuItem facultydetails = new JMenuItem("View Faculty Details");
         details.add(facultydetails);
         facultydetails.setBackground(Color.WHITE );
         facultydetails.addActionListener(this);
         
         JMenuItem viewdetails= new JMenuItem("View Student Details");
         details.add(viewdetails);
         viewdetails.setBackground(Color.white );
         viewdetails.addActionListener(this);
   
          
         //leave
         JMenu leave= new JMenu ("Apply Leave");
         leave.setForeground(Color.BLUE);
         mb.add(leave);
         
         JMenuItem facultyleave= new JMenuItem("Faculty Leave");
         leave.add(facultyleave);
         facultyleave.setBackground(Color.white );
         facultyleave.addActionListener(this);
         
         JMenuItem studentleave = new JMenuItem("Student Leave");
         leave.add(studentleave);
         studentleave.setBackground(Color.WHITE );
         studentleave.addActionListener(this);
         
         JMenu leavedetails= new JMenu ("Leave Details");
         leavedetails.setForeground(Color.RED);
         mb.add(leavedetails);
         
         JMenuItem facultyleavedetails= new JMenuItem("Faculty Leave Details");
         leavedetails.add(facultyleavedetails);
         facultyleavedetails.setBackground(Color.white);
         facultyleavedetails.addActionListener(this);
          
         JMenuItem studentleavedetails = new JMenuItem("Student Leave Details");
         leavedetails.add(studentleavedetails);
         studentleavedetails.setBackground(Color.WHITE );
         studentleavedetails.addActionListener(this);
    
         JMenu exam= new JMenu ("Examination");
         exam.setForeground(Color.BLUE);
         mb.add(exam);
         
         JMenuItem examinationdetails= new JMenuItem("Examination Results");
         exam.add(examinationdetails);
          examinationdetails.setBackground(Color.white);
          examinationdetails.addActionListener(this);
         
         JMenuItem entermarks = new JMenuItem("Enter Marks");
         exam.add(entermarks);
         entermarks.setBackground(Color.white);
         entermarks.addActionListener(this);
         
         JMenu updateinfo= new JMenu ("Update Details");
         updateinfo.setForeground(Color.RED);
         mb.add(updateinfo);
         
         
         JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
         updateinfo.add(updatestudentinfo);
         updatestudentinfo.setBackground(Color.white);
         updatestudentinfo.addActionListener(this);
         
          JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
         updateinfo.add(updatefacultyinfo);
         updatefacultyinfo.setBackground( Color.white);
         updatefacultyinfo.addActionListener(this);
         
         
         JMenu fee= new JMenu("Fee Details");
          fee.setForeground(Color.blue);
          mb.add(fee);
         
         JMenuItem feestructure= new JMenuItem("Fee Structure");
         fee.add(feestructure);
         feestructure.setBackground( Color.white);
         feestructure.addActionListener(this);
         
         JMenuItem feeform= new JMenuItem("Student fee Form");
         fee.add(feeform);
         feeform.setBackground(Color.white);
         feeform.addActionListener(this);
          
         JMenuItem feedetails= new JMenuItem("Print Student Fees Details");
         fee.add(feedetails);
         feedetails.setBackground(Color.white);
         feedetails.addActionListener(this);
         
         JMenu utility= new JMenu ("Utility");
         utility.setForeground(Color.RED);
         mb.add(utility);
         
         JMenuItem notepad= new JMenuItem("Notepad");
         utility.add(notepad);
         notepad.setBackground( Color.white);
         notepad.addActionListener(this);
         
         JMenuItem  calc= new JMenuItem("Calculator");
         utility.add(calc);
         calc.setBackground(Color.white);
         calc.addActionListener(this);
         
         
         JMenu exit= new JMenu ("Exit");
         exit.setForeground(Color.blue);
         mb.add(exit);
         
        JMenuItem ex= new JMenuItem("Exit");
        exit.add(ex);
        exit.setBackground( Color.BLUE);
        ex.addActionListener(this);
              
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(mb);
        setVisible(true);
     
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg=ae.getActionCommand();
        if(msg.equals("Exit")){
            setVisible(false);
        }
        else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }
            catch (Exception e){
                
            }
        }
        else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }
            catch (Exception e){
                
            }
        }
        else if (msg.equals("New Faculty Information")) {
            new AddTeacher();
        } 
        else if (msg.equals("New Student Information")) {
            new Addstudent();
        }
        else if (msg.equals("View Faculty Details")) {
           new TeacherDetails();
        }
         else if (msg.equals("View Student Details")) {
          new StudentDetails();
        }
         else if (msg.equals("Faculty Leave")) {
             new TeacherLeave();
        }
         else if (msg.equals("Student Leave")) {
             new StudentLeave();
        }
         else if(msg.equals("Faculty Leave Details")){
            new TeacherLeaveDetails();        
        }
        
        else if(msg.equals("Student Leave Details")){
             new StudentLeaveDetails();       
       }
        
            else if(msg.equals("Update Student Details")){
             new  UpdateStudent();    
        }
        
            else if(msg.equals("Update Faculty Details")){
             new UpdateTeacher();       
    } 
        
           else if(msg.equals("Enter Marks")){
             new EnterMarks();       
    }  
        
        else if(msg.equals("Examination Results")){
            new ExaminationDetails();
    }  
    
               else if(msg.equals("Fee Structure")){
             new FeeStructure();
    }  
           else if(msg.equals("Student fee Form")){
             new StudentFeeForm();
    }  
           else if (msg.equals("Print Student Fees Details"))
           {
               new PrintFee();
           }
  }
 public static void main(String[] args){
     new Project();
 }   
}