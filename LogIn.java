package aplicacion.cliente;

import aplicacion.utilerias.Archivo;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.lang.String;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.io.FileNotFoundException;

public  class LogIn extends JFrame implements ActionListener
{
    public boolean mostrar = true;
    public boolean correctoU = false;
    public boolean correctoC = false;
    public int cont =0;
    public char [] contra;
    public String clave;
    public ArrayList <String> contenidoUser = new  ArrayList <String>();
    public ArrayList <String> contenidoPass = new  ArrayList <String>();

    Boolean pasar = new Boolean(false);
    JPanel panel;
    Color fondo;
    JLabel texto,usuario,contrasena;
    JTextField txtusuario,txtcontrasenavis;
    JPasswordField txtcontrasena;
    JButton inicio,registro,ver;
    JMenuBar menuBarra;
    JMenu info;

    public LogIn()
    {
       /* try
        {   setIconImage(new ImageIcon(getClass().getResource("libros.png")).getImage());   }
        catch(Exception e) {    System.out.println("Error: NO SE ECONTRO IMAGEN");} */

        menuBarra = new JMenuBar();
        info = new JMenu("INFORMACION");
        menuBarra.add(info);

        fondo = new Color(187,182,214);
        texto = new JLabel("Iniciar Sesion");
        texto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN,30));
        texto.setBounds(100,50,200,30);

        usuario = new JLabel("Usuario:");
        usuario.setFont(new Font("Arial Unicode MS", Font.PLAIN,20));
        usuario.setBounds(40,110,80,30);

        txtusuario = new JTextField();
        txtusuario.setBounds(120,110,180,30);
        txtusuario.setBorder(null);

        contrasena = new JLabel("Clave:");
        contrasena.setFont(new Font("Arial Unicode MS", Font.PLAIN,20));
        contrasena.setBounds(50,160,70,30);


        txtcontrasena = new JPasswordField();
        txtcontrasena.setBounds(120,160,180,30);
        txtcontrasena.setVisible(true);
        txtcontrasena.setBorder(null);
        txtcontrasenavis = new JTextField();
        txtcontrasenavis.setBounds(120,160,180,30);
        txtcontrasenavis.setDisabledTextColor(Color.BLACK);
        txtcontrasenavis.setEnabled(false);
        txtcontrasenavis.setBorder(null);
        txtcontrasenavis.setVisible(false);

        ver = new JButton();
        ver.setBounds(303,160,30,30);
        ver.setBorder(null);
       /* try
        {
            ImageIcon verc = new ImageIcon("ojo.png");
            ver.setIcon(new ImageIcon(verc.getImage().getScaledInstance(ver.getWidth(),ver.getHeight(),Image.SCALE_SMOOTH)));
        }
        catch(Exception e)  {   System.out.println("no se encontro imagen para colocar.");  }*/

        registro = new JButton("Registro");
        registro.setBounds(35,230,120,30);
        registro.setFont(new Font("Copperplate Gothic Bold",Font.PLAIN,15));
        registro.setBorder(null);

        inicio = new JButton("iniciar");
        inicio.setBounds(255,230,110,30);
        inicio.setFont(new Font("Copperplate Gothic Bold",Font.PLAIN,15));
        inicio.setBorder(null);


        this.setJMenuBar(menuBarra);
        this.add(ver);
        this.add(registro);
        this.add(inicio);
        this.add(texto);
        this.add(usuario);
        this.add(txtusuario);
        this.add(contrasena);
        this.add(txtcontrasena);
        this.add(txtcontrasenavis);
        this.setResizable(false);
        this.setTitle("prueba");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(450,100,400,450);
        this.getContentPane().setBackground(fondo);
        this.setVisible(true);

        ver.addActionListener(this);
        registro.addActionListener(this);
        inicio.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource()== this.ver)
        {
            clave = "";
            contra = txtcontrasena.getPassword();
            for (int i=0; i<contra.length; i++)
            {
                clave+=contra[i];
            }

            if(mostrar==true)
            {
                txtcontrasenavis.setVisible(true);
                txtcontrasena.setVisible(false);
                txtcontrasenavis.setText(clave);
                mostrar=false;
            }
            else
            {
                txtcontrasenavis.setVisible(false);
                txtcontrasena.setVisible(true);
                txtcontrasena.setText(clave);
                mostrar=true;
            }
        }

        else if (event.getSource()== this.registro)
        {
          contenidoUser = Archivo.leerTodo("Usuarios.txt");
          if(contenidoUser != null){
            for (int i=0;i<contenidoUser.size() ; i++) {
              if(txtusuario.getText().equals(contenidoUser.get(i))){
                JOptionPane.showMessageDialog(null,"El usuario ya existe intente con otro");
                cont++;
              }
            }
            if(cont==0){
              Archivo.CrearArchivo(txtusuario.getText(),"Usuarios.txt");
              Archivo.CrearArchivo(txtcontrasenavis.getText(),"Passwords.txt");
            }
          }else{
            Archivo.CrearArchivo(txtusuario.getText(),"Usuarios.txt");
            Archivo.CrearArchivo(txtcontrasena.getText(),"Passwords.txt");
          }
        }

        else if (event.getSource()== this.inicio)
        {   clave = "";
            contra = txtcontrasena.getPassword();
            for (int i=0; i<contra.length; i++)
            {
                clave+=contra[i];
            }
            contenidoUser = Archivo.leerTodo("Usuarios.txt");
            for (int i=0; i<contenidoUser.size(); i++)
            {
                if(txtusuario.getText().equals(contenidoUser.get(i)))
                {
                    correctoU = true;
                    System.out.println("usuario encontrado: "+ contenidoUser.get(i));
                }
            }
            contenidoPass = Archivo.leerTodo("Claves.txt");
            for (int i=0; i<contenidoPass.size(); i++)
            {
                if(clave.equals(contenidoPass.get(i)))
                {
                    correctoC = true;
                    System.out.println("Clave encontrado: "+ contenidoPass.get(i));
                }
            }
            System.out.println("Hola");
            //JOptionPane.showMessageDialog (null, "Usuario no registrado.", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }
}
/* Inicio de Sesion
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class Login extends JFrame implements ActionListener{
  JPanel panel;
  Font font = new Font("arial",Font.BOLD,25);
  JLabel lblUsername;
  JLabel lblPassword;
  JTextField txtUsername;
  JPasswordField txtPassword;
  JButton btnLogin;
  JButton btnBack;
  Boolean iguales = new Boolean(false);
  int numUser = 0;
  int asegurar;

  public Login(){

    panel = new JPanel();
    panel.setLayout(null);
    Color cGris = new Color(211,211,211);
    Color cAzul = new Color(173, 216, 230);

    panel.setBackground(cAzul);

    lblUsername= new JLabel("Usuario: ");
    lblUsername.setBounds(25,25,115,30);
    lblUsername.setFont(font);
    lblPassword = new JLabel("Clave: ");
    lblPassword.setBounds(50,85,100,30);
    lblPassword.setFont(font);
    txtUsername = new JTextField();
    txtUsername.setBounds(180,25,250,30);
    txtUsername.setBorder(null);
    txtUsername.setFont(font);
    txtPassword = new  JPasswordField();
    txtPassword.setBounds(180,85,250,30);
    txtPassword.setBorder(null);
    txtPassword.setFont(font);
    btnLogin = new JButton("Ingresar");
    btnLogin.setBounds(270,175,100,30);
    btnLogin.setBackground(cGris);
    btnLogin.addActionListener(this);
    btnBack = new JButton("Regresar");
    btnBack.setBounds(90,175,100,30);
    btnBack.setBackground(cGris);
    btnBack.addActionListener(this);

    panel.add(lblUsername);
    panel.add(lblPassword);
    panel.add(txtUsername);
    panel.add(txtPassword);
    panel.add(btnLogin);
    panel.add(btnBack);

    this.add(panel);
    this.setTitle(" Login ");
    this.setSize(480,300);
    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    this.setResizable(false);

  }
  public void actionPerformed(ActionEvent event){
    if(event.getSource() == this.btnLogin){
      try{
        File usuarios = new File("D:/Practica4/UsersPasswords/Users.txt");
        File claves = new File ("D:/Practica4/UsersPasswords/Passwords.txt");

        FileReader fr1 = new FileReader(usuarios);
        FileReader fr2 = new FileReader(claves);

        BufferedReader bf1 = new BufferedReader(fr1);
        BufferedReader bf2 = new BufferedReader(fr2);

        String sCadena1 = bf1.readLine();
        String sCadena2 = bf2.readLine();

        while ((sCadena1!=null)||(sCadena2!=null)){
          if(sCadena1.equals(txtUsername.getText())){
            if(sCadena2.equals(txtPassword.getText())){
             this.dispose();
             iguales = true;
             MenuJuego mj = new MenuJuego(numUser);
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
    }else if(event.getSource() == this.btnBack){
      this.dispose();
      InicioSesion is = new InicioSesion();
    }
  }
}
*/

