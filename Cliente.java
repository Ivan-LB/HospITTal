package aplicacion.cliente;

import aplicacion.utilerias.Objeto;
import aplicacion.utilerias.Archivo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.awt.Color;
import java.awt.Font;
import java.util.*;
import javax.sound.sampled.*;

public class Cliente extends JFrame implements ActionListener{
	public JPanel panel;
 	public JLabel lblNombre;
 	public JLabel lblCel;
 	public JLabel lblMail;
 	public JLabel lblSangre;
 	public JLabel lblGenero;
 	public JLabel lblFecha;
 	public JLabel lblEnfermedad;
 	public JLabel lblCurp;
 	public JLabel lblDom;
 	public JLabel lblTitulo;
 	public JLabel fondo;
 	public JButton btnRegresar;
 	public JButton btnRegistro;
	public JTextField camposTxt[] = new JTextField[9];
	public Boolean respuestaServidor = new Boolean(false);
	public Thread hilo1;
	public Color color1= new Color(7,3,26);//Azul oscuro
	public Color color2= new Color(255,203,116);//AMARILLO
	public Color color3= new Color(79,138,139);// Azul claro
	public Color color4= new Color(244,246,255);// blanco azulado
	public ArrayList<String> nombresU;
	public int cont;
	public Clip clip;
	public Clip chas;
	public JTextField ip;
	public JLabel lblIP;

