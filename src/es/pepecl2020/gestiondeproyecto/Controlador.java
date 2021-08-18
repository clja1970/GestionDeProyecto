package es.pepecl2020.gestiondeproyecto;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements WindowListener,MouseListener
{
	VistaAcceso objVistaAcceso = null;
	VistaCrud objVistaCrud = null;
	VistaCrudClientes objVistaCrudClientes = null;
	VistaAltasClientes objVistaAltaClientes = null;

	String root = "";
	String contrase = "";

	ClaseModelo objModelo = null;


	int i=0;

	public Controlador (VistaAcceso objVistaAcceso, ClaseModelo objModelo)
	{
		this.objVistaAcceso = objVistaAcceso;
		this.objModelo = objModelo;

		objVistaAcceso.addWindowListener(this);
		objVistaAcceso.addMouseListener(this);
		objVistaAcceso.setVisible(true);

		objVistaAcceso.dlgUno.addWindowListener(this);

	}


	@Override
	public void mouseClicked(MouseEvent evento)
	{
		int x = evento.getX();
		int y = evento.getY();

		System.out.println("Coordenada x: " + x);
		System.out.println("Coordenada y: " + y);
		if (this.objVistaAcceso.isActive())
		{
			if ((x>=90)&&(x<=215)&&(y>=120)&&(y<=160))
			{
				System.out.println("Acceder");

				i=i+1;
				System.out.println(i);
				if ((objVistaAcceso.txtUsuario.getText().equals("root"))&&(objVistaAcceso.txtContra.getText().equals("Studium2020;")))
				{
					root = objVistaAcceso.txtUsuario.getText();
					contrase = objVistaAcceso.txtContra.getText();

					System.out.println("Bien logueao");
					//Aquí quiero hacer la conexión a la BD y darle el root y password desde aquí
					objVistaCrud = new VistaCrud ();

					objVistaCrud.addWindowListener(this);
					objVistaCrud.addMouseListener(this);

					objVistaCrud.setVisible(true);

					objVistaAcceso.setVisible(false);

				}
				else 
				{
					System.out.println("Fallo de Log");

					if(i==1)
					{
						System.out.println("Primer fallo");
						objVistaAcceso.dlgUno.setVisible(true);
						objVistaAcceso.lblError.setText("Te quedan otro intento");
					}
					else if(i==2)
					{
						System.out.println("Otro fallo");
						objVistaAcceso.dlgUno.setVisible(true);
						objVistaAcceso.lblError.setText("Tres fallos, bloqueado");
					}
					else if(i==3)
					{
						System.out.println("fuera"+i);
						System.out.println(objVistaAcceso.txtContra.getText());
						objVistaAcceso.dlgUno.setVisible(true);
						objVistaAcceso.lblError.setText("Estas fuera");
						objVistaAcceso.setVisible(false);
					}
				}

			}

		}
		else if (this.objVistaCrud.isActive())
		{
			if ((x>=150)&&(x<=275)&&(y>=50)&&(y<=90))
			{

				objVistaCrudClientes = new VistaCrudClientes();

				objVistaCrudClientes.addWindowListener(this);
				objVistaCrudClientes.addMouseListener(this);

				objVistaCrudClientes.setVisible(true);

				objVistaCrud.setVisible(false);

				System.out.println("Clientes");

				//objVistaCrud.setVisible(false);
			}
		}
		else if (this.objVistaCrudClientes.isActive())
		{
			if ((x>=150)&&(x<=290)&&(y>=100)&&(y<=140))//140*40
			{
				System.out.println("Altas");
				objVistaAltaClientes = new VistaAltasClientes ();
				objVistaAltaClientes.addWindowListener(this);
				objVistaAltaClientes.addMouseListener(this);
				objVistaAltaClientes.setVisible(true);

				objVistaCrudClientes.setVisible(false);
			}
			else if ((x>=150)&&(x<=290)&&(y>=220)&&(y<=260))//140*40
			{
				System.out.println("Consulta");
				System.out.println(contrase);
				//objModelo.Conectar(root, contrase);
				objModelo.Consulta(root, contrase);



			}

		}
		else if(this.objVistaAltaClientes.isActive())
		{
			if ((x>=90)&&(x<=140)&&(y>=260)&&(y<=310))
			{

				System.out.println("Ok");
				System.out.println(objVistaAltaClientes.txtNombreCliente.getText());
				objModelo.AltaCliente(root, contrase, objVistaAltaClientes.txtNombreCliente.getText(), objVistaAltaClientes.txtApellidosCliente.getText(), objVistaAltaClientes.txtDni.getText(), objVistaAltaClientes.txtTelefono.getText(),objVistaAltaClientes.txtEmail.getText());
			}

		}

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		if (objVistaAcceso.isActive()) 
		{
			objVistaAcceso.txtUsuario.setText("root");
			objVistaAcceso.txtContra.setText("Studium2020;");
		}

	}


	@Override
	public void windowOpened(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		if (objVistaAcceso.isActive())
		{
			objVistaAcceso.setVisible(false);
		}
		else if (objVistaAcceso.dlgUno.isActive())
		{
			objVistaAcceso.setVisible(true);
			objVistaAcceso.dlgUno.setVisible(false);
		}
		else if (objVistaCrud.isActive())
		{
			objVistaCrud.setVisible(false);
			//objVistaAcceso.setVisible(true);
		}
		else if (objVistaCrudClientes.isActive())
		{
			objVistaCrudClientes.setVisible(false);
			objVistaCrud.setVisible(true);
		}
		else if (objVistaAltaClientes.isActive())
		{
			objVistaAltaClientes.setVisible(false);
			objVistaCrudClientes.setVisible(true);
		}

	}

	@Override
	public void windowClosed(WindowEvent e)
	{

	}

	@Override
	public void windowIconified(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

}
