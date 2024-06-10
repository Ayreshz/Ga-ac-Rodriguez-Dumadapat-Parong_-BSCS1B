package javaapplication2;   
import java.awt.*;
import java.awt.event.*;

public class JavaApplication2 {

    public static void main(String[] args) {
        Frame frame = new Frame("Welcome");
        Label user = new Label("Username:");
        Label pass = new Label("Password:");
        TextField txtname = new TextField ();
         TextField txtpass = new TextField ();
        Button btn = new Button("Submit");
                
        frame.setVisible(true);
        frame.setSize(500,300);
        frame.setLayout(new FlowLayout());
        
        txtname.setPreferredSize(new Dimension(100,27));
        txtpass.setPreferredSize(new Dimension(100, 27));
        txtpass.setEchoChar('*');
        
        frame.add(user);
        frame.add(pass);
        frame.add(txtname);
        frame.add(txtpass);
        frame.add(btn);
        
        frame.addWindowListener(new WindowAdapter(){
        @Override
        public void windowClosing(WindowEvent e){
            System.exit(0);
        }
        });

      btn.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
              String name = txtname.getText();
              String pass = txtpass.getText();
              
              System.out.println("Your username is " + name);
              System.out.println("Your password is " + pass);
              
              txtname.setText("");
              txtpass.setText("");
          }
      }) ;       
        
        
        
    }
    
}
