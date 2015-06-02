
/**
 * Write a description of class Test2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test2
{
    public void Test1() 
    {
        Liga miLiga = new Liga(10);
        miLiga.simularJornadas(9); //simula toda la liga mostrando por pantalla el desarrollo de cada jornada
        miLiga.mostrarClasificaciones();
    }
    
    public void Test2()
    {
        Liga miLiga = new Liga(10);
        miLiga.simularJornadas2(9); //simula toda la liga mostrando por pantalla el desarrollo de cada jornada
        miLiga.mostrarClasificaciones();
    }
}