import java.util.ArrayList;
import java.util.Random;
import java.lang.System;
/**
 * Write a description of class Equipo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Equipo
{
    // instance variables - replace the example below with your own
    private String nombre;
    private ArrayList<Jugador> jugadores;
    public static final int NUMERODEJUGADORESTITULARES = 11;
    private int numeroDeJugadoresReservas;
    //almacena los 11 jugadores que forma el equipo titular
    private ArrayList <Jugador>jugadoresTitulares;
    //almacena los jugadores suplentes del equipo
    private ArrayList <Jugador>jugadoresSuplentes;
    //indica los puntos que ha obtenido el equipo
    private int puntos;
    //indica el numero de partidos ganados por el equipo
    private int partidosGanados;
    //indica el numero de partidos perdidos por el equipo
    private int partidosPerdidos;
    //indica el numero de partidos empatados por el equipo
    private int partidosEmpatados;
    /**
     * Constructor for objects of class Equipo
     */
    public Equipo(String nombre, int numeroDeJugadores)
    {
        jugadores = new ArrayList<>();
        jugadoresTitulares = new ArrayList<>();
        jugadoresSuplentes = new ArrayList<>();
        puntos = 0;
        partidosGanados = 0;
        partidosPerdidos = 0;
        partidosEmpatados = 0;
        Random rnd = new Random(); //Creamos un objeto rando para asignar valores aleatorios
        int dorsales = 1;

        this.nombre = nombre;
        this.numeroDeJugadoresReservas = numeroDeJugadores - NUMERODEJUGADORESTITULARES;

        jugadores.add(new Portero(dorsales)); //Creamos un portero con dorsal 1 y lo metemos en la lista de jugadores. 
        dorsales++;
        int dorsalCapitan = rnd.nextInt(numeroDeJugadores - 1)+2; //Creamos un numero de capitan aleatorio entre dos y el numero de jugadores que hay.

        int index=0;
        boolean hayUnCrack = false;
        while(index<numeroDeJugadores-1){ //Creamos el resto de jugadores y lo metemos en el array de jugadores.

            if(dorsalCapitan == dorsales)
            {
                //si coincide los dorsales se crea el capitan y se añade al array
                jugadores.add(new Capitan(dorsalCapitan));
            }
            else
            {
                //se crean los jugadores de campo y se añaden
                Jugador jugador = new JugadorCampo(dorsales);
                jugadores.add(jugador);

                //si no hay todavia nigun crack en el equipo
                if(!hayUnCrack)
                {
                    //se comprueba si ese jugador puede ser un crack
                    hayUnCrack = ((JugadorCampo)jugador).convertirACrack();

                }
            }
            dorsales++;
            index++;
        }
    }

    public void alineacionTitular(){
        Random rnd = new Random(); //Creamos un objeto random para asignar valores aleatorios.

        //introducimos en titulares al portero y al capitan automaticamente
        for(Jugador jugad: jugadores){
            if(jugad instanceof Portero || jugad instanceof Capitan){
                jugadoresTitulares.add(jugad);
            }
        }
        //Creamos e introducimos 9 jugadores mas en la lista de titulares
        int contador = 0;
        while(contador < 9){
            Jugador j = jugadores.get(rnd.nextInt(jugadores.size()));
            if(!jugadoresTitulares.contains(j)){
                jugadoresTitulares.add(j);
                contador++;
            }
        }
        //Seleccionamos los jugadores restantes y los introducimos en la lista de suplentes
        int contadorSuple = 0;
        while(contadorSuple < numeroDeJugadoresReservas){
            Jugador y = jugadores.get(rnd.nextInt(jugadores.size()));
            if(!jugadoresTitulares.contains(y)&&!jugadoresSuplentes.contains(y)){
                jugadoresSuplentes.add(y);
                contadorSuple++;
            }
        }

    }

    /**
     * 
     */
    public void mostrarAlineacion()
    {
        //imprimimos el nombre del equipo
        System.out.println("\n\n");
        System.out.println(nombre.toUpperCase());
        //imprimimos titulares
        System.out.println("**TITULARES**");
        for(Jugador titular: jugadoresTitulares){
            System.out.println(titular.toString());
        }

        System.out.printf("*********************  Media de valoración del equipo titular: %.2f *******************************\n",valoracionMediaEquipoTitular());
        //imprimimos suplentes
        System.out.println("**SUPLENTES**");
        for(Jugador suplente: jugadoresSuplentes){
            System.out.println(suplente.toString());
        }
    }

    /**
     * Metodo que permite al equipo entrenarse y aumentar su estado de forma entre un 10 y un 50%
     */
    public void entrenar()
    {
        //mediante un duro entrenamiento los jugadores pueden aumentar su estado de forma en un % del 10 al 50
        Random rnd = new Random();
        int entrenamiento = rnd.nextInt(5) + 1;
        //se recorre la coleccion de jugadores modificando su estado de forma
        for(Jugador jugador : jugadores)
        {
            jugador.setForma(jugador.getEstadoDeForma() + entrenamiento);
        }
    }

    /**
     * Metodo que calcula la valoracion media del equipo titular
     * @return la valoracion media del equipo titular
     */
    public float valoracionMediaEquipoTitular()
    {
        float valoracionMedia = 0;
        for(Jugador jugador : jugadoresTitulares)
        {
            valoracionMedia += jugador.valoracion();
        }
        return valoracionMedia/NUMERODEJUGADORESTITULARES;
    }

    /**
     * Metodo que devuelve el nombre del equipo
     * @return el nombre del equipo en forma de cadena
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * Metodo que devuelve los puntos que tiene el equipo
     * @return los puntos que tiene el equipo
     */
    public int getPuntos()
    {
        return puntos;
    }

    /**
     * Metodo que modifica los puntos que tiene el equipo
     * @param nuevosPuntos son los puntos que se añaden
     */
    public void setPuntos(int nuevosPuntos)
    {
        if(nuevosPuntos > 0)
        {
            puntos += nuevosPuntos;
        }
    }

    /**
     * Metodo que elimina los jugadores almacenados en el array de jugadoresTitulares y jugadoresSuplentes
     */
    public void deshacerAlineacion()
    {
        int numJugadoresTitulares = jugadoresTitulares.size();
        for(int i = 0; i < numJugadoresTitulares; i++)
        {
            jugadoresTitulares.remove(0);
        }
        int numJugadoresSuplentes = jugadoresSuplentes.size();
        for(int i = 0; i < numJugadoresSuplentes ; i++)
        {
            jugadoresSuplentes.remove(0);
        }
    }

    /**
     * Metodo que devuelve el numero de partidos ganados
     * @return el numero de partidos ganados
     */
    public int getPartidosGanados()
    {
        return partidosGanados;
    }

    /**
     * Metodo que devuelve el numero de partidos perdidos
     * @return el numero de partidos perdidos
     */
    public int getPartidosPerdidos()
    {
        return partidosPerdidos;
    }

    /**
     * Metodo que devuelve el numero de partidos empatados
     * @return el numero de partidos empatados
     */
    public int getPartidosEmpatados()
    {
        return partidosEmpatados;
    }

    /**
     * metodo que modifica el numero de partidos ganados
     * 
     */
    public void setPartidosGanados()
    {
        partidosGanados++;
    }

    /**
     * metodo que modifica el numero de partidos perdidos
     * 
     */
    public void setPartidosPerdidos()
    {
        partidosPerdidos++;
    }

    /**
     * metodo que modifica el numero de partidos empatados
     * 
     */
    public void setPartidosEmpatados()
    {
        partidosEmpatados++;
    }

    /**
     * Metodo que muestra datos del equipo
     */
    public String toString()
    {
        return String.format("%-18s PG : %2d PP : %2d PE : %2d Puntos : %3d",nombre,partidosGanados,partidosPerdidos,partidosEmpatados,puntos);
    }
}
