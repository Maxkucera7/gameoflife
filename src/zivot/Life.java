package zivot;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

public class Life {
    private Svet svet;
    private int [][] telo;
    private int [] [] sousede;
    public Life(Svet svet){
    this.svet=svet;
    telo=new int [svet.getSvet().length][svet.getSvet()[0].length];
    sousede=new int [svet.getSvet().length][svet.getSvet()[0].length];
    Pocatek(500);
    Nacti();
    NajdiSousedy();
    Cas();
        
        
}
private void Nacti(){
    Bunka[] []bunky=svet.getSvet();
    for (int i = 0; i < telo.length; i++) {
        for (int j = 0; j < telo[0].length; j++) {
            if(telo[i][j]==1){
                bunky[i][j].setBackground(Color.BLACK);
                bunky [i][j].setBorderPainted(false);
            }else{
                bunky[i][j].setBackground(Color.WHITE);
                bunky [i][j].setBorderPainted(false);
            }
        }
    }
}
  private void Pocatek(int pocetZivych){
      if(pocetZivych>=telo.length*telo[0].length){
      for (int i=0;i<telo.length;i++){
          for (int j = 0; j < 10; j++) {
              telo[i][j]=1;
          }
      }
      }
      else{
          Napln(pocetZivych);
          
      }
  }
public void Napln(int pocet){
    int index;
    Random r=new Random();
    
    ArrayList<String> souradnice=new ArrayList();
    for (int i = 0; i < telo.length; i++) {
        for (int j = 0; j < telo[0].length; j++) {
            souradnice.add(Integer.toString(i)+","+Integer.toString(j));
        }
    }
    for (int i = 0; i < pocet; i++) {
        index=r.nextInt(souradnice.size());
        NastavNaZivou(souradnice.get(index));
        souradnice.remove(index);
    }
}
private void NastavNaZivou(String s){
    String[] cisla=s.split(",");
    telo[Integer.parseInt(cisla[0])][Integer.parseInt(cisla[1])]=1;
}
private void NajdiSousedy(){
    for (int i = 0; i < telo.length; i++) {
        for (int j = 0; j < telo[0].length; j++) {
            sousede[i][j]=Sousede(i,j);
        }
        
    }
}
private void Cas(){
    ActionListener taskPerformer = new ActionListener(){
        public void actionPerformed(ActionEvent evt){
        Zij();
        }
    
    };
    new Timer (1000, taskPerformer).start();

}
public void Zij(){
    Nacti();
    DalsiDen();
}
private int Sousede(int i, int j){
    int pocet = 0;
    for (int k = -1; k <= 1; k++) {
        for (int l = -1; l <= 1; l++) {
            if (!(k == 0 && l == 0)) {

                try {
                    if (telo[i + k][j + l] == 1) {
                        pocet++;
                    }
                } catch (Exception E) {

                }
            }
        }
    }

    return pocet;
}


public void ZabijBunky() {
    for (int i  = 0; i < telo.length; i++) {
        for (int j = 0; j < telo[0].length; j++) {
            telo[i][j]=0;
        }
    }
}

public void DalsiDen (){ 
        
        for (int i  = 0; i < telo.length; i++) {
            for (int j = 0; j < telo[0].length; j++) {
                int pocet=Sousede( i,  j);
               if (telo [i][j]==1&&pocet<2){
                    telo[i][j]=0;
                }else if(telo [i][j]==1&&pocet==2||pocet==3){
                    telo[i][j]=1;
                 }else if(telo [i][j]==1&&pocet>3){
                     telo [i][j]=0;
                }else if(telo[i][j]==0&&pocet==3){
                    telo [i][j]=1;
    } 
            }
        }}

 
}

