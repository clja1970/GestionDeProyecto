package es.pepecl2020.gestiondeproyecto;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;

public class VistaAltasClientes extends Frame
{

	private static final long serialVersionUID = 1L;
	
	Label lblNombreCliente = new Label("Nombre: ");
	TextField txtNombreCliente = new TextField (20);
	Label lblApellidosCliente = new Label("Apellidos: ");
	TextField txtApellidosCliente = new TextField (25);
	Label lblDni = new Label ("D.N.I.: ");
	TextField txtDni = new TextField (10);
	Label lblTelefono = new Label ("Teléfono: ");
	TextField txtTelefono = new TextField (10);
	Label lblEmail = new Label ("email: ");
	TextField txtEmail = new TextField (20);
	
	Dialog dlgAltaCliente = new Dialog (this,"Confirmación", true);
	Label lblAltaconfirmacion = new Label ();
	
	Toolkit herramienta;
	Image btnOk;
	
	public VistaAltasClientes ()
	{
		add(lblNombreCliente);
		add(txtNombreCliente);
		add(lblApellidosCliente);
		add(txtApellidosCliente);
		add(lblDni);
		add(txtDni);
		add(lblTelefono);
		add(txtTelefono);
		add(lblEmail);
		add(txtEmail);
		dlgAltaCliente.add(lblAltaconfirmacion);
		
		herramienta = getToolkit();
		btnOk = herramienta.getImage("./Graficos/btnOk.png");
		
		
		Color celeste = new Color(51,204,255);
		setLayout(new FlowLayout());
		setResizable(false);
		setSize(230,330);
		setBackground(celeste);
		setLocationRelativeTo(null);
		
	}
	public void paint (Graphics ok)
	{
		ok.drawImage(btnOk, 90, 260, this);
	}
}
