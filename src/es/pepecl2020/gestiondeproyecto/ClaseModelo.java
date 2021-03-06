package es.pepecl2020.gestiondeproyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClaseModelo
{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/Gestion_de_Proyecto_fi?serverTimezone=UTC";
	String sentencia = "";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	String login="";
	String password = "";
	
	//String login = objContro.root;
	//String password = objContro.contrase;

	public ClaseModelo ()
	{

	}
	

	public void Consulta (String login, String password)
	{

		System.out.println(login);
		try
		{
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexi?n con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);
			//Crear una sentencia
			statement = connection.createStatement();
			//Crear un objeto ResultSet para guardar lo obtenido
			//y ejecutar la sentencia SQL
			sentencia="SELECT * FROM clientes";
			rs = statement.executeQuery(sentencia);
			while (rs.next())
			{
				System.out.println();
				System.out.println(rs.getInt("idClientes") + "-" + rs.getString("nombreCliente")+"-"+ rs.getString("apellidoCliente")+"-"+ rs.getString("dniCliente")+"-"+rs.getString("telefono")+"-"+rs.getString("correoElectronico"));
			}
			sentencia="SELECT * FROM proyectos";
			rs = statement.executeQuery(sentencia);
			while (rs.next())
			{
				System.out.println();
				System.out.println(rs.getInt("idProyectos") + "-" + rs.getString("nombreProyecto")+"-"+ rs.getString("contenidoProyecto")+"-"+rs.getString("idClientesFK8"));
			}

		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1-"+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error 2-"+sqle.getMessage());
		}

	}
	public void AltaCliente (String login, String password, String nombreCliente, String apellidoCliente, String dniCliente, String telefono, String correoElectronico)
	{
		try
		{
			System.out.println("Carga algo");
			//Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			//Establecer la conexi?n con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);
			//Crear una sentencia
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			//Crear un objeto ResultSet para guardar lo obtenido
			//y ejecutar la sentencia SQL
			System.out.println(telefono);
			if(((nombreCliente.length())!=0)&&((apellidoCliente.length())!=0)&&((dniCliente.length()!=0))&&((telefono.length()!=0))&&((correoElectronico.length()!=0)))
			{
				sentencia = "INSERT INTO clientes VALUES (null, '"
						+ nombreCliente + "', '" + apellidoCliente + "','" + dniCliente + "','" + telefono + "', '" + correoElectronico + "')";
				statement.executeUpdate(sentencia);
				
				System.out.println(nombreCliente);
				System.out.println("Articulo dado de Alta OK");
				
			}
			else
			{
				System.out.println("Faltan datos");
			}
		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Error 1-"+cnfe.getMessage());
		}
		catch (SQLException sqle)
		{
			System.out.println("Error en ALTA");
		}
		finally
		{
			System.out.println("Fin");
		}
	}
}

