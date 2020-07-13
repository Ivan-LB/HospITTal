package aplicacion.servidor;

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
import javax.swing.filechooser.FileNameExtensionFilter;

class ControlDoctores extends JFrame implements ActionListener{

	public JPanel panel;
	public JLabel nombre;
	public JLabel paciente;
	public JLabel h1;
	public JLabel proximaCita;
	public JLabel linea;
	public JLabel linea2;
	public JLabel itt;
	public JLabel lugarFav;
	public JTextArea lugar;

	public Color azulOscuro= new Color(7,3,26);//Azul oscuro
	public Color amarillo= new Color(255,203,116);//AMARILLO
	public Color color3= new Color(79,138,139);// Azul claro
	public Color color4= new Color(244,246,255);// blanco azulado

	public JButton salir;

	public JButton doctores;

	public ControlDoctores()
	{
		panel = new JPanel();
		panel.setLayout(null);

		panel.setBackground(azulOscuro);

		nombre = new JLabel("Centro de Control de Usuarios");
		nombre.setFont(new Font("Serif", Font.PLAIN, 18));
		nombre.setBounds(150,50,400,100);
		nombre.setOpaque(false);
		nombre.setForeground(Color.white);

    paciente = new JLabel("Servidor");
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

		proximaCita = new JLabel("Pacientes Actuales");
		proximaCita.setFont(new Font("Serif", Font.PLAIN, 20));
		proximaCita.setBounds(50,250,400,22);
		proximaCita.setOpaque(false);
		proximaCita.setForeground(Color.white);

    lugar = new JTextArea();
    lugar.setFont(new Font("Serif", Font.PLAIN, 15));
    lugar.setBounds(50,500,400,200);
    lugar.setOpaque(false);
		lugar.setLineWrap(true);
    lugar.setForeground(Color.white);

		linea = new JLabel();
		linea.setBounds(45,275,600,5);
		linea.setOpaque(true);
		linea.setBackground(amarillo);

		linea2 = new JLabel();
		linea2.setBounds(45,475,600,5);
		linea2.setOpaque(true);
		linea.setBackground(amarillo);

		lugarFav = new JLabel("Datos del Paciente: ");
		lugarFav.setFont(new Font("Serif", Font.PLAIN, 20));
		lugarFav.setBounds(50,450,400,22);
		lugarFav.setOpaque(false);
		lugarFav.setForeground(Color.white);

		salir = new JButton("Salir");
		salir.setFont(new Font("Serif", Font.PLAIN, 11));
		salir.setBounds(600,600,100,40);
		salir.setOpaque(false);
		salir.setForeground(Color.BLACK);

    doctores = new JButton("Abrir Expedientes");
    doctores.setFont(new Font("Serif", Font.PLAIN, 11));
    doctores.setBounds(150,325,200,40);
    doctores.setOpaque(true);
    doctores.setBackground(color3);
    doctores.setForeground(Color.BLACK);

		panel.add(nombre);
		panel.add(paciente);
		panel.add(h1);
		panel.add(proximaCita);
	  panel.add(lugar);
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
					//this.dispose();
				}
	      else if(event.getSource() == this.doctores){
					lugar.setText("");
					try {
						String nombre_archivo_guardar = "";
						JFileChooser fc = new JFileChooser();
						FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Texto","txt");
						fc.setFileFilter(filter);
						fc.setCurrentDirectory(new java.io.File("./Expedientes"));
						if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
						  File fichero=fc.getSelectedFile();
							nombre_archivo_guardar = fichero.getAbsolutePath();
						}
						ArrayList<String> contenido = new ArrayList<String>();
						contenido = Archivo.leerTodo(nombre_archivo_guardar);
						for(int i=0; i<contenido.size(); i++) {
							lugar.append(contenido.get(i)+"\n");
						}
					} catch(Exception e) {
						JOptionPane.showMessageDialog(null,"No se selecciono un expediente");
					}

		 }
	}
}
