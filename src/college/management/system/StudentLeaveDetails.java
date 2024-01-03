
package college.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class StudentLeaveDetails extends JFrame implements ActionListener{
    JButton search,print,cancel;
    Choice crollno;
    JTable table;
 StudentLeaveDetails(){
     
     setSize(900,700);
     setLocation(300,100);
     getContentPane().setBackground(Color.WHITE);     
     setLayout(null);
     
     JLabel heading = new JLabel("Search by Roll No");
     heading.setBounds(20,20,150,20);
     add(heading);
     
     crollno=new Choice();
     crollno.setBounds(180,20,150,20);
     add(crollno);
     
     try{
         Conn c = new Conn();
         ResultSet rs = c.s.executeQuery("select * from student");
         while(rs.next()){
             crollno.add(rs.getString("rollno"));
         }
     }catch(Exception e){
         e.printStackTrace();
     }
     
     table = new JTable();
     
     JScrollPane jsp = new JScrollPane(table);
     jsp.setBounds(0,100,900,600);
     
     add(jsp);
     
     
     try{
         Conn c = new Conn();
         ResultSet rs = c.s.executeQuery("select * from studentleave");
         while(rs.next()){
             crollno.add(rs.getString("rollno"));
             table.setModel(DbUtils.resultSetToTableModel(rs));
         }
     }catch(Exception e){
          e.printStackTrace();
     } 
     
      search = new JButton("Search");
      search.setBounds(20,70,80,20);
      add(search);
      search.addActionListener(this);
      
     
      print = new JButton("Print");
      print.setBounds(120,70,80,20);
      add(print);
      print.addActionListener(this);
      
      cancel= new JButton("Cancel");
      cancel.setBounds(220,70,80,20);
      add(cancel);
      cancel.addActionListener(this);
     setVisible(true);
 }   
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query= "select * from studentleave where rollno = '"+crollno.getSelectedItem()+"'";
        
        try{
            Conn c = new Conn();
            ResultSet rs =c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        }
        else if(ae.getSource()==print){
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
       else {
         setVisible(false);
    }
    }
    

    public static void main(String[] args){
        new StudentLeaveDetails();
}
}
