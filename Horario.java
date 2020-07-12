package aplicacion.cliente;

import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import java.lang.*;
import java.net.*;
import java.util.*;
import aplicacion.utilerias.Archivo;
import aplicacion.utilerias.ColoredToggleButton;

class Horario extends JFrame implements ActionListener,ItemListener{
	public JPanel panel;
	public JLabel uno;
	public JLabel dos;
	public JLabel tres;
	public JLabel cuatro;
	public JLabel l;
	public JLabel m;
	public JLabel mi;
	public JLabel ju;
	public JLabel vi;
	public JLabel sa;
	public JLabel instrucciones;
	public int i=0;
	public Color azulOscuro = new Color (7,3,26);
	public int numeroEnviar = -1;
	public String fechaFinal;
	public JComboBox doctores;
	public JButton btnEnviar;
	public String nombreDoctor;
	public int antiNull = 0;
	public boolean confirmado = true;
	public String [] doctor = {"pepe","Petronila","El Fede","Jairo"};
	public Boolean seleccionado = new Boolean(false);
	public ColoredToggleButton dia[] = new ColoredToggleButton[24];
	public ArrayList<String> arrayCitas;
	public ArrayList<String> datosPaciente = new ArrayList<>();
	public JButton salir;
	public String paciente;
	public int numUsers;
	public Horario(String nombreDoctor, String paciente, int numUser)
	{
		this.nombreDoctor=nombreDoctor;
		this.paciente = paciente;
		this.numUsers = numUser;
		panel = new JPanel();
		panel.setLayout(null);

		panel.setBackground(azulOscuro);

		instrucciones = new JLabel("Todas las fechas estan agendadas para la siguiente semana.",JLabel.CENTER);
		instrucciones.setFont(new Font("Serif", Font.PLAIN, 18));
		instrucciones.setBounds(100,600,600,100);
		instrucciones.setOpaque(false);
		instrucciones.setForeground(Color.white);

		for(int y=1;y<5;y++){
				for (int x=0;x<6;x++,i++) {
					dia[i] = new ColoredToggleButton();
					dia[i].setBounds(100*(x+1),100*y,100,100);
					//dia[i].addActionListener(this);
					dia[i].addItemListener(this);
					if(seleccionado.equals(true)){
						dia[i].setBackground(Color.BLUE);
					}
				panel.add(dia[i]);
			}
		}

		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(300,550,200,50);

		this.btnEnviar.setEnabled(false);
		btnEnviar.setBackground(Color.darkGray);

		uno = new JLabel("8:00-10:00",JLabel.CENTER);
		uno.setFont(new Font("Serif", Font.PLAIN, 20));
		uno.setBounds(0,100,100,100);
		uno.setOpaque(false);
		uno.setForeground(Color.white);

		dos = new JLabel("11:00-1:00",JLabel.CENTER);
		dos.setFont(new Font("Serif", Font.PLAIN, 20));
		dos.setBounds(0,200,100,100);
		dos.setOpaque(false);
		dos.setForeground(Color.white);

		tres = new JLabel("1:00-3:00",JLabel.CENTER);
		tres.setFont(new Font("Serif", Font.PLAIN, 20));
		tres.setBounds(0,300,100,100);
		tres.setOpaque(false);
		tres.setForeground(Color.white);

		cuatro = new JLabel("3:00-5:00",JLabel.CENTER);
		cuatro.setFont(new Font("Serif", Font.PLAIN, 20));
		cuatro.setBounds(0,400,100,100);
		cuatro.setOpaque(false);
		cuatro.setForeground(Color.white);

		l = new JLabel("Lu",JLabel.CENTER);
		l.setFont(new Font("Serif", Font.PLAIN, 24));
		l.setBounds(100,0,100,100);
		l.setOpaque(false);
		l.setForeground(Color.white);

		m = new JLabel("Ma",JLabel.CENTER);
		m.setFont(new Font("Serif", Font.PLAIN, 24));
		m.setBounds(200,0,100,100);
		m.setOpaque(false);
		m.setForeground(Color.white);

		mi = new JLabel("Mi",JLabel.CENTER);
		mi.setFont(new Font("Serif", Font.PLAIN, 24));
		mi.setBounds(300,0,100,100);
		mi.setOpaque(false);
		mi.setForeground(Color.white);

		ju = new JLabel("Ju",JLabel.CENTER);
		ju.setFont(new Font("Serif", Font.PLAIN, 24));
		ju.setBounds(400,0,100,100);
		ju.setOpaque(false);
		ju.setForeground(Color.white);

		vi = new JLabel("Vi",JLabel.CENTER);
		vi.setFont(new Font("Serif", Font.PLAIN, 24));
		vi.setBounds(500,0,100,100);
		vi.setOpaque(false);
		vi.setForeground(Color.white);

		sa = new JLabel("Sa",JLabel.CENTER);
		sa.setFont(new Font("Serif", Font.PLAIN, 24));
		sa.setBounds(600,0,100,100);
		sa.setOpaque(false);
		sa.setForeground(Color.white);

		salir = new JButton("Salir");
		salir.setFont(new Font("Serif", Font.PLAIN, 11));
		salir.setBounds(584,578,100,40);
		salir.setOpaque(false);
		salir.setForeground(Color.BLACK);
		salir.setVisible(false);

		panel.add(uno);
		panel.add(dos);
		panel.add(tres);
		panel.add(cuatro);
		panel.add(l);
		panel.add(m);
		panel.add(mi);
		panel.add(ju);
		panel.add(vi);
		panel.add(sa);
		panel.add(btnEnviar);
		panel.add(instrucciones);
		panel.add(salir);
		btnEnviar.addActionListener(this);
		salir.addActionListener(this);
		this.add(panel);
		this.btnEnviar.setEnabled(false);
		SwingUtilities.updateComponentTreeUI(this);
		this.pack();
		this.setTitle("CREA TU CITA");
		this.setBounds(700,400,760,760);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(null);
		checarCitasPRO();

	}

