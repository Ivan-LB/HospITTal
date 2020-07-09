package aplicacion.servidor;

import aplicacion.utilerias.Objeto;
import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.io.*;

public class Servidor extends JFrame implements Runnable{
  JLabel lblNombre;
  JLabel lblNSS;
  JLabel lblSangre;
  JLabel lblGenero;
  JLabel lblAlergias;
  JLabel lblEstCivil;
  JLabel lblCel;
  JLabel lblEnfermedades;
  JLabel lblCurp;
  JPanel panel;
  Thread hilo1;

  public Servidor(){
    panel= new JPanel();
		panel.setLayout(null);

		lblNombre = new JLabel("");
    lblNombre.setBounds(10,0,150,30);
    lblNSS = new JLabel("");
    lblNSS.setBounds(10,40,150,30);
    lblSangre = new JLabel("");
    lblSangre.setBounds(10,80,150,30);
    lblGenero = new JLabel("");
    lblGenero.setBounds(10,120,150,30);
    lblAlergias = new JLabel("");
    lblAlergias.setBounds(10,160,150,30);
    lblEstCivil = new JLabel("");
    lblEstCivil.setBounds(10,200,150,30);
    lblCel = new JLabel("");
    lblCel.setBounds(10,240,150,30);
    lblEnfermedades = new JLabel("");
    lblEnfermedades.setBounds(10,280,150,30);
    lblCurp = new JLabel("");
    lblCurp.setBounds(10,320,150,30);

    panel.add(lblNombre);panel.add(lblNSS);panel.add(lblSangre);panel.add(lblGenero);panel.add(lblAlergias);panel.add(lblEstCivil);panel.add(lblCel);panel.add(lblEnfermedades);panel.add(lblCurp);

    hilo1 = new Thread(this);
    hilo1.start();


		this.add(panel);
    this.setTitle("Servidor ");
    this.setBounds(100,300,400,400);
		this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
  public void run(){
    try {
      ServerSocket server = new ServerSocket(9000); //Socket del servidor
      while(true){
        Socket socket = server.accept(); //Socket del Cliente
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
        Objeto o = (Objeto)is.readObject();
        System.out.println("Llego");
        lblNombre.setText(o.nombre);
        lblNSS.setText(o.nss);
        lblSangre.setText(o.sangre);
        lblGenero.setText(o.genero);
        lblAlergias.setText(o.alergias);
        lblEstCivil.setText(o.estCivil);
        lblCel.setText(o.cel);
        lblEnfermedades.setText(o.enfermedad);
        lblCurp.setText(o.curp);
        socket.close();
      }
    }catch (Exception e) {
      e.printStackTrace();
    }

  }
}
