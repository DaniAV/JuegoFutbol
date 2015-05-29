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
    public Portero(int dorsal)
    {
        super(dorsal);
        Random rnd = new Random();
        this.agilidad = rnd.nextInt(11);
        this.fortalezaMental = rnd.nextInt(11);
    }

    public int valoracion(){
        return (getEstadoDeForma() + agilidad + fortalezaMental)/3;
    }
       
    /**
     * Metodo que devuelve la puntuacion en agilidad
     * @return la puntuacion en agilidad del portero
     */
    public int getAgilidad()
    {
        return agilidad;
    }
   
    /**
     * Metodo que devuelve la puntuacion en fortaleza mental
     * @return la puntuacion en fortaleza mental del portero
     */
    public int getFortalezaMental()
    {
        return fortalezaMental;
    }
    
    public String toString(){
         String espacio = " ";
        return super.toString() + String.format("  Agil  : %2d  FortM   : %2d %12s   Valoracion : %2d",agilidad,
            fortalezaMental,espacio,valoracion());
    }
    
    
}