	public void checarCitasPRO(){
		arrayCitas = new ArrayList<String>();
		switch(this.nombreDoctor){
			case "Jairo Lopez":
				arrayCitas = Archivo.leerTodo("./Citas/Lista1.txt");
				if(arrayCitas!=null){
					Collections.reverse(arrayCitas);
					for(int lp=0; lp<arrayCitas.size(); lp++){
						for(int j=0; j<24; j++) {
							if(Integer.parseInt(arrayCitas.get(lp)) == j){
								dia[j].setBackground(Color.RED);
								dia[j].setEnabled(false);
								dia[j].desactivar(false);
							}
						}
					}
				}
			break;
			case "Pepe Aguilar":
				arrayCitas = new ArrayList<String>();
				arrayCitas = Archivo.leerTodo("./Citas/Lista2.txt");
				if(arrayCitas!=null){
					Collections.reverse(arrayCitas);
					for(int lp=0; lp<arrayCitas.size(); lp++){
						for(int j=0; j<24; j++) {
							if(Integer.parseInt(arrayCitas.get(lp)) == j){
								dia[j].setBackground(Color.RED);
								dia[j].setEnabled(false);
								dia[j].desactivar(false);
							}
						}
					}
				}
			break;
			case "Dante Cambrano":
			arrayCitas = new ArrayList<String>();
			arrayCitas = Archivo.leerTodo("./Citas/Lista3.txt");
			if(arrayCitas!=null){
				Collections.reverse(arrayCitas);
				for(int lp=0; lp<arrayCitas.size(); lp++){
					for(int j=0; j<24; j++) {
						if(Integer.parseInt(arrayCitas.get(lp)) == j){
							dia[j].setBackground(Color.RED);
							dia[j].setEnabled(false);
							dia[j].desactivar(false);
						}
					}
				}
			}
			break;
			case "Estefania Alba":
			arrayCitas = new ArrayList<String>();
			arrayCitas = Archivo.leerTodo("./Citas/Lista4.txt");
			if(arrayCitas!=null){
				Collections.reverse(arrayCitas);
				for(int lp=0; lp<arrayCitas.size(); lp++){
					for(int j=0; j<24; j++) {
						if(Integer.parseInt(arrayCitas.get(lp)) == j){
							dia[j].setBackground(Color.RED);
							dia[j].setEnabled(false);
							dia[j].desactivar(false);
						}
					}
				}
			}
			break;
		}
	}

