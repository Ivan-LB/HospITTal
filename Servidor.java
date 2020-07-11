package aplicacion.servidor;

import aplicacion.utilerias.Objeto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class Servidor extends JFrame implements Runnable,ActionListener{
  JLabel lblNombre;
  JLabel lblCel;
  JLabel lblMail;
  JLabel lblSangre;
  JLabel lblGenero;
  JLabel lblFecha;
  JLabel lblDom;
  JLabel lblEnfermedades;
  JLabel lblCurp;
  JLabel lbl1;JLabel lbl2;JLabel lbl3; JLabel lbl4; JLabel lbl5; JLabel lbl6; JLabel lbl7; JLabel lbl8; JLabel lbl9;
  JLabel lblDatos;
  JLabel fondo;
  JPanel panel;
  JButton btnRechazar;JButton btnAceptar;
  Boolean r= new Boolean(false);

  Thread hilo1;
  Color color1= new Color(7,3,26);//Azul oscuro
  Color color2= new Color(255,203,116);//AMARILLO
  Color color3= new Color(79,138,139);// Azul claro
  Color color4= new Color(244,246,255);// blanco azulado

  ServerSocket server;
  Socket socket;
  ObjectInputStream is;
  DataOutputStream os;


  public Servidor(){
    panel= new JPanel();
		panel.setLayout(null);
    panel.setBackground(color1);

    fondo=new JLabel("");
    fondo.setBounds(0,320,600,10);
    fondo.setBackground(color2);
    fondo.setOpaque(true);

    lblDatos= new JLabel("Datos del paciente", SwingConstants.CENTER);
    lblDatos.setBounds(0,0,600,30);
    lblDatos.setBackground(color3);
    lblDatos.setOpaque(true);
    lblDatos.setForeground(Color.white);

		lblNombre = new JLabel("");
    lblNombre.setBounds(100,40,240,30);
    lblNombre.setBackground(color3);
    lblNombre.setOpaque(true);
    lblNombre.setForeground(color1);
    lbl1= new JLabel(" Nombre: ");
    lbl1.setBounds(20,40,80,30);
    lbl1.setBackground(color4);
    lbl1.setOpaque(true);

    lblCel = new JLabel("");
    lblCel.setBounds(420,40,150,30);
    lblCel.setBackground(color3);
    lblCel.setOpaque(true);
    lblCel.setForeground(color1);
    lbl2= new JLabel(" Celular: ");
    lbl2.setBounds(350,40,70,30);
    lbl2.setBackground(color4);
    lbl2.setOpaque(true);

    lblDom = new JLabel("");
    lblDom.setBounds(100,80,470,30);
    lblDom.setBackground(color3);
    lblDom.setOpaque(true);
    lblDom.setForeground(color1);
    lbl7= new JLabel(" Domicilio:");
    lbl7.setBounds(20,80,80,30);
    lbl7.setBackground(color4);
    lbl7.setOpaque(true);

    lblCurp = new JLabel("");
    lblCurp.setBounds(70,120,150,30);
    lblCurp.setBackground(color3);
    lblCurp.setOpaque(true);
    lblCurp.setForeground(color1);
    lbl9= new JLabel(" CURP: ");
    lbl9.setBounds(20,120,50,30);
    lbl9.setBackground(color4);
    lbl9.setOpaque(true);


    lblMail = new JLabel("");
    lblMail.setBounds(300,120,270,30);
    lblMail.setBackground(color3);
    lblMail.setOpaque(true);
    lblMail.setForeground(color1);
    lbl3= new JLabel(" E-mail: ");
    lbl3.setBounds(230,120,70,30);
    lbl3.setBackground(color4);
    lbl3.setOpaque(true);

    lblSangre = new JLabel("");
    lblSangre.setBounds(120,160,40,30);
    lblSangre.setBackground(color3);
    lblSangre.setOpaque(true);
    lblSangre.setForeground(color1);
    lbl4= new JLabel(" Tipo de sangre: ");
    lbl4.setBounds(20,160,100,30);
    lbl4.setBackground(color4);
    lbl4.setOpaque(true);

    lblGenero = new JLabel("");
    lblGenero.setBounds(230,160,100,30);
    lblGenero.setBackground(color3);
    lblGenero.setOpaque(true);
    lblGenero.setForeground(color1);
    lbl5= new JLabel(" Genero: ");
    lbl5.setBounds(170,160,60,30);
    lbl5.setBackground(color4);
    lbl5.setOpaque(true);


    lblFecha = new JLabel("");
    lblFecha.setBounds(450,160,120,30);
    lblFecha.setBackground(color3);
    lblFecha.setOpaque(true);
    lblFecha.setForeground(color1);
    lbl6= new JLabel(" Fecha Nacimiento:");
    lbl6.setBounds(340,160,110,30);
    lbl6.setBackground(color4);
    lbl6.setOpaque(true);



    lblEnfermedades = new JLabel("");
    lblEnfermedades.setBounds(130,200,440,30);
    lblEnfermedades.setBackground(color3);
    lblEnfermedades.setOpaque(true);
    lblEnfermedades.setForeground(color1);
    lbl8= new JLabel(" Enfermedades: ");
    lbl8.setBounds(20,200,110,30);
    lbl8.setBackground(color4);
    lbl8.setOpaque(true);


    //botones

    btnAceptar= new JButton("Aceptar");
    btnAceptar.setBounds(120,250,100,50);
    btnAceptar.setBackground(color4);
    btnRechazar= new JButton("Rechazar");
    btnRechazar.setBounds(330,250,100,50);
    btnRechazar.setBackground(color4);


    panel.add(lblNombre);panel.add(lblCel);panel.add(lblMail);panel.add(lblSangre);panel.add(lblGenero);panel.add(lblFecha);panel.add(lblDom);panel.add(lblEnfermedades);panel.add(lblCurp);

    panel.add(lbl1);panel.add(lbl2);panel.add(lbl3);panel.add(lbl4);panel.add(lbl5);panel.add(lbl6);panel.add(lbl7);panel.add(lbl8);panel.add(lbl9);
    panel.add(lblDatos);panel.add(fondo);
    panel.add(btnAceptar);panel.add(btnRechazar);


    btnAceptar.addActionListener(this); btnRechazar.addActionListener(this);
    hilo1 = new Thread(this);
    hilo1.start();


		this.add(panel);
    this.setTitle("Servidor ");
    this.setBounds(100,150,600,370);
		this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
  public void actionPerformed(ActionEvent e){
      if(e.getSource()== this.btnAceptar){
        r = true;
        enviar();

      }
      if(e.getSource()== this.btnRechazar){
        r = false;
      }
  }
  public boolean getBoolean(){
    return r;
  }
  public void run(){
    try {
      server = new ServerSocket(9000); //Socket del servidor
      while(true){
        socket = server.accept(); //Socket del Cliente
        is = new ObjectInputStream(socket.getInputStream());
        Objeto o = (Objeto)is.readObject();
        lblNombre.setText(o.nombre);
        lblCel.setText(o.cel);
        lblMail.setText(o.mail);
        lblSangre.setText(o.sangre);
        lblGenero.setText(o.genero);
        lblFecha.setText(o.fecha);
        lblDom.setText(o.dom);
        lblEnfermedades.setText(o.enfermedad);
        lblCurp.setText(o.curp);
        os = new DataOutputStream(socket.getOutputStream());
        os.writeBoolean(getBoolean());
        //socket.close();
      }
    }catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void enviar()
  {
    try{
      os.writeBoolean(getBoolean());
    }catch(Exception e){
      System.out.println("Error al enviar.");
    }

  }
}