	public Cliente(){

		try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("LikeFluids.WAV").getAbsoluteFile());
       	clip = AudioSystem.getClip();
        clip.open(audioInputStream);
				AudioInputStream audioIO = AudioSystem.getAudioInputStream(new File("chas.WAV").getAbsoluteFile());
				chas = AudioSystem.getClip();
				chas.open(audioIO);
    } catch(Exception ex) {
        System.out.println("Error with playing sound.");
        ex.printStackTrace();
    }

		panel= new JPanel();
		panel.setLayout(null);
		panel.setBackground(color1);

		lblIP = new JLabel("IP",JLabel.CENTER);
		lblIP.setBounds(330,250,40,30);
		lblIP.setBackground(color3);
		lblIP.setOpaque(true);
		lblIP.setForeground(Color.white);

		ip = new JTextField("");
		ip.setBounds(370,250,200,30);
		ip.setBackground(Color.white);
		ip.setOpaque(true);

		fondo=new JLabel("");
		fondo.setBounds(0,310,600,10);
		fondo.setBackground(color2);
		fondo.setOpaque(true);

		lblTitulo= new JLabel("Ingrese los siguientes datos",SwingConstants.CENTER);
		lblTitulo.setBounds(0,0,600,30);
		lblTitulo.setBackground(color3);
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(Color.white);

		camposTxt[0]= new JTextField(50);
		camposTxt[0].setBounds(100,40,240,30);
		camposTxt[0].setBackground(color3);
		camposTxt[0].setForeground(color1);
		lblNombre= new JLabel(" Nombre: ", SwingConstants.CENTER);
		lblNombre.setBounds(20,40,80,30);
		lblNombre.setBackground(color4);
		lblNombre.setOpaque(true);

		camposTxt[1]=new JTextField(10);
		camposTxt[1].setBounds(420,40,150,30);
		camposTxt[1].setBackground(color3);
		camposTxt[1].setForeground(color1);
		lblCel= new JLabel(" Celular: ",SwingConstants.CENTER);
		lblCel.setBounds(350,40,70,30);
		lblCel.setBackground(color4);
		lblCel.setOpaque(true);

		camposTxt[2]=new JTextField(100);
		camposTxt[2].setBounds(100,80,470,30);
		camposTxt[2].setBackground(color3);
		camposTxt[2].setForeground(color1);
		lblDom= new JLabel(" Domicilio: ",SwingConstants.CENTER);
		lblDom.setBounds(20,80,80,30);
		lblDom.setBackground(color4);
		lblDom.setOpaque(true);

		camposTxt[3]= new JTextField(15);
		camposTxt[3].setBounds(70,120,150,30);
		camposTxt[3].setBackground(color3);
		camposTxt[3].setForeground(color1);
		lblCurp= new JLabel(" Curp: ",SwingConstants.CENTER);
		lblCurp.setBounds(20,120,50,30);
		lblCurp.setBackground(color4);
		lblCurp.setOpaque(true);

		camposTxt[4]= new JTextField(50);
		camposTxt[4].setBounds(300,120,270,30);
		camposTxt[4].setBackground(color3);
		camposTxt[4].setForeground(color1);
		lblMail= new JLabel(" E-mail: ",SwingConstants.CENTER);
		lblMail.setBounds(230,120,70,30);
		lblMail.setBackground(color4);
		lblMail.setOpaque(true);

		camposTxt[5]= new JTextField(5);
		camposTxt[5].setBounds(120,160,40,30);
		camposTxt[5].setBackground(color3);
		camposTxt[5].setForeground(color1);
		lblSangre= new JLabel(" Tipo de sangre: ",SwingConstants.CENTER);
		lblSangre.setBounds(20,160,100,30);
		lblSangre.setBackground(color4);
		lblSangre.setOpaque(true);

		camposTxt[6]= new JTextField(10);
		camposTxt[6].setBounds(230,160,120,30);
		camposTxt[6].setBackground(color3);
		camposTxt[6].setForeground(color1);
		lblGenero= new JLabel(" Genero: ",SwingConstants.CENTER);
		lblGenero.setBounds(170,160,60,30);
		lblGenero.setBackground(color4);
		lblGenero.setOpaque(true);

		camposTxt[7]= new JTextField(11);
		camposTxt[7].setBounds(450,160,120,30);
		camposTxt[7].setBackground(color3);
		camposTxt[7].setForeground(color1);
		lblFecha= new JLabel("Nacimiento:",SwingConstants.CENTER);
		lblFecha.setBounds(360,160,90,30);
		lblFecha.setBackground(color4);
		lblFecha.setOpaque(true);

		camposTxt[8]= new JTextField(100);
		camposTxt[8].setBounds(130,200,440,30);
		camposTxt[8].setBackground(color3);
		camposTxt[8].setForeground(color1);
		lblEnfermedad= new JLabel(" Enfermedades: ",SwingConstants.CENTER);
		lblEnfermedad.setBounds(20,200,110,30);
		lblEnfermedad.setBackground(color4);
		lblEnfermedad.setOpaque(true);

		btnRegistro= new JButton("Enviar");
		btnRegistro.setBounds(120,250,175,50);
		btnRegistro.setBackground(color4);
		btnRegistro.addActionListener(this);
		panel.add(lblTitulo);

		panel.add(camposTxt[0]);panel.add(camposTxt[1]);panel.add(camposTxt[2]);panel.add(camposTxt[3]);panel.add(camposTxt[4]);panel.add(camposTxt[5]);panel.add(camposTxt[6]);panel.add(camposTxt[7]);panel.add(camposTxt[8]);
		panel.add(lblNombre);panel.add(lblCel);panel.add(lblDom);panel.add(lblCurp);panel.add(lblMail);panel.add(lblSangre);panel.add(lblGenero);panel.add(lblEnfermedad);panel.add(lblFecha);
		panel.add(btnRegistro);
		panel.add(fondo);
		panel.add(ip);
		panel.add(lblIP);

		//hilo1 = new Thread(this);
		this.add(panel);
		this.setTitle("Registro");
		this.setBounds(100,150,600,370);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == this.btnRegistro){
			int cont = 0;
			chas.start();
			for(int i=0; i<camposTxt.length; i++) {
				if(camposTxt[i].getText().isEmpty()){
					cont++;
				}
			}
			if(cont==0){
				btnRegistro.setEnabled(true);
				clip.start();
				enviarDatos(ip.getText());
			}else{
				JOptionPane.showMessageDialog(null,"Favor de llenar todos los campos");
				clip.stop();
			}
		}
	}
	public void enviarDatos(String ip){
		try {
			Socket socket = new Socket(ip,9000); //IP del servidor (201.170.39.252)
			ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
			Objeto o = new Objeto(camposTxt[0].getText(),camposTxt[1].getText(),camposTxt[4].getText(),camposTxt[5].getText(),camposTxt[6].getText(),camposTxt[7].getText(),camposTxt[2].getText(),camposTxt[8].getText(),camposTxt[3].getText());
			os.writeObject(o);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			respuestaServidor = in.readBoolean();
			while((respuestaServidor = in.readBoolean())!=null){
				if(respuestaServidor.equals(true)){
					for(int i=0; i<camposTxt.length; i++) {
						camposTxt[i].setText("");
					}
					JOptionPane.showMessageDialog(null,"Su formulario fue aceptado por el servidor");
					nombresU = Archivo.leerTodo("./UsuariosContrasennas/Nombres.txt");
			    if(nombresU != null){
			      if(cont==0){
			        Archivo.CrearArchivoP(o.nombre,"UsuariosContrasennas/Nombres.txt");
			      }
			    }else if(nombresU == null){
			       Archivo.CrearArchivo(o.nombre,"UsuariosContrasennas/Nombres.txt");
			    }
					clip.stop();
					InicioSesion is = new InicioSesion();
					socket.close();
					this.dispose();
				}else if(respuestaServidor.equals(false)){
					JOptionPane.showMessageDialog(null,"Su formulario no fue aceptado por el servidor");
					clip.stop();
					btnRegistro.setEnabled(true);
					for(int i=0; i<camposTxt.length; i++){
						camposTxt[i].setText("");
					}
					break;
				}
			}
		}catch (Exception e) {
			System.out.println("Error en la conexion");
			clip.stop();
		}
	}
}
