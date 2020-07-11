package aplicacion.cliente;

import aplicacion.utilerias.Objeto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class Cliente extends JFrame implements ActionListener, Runnable{
	public JTextField camposTxt[] = new JTextField[9];
	public JPanel panel;
	public JButton btnEnviar;
	public JLabel lblTexto;
	public JLabel lblNombre;
	public JLabel lblNss;
	public JLabel lblSangre;
	public JLabel lblGenero;
	public JLabel lblNacionalidad;
	public JLabel lblEstCivil;
	public JLabel lblCel;
	public JLabel lblEnfermedad;
	public JLabel lblCurp;
	public JLabel lblV;
	public JLabel lblN;
	public JLabel lblO;
	public JLabel lblP;
	public JLabel lblFondo;// lbl para el fondo que pondras amiko
	public Color cAzul= new Color(208,231,227);
	public Color cGris= new Color(187,211,216);
	public Boolean respuestaServidor = new Boolean(false);
	public Thread hilo1;

	public Cliente(){
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(cGris);

 		lblN=new JLabel(new ImageIcon(((new ImageIcon("./imagenes/st.png")).getImage()).getScaledInstance(70,70,java.awt.Image.SCALE_SMOOTH)));
 		lblN.setBounds(450,30,70,120);

 		lblO=new JLabel(new ImageIcon(((new ImageIcon("./imagenes/med.png")).getImage()).getScaledInstance(70,70,java.awt.Image.SCALE_SMOOTH)));
 		lblO.setBounds(450,150,70,120);

 		lblP=new JLabel(new ImageIcon(((new ImageIcon("./imagenes/doc.png")).getImage()).getScaledInstance(70,70,java.awt.Image.SCALE_SMOOTH)));
 		lblP.setBounds(450,270,70,120);

		lblTexto=new JLabel(" Ingrese los siguientes datos: ");
		lblTexto.setBounds(195,0,200,30);

		lblNombre=new JLabel("Nombre: ");
		lblNombre.setBounds(5,40,60,30);
		camposTxt[0]=new JTextField(50);
		camposTxt[0].setBounds(150,40,225,30);
		camposTxt[0].setBorder(null);

		lblNss=new JLabel("Celular: ");
		lblNss.setBounds(5,80,60,30);
		camposTxt[1]=new JTextField(10);
		camposTxt[1].setBounds(150,80,225,30);
		camposTxt[1].setBorder(null);

		lblSangre=new JLabel("E-mail: ");
		lblSangre.setBounds(5,120,100,30);
		camposTxt[2]=new JTextField(50);
		camposTxt[2].setBounds(150,120,225,30);
		camposTxt[2].setBorder(null);


		lblGenero=new JLabel("Tipo Sangre: ");
		lblGenero.setBounds(5,160,100,30);
		camposTxt[3]=new JTextField(3);
		camposTxt[3].setBounds(150,160,225,30);
		camposTxt[3].setBorder(null);

		lblNacionalidad= new JLabel("Genero:");
		lblNacionalidad.setBounds(5,200,100,30);
		camposTxt[4]=new JTextField(10);
		camposTxt[4].setBounds(150,200,225,30);
		camposTxt[4].setBorder(null);

		lblEstCivil=new JLabel("Fecha Nacimiento: ");
		lblEstCivil.setBounds(5,240,100,30);
		camposTxt[5]=new JTextField(10);
		camposTxt[5].setBounds(150,240,225,30);
		camposTxt[5].setBorder(null);

		lblCel= new JLabel("Domicilio: ");
		lblCel.setBounds(5,280,100,30);
		camposTxt[6]=new JTextField(50);
		camposTxt[6].setBounds(150,280,225,30);
		camposTxt[6].setBorder(null);

		lblEnfermedad=new JLabel("Alergias: ");
		lblEnfermedad.setBounds(5,320,190,30);
		camposTxt[7]=new JTextField(20);
		camposTxt[7].setBounds(150,320,225,30);
		camposTxt[7].setBorder(null);

		lblCurp=new JLabel ("Enfermedades: ");
		lblCurp.setBounds(5,360,100,30);
		camposTxt[8]=new JTextField(50);
		camposTxt[8].setBounds(150,360,225,30);
		camposTxt[8].setBorder(null);

		btnEnviar=new JButton("Enviar");
		btnEnviar.setBounds(255,410,250,30);
		btnEnviar.addActionListener(this);
		btnEnviar.setBackground(cAzul);

		panel.add(btnEnviar);
		panel.add(camposTxt[0]);panel.add(camposTxt[1]);panel.add(camposTxt[2]);panel.add(camposTxt[3]);panel.add(camposTxt[4]);panel.add(camposTxt[5]);panel.add(camposTxt[6]);panel.add(camposTxt[7]);panel.add(camposTxt[8]);
		panel.add(lblTexto);panel.add(lblNombre);panel.add(lblNss);panel.add(lblSangre);panel.add(lblGenero);panel.add(lblNacionalidad);panel.add(lblEstCivil);panel.add(lblCel);panel.add(lblEnfermedad);panel.add(lblCurp);

		panel.add(lblN);panel.add(lblO);panel.add(lblP);
		hilo1 = new Thread(this);

		this.add(panel);
		this.setTitle("Cliente");
		this.setBounds(500,200,600,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == this.btnEnviar){
			int cont = 0;
			for(int i=0; i<camposTxt.length; i++) {
				if(camposTxt[i].getText().isEmpty()){
					cont++;
				}
			}
			if(cont==0){
				btnEnviar.setEnabled(false);
				hilo1.start();
			}else{
				JOptionPane.showMessageDialog(null,"Favor de llenar todos los campos");
			}
		}
	}
	public void run(){
		try {
			Socket socket = new Socket("201.170.39.252",9000); //IP del servidor (201.170.39.252)
			ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
			Objeto o = new Objeto(camposTxt[0].getText(),camposTxt[1].getText(),camposTxt[2].getText(),camposTxt[3].getText(),camposTxt[4].getText(),camposTxt[5].getText(),camposTxt[6].getText(),camposTxt[7].getText(),camposTxt[8].getText());
			os.writeObject(o);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			respuestaServidor = in.readBoolean();
			while((respuestaServidor = in.readBoolean())!=null){
				if(respuestaServidor.equals(true)){
					//Registro registro= new registro();
					System.out.println("Aceptado por el servidor: ");
					for(int i=0; i<camposTxt.length; i++) {
						camposTxt[i].setText("");
					}
					//this.dispose();
				}
			}
		}catch (Exception e) {
			System.out.println("Error en la conexion");
		}
	}
}
