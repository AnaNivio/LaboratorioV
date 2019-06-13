import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import clases.Persona;


public class Main {

    public static void main(String[] args) {
    /*
        //Punto 1:Mayores >21
        
        List<Persona> personas= new ArrayList<Persona>();

        personas = Arrays.asList( new Persona("Jaimito","Fernandez",123456789,18),
        new Persona("Susana","Juarez",234567891,31),
        new Persona("Manuel","Rivera",345678912,27),
        new Persona("Lucas","Luces",567891234,17)
        );

        System.out.println(String.format("Personas: %s",personas));//lee las direcciones de memoria de las variables

        System.out.println(String.format("Mayores a 21: %s",personas.stream()
                .filter(Persona->Persona.getEdad()>21)
                .collect(Collectors.toList())));
    */
    //Punto 2: Menores 18
    /*
        List<Persona> personas= new ArrayList<Persona>();

        personas = Arrays.asList( new Persona("Jaimito","Fernandez",123456789,18),
                new Persona("Susana","Juarez",234567891,31),
                new Persona("Manuel","Rivera",345678912,27),
                new Persona("Lucas","Luces",567891234,17)
        );

        System.out.println(String.format("Personas: %s",personas));

        System.out.println(String.format("Menores a 18: %s",personas.stream()
                .filter(Persona->Persona.getEdad()<18)
                .collect(Collectors.toList())));
    }
   */

        //Punto 3:Mayores 21+ Dni>20000000
        List<Persona> personas= new ArrayList<Persona>();

        personas = Arrays.asList( new Persona("Jaimito","Fernandez",123456789,18),
                new Persona("Susana","Juarez",234567891,31),
                new Persona("Manuel","Rivera",345678912,27),
                new Persona("Lucas","Luces",567891234,17)
        );

        System.out.println(String.format("Personas: %s",personas));

        System.out.println(String.format("Mayores a 21 + Dni > 20000000: %s",personas.stream()
                .filter(Persona->Persona.getEdad()>21)
                .filter(Persona->Persona.getDni()>20000000)
                .collect(Collectors.toList())));
    }
}
