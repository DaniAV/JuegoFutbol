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

        //se hace un ordenamiento en burbuja
        for(int i = 0; i < copia.size();i++)
        {
            for(int j = 1; j < copia.size() - i ;j++)
            {
                //el primer criterio de ordenacion son los puntos obtenidos
                if(copia.get(j).getPuntos() > copia.get(j - 1).getPuntos())
                {
                    Equipo aux = copia.get(j);
                    copia.set(j,copia.get(j - 1));
                    copia.set(j - 1,aux);

                }
                //si los puntos son iguales se comprueba el numero de partidos ganados
                else if(copia.get(j).getPuntos() == copia.get(j - 1).getPuntos())
                {
                    if(copia.get(j).getPartidosGanados() > copia.get(j - 1).getPartidosGanados())
                    {
                        Equipo aux = copia.get(j);
                        copia.set(j,copia.get(j - 1));
                        copia.set(j - 1,aux);
                    }
                    //si el numero de partidos ganados es igual,se mira el numero de partidos perdidos
                    else if(copia.get(j).getPartidosGanados() == copia.get(j - 1).getPartidosGanados())
                    {
                        if(copia.get(j).getPartidosPerdidos() < copia.get(j - 1).getPartidosPerdidos())
                        {
                            Equipo aux = copia.get(j);
                            copia.set(j,copia.get(j - 1));
                            copia.set(j - 1,aux);
                        }
                    }
                }
            }
        }

        //se muestra la clasificacion ya ordenada
        int num = 1;
        for(Equipo equipo : copia)
        {

            System.out.println(num + "." + " " + equipo);
            num++;
        }

    }

    /**
     * Metodo que simula que se juegan un numero de jornadas determinado por el valor pasado por parametro
     * @rama num es el numero de jornadas a jugar
     */
    public void simularJornadas(int num)
    {
        //se mira el numero de equipos que tiene la liga
        int numEquipos = equipos.size();
        //el numero maximo de jornadas que se puede jugar
        int maxJornadas = (numEquipos - 1)*2;
        if(num > maxJornadas)
        {
            num = maxJornadas;
        }
        int maxPartidosJornada = numEquipos/2;

        //se hacen los emparejamientos de la primera jornada
        System.out.println("Jornada " + jornadaActual);
        int indiceJornadaImpar = numEquipos - 1;
        int aux = indiceJornadaImpar;
        for(int j = 0; j < maxPartidosJornada ; j++)
        {
            Partido partido = new Partido(equipos.get(j),equipos.get(aux));
            partido.simularPartido();
            aux--;
        }
        indiceJornadaImpar--;
        jornadaActual++;

        for(int i = 0; i < num - 1; i++)
        {
            System.out.println("Jornada " + jornadaActual);
            //si la jornada es par
            if(i%2 == 0)
            {
                //variable que indica donde comienza el bucle

                int indiceJornadaPar = 1;
                //se usa una variable auxiliar
                int cont = indiceJornadaPar;
                for(int a = numEquipos - 1; a >= maxPartidosJornada; a--)
                {
                    Partido partido2 = new Partido(equipos.get(a),equipos.get(cont));
                    partido2.simularPartido();
                    cont++;

                    if(cont == maxPartidosJornada)
                    {
                        cont = 0;
                    }
                }
                indiceJornadaPar++;
                jornadaActual++;
            }
            else
            {
                int aux2 = indiceJornadaImpar;
                for(int b = 0; b < maxPartidosJornada; b++)
                {
                    Partido partido = new Partido(equipos.get(b),equipos.get(aux2));
                    partido.simularPartido();
                    aux2--;

                    if(aux2 == maxPartidosJornada)
                    {
                        aux2 = numEquipos - 1;
                    }
                }
                indiceJornadaImpar--;
                jornadaActual++;
            }

        }

    } 


   
}
