
package algorithm_project;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class Sort  extends JFrame implements ActionListener {
    JButton b1,b2;
    JTextField tx1,tx2,tx3,tx4,tx5,tx6,tx7,tx8,tx9,tx10,tx11,tx12;
    JLabel lb1,lb2;
   
    Sort(){
        tx1 = new JTextField();
        tx1.setBounds(20, 50, 60, 30);
        add(tx1);
        
        tx2 = new JTextField();
        tx2.setBounds(100, 50, 60, 30);
        add(tx2);
        
        tx3 = new JTextField();
        tx3.setBounds(180, 50, 60, 30);
        add(tx3);
        
        tx4 = new JTextField();
        tx4.setBounds(260, 50, 60, 30);
        add(tx4);
        
        tx5 = new JTextField();
        tx5.setBounds(340, 50, 60, 30);
        add(tx5);
        
        tx6 = new JTextField();
        tx6.setBounds(420, 50, 60, 30);
        add(tx6);
        
        //Sorting list Start
        tx7 = new JTextField();
        tx7.setBounds(20, 300, 60, 30);
        add(tx7);
        
        
        tx8 = new JTextField();
        tx8.setBounds(100, 300, 60, 30);
        add(tx8);
        
        tx9 = new JTextField();
        tx9.setBounds(180, 300, 60, 30);
        add(tx9);
        
        tx10 = new JTextField();
        tx10.setBounds(260, 300, 60, 30);
        add(tx10);
        
        tx11 = new JTextField();
        tx11.setBounds(340, 300, 60, 30);
        add(tx11);
        
        tx12 = new JTextField();
        tx12.setBounds(420, 300, 60, 30);
        add(tx12);
     
        
        lb1 = new JLabel("Please Enter Registration Code");
        lb1.setBounds(20, 25,300, 20);
        add(lb1);  
        
        lb2 = new JLabel("Sorted Registration Code");
        lb2.setBounds(20, 280,300, 20);
        add(lb2);        
        
        b1 = new JButton("Sort");
        b1.setBounds(40, 220, 120, 30);
        add(b1);
        
        b2 = new JButton("Ok");
        b2.setBounds(20, 360, 60, 30);
        add(b2);
    
        
        b1.addActionListener(this);
        b2.addActionListener(this);
      
        setLayout(null);
        setSize(510,500);
        setVisible(true);
        setTitle("Customer Entry");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent x){
         int l[] = new int[6];
        int a = Integer.parseInt(tx1.getText());
        int b = Integer.parseInt(tx2.getText()); 
        int c = Integer.parseInt(tx3.getText());
        int d = Integer.parseInt(tx4.getText());
        int e = Integer.parseInt(tx5.getText());
        int f = Integer.parseInt(tx6.getText());
        
        if(x.getSource()==b1){
         
            l[0] = a;
            l[1] = b;
            l[2] = c;
            l[3] = d;
            l[4] = e;
            l[5] = f;
         
        for (int i = 0; i <l.length; i++) {
            
            int min = i;
            
            for (int j = i+1; j <l.length; j++) {
                
                if(l[j]<l[min])
                {
                    min = j;
                }
            }
            int temp = l[i];
            l[i] = l[min];
            l[min]= temp;
            
        }
          
        tx7.setText(String.valueOf(l[0]));
        tx8.setText(String.valueOf(l[1]));
        tx9.setText(String.valueOf(l[2]));
        tx10.setText(String.valueOf(l[3]));
        tx11.setText(String.valueOf(l[4]));
        tx12.setText(String.valueOf(l[5]));
        }
        
        if(x.getSource()== b2){
          BookShop_Inventory newframe = new BookShop_Inventory();
          newframe.setVisible(true);
          dispose();
        }
      
      
    }
    public static void main(String[] args) {
        
      Sort s  = new Sort(); 
       
        
    
}

}
