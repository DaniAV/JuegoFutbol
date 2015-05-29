import java.util.Random;
/**
 * Write a description of class Capitan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Capitan extends JugadorCampo
{
    // instance variables - replace the example below with your own
    private int liderazgo;

    /**
     * Constructor for objects of class Capitan
     */
    public Capitan(int dorsal)
    {
        super(dorsal);
        Random rnd = new Random();
        this.liderazgo = rnd.nextInt(5);
    }

    public int valoracion(){
        return super.valoracion() + liderazgo;
    }
    
    public String setNombre(){
        return super.setNombre();
    }
    
    public String getNombre(){
        return super.getNombre();
    }
    
    public String toString(){
        return super.toString() + " Liderazgo: " + liderazgo;
    }
}
