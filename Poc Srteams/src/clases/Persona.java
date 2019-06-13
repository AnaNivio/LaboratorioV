package clases;

public class Persona {


    private String nombre;
    private String apellido;
    private int dni;
    private int edad;

    public Persona(String nombreRecibido, String apellidoRecibido, int dniRecibido, int edadRecibida){

        nombre=nombreRecibido;
        apellido=apellidoRecibido;
        dni=dniRecibido;
        edad=edadRecibida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {

        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


}
