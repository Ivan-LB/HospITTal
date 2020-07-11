package aplicacion.cliente;

import aplicacion.utilerias.Archivo;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.lang.String;
import java.util.*;
import javax.swing.JOptionPane;
import java.io.FileNotFoundException;



public class Registro extends JFrame implements ActionListener{
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
   JButton btnRegresar;
   JButton btnRegistro;
   JToggleButton btnVisible;
   public ArrayList<String> contenidoUser = new ArrayList<>();
   public ArrayList<String> contenidoPass = new ArrayList<>();

   Color color1= new Color(7,3,26);//Azul oscuro
 	 Color color2= new Color(255,203,116);//AMARILLO
	 Color color3= new Color(79,138,139);// Azul claro
   Color color4= new Color(244,246,255);// blanco azulado

  public Registro(){
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

    lblTitulo= new JLabel("Ingrese los siguientes datos",SwingConstants.CENTER);
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

		btnRegistro= new JButton("Registrar");
 		btnRegistro.setBounds(140,370,100,50);
 		btnRegistro.setBackground(color4);
		btnRegistro.addActionListener(this);
 		btnRegresar= new JButton("Volver");
 		btnRegresar.setBounds(350,370,100,50);
 		btnRegresar.setBackground(color4);
		btnRegresar.addActionListener(this);

 		panel.add(btnRegistro);panel.add(btnRegresar);

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
    this.setTitle("Registro");
    this.setBounds(100,150,600,508);
	  this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  public void actionPerformed(ActionEvent event){
  	if(event.getSource()== this.btnRegistro){
      contenidoUser = Archivo.leerTodo("Usuario.txt");
      if(contenidoUser != null){
        for (int i=0;i<contenidoUser.size() ; i++) {
          if(campoNombre.getText().equals(contenidoUser.get(i))){
            JOptionPane.showMessageDialog(null,"El usuario ya existe intente con otro");
            cont++;
          }
        }
        if(cont==0){
          Archivo.CrearArchivo(campoNombre.getText(),"Usuarios.txt");
          Archivo.CrearArchivo(campoClave.getText(),"Passwords.txt");
        }
      }else{
        Archivo.CrearArchivo(campoNombre.getText(),"Usuarios.txt");
        Archivo.CrearArchivo(campoClave.getText(),"Passwords.txt");
      }
			JOptionPane.showMessageDialog(null,"Se ha creado su perfil exitosamente");
      Cliente c = new Cliente();
			this.dispose();
  	}else	if(event.getSource()== this.btnRegresar){
      this.dispose();
  	}
  }
}
