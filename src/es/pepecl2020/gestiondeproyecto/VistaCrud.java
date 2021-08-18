package es.pepecl2020.gestiondeproyecto;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class VistaCrud extends Frame
{
	private static final long serialVersionUID = 1L;
	
	Toolkit herramienta;
	Image btnClientes;
	Image btnProveedores;
	Image btnFacturas;
	
	public VistaCrud()
	{
		Color celeste = new Color(51,204,255);
		setLayout(new FlowLayout());
		setResizable(false);
		setSize(350,220);
		setBackground(celeste);
		setLocationRelativeTo(null);
		
		
		herramienta = getToolkit();
		btnClientes = herramienta.getImage("./Graficos/btnClientes.png");
		btnProveedores = herramienta.getImage("./Graficos/btnProve.png");
		btnFacturas = herramienta.getImage("./Graficos/btnFacturas.png");
		
	}
	public void paint (Graphics pin)
	{
		pin.drawImage(btnClientes, 150, 50, this);
		pin.drawImage(btnProveedores, 150,100, this);
		pin.drawImage(btnFacturas, 150, 150, this);
		
		Font fuente5 = new Font("Segoe Print", Font.BOLD, 18);
		pin.setFont(fuente5);
		pin.setColor(Color.blue);
		pin.drawString("Opciones a", 30, 115);
		pin.drawString("Manejar", 40, 135);
	}
	
}
