import java.util.Random;
/**
 * Write a description of class Portero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portero extends Jugador
{
    // instance variables - replace the example below with your own
    private int agilidad;
    private int fortalezaMental;

    /**
     * Constructor for objects of class Portero
     */
    public Portero(int edad, int estadoDeForma,int dorsal, int agilidad, int fortalezaMental)
    {
        super(dorsal);
        Random rnd = new Random();
        this.agilidad = rnd.nextInt(10);
        this.fortalezaMental = rnd.nextInt(10);
    }

    public int valoracion(){
        return (agilidad + fortalezaMental)/2;
    }
    
    public String setNombre(){
        return super.setNombre();
    }
    
    public String getNombre(){
         return super.getNombre();
    }
    
    public String toString(){
         String espacio = " ";
        return super.toString() + String.format("  Agil  : %2d  FortM   : %2d %12s   Valoracion : %2d",agilidad,
            fortalezaMental,espacio,valoracion());
    }
}
