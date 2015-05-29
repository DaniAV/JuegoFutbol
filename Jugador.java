import java.util.Random;
/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Jugador
{
    // instance variables - replace the example below with your own
    private static String[] ListaNombre = {"Ramon", "Pedro", "Juan", "Mario", "Marcos", "Miguel", "Luis", "Carlos",
            "Jose Ramon", "Federico", "Alberto", "Roberto", "Ruben", "Guillermo", "Hector", 
            "Mario", "Felipe", "Manuel", "Tomas", "Agustin", "Jose Manuel", "Juan Jesus", 
            "Pepe", "Ricardo", "Fernando", "Antonio", "Jose Alberto", "Jose Luis", "David", 
            "Emilio", "Cesar", "German", "Raul", "Pablo"};
    private int edad;
    private int estadoDeForma;
    private int dorsal;
    private String nombre;

    /**
     * Constructor for objects of class Jugador
     */
    public Jugador(int dorsal)
    {
        Random rnd = new Random();
        this.nombre = setNombre();
        this.edad = rnd.nextInt(22)+18;
        this.estadoDeForma = rnd.nextInt(11);
        this.dorsal = dorsal;

    }

    public abstract int valoracion();

    public String setNombre(){
        Random rnd = new Random(); //Creamos un objeto rando para asignar valores aleatorios
        return ListaNombre[rnd.nextInt(ListaNombre.length)];
    }

    public String getNombre(){
        return nombre;
    }

    public void setDorsal(int d){
        dorsal = d;
    }

    public int getDorsal(){
        return dorsal;
    }

    public String toString(){
        return String.format("Dorsal : %3d.  %-12s  (%2d  anios )  Forma : %2d",dorsal,nombre,edad,estadoDeForma);
    }

    /**
     * Metodo que modifica el estado de forma
     */
    public void setForma(int nuevoEstadoForma)
    {
        estadoDeForma = nuevoEstadoForma;
    }

    /**
     * Metodo que devuelve el estado de forma del jugador
     * @return el estado de forma del jugador
     */
    public int getEstadoDeForma()
    {
        return estadoDeForma;
    }

}
