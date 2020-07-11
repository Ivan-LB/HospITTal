package aplicacion.cliente;

import aplicacion.utilerias.Archivo;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.lang.String;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;
import java.io.FileNotFoundException;



public class InicioSesion extends JFrame implements ActionListener{
	 JPanel panel;
   JTextField campoNombre;
   JPasswordField campoClave;
   Font font = new Font("arial",Font.BOLD,25);
   JLabel lblNombre;
   JLabel lblClave;
   JLabel lblN;
   JLabel lblTitulo;
   JLabel fondo;
   int cont;
   JButton btnIngresar;
   Boolean iguales= new Boolean(false);
   int numUser= 0;

   JToggleButton btnVisible;
   public ArrayList<String> contenidoUser = new ArrayList<>();
   public ArrayList<String> contenidoPass = new ArrayList<>();

   Color color1= new Color(7,3,26);//Azul oscuro
 	 Color color2= new Color(255,203,116);//AMARILLO
	 Color color3= new Color(79,138,139);// Azul claro
   Color color4= new Color(244,246,255);// blanco azulado

  public InicioSesion(){
		panel= new JPanel();
  	panel.setLayout(null);
    panel.setBackground(color1);

    lblN=new JLabel(new ImageIcon(((new ImageIcon("./imagenes/inicio.png")).getImage()).getScaledInstance(170,170,java.awt.Image.SCALE_SMOOTH)));
   	lblN.setBounds(220,50,170,170);
   	lblN.setBackground(color2);
   	lblN.setOpaque(true);

    fondo=new JLabel("");
    fondo.setBounds(0,450,600,10);
    fondo.setBackground(color2);
    fondo.setOpaque(true);

    lblTitulo= new JLabel("Bienvenido",SwingConstants.CENTER);
    lblTitulo.setBounds(0,0,600,40);
    lblTitulo.setBackground(color3);
    lblTitulo.setOpaque(true);
    lblTitulo.setForeground(Color.white);

    campoNombre= new JTextField(50);
    campoNombre.setBounds(220,240,240,30);
    campoNombre.setBackground(color3);
    campoNombre.setForeground(color1);
    lblNombre= new JLabel(" Usuario: ", SwingConstants.CENTER);
    lblNombre.setBounds(140,240,80,30);
    lblNombre.setBackground(color4);
    lblNombre.setOpaque(true);

    campoClave= new JPasswordField();
    campoClave.setBounds(220,280,240,30);
    campoClave.setEchoChar('*');
    campoClave.setBackground(color3);
    campoClave.setForeground(color1);
    lblClave= new JLabel(" Clave: ", SwingConstants.CENTER);
    lblClave.setBounds(140,280,80,30);
    lblClave.setBackground(color4);
    lblClave.setOpaque(true);

    panel.add(lblTitulo);

    panel.add(campoNombre);panel.add(campoClave);
    panel.add(lblNombre);panel.add(lblClave);
    panel.add(fondo);panel.add(lblN);

    btnVisible = new JToggleButton();
    btnVisible.setIcon(new ImageIcon(((new ImageIcon("./Imagenes/VisibleOff.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
    btnVisible.setSelectedIcon(new ImageIcon(((new ImageIcon("./Imagenes/VisibleOn.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
    btnVisible.setBounds(470,280,30,30);
    panel.add(btnVisible);

 		btnIngresar= new JButton("Ingresar");
 		btnIngresar.setBounds(260,370,100,50);
 		btnIngresar.setBackground(color4);
    btnIngresar.addActionListener(this);

 		panel.add(btnIngresar);

    ItemListener itemListener = new ItemListener(){
      public void itemStateChanged(ItemEvent ItemEvent){
        int state = ItemEvent.getStateChange();
        if(state == ItemEvent.SELECTED){
          campoClave.setEchoChar((char)0);
        }else{
          campoClave.setEchoChar('*');
        }
      }
    };
    btnVisible.addItemListener(itemListener);

  	this.add(panel);
    this.setTitle("Inicio de Sesion  ");
    this.setBounds(100,150,600,500);
	  this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  public void actionPerformed(ActionEvent event){
    if(event.getSource() == this.btnIngresar){
      try{
        File usuarios = new File("./UsuariosContrasennas/Usuarios.txt");
        File claves = new File ("./UsuariosContrasennas/Passwords.txt");

        FileReader fr1 = new FileReader(usuarios);
        FileReader fr2 = new FileReader(claves);

        BufferedReader bf1 = new BufferedReader(fr1);
        BufferedReader bf2 = new BufferedReader(fr2);

        String sCadena1 = bf1.readLine();
        String sCadena2 = bf2.readLine();

        while ((sCadena1!=null)||(sCadena2!=null)){
          if(sCadena1.equals(campoNombre.getText())){
            if(sCadena2.equals(campoClave.getText())){
             this.dispose();
             iguales = true;
             Doctores d = new Doctores();
            }
          }
          sCadena1 = bf1.readLine();
          sCadena2 = bf2.readLine();
          if(iguales.equals(false)){
            numUser++;
          }
        }
        if(iguales.equals(false)){
          System.out.println(iguales);
          JOptionPane.showMessageDialog(null,"Verifique que escribio correctamente su usuario y contraseña");
        }
      }catch(Exception e){
        e.printStackTrace();
      }
    }
    // else if(event.getSource() == this.btnBack){
    //   Inicio i = inicio();
    //   this.dispose();
    // }
  }
}
