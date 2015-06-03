import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
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
        System.out.println("Clasificacion : ");
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

            System.out.println(String.format("%2d",num)  + "." + " " + equipo);
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
        int maxJornadas = (numEquipos - 1);
        if(num > maxJornadas)
        {
            num = maxJornadas;
        }
        //se determina el numero maximo de partidos por jornada
        int maxPartidosJornada = numEquipos/2;
        //se repite el bucle tantas veces como jornadas haya
        for(int i = 0; i < num ; i++)
        {

            System.out.println("Jornada " + jornadaActual);

            Random rnd = new Random();
            //se hace una copia del array para no modificarlo
            ArrayList<Equipo> copia = new ArrayList<>();
            copia =(ArrayList)equipos.clone();
            //se repite el bucle tantas veces como partidos haya por jornada
            for(int j = 0; j < maxPartidosJornada ; j++)
            {
                //se obtiene el equipo local de forma aleatoria
                int loc = rnd.nextInt(copia.size());
                Equipo local = copia.get(loc);
                //se elimina este equipo del array para que no aparezca mas esta jornada
                copia.remove(local);
                //se hace lo mismo con el equipo visitante
                int visi = rnd.nextInt(copia.size());
                Equipo visitante = copia.get(visi);
                copia.remove(visi);
                //se crea el partido y se simula
                Partido partido = new Partido(local,visitante);
                partido.simularPartido();

            }
            //al acabar la jornada se aumenta el contador
            jornadaActual++;
            //al terminar la jornada todos los equipos entrenan
            entrenanEquipos();
        }

    } 

    /**
     * Metodo por el cual todos equipos entrenan
     */
    private void entrenanEquipos()
    {
        for(Equipo equipo : equipos)
        {
            equipo.entrenamiento();
        }

    }

    /**
     * Metodo que simula que se disputan una serie de jornadas de liga determinadas por el parametro
     * @param num es el numero de jornadas a jugar
     */
    public void simularJornadas2(int num)
    {
        //se mira el numero de equipos que tiene la liga
        int numEquipos = equipos.size();
        
        //el numero maximo de jornadas que se puede jugar
        int maxJornadas = (numEquipos - 1);
        if(num > maxJornadas)
        {
            num = maxJornadas;
        }
        //se determina el numero maximo de partidos por jornada
        int maxPartidosJornada = numEquipos/2;
        //se hace una copia del array para no modificarlo
        ArrayList<Equipo> copia = new ArrayList<>();
        copia =(ArrayList)equipos.clone();
             
        Collections.shuffle(copia);
        for(int i = 1; i < num + 1; i++)
        {
            //se comprueba si la jornada es par o impar
            if(i%2 != 0)
            {
                System.out.println("Jornada " + (i));
                int a = 0;
                int b = copia.size() - 1;
                for(int k = 0; k < maxPartidosJornada; k++)
                {
                    Equipo local = copia.get(a);
                    Equipo visitante = copia.get(b);
                    Partido partido = new Partido(local,visitante);
                    partido.simularPartido();
                    a++;
                    b--;
                }
                //se reordena el arrayList para hacer que se mueva la lista una posicion,excepto la posicion 0
                //que se mantiene siempre igual
                Equipo equipo = copia.get(1);
                copia.remove(1);
                //se añade el equipo que estaba en la posicion 1 al ultimo lugar
                copia.add(equipo);

                //al terminar la jornada todos los equipos entrenan
                entrenanEquipos();
            }
            else
            {
                //si la jornada es par,se alterna los partidos de local y visitante
                System.out.println("Jornada " + (i));
                int a = 0;
                int b = copia.size() - 1;
                for(int k = 0; k < maxPartidosJornada; k++)
                {
                    Equipo local = copia.get(b);
                    Equipo visitante = copia.get(a);
                    Partido partido = new Partido(local,visitante);
                    partido.simularPartido();
                    a++;
                    b--;
                }
                //se reordena el arrayList
                Equipo equipo = copia.get(1);
                copia.remove(1);
                copia.add(equipo);

                //al terminar la jornada todos los equipos entrenan
                entrenanEquipos();
            }
        }
    }
}
