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

    /**
     * Metodo que muestra la clasificacion de la liga en funcion de los puntos que tengan los equipos
     */
    public void mostrarClasificaciones()
    {

        ArrayList<Equipo> copia = new ArrayList<>();
        copia =(ArrayList)equipos.clone();

        for(int i = 0; i < copia.size();i++)
        {
            for(int j = 1; j < copia.size() - 1;j++)
            {
                if(copia.get(j).getPuntos() > copia.get(j - 1).getPuntos())
                {
                    Equipo aux = copia.get(j);
                    copia.set(j,copia.get(j - 1));
                    copia.set(j - 1,copia.get(j));
                }
                //si los puntos son iguales se comprueba el numero de partidos ganados
                else if(copia.get(j).getPuntos() == copia.get(j - 1).getPuntos())
                {
                    if(copia.get(j).getPartidosGanados() > copia.get(j - 1).getPartidosGanados())
                    {
                        Equipo aux = copia.get(j);
                        copia.set(j,copia.get(j - 1));
                        copia.set(j - 1,copia.get(j));
                    }
                    //si el numero de partidos ganados es igual,se mira el numero de partidos perdidos
                    else if(copia.get(j).getPartidosGanados() == copia.get(j - 1).getPartidosGanados())
                    {
                        if(copia.get(j).getPartidosPerdidos() < copia.get(j - 1).getPartidosPerdidos())
                        {
                            Equipo aux = copia.get(j);
                            copia.set(j,copia.get(j - 1));
                            copia.set(j - 1,copia.get(j));
                        }
                    }
                }
            }
        }

        //se muestra la clasificacion ya ordenada
        int num = 1;
        for(Equipo equipo : equipos)
        {

            System.out.println(num + "." + " " + equipo);
            num++;
        }
    }
}
