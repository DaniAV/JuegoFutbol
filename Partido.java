
/**
 * Write a description of class Partido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Partido
{
    // instance variables - replace the example below with your own
    private Equipo local;
    private Equipo visitante;

    /**
     * Constructor for objects of class Partido
     */
    public Partido(Equipo equipoLocal, Equipo equipoVisitante)
    {
        // initialise instance variables
        this.local = equipoLocal;
        this.visitante = equipoVisitante;
    }

    public void mostrarAlineaciones(){
        local.alineacionTitular();
        visitante.alineacionTitular();
    }
}
