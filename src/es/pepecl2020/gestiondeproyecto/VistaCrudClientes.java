package es.pepecl2020.gestiondeproyecto;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class VistaCrudClientes extends Frame
{
	private static final long serialVersionUID = 1L;

	Toolkit herramienta;
	Image btnAltas;
	Image btnBajas;
	Image btnConsultas;
	Image btnModi;

	public VistaCrudClientes ()
	{
		Color celeste = new Color(51,204,255);
		setLayout(new FlowLayout());
		setResizable(false);
		setSize(470,400);
		setBackground(celeste);
		setLocationRelativeTo(null);
		

		herramienta = getToolkit();
		
		btnAltas = herramienta.getImage("./Graficos/btnAltas.png");
		btnBajas = herramienta.getImage("./Graficos/btnBajas.png");
		btnConsultas = herramienta.getImage("./Graficos/btnConsultas.png");
		btnModi = herramienta.getImage("./Graficos/btnModi.png");

	}
	public void paint (Graphics pinturilla)
	{
		pinturilla.drawImage(btnAltas, 150, 100, this);
		pinturilla.drawImage(btnBajas, 300,160, this);
		pinturilla.drawImage(btnConsultas, 150, 220, this);
		pinturilla.drawImage(btnModi, 300, 280, this);
		
		Font fuente5 = new Font("Segoe Print", Font.BOLD, 20);
		pinturilla.setFont(fuente5);
		pinturilla.setColor(Color.blue);
		pinturilla.drawString("Menú de:", 40, 160);
		pinturilla.drawString("Clientes ", 50, 185);

	}
}
