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
    /**
     * Constructor for objects of class Equipo
     */
    public Equipo(String nombre, int numeroDeJugadores)
    {
        jugadores = new ArrayList<>();
        Random rnd = new Random(); //Creamos un objeto rando para asignar valores aleatorios
        int dorsalPortero = 1;
        int dorsales = 2;
        this.nombre = nombre;
        this.numeroDeJugadoresReservas = numeroDeJugadores - NUMERODEJUGADORESTITULARES;
        
        jugadores.add(new Portero(0,0, dorsalPortero, 0,0)); //Creamos un portero con dorsal 1 y lo metemos en la lista de jugadores. 
        int dorsalCapitan = rnd.nextInt(numeroDeJugadores)+dorsales; //Creamos un numero de capitan aleatorio entre dos y el numero de jugadores que hay.
        jugadores.add(new Capitan(dorsalCapitan));//Creamos un capitan con dorsal aleatorio anterior, y lo metemos en la lista de jugadores.

        int index=0;
        while(index<numeroDeJugadores-2){ //Creamos el resto de jugadores y lo metemos en el array de jugadores.
            Jugador jugador = new JugadorCampo(dorsales);
            jugadores.add(jugador);
            if(jugador.getDorsal() == dorsalCapitan){
                jugador.setDorsal(23);
            }
            dorsales++;
            index++;
        }
    }

    public void alineacionTitular(){
        Random rnd = new Random(); //Creamos un objeto random para asignar valores aleatorios.
        ArrayList <Jugador>jugadoresTitulares  = new ArrayList<>();
        ArrayList <Jugador>jugadoresSuplentes = new ArrayList<>();

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

        //imprimimos el nombre del equipo
        System.out.println("\n\n");
        System.out.println(nombre.toUpperCase());
        //imprimimos titulares
        System.out.println("**TITULARES**");
        for(Jugador titular: jugadoresTitulares){
            System.out.println(titular.toString());
        }
        //Calculamos la media.
        float media = 0F;
        for(Jugador jugador: jugadoresTitulares){
            media += jugador.valoracion();
        }
        System.out.println("*********************  Media de valoración del equipo titular: " + media/jugadoresTitulares.size() + "*******************************\n");
        //imprimimos suplentes
        System.out.println("**SUPLENTES**");
        for(Jugador suplente: jugadoresSuplentes){
            System.out.println(suplente.toString());
        }
    }
    
   
}

