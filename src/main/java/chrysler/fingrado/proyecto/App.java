package chrysler.fingrado.proyecto;

import chrysler.fingrado.proyecto.importante.Modelo;

public class App 
{
    public static void main( String[] args )
    {
       Vista vista = new Vista();
       Modelo modelo= new Modelo();
       Controlador controller = new Controlador(vista,modelo);
    }
}
