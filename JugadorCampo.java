import java.util.Random;
/**
 * Write a description of class JugadorCampo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JugadorCampo extends Jugador
{
    // instance variables - replace the example below with your own
    private int pase;
    private int regate;
    private int remate;

    /**
     * Constructor for objects of class JugadorCampo
     */
    public JugadorCampo(int dorsal)
    {
        super(dorsal);
        Random rnd = new Random();
        this.pase = rnd.nextInt(10);
        this.regate = rnd.nextInt(10);
        this.remate = rnd.nextInt(10);
    }

    public int valoracion(){
        return (pase + regate + remate)/3;
    }
    
    public String setNombre(){
        return super.setNombre();
    }
    
    public String getNombre(){
        return super.getNombre();
    }
    
    public String toString(){
        return super.toString() + String.format("  Pases : %2d  Regates : %2d  Remates : %2d"
            + "  Valoracion : %2d",pase,regate,remate,valoracion());
    }
}
