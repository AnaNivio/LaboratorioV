import classes.City;
import classes.Event;
import classes.Location;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List <City> cities= new ArrayList<>();
        List <Location> locations= new ArrayList<>();
        List <Event> events= new ArrayList<>();

        /*cities=Arrays.asList(new City(8,"Miramar"),new City(19,"Mar Del Plata"),new City(5,"Santa Clara"));
        locations=Arrays.asList(new Location(8,"Location a",8),new Location(3,"Location b",19),new Location(10,"Location c",5));
        */

        events= Arrays.asList(new Event(10,"Lollapalooza",new Location(8,"Location a",new City(8,"Miramar"))),
                new Event(3, "Ted Talk:CyberProblems and how to resolve them",new Location(3,"Location b",new City(19,"Mar Del Plata"))),
                new Event(9,"Feria de la cerveza nacional",new Location(10,"Location c",new City(5,"Santa Clara"))),
                new Event(20,"Cuentos infantiles",new Location(1,"Location d",new City(2,"City x"))),
                new Event(4,"Kingdom Hearts: Orchesta Concert",new Location(4,"Location e",new City(17,"City y"))),
                new Event(12,"Last but not least",new Location(6,"Location f",new City(3,"City q"))));


        //getEventById

        /*Event e= new Event();

        e=getEventById(12,events);
        System.out.println(e.toString());*/

        /*getPrimerosPorId:
        strem tiene una funcion llamada limit que muestra los cinco primer registros...
        * pero si quiero obtener por id, debo ordenarlos primero por medio de la funcion sorted*/

        /*
        List<Event> sortedList= events.stream().sorted(Comparator.comparing(Event::getIdEvent)).limit(5).collect(Collectors.toList());

        for(Event ev: sortedList){
            System.out.println(ev.toString());
        }
        */

        //getOrdenadosDeFormaAlfabetica:
        // en este, tuve que sobreescribir el metodo compareTo. Sorted permite que se incluya
        // los metodos necesarios para la comprabacion, entre ellos el compareTo. Calculo que no me dejo hacer lo mismo que
        // lo de arriba solo que ahora con el getName(Event::getIdEvent) porque se trata al String de forma distinta por ser un obejto,
        // por eso la necesidad de crear un metodo que compare cada nombre
        //CORRECCION: Me faltaba hacer Comparator.comparing() y ahi dentro del parentesis meter el Event::getName

       // List<Event> sortedList=events.stream().sorted(Comparator.comparing(Event::getName)).collect(Collectors.toList());
        //or
        //List<Event> sortedList=events.stream().sorted(Event::compareTo).collect(Collectors.toList());
        events.sort(Comparator.comparing(Event::getName));


        for(Event ev: events){
            System.out.println(ev.toString());
        }

        Map <> map= new 





    }

    public static Event getEventById(int id, List <Event> list)
    {
        Event found= new Event();

        if(list.isEmpty() == false){
            for(Event e : list){
                if(e.getIdEvent() == id){
                    found = e;
                }
            }
        }

        return found;
    }





}
