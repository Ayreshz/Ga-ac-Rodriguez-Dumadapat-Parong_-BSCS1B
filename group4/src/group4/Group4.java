package group4;
import  java.awt.*;
import  java.awt.event.*;

public class Group4{
   
    public static void main(String[] args) {
        
        
        Frame frame = new Frame("Hello");
        Label lb1 = new Label("Label 1");
        Label lb2 = new Label("Label 2 ");
        Label lb3 = new Label("Labe1 3 ");
        TextField txt = new TextField("");
        TextArea txtArea = new TextArea();
        Button btn = new Button("Submit");
        
     
        frame.setSize(300,200);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        frame.addWindowListener(EXIT_ON_CLOSE);
        
        txt.setPreferredSize(new Dimension (100,300));
        btn.setLabel("Submit");
        txtArea.setPreferredSize(new Dimension (100,300));
        
         
        frame.add(lb1);
        frame.add(lb2);
        frame.add(lb3);
        frame.add(txt);
        frame.add(txtArea);
        frame.add(btn);    
    }
}
