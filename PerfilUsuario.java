package aplicacion.cliente;

import aplicacion.utilerias.Archivo;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import java.lang.*;
import java.net.*;
import java.util.*;
import javax.sound.sampled.*;

class PerfilUsuario extends JFrame implements ActionListener{
	//OBJETOS
	public JPanel panel;
	public JLabel nombre;
	public JLabel paciente;
	public JLabel h1;
	public JLabel proximaCita;
	public JLabel linea;
	public JLabel linea2;
	public JLabel cita;
	public JLabel itt;
	public JLabel lugarFav;
	public JLabel lugar;
	public ArrayList<String> fechaCitas= new ArrayList<>();

	public Color azulOscuro= new Color(7,3,26);//Azul oscuro
	public Color amarillo= new Color(255,203,116);//AMARILLO
	public Color color3= new Color(79,138,139);// Azul claro
	public Color color4= new Color(244,246,255);// blanco azulado

	public JButton salir;

	public JButton doctores;

	public String nombreMio;
	public int numUsers;

	Clip pepe;

	public PerfilUsuario(String nombreUsuario, int numUser)
	{

		try {
			AudioInputStream pl = AudioSystem.getAudioInputStream(new File("chas.WAV").getAbsoluteFile());
			pepe = AudioSystem.getClip();
			pepe.open(pl);
		} catch(Exception ex) {
				System.out.println("Error with playing sound.");
				ex.printStackTrace();
		}

		panel = new JPanel();
		panel.setLayout(null);

    this.nombreMio = nombreUsuario;
    this.numUsers = numUsers;
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

    String ruta = "./CitaClientes/"+nombreUsuario+".txt";
    fechaCitas = Archivo.leerTodo(ruta);
    if(fechaCitas != null){
      String info = fechaCitas.get(numUsers);
      cita = new JLabel(info);
      cita.setFont(new Font("Serif", Font.PLAIN, 20));
      cita.setBounds(50,325,400,22);
      cita.setOpaque(false);
      cita.setForeground(Color.white);
    }else{
      cita = new JLabel("No tiene citas de momento");
      cita.setFont(new Font("Serif", Font.PLAIN, 20));
      cita.setBounds(50,325,400,22);
      cita.setOpaque(false);
      cita.setForeground(Color.white);
    }
		linea = new JLabel();
		linea.setBounds(45,275,600,5);
		linea.setOpaque(true);
		linea.setBackground(amarillo);

		linea2 = new JLabel();
		linea2.setBounds(45,475,600,5);
		linea2.setOpaque(true);
		linea.setBackground(amarillo);

		lugarFav = new JLabel("Menu de Doctores");
		lugarFav.setFont(new Font("Serif", Font.PLAIN, 20));
		lugarFav.setBounds(50,450,400,22);
		lugarFav.setOpaque(false);
		lugarFav.setForeground(Color.white);

		salir = new JButton("Salir");
		salir.setFont(new Font("Serif", Font.PLAIN, 11));
		salir.setBounds(600,600,100,40);
		salir.setOpaque(false);
		salir.setForeground(Color.BLACK);

    doctores = new JButton("Abrir Doctores");
    doctores.setFont(new Font("Serif", Font.PLAIN, 11));
    doctores.setBounds(100,500,200,40);
    doctores.setOpaque(true);
    doctores.setBackground(color3);
    doctores.setForeground(Color.BLACK);

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
    panel.add(doctores);

		salir.addActionListener(this);
    doctores.addActionListener(this);

		this.add(panel);

		SwingUtilities.updateComponentTreeUI(this);
		this.pack();
		this.setTitle("Centro De Control");
		this.setBounds(500,0,760,760);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(null);

	}
	public void actionPerformed(ActionEvent event){

				if(event.getSource() == this.salir){
					System.exit(0);
				}
	      else if(event.getSource() == this.doctores)
	      {
					pepe.start();
	        Doctores doc = new Doctores(nombreMio,numUsers);
	        this.dispose();
	      }
	}

}
