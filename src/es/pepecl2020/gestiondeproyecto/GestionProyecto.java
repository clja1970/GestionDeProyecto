package es.pepecl2020.gestiondeproyecto;

public class GestionProyecto
{

	public static void main(String[] args)
	{
		VistaAcceso objVistaAcceso = new VistaAcceso ();
		ClaseModelo objModelo = new ClaseModelo();
		
		new Controlador (objVistaAcceso, objModelo);

	}

}
