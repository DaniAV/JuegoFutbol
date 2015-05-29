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
    //indica si el jugador es un crack
    private boolean crack;
    //cte que indica que un jugador se convierte en crack
    private static final int NUM_CRACK = 7 ;
    /**
     * Constructor for objects of class JugadorCampo
     */
    public JugadorCampo(int dorsal)
    {
        super(dorsal);
        Random rnd = new Random();
        this.pase = rnd.nextInt(11);
        this.regate = rnd.nextInt(11);
        this.remate = rnd.nextInt(11);
        crack = false;
        
        
        
    }

    public int valoracion(){
        return (getEstadoDeForma() + pase + regate + remate)/4;
    }
      
        public String toString(){
        return super.toString() + String.format("  Pases : %2d  Regates : %2d  Remates : %2d"
            + "  Valoracion : %2d %5s",pase,regate,remate,valoracion(),mostrarCrack());
          
    }
    
    /**
     * Metodo que convierte a un jugador de campo en crack
     * @return true si lo convierte,false si no lo hace
     */
    public boolean convertirACrack()
    {
        
        //se determina si un jugador es crack de forma aleatoria
        Random rnd = new Random();
        int esUnCrack = rnd.nextInt(11);
        if(esUnCrack == NUM_CRACK)
        {
            setForma(10);
            pase = 10;
            regate = 10;
            remate = 10;
            crack = true;
        }
        return crack;
    }
    
    /**
     * Metodo que hace que un jugador crack deje de serlo
     */
    public void setCrack()
    {
        crack = false;
    }
    
    /**
     * Metodo que devuelve si un jugador es un crack
     * @return true si es un crack,false si no lo es
     */
    public boolean isCrack()
    {
        return crack;
    }
    
    /**
     * Metodo que muestra en forma de cadena si un jugador es un crack
     */
    public String mostrarCrack()
    {
        String crack =" ";
        if(isCrack())
        {
            crack = "Crack";
        }
        return crack;
    }
}
