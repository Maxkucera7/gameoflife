package zivot;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Bunka extends JButton{
    
    private int size;
    
    public Bunka(int size, String popis){
        this.setSize(size,size);
        this.setVisible(true);
        this.setText(popis);
        this.size=size;
        
        
    }     
    public int vemSize(){
        return size;
    }
    
}
