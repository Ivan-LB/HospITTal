package aplicacion.cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.sound.sampled.*;
import java.io.*;
import java.util.*;
import aplicacion.utilerias.Archivo;


public class Inicio extends JFrame implements ActionListener{
  public JPanel panel;
  public JLabel titulo;
  public JLabel pregunta;
  public JLabel creditos;
  public JButton si;
  public JButton no;
  public JButton irSin;
  public Color azul = new Color(7,3,26);
  public Clip pepe;
  public ArrayList<String> arrayUsers = new ArrayList<>();

  public Inicio()
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
    panel.setBackground(azul);

    titulo = new JLabel(new ImageIcon(((new ImageIcon("./imagenes/logo1.png")).getImage()).getScaledInstance(384,216,java.awt.Image.SCALE_SMOOTH)));
    titulo.setBounds(0,50,500,216);
    titulo.setOpaque(false);

    pregunta = new JLabel("Viene aqui por primera vez?",JLabel.CENTER);
    pregunta.setBounds(100,300,300,23);
    pregunta.setFont(new Font("Serif", Font.PLAIN, 22));
    pregunta.setForeground(Color.white);
    pregunta.setOpaque(false);


    si = new JButton("Si");
    si.setBounds(125,350,100,30);
    si.addActionListener(this);

    no = new JButton("No");
    no.setBounds(275,350,100,30);
    no.addActionListener(this);

    arrayUsers = Archivo.leerTodo("./UsuariosContrasennas/Usuarios.txt");
    if(arrayUsers == null){
      no.setEnabled(false);
    }

    panel.add(titulo);
    panel.add(pregunta);
    panel.add(si);
    panel.add(no);

    this.add(panel);

    this.pack();
    this.setTitle("BIENVENIDO");
    this.setBounds(150,150,500,520);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setLayout(null);
  }
    public void actionPerformed(ActionEvent event)
    {
      if(event.getSource() == this.si)
      {
        pepe.start();
        Registro r = new Registro();
        this.dispose();
      }
      else if(event.getSource() == this.no)
      {
        pepe.start();
        InicioSesion is = new InicioSesion();
        this.dispose();
      }
    }

}
