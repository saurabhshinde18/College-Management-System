
package college.management.system;
import javax.swing.*;
import java.awt.*;
public class Splash extends JFrame implements Runnable{
    Thread t;
    Splash(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("maxresdefault.jpg"));
        Image i2 =i1.getImage().getScaledInstance(1400, 720,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        add(image);
        t=new Thread(this);
        t.start();
          setVisible(true);
     int x=1;
      for(int i=2;i<=500;i++){
        setLocation(600-((i+x)/2),250- (i/2));
        setSize(2*i+x,2*i+x);
        
    }
      try{
          Thread.sleep(10);
     
    }catch(Exception e){}
      
    }
    public void run(){
            try{
                Thread.sleep(7000);
                setVisible(false);
               new Login();
    }catch(Exception e) {}
    }   
    public static void main(String args[])
    {
        Splash a = new Splash();
    }
}
 