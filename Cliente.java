package aplicacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class Cliente extends JFrame implements ActionListener{
	public JTextField campoNombre;
	public JTextField campoNss;
	public JTextField campoSamgre;
	public JTextField campoGenero;
	public JTextField campoNacionalidad;
	public JTextField campoEstCivil;
	public JTextField campoCel;
	public JTextField campoEnfermedad;
	public JTextField campoCurp;
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
		campoNombre=new JTextField(20);
		campoNombre.setBounds(150,40,225,30);
		campoNombre.setBorder(null);

		lblNss=new JLabel("Celular: ");
		lblNss.setBounds(5,80,60,30);
		campoNss=new JTextField(20);
		campoNss.setBounds(150,80,225,30);
		campoNss.setBorder(null);

		lblSangre=new JLabel("E-mail: ");
		lblSangre.setBounds(5,120,100,30);
		campoSamgre=new JTextField(20);
		campoSamgre.setBounds(150,120,225,30);
		campoSamgre.setBorder(null);


		lblGenero=new JLabel("Tipo Sangre: ");
		lblGenero.setBounds(5,160,100,30);
		campoGenero=new JTextField(20);
		campoGenero.setBounds(150,160,225,30);
		campoGenero.setBorder(null);

		lblNacionalidad= new JLabel("Genero:");
		lblNacionalidad.setBounds(5,200,100,30);
		campoNacionalidad=new JTextField(20);
		campoNacionalidad.setBounds(150,200,225,30);
		campoNacionalidad.setBorder(null);

		lblEstCivil=new JLabel("Fecha Nacimiento: ");
		lblEstCivil.setBounds(5,240,100,30);
		campoEstCivil=new JTextField(20);
		campoEstCivil.setBounds(150,240,225,30);
		campoEstCivil.setBorder(null);
		
		lblCel= new JLabel("Domicilio: ");
		lblCel.setBounds(5,280,100,30);
		campoCel=new JTextField(20);
		campoCel.setBounds(150,280,225,30);
		campoCel.setBorder(null);

		lblEnfermedad=new JLabel("Alergias: ");
		lblEnfermedad.setBounds(5,320,190,30);
		campoEnfermedad=new JTextField(20);
		campoEnfermedad.setBounds(150,320,225,30);
		campoEnfermedad.setBorder(null);

		lblCurp=new JLabel ("Enfermedades: ");
		lblCurp.setBounds(5,360,100,30);
		campoCurp=new JTextField(20);
		campoCurp.setBounds(150,360,225,30);
		campoCurp.setBorder(null);

		btnEnviar=new JButton("Enviar");
		btnEnviar.setBounds(255,410,75,30);
		btnEnviar.addActionListener(this);
		btnEnviar.setBackground(cAzul);

		panel.add(btnEnviar);
		panel.add(campoNss);panel.add(campoNombre);panel.add(campoSamgre);panel.add(campoGenero);panel.add(campoNacionalidad);panel.add(campoEstCivil);panel.add(campoCel);panel.add(campoEnfermedad);panel.add(campoCurp);
		panel.add(lblTexto);panel.add(lblNombre);panel.add(lblNss);panel.add(lblSangre);panel.add(lblGenero);panel.add(lblNacionalidad);panel.add(lblEstCivil);panel.add(lblCel);panel.add(lblEnfermedad);panel.add(lblCurp);

		panel.add(lblN);panel.add(lblO);panel.add(lblP);

		this.add(panel);
		this.setTitle("Cliente");
		this.setBounds(500,200,600,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent event){
		if(event.getSource() == this.btnEnviar){
			try {
				Socket socket = new Socket("201.170.39.252",9000); //IP del servidor
				ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
				Objeto o = new Objeto(campoNombre.getText(),campoNss.getText(),campoSamgre.getText(),campoGenero.getText(),campoNacionalidad.getText(),campoEstCivil.getText(),campoCel.getText(),campoEnfermedad.getText(),campoCurp.getText());
				os.writeObject(o);
				os.close();
				campoNombre.setText("");
				campoNss.setText("");
				campoSamgre.setText("");
				campoGenero.setText("");
				campoNacionalidad.setText("");
				campoEstCivil.setText("");
				campoCel.setText("");
				campoEnfermedad.setText("");
				campoCurp.setText("");
				Doctores d = new Doctores();
				this.dispose();
			}catch (Exception e) {
				System.out.println("Error en la conexion");
			}
		}
	}
}
