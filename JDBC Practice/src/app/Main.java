/*
* RESUELTO ERROR MYSQL. ERA POR LA CONSOLA DE XAMPP Y QUE NO SE CONECTABA CON MYSQL.*/
package app;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        //incluyo el jdbc para poder trabajar con la base de datos
       try {
           Class.forName("com.mysql.jdbc.Driver");

       }catch (ClassNotFoundException e)
       {
           System.out.println("Falta la libreria de mysql!!");
       }

        //creo la coneccion, por medio de esta, podre ejecutar consultas
        try {
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/partido1710", "root", "");

            Statement st= connection.createStatement(); //para crear una consulta
            ResultSet rs=st.executeQuery("SELECT * FROM JUGADORES");//para traer datos de una tabla
            //obtengo los datos de todos los jugadores que carge...ahora debo mostrarlos

            while(rs.next()){
                int idJugadorRecibido=rs.getInt("id_jugador");
                String nombreRecibido=rs.getString("nombre_jugador");
                String apellidoRecibido=rs.getString("apellido_jugador");
                int idEquipoRecibido=rs.getInt("id_equipo");

                System.out.println(idJugadorRecibido+" "+nombreRecibido+" "+apellidoRecibido+" "+idEquipoRecibido);

            }



        }catch (SQLException e){

            System.out.println("No se pudo conectar a la base de datos");
        }
        catch (Exception e){
            System.out.println("es otra cosa");
        }

        //Statement stmt = con.createStatement();








    }
}
