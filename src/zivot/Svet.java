package zivot;
public class Svet {
    
    private Bunka [][] svet;
    private String [] popisky=new String [2];
    public Svet(int vyska, int sirka, String z,String m,int sizeB){
        svet=new Bunka [vyska][sirka];
        popisky[0]=z;
        popisky[1]=m;
        for (int i = 0; i < svet.length; i++) {
            for (int j = 0; j < svet[0].length; j++) {
                svet[i][j]=new Bunka (sizeB,popisky[1]);
            }
            
        }
        
        
    }
    

    public Bunka[][] getSvet() {
        return svet;
    }

    public String[] getPopisky() {
        return popisky;
    }
    
    
}
