package es.pepecl2020.gestiondeproyecto;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;

public class VistaAcceso extends Frame
{
	private static final long serialVersionUID = 1L;


	Label lblLinea1 = new Label ("");
	TextField txtUsuario = new TextField (10);
	Label lblLinea2 = new Label ("");
	TextField txtContra = new TextField (10);
	

	Dialog dlgUno = new Dialog (this,"Error",true);
	Label lblError = new Label (" Error, dos intentos más");

	Toolkit herramienta;
	Image btnAcceder;


	public VistaAcceso ()
	{
		setTitle("Acceso");
		add(lblLinea1);
		add(txtUsuario);
		add(lblLinea2);
		add(txtContra);
		txtContra.setEchoChar('*');
		dlgUno.add(lblError);

		Color celeste = new Color(51,204,255);
		setLayout(new FlowLayout());
		setResizable(false);
		setSize(300,200);
		setBackground(celeste);
		setLocationRelativeTo(null);
		

		herramienta = getToolkit();
		btnAcceder = herramienta.getImage("./Graficos/btnacceder.png");

		
		Color rojoSuave = new Color (255, 102, 102);
		dlgUno.setBackground(rojoSuave);
		dlgUno.setLayout(new FlowLayout());
		dlgUno.setSize(200, 125);	
		dlgUno.setResizable(false);
		dlgUno.setLocationRelativeTo(null);


	}
	public void paint (Graphics dib)
	{
		Font fuente5 = new Font("Segoe Print", Font.BOLD, 18);
		dib.setFont(fuente5);
		dib.setColor(Color.blue);
		dib.drawString("Usuario", 55, 90);
		dib.drawString("Contraseña", 170, 90);
		dib.drawImage(btnAcceder,90,120, this);//medidas del botón 125*40
	}
}
