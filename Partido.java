
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
    //cte que indica los puntos que se suman cuando el equipo gana el partido
    public static final int PUNTOS_GANAR = 3;
    //cte que indica los puntos que se suman cuando se empate
    public static final int PUNTOS_EMPATE = 1;
   
    /**
     * Constructor for objects of class Partido
     */
    public Partido(Equipo equipoLocal, Equipo equipoVisitante)
    {
        // initialise instance variables
        this.local = equipoLocal;
        local.alineacionTitular();
        this.visitante = equipoVisitante;
        visitante.alineacionTitular();
    }

    public void mostrarAlineaciones(){
        local.mostrarAlineacion();
        visitante.mostrarAlineacion();
    }

    /**
     * Metodo que simula un partido entre dos equipos
     */
    public void simularPartido()
    {
        //se obtiene la valoracion media del equipo titular de ambos equipos
        float valoLocal = local.valoracionMediaEquipoTitular();
        float valoVisitante = visitante.valoracionMediaEquipoTitular();
        //para saber quien ha ganado se tiene en cuenta la valoracion media de los equipos
        //si el equipo local tiene una valoracion superior en mas de 1 punto que la del equipo visitante
        if(valoLocal > valoVisitante + 1)
        {
            
            System.out.println(local.getNombre() + victoriaLocal(valoLocal - valoVisitante) + visitante.getNombre());
            //se le suma los 3 puntos al ganador
            local.setPuntos(PUNTOS_GANAR);
            //se aumenta el numero de partidos ganados
            local.setPartidosGanados();
            //se aumenta el numero de partidos perdidos al perdedor
            visitante.setPartidosPerdidos();
        }
        else if(valoLocal +1 < valoVisitante)
        {
           System.out.println(local.getNombre() + victoriaVisitante(valoVisitante - valoLocal) + visitante.getNombre());
           visitante.setPuntos(PUNTOS_GANAR);
           //se aumenta el numero de partidos ganados
           visitante.setPartidosGanados();
           //se aumenta el numero de partidos perdidos al perdedor
           local.setPartidosPerdidos();
        }
        else
        {
            System.out.println(local.getNombre() + empate(valoVisitante - valoLocal) + visitante.getNombre());
            local.setPuntos(PUNTOS_EMPATE);
            visitante.setPuntos(PUNTOS_EMPATE);
            //se aumenta el numero de partidos empatados
            local.setPartidosEmpatados();
            visitante.setPartidosEmpatados();
        }
        //se aumenta el numero de partidos jugados
        local.setPartidosJugados();
        visitante.setPartidosJugados();
        //se deshacen las alineaciones al terminar el partido
        local.deshacerAlineacion();
        
        visitante.deshacerAlineacion();
    }

    /**
     * Metodo que devuelve un resultado de victoria del equipo local que dependera del valor pasado
     * por parametro
     * @param valoracion es la diferencia entre la valoracion del equipo local y el equipo visitante
     * @return un resultado de victoria del equipo local en forma de cadena
     */
    private String victoriaLocal(float valoracion)
    {
        String resultado = "";
        if(valoracion <= 0.5)
        {
            if(valoracion <= 0.2)
            {
                resultado =" 1 - 0 ";
            }
            else if(valoracion > 0.2 && valoracion <= 0.35)
            {
                resultado = " 2 - 1 ";
            }
            else
            {
                resultado = " 3 - 2 ";
            }
        }
        else if(valoracion > 0.5 && valoracion <= 1)
        {
            if(valoracion < 0.7)
            {
                resultado = " 2 - 0 ";
            }
            else if(valoracion >= 0.7 && valoracion <= 0.85)
            {
                resultado = " 3 - 1 ";
            }
            else
            {
                resultado = " 4 - 2 ";
            }
        }
        else
        {
            if(valoracion > 1 && valoracion <= 1.25)
            {
                resultado = " 3 - 0 ";
            }
            else if(valoracion > 1.25 && valoracion <= 1.75)
            {
                resultado = " 4 - 1 ";
            }
            else
            {
                resultado = " 5 - 0 ";
            }
        }
        return resultado;
    }
    
    /**
     * Metodo que devuelve un resultado de victoria del equipo visitante que dependera del valor pasado
     * por parametro
     * @param valoracion es la diferencia entre la valoracion del equipo visitante y el equipo local
     * @return un resultado de victoria del equipo visitante en forma de cadena
     */
    private String victoriaVisitante(float valoracion)
    {
        String resultado = "";
        if(valoracion <= 0.5)
        {
            if(valoracion <= 0.2)
            {
                resultado =" 0 - 1 ";
            }
            else if(valoracion > 0.2 && valoracion <= 0.35)
            {
                resultado = " 1 - 2 ";
            }
            else
            {
                resultado = " 2 - 3 ";
            }
        }
        else if(valoracion > 0.5 && valoracion <= 1)
        {
            if(valoracion < 0.7)
            {
                resultado = " 0 - 2 ";
            }
            else if(valoracion >= 0.7 && valoracion <= 0.85)
            {
                resultado = " 1 - 3 ";
            }
            else
            {
                resultado = " 2 - 4 ";
            }
        }
        else
        {
            if(valoracion > 1 && valoracion <= 1.25)
            {
                resultado = " 0 - 3 ";
            }
            else if(valoracion > 1.25 && valoracion <= 1.75)
            {
                resultado = " 1 - 4 ";
            }
            else
            {
                resultado = " 0 - 5 ";
            }
        }
        return resultado;
    }
    
    /**
     * Metodo que devuelve un resultado de empate que dependera del valor del parametro pasado
     * @param valoracion es la diferencia entre la valoracion del equipo local y la del equipo visitante
     * @return un resultado de empate en forma de cadena
     */
    private String empate(float valoracion)
    {
        String resultado = " ";
        //se obtiene el valor absoluto del parametro 
        float valorAbs = Math.abs(valoracion);
        if(valorAbs >= 0 && valorAbs < 0.33 )
        {
            resultado = " 0 - 0 ";
        }
        else if(valorAbs >= 0.33 && valorAbs < 0.66)
        {
            resultado = " 1 - 1 ";
        }
        else
        {
            resultado = " 2 - 2 ";
        }
        return resultado;
    }
}