/* Registro
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.Dimension;

class SignUp extends JFrame implements ActionListener{
  JPanel panel;
  Font font = new Font("arial",Font.BOLD,25);
  JLabel lblUser;
  JLabel lblPassword;
  JTextField txtUserNew;
  JCheckBox visible;
  JPasswordField txtPasswordNew;
  JButton btnListo;
  JButton btnBack;
  JToggleButton btnVisible;
  ArrayList<String> usuarios = new ArrayList<String>();
  int flag = 0;

  public SignUp(){
      panel = new JPanel();
      panel.setLayout(null);
      Color cGris = new Color(211,211,211);
      Color cAzul = new Color(173, 216, 230);
      panel.setBackground(cAzul);



      usuarios = Archivo.leerTodo("D:/Practica4/UsersPasswords/Users.txt");
      lblUser = new JLabel("Usuario: ", SwingConstants.RIGHT);
      lblUser.setBounds(15,25,120,30);
      lblUser.setFont(font);
      lblPassword = new JLabel("Clave: ", SwingConstants.RIGHT);
      lblPassword.setBounds(15,85,120,30);
      lblPassword.setFont(font);
      txtUserNew = new JTextField();
      txtUserNew.setBorder(null);
      txtUserNew.setBounds(140,25,200,30);
      txtUserNew.setFont(font);
      txtPasswordNew = new  JPasswordField();
      txtPasswordNew.setEchoChar('*');
      txtPasswordNew.setFont(font);
      txtPasswordNew.setBorder(null);
      txtPasswordNew.setBounds(140,85,200,30);
      btnListo = new JButton("Registrar");
      btnListo.setBounds(320,175,100,50);
      btnListo.setBackground(cGris);
      btnListo.addActionListener(this);
      btnBack = new JButton("Volver al menu");
      btnBack.setBounds(30,184,150,30);
      btnBack.setBackground(cGris);
      btnBack.addActionListener(this);
      btnVisible = new JToggleButton();
      btnVisible.setIcon(new ImageIcon(((new ImageIcon("./Imagenes/VisibleOff.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnVisible.setSelectedIcon(new ImageIcon(((new ImageIcon("./Imagenes/VisibleOn.png")).getImage()).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
      btnVisible.setBounds(350,85,30,30);
      ItemListener itemListener = new ItemListener(){
        public void itemStateChanged(ItemEvent ItemEvent){
          int state = ItemEvent.getStateChange();
          if(state == ItemEvent.SELECTED){
            txtPasswordNew.setEchoChar((char)0);
          }else{
            txtPasswordNew.setEchoChar('*');
            txtPasswordNew.setFont(font);
          }
        }
      };
      btnVisible.addItemListener(itemListener);

      panel.add(lblUser);
      panel.add(lblPassword);
      panel.add(txtUserNew);
      panel.add(txtPasswordNew);
      panel.add(btnListo);
      panel.add(btnBack);
      panel.add(btnVisible);

      this.add(panel);
      this.setTitle(" Registro ");
  		this.setSize(450,300);
  		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
  		this.setVisible(true);
  		this.setLocationRelativeTo(null);
      this.setResizable(false);
  }
  public void actionPerformed(ActionEvent event){
  	if(event.getSource() == this.btnListo){
      if(txtUserNew.getText().isEmpty() == false){
        for (int i=0;i<usuarios.size(); i++) {
          if(txtUserNew.getText().equals(usuarios.get(i))) {
            JOptionPane.showMessageDialog(null,"El usuario ya existe intente con otro");
            flag++;
          }
        }
        if(flag==0){
          Archivo.CrearArchivo(txtUserNew.getText(),"Users.txt");
          Archivo.CrearArchivo(txtPasswordNew.getText(),"Passwords.txt");
          Archivo.CrearArchivo("0","Puntajes.txt");
          JOptionPane.showMessageDialog(null, "Usuario Registrado con exito...");
      	}
        txtUserNew.setText("");
        txtPasswordNew.setText("");
      }else{
        JOptionPane.showMessageDialog(null,"Falto de llenar uno de los espacios");
      }
    }else if(event.getSource() == this.btnBack){
      this.dispose();
      InicioSesion f = new InicioSesion();
    }
  }
}
*/
