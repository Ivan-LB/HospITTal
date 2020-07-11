package aplicacion.cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class Inicio extends JFrame implements ActionListener{

JPanel panel;

JLabel titulo;
JLabel subtitulo;
JLabel pregunta;
JLabel creditos;

JButton si;
JButton no;

JButton irSin;

public Inicio()
{
  panel = new JPanel();
  panel.setLayout(null);

  titulo = new JLabel("HospITTal",JLabel.CENTER);
  titulo.setBounds(100,50,300,37);
  titulo.setFont(new Font("Serif", Font.PLAIN, 36));
  titulo.setOpaque(false);

  subtitulo = new JLabel("Bienvenido...",JLabel.CENTER);
  subtitulo.setBounds(100,90,300,25);
  subtitulo.setFont(new Font("Serif", Font.PLAIN, 24));
  subtitulo.setOpaque(false);

  pregunta = new JLabel("Viene aqui por primera vez?",JLabel.CENTER);
  pregunta.setBounds(100,200,300,23);
  pregunta.setFont(new Font("Serif", Font.PLAIN, 22));
  pregunta.setOpaque(false);

  si = new JButton("Si");
  si.setBounds(150,250,100,30);
  si.addActionListener(this);

  no = new JButton("No");
  no.setBounds(250,250,100,30);
  no.addActionListener(this);

  panel.add(titulo);
  panel.add(subtitulo);
  panel.add(pregunta);
  panel.add(si);
  panel.add(no);

  this.add(panel);

  this.pack();
  this.setTitle("INICIO");
  this.setBounds(150,150,500,520);
  this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  this.setVisible(true);
  this.setLayout(null);
}
  public void actionPerformed(ActionEvent event)
  {
    if(event.getSource() == this.si)
    {
      Registro r = new Registro();
      this.dispose();
    }
    else if(event.getSource() == this.no)
    {
      InicioSesion is = new InicioSesion();
    }
  }

}