	public void itemStateChanged(ItemEvent e){
		for(int g=0;g<24;g++){
		 if(this.dia[g].isSelected()){
			 SwingUtilities.updateComponentTreeUI(dia[g]);
			 disableOthers(g);
			 numeroEnviar = g;
			 break;
		 }else if (!this.dia[g].isSelected()){
			 SwingUtilities.updateComponentTreeUI(dia[g]);
			 enableOthers();
		 }
	 }
	}

public void actionPerformed(ActionEvent event){
		 	if(event.getSource() == this.btnEnviar){
				switch (numeroEnviar)
				{
					case 0:
					fechaFinal = ("Lunes " + uno.getText());
					break;

					case 1:
					fechaFinal = ("Martes " + uno.getText());
					break;

					case 2:
					fechaFinal = ("Miercoles " + uno.getText());
					break;

					case 3:
					fechaFinal = ("Jueves " + uno.getText());
					break;

					case 4:
					fechaFinal = ("Viernes " + uno.getText());
					break;

					case 5:
					fechaFinal = ("Sabado " + uno.getText());
					break;

					case 6:
					fechaFinal = ("Lunes " + dos.getText());
					break;

					case 7:
					fechaFinal = ("Martes " + dos.getText());
					break;

					case 8:
					fechaFinal = ("Miercoles " + dos.getText());
					break;

					case 9:
					fechaFinal = ("Jueves " + dos.getText());
					break;

					case 10:
					fechaFinal = ("Viernes " + dos.getText());
					break;

					case 11:
					fechaFinal = ("Sabado " + dos.getText());
					break;

					case 12:
					fechaFinal = ("Lunes " + tres.getText());
					break;

					case 13:
					fechaFinal = ("Martes " + tres.getText());
					break;

					case 14:
					fechaFinal = ("Miercoles " + tres.getText());
					break;

					case 15:
					fechaFinal = ("Jueves " + tres.getText());
					break;

					case 16:
					fechaFinal = ("Viernes " + tres.getText());
					break;

					case 17:
					fechaFinal = ("Sabado " + tres.getText());
					break;

					case 18:
					fechaFinal = ("Lunes " + cuatro.getText());
					break;

					case 19:
					fechaFinal = ("Martes " + cuatro.getText());
					break;

					case 20:
					fechaFinal = ("Miercoles " + cuatro.getText());
					break;

					case 21:
					fechaFinal = ("Jueves " + cuatro.getText());
					break;

					case 22:
					fechaFinal = ("Viernes " + cuatro.getText());
					break;

					case 23:
					fechaFinal = ("Sabado " + cuatro.getText());
					break;
				}
				if (JOptionPane.showConfirmDialog(null, "Su cita ha sido agenda para "+fechaFinal+"\nCon el doctor/a "+nombreDoctor, "Cita Agendada",
				   JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

					disableAll();
					btnEnviar.setEnabled(false);
					salir.setVisible(true);
					switch(this.nombreDoctor){
						case "Jairo Lopez":
							arrayCitas.add(Integer.toString(numeroEnviar));
							Archivo.guardarTodo(arrayCitas,"Lista1.txt");
							datosPaciente.add("Su cita es: "+fechaFinal);
							datosPaciente.add("Doctor: "+nombreDoctor);
							datosPaciente.add("Favor de Presentarse en el consultorio 1");
							Archivo.CrearArchivo(datosPaciente,paciente);
						break;
						case "Pepe Aguilar":
							arrayCitas.add(Integer.toString(numeroEnviar));
							Archivo.guardarTodo(arrayCitas,"Lista2.txt");
							datosPaciente.add("Su cita es: "+fechaFinal);
							datosPaciente.add("Doctor: "+nombreDoctor);
							datosPaciente.add("Favor de Presentarse en el consultorio 2");
							Archivo.CrearArchivo(datosPaciente,paciente);
						break;
						case "Dante Cambrano":
							arrayCitas.add(Integer.toString(numeroEnviar));
							Archivo.guardarTodo(arrayCitas,"Lista3.txt");
							datosPaciente.add("Su cita es: "+fechaFinal);
							datosPaciente.add("Doctor: "+nombreDoctor);
							datosPaciente.add("Favor de Presentarse en el consultorio 3");
							Archivo.CrearArchivo(datosPaciente,paciente);
						break;
						case "Estefania Alba":
							arrayCitas.add(Integer.toString(numeroEnviar));
							Archivo.guardarTodo(arrayCitas,"Lista4.txt");
							datosPaciente.add("Su cita es: "+fechaFinal);
							datosPaciente.add("Doctor: "+nombreDoctor);
							datosPaciente.add("Favor de Presentarse en el consultorio 4");
							Archivo.CrearArchivo(datosPaciente,paciente);
						break;
					}
				} else {
						System.out.println("Continuar operacion");
				}
			}
			else if(event.getSource() == this.salir){
				PerfilUsuario pu = new PerfilUsuario(paciente,numUsers);
					System.exit(0);
			}
}
public void disableOthers(int number){
		this.btnEnviar.setEnabled(true);
		btnEnviar.setBackground(Color.white);
		for(int l=0;l<24;l++)
		{
			dia[l].setEnabled(false);
		}
		 dia[number].setEnabled(true);
}

public void disableAll(){
		this.btnEnviar.setEnabled(true);
		btnEnviar.setBackground(Color.white);
		for(int l=0;l<24;l++)
		{
			dia[l].setEnabled(false);
		}
}

public void enableOthers(){
	this.btnEnviar.setEnabled(false);
	btnEnviar.setBackground(Color.darkGray);
	for(int l=0;l<24;l++){
		dia[l].setEnabled(true);
	}
	checarCitasPRO();
}

}
