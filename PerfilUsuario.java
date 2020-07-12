package aplicacion.cliente;

import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import java.lang.*;
import java.net.*;
import java.util.*;

class PerfilUsuario extends JFrame implements ActionListener{
//OBJETOS
JPanel panel;
JLabel nombre;
JLabel paciente;
JLabel h1;
JLabel proximaCita;
JLabel linea;
JLabel linea2;
JLabel cita;
JLabel itt;
JLabel lugarFav;
JLabel lugar;

Color azulOscuro= new Color(7,3,26);//Azul oscuro
Color amarillo= new Color(255,203,116);//AMARILLO
Color color3= new Color(79,138,139);// Azul claro
Color color4= new Color(244,246,255);// blanco azulado

JButton salir;

	public PerfilUsuario(String nombreUsuario)
	{
		panel = new JPanel();
		panel.setLayout(null);

		panel.setBackground(azulOscuro);

		nombre = new JLabel(nombreUsuario);
		nombre.setFont(new Font("Serif", Font.PLAIN, 18));
		nombre.setBounds(150,50,400,100);
		nombre.setOpaque(false);
		nombre.setForeground(Color.white);

    paciente = new JLabel("Paciente");
		paciente.setFont(new Font("Serif", Font.PLAIN, 18));
		paciente.setBounds(150,100,400,100);
		paciente.setOpaque(false);
		paciente.setForeground(amarillo);

    h1 = new JLabel(new ImageIcon(((new ImageIcon("./imagenes/ic.png")).getImage()).getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH)));
		h1.setBounds(30,75,100,100);
    h1.setBackground(amarillo);
		h1.setOpaque(true);

    itt = new JLabel(new ImageIcon(((new ImageIcon("./imagenes/logo carrera.png")).getImage()).getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH)));
		itt.setBounds(600,75,100,100);
		itt.setOpaque(false);

		proximaCita = new JLabel("Tu proxima cita");
		proximaCita.setFont(new Font("Serif", Font.PLAIN, 20));
		proximaCita.setBounds(50,250,400,22);
		proximaCita.setOpaque(false);
		proximaCita.setForeground(Color.white);

    cita = new JLabel("   -  El perro pinche Lunes");
    cita.setFont(new Font("Serif", Font.PLAIN, 20));
    cita.setBounds(50,325,400,22);
    cita.setOpaque(false);
    cita.setForeground(Color.white);

		linea = new JLabel();
		linea.setBounds(45,275,500,5);
		linea.setOpaque(true);
		linea.setBackground(amarillo);

		linea2 = new JLabel();
		linea2.setBounds(45,475,500,5);
		linea2.setOpaque(true);
		linea.setBackground(amarillo);

		lugarFav = new JLabel("Notas");
		lugarFav.setFont(new Font("Serif", Font.PLAIN, 20));
		lugarFav.setBounds(50,450,400,22);
		lugarFav.setOpaque(false);
		lugarFav.setForeground(Color.white);


		salir = new JButton("Salir");
		salir.setFont(new Font("Serif", Font.PLAIN, 11));
		salir.setBounds(600,600,100,40);
		salir.setOpaque(false);
		salir.setForeground(Color.BLACK);

		panel.add(nombre);
		panel.add(paciente);
		panel.add(h1);
		panel.add(proximaCita);
	  panel.add(cita);
		panel.add(linea);
		panel.add(linea2);
		panel.add(itt);
		panel.add(lugarFav);
		panel.add(salir);

		salir.addActionListener(this);

		this.add(panel);

		SwingUtilities.updateComponentTreeUI(this);
		this.pack();
		this.setTitle("Centro De Control");
		this.setBounds(700,400,760,760);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(null);

	}

public void actionPerformed(ActionEvent event){

			if(event.getSource() == this.salir){
					System.exit(0);
			}
}

}
