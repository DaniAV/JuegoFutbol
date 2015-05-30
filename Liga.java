import java.util.ArrayList;
import java.util.Random;
/**
 * Esta clase representa a un liga de futbol
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Liga
{
    //almacena un conjunto de equipos que forman la liga
    private ArrayList<Equipo> equipos;
    //indica la jornada actual en la que se encuentra la liga
    private int jornadaActual;
    //cte que indica el numero maximo de equipos que puede tener la liga
    private static final int NUM_MAX_EQUIPOS = 20;
    /**
     * Constructor for objects of class Liga
     */
    public Liga(int numEquipos)
    {
       equipos = new ArrayList<>();
       //se controla que el numero de equipos pasado por parametro no exceda el numero maximo permitido
       if(numEquipos > NUM_MAX_EQUIPOS)
       {
           numEquipos = NUM_MAX_EQUIPOS;
       }
       //se añade los equipos al array
       for(int i = 0; i < numEquipos;i++)
       {
           equipos.add(new Equipo(asignarNombre(i),15));
       }
       jornadaActual = 1;
    }

    /**
     * Metodo que devuelve  un nombre de un equipo a partir de una coleccion de nombres
     * @return el nombre de un equipo
     */
    public String asignarNombre(int indice)
    {
        String[]nombreEquipos = {"Real Madrid","FC Barcelona","Atletico de Madrid","Valencia","Sevilla","Villareal","Celta","Athletic de Bilbao" 
        ,"Cordoba","Cultural Leonesa","Espanyol","Rayo Vallecano","Real Sociedad","Malaga","Elche","Betis","Getafe","Almeria","Granada","Deportivo"};
        
        String nombre = nombreEquipos[indice];
        
        return nombre;
    }
    
    /**
     * Metodo que calcula el numero maximo de jornadas que se puede jugar en la liga
     * @return el numero maximo de jornadas que se puede jugar
     */
    public int numeroMaxJornadas()
    {
        return equipos.size() - 1;
    }
    
   }
