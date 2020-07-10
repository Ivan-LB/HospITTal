import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import java.lang.*;
import java.net.*;
import java.util.Date;
import java.text.SimpleDateFormat;

class Horario extends JFrame implements ActionListener,ItemListener{
//OBJETOS
JPanel panel;
JLabel uno;
JLabel dos;
JLabel tres;
JLabel cuatro;
JLabel l;
JLabel m;
JLabel mi;
JLabel ju;
JLabel vi;
JLabel sa;
int i=0;

public int numeroEnviar = -1;

JComboBox doctores;
JButton btnEnviar;
boolean confirmado = true;
String [] doctor = {"pepe","Petronila","El Fede","Jairo"};
Boolean seleccionado = new Boolean(false);
ColoredToggleButton dia[] = new ColoredToggleButton[24];
// ArrayList<Integer> arrayCitas = new ArrayList<>();
	public Horario()
	{

		panel = new JPanel();
		panel.setLayout(null);

		for(int y=1;y<5;y++){
				for (int x=0;x<6;x++,i++) {
					dia[i] = new ColoredToggleButton("Disponible");
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
		btnEnviar.setBounds(200,500,200,50);

		uno = new JLabel("8:00-10:00",JLabel.CENTER);
		uno.setFont(new Font("Serif", Font.PLAIN, 20));
		uno.setBounds(0,100,100,100);
		uno.setOpaque(false);

		dos = new JLabel("11:00-1:00",JLabel.CENTER);
		dos.setFont(new Font("Serif", Font.PLAIN, 20));
		dos.setBounds(0,200,100,100);
		dos.setOpaque(false);

		tres = new JLabel("1:00-3:00",JLabel.CENTER);
		tres.setFont(new Font("Serif", Font.PLAIN, 20));
		tres.setBounds(0,300,100,100);
		tres.setOpaque(false);

		cuatro = new JLabel("3:00-5:00",JLabel.CENTER);
		cuatro.setFont(new Font("Serif", Font.PLAIN, 20));
		cuatro.setBounds(0,400,100,100);
		cuatro.setOpaque(false);

		l = new JLabel("Lu",JLabel.CENTER);
		l.setFont(new Font("Serif", Font.PLAIN, 24));
		l.setBounds(100,0,100,100);
		l.setOpaque(false);

		m = new JLabel("Ma",JLabel.CENTER);
		m.setFont(new Font("Serif", Font.PLAIN, 24));
		m.setBounds(200,0,100,100);
		m.setOpaque(false);

		mi = new JLabel("Mi",JLabel.CENTER);
		mi.setFont(new Font("Serif", Font.PLAIN, 24));
		mi.setBounds(300,0,100,100);
		mi.setOpaque(false);

		ju = new JLabel("Ju",JLabel.CENTER);
		ju.setFont(new Font("Serif", Font.PLAIN, 24));
		ju.setBounds(400,0,100,100);
		ju.setOpaque(false);

		vi = new JLabel("Vi",JLabel.CENTER);
		vi.setFont(new Font("Serif", Font.PLAIN, 24));
		vi.setBounds(500,0,100,100);
		vi.setOpaque(false);

		sa = new JLabel("Sa",JLabel.CENTER);
		sa.setFont(new Font("Serif", Font.PLAIN, 24));
		sa.setBounds(600,0,100,100);
		sa.setOpaque(false);

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

		btnEnviar.addActionListener(this);

		this.add(panel);

		this.btnEnviar.setEnabled(false);

		SwingUtilities.updateComponentTreeUI(this);
		this.pack();
		this.setTitle("CREA TU CITA");
		this.setBounds(20,40,760,760);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(null);

	}
	// public void checarArrayList(){
	// 	for(int i=0; i<arrayCitas.size(); i++){
	// 		for(int j=0; j<25; j++) {
	// 			if(arrayCitas.get(i).equals(j)){
	// 				dia[i].setBackground(Color.RED);
	// 				dia[i].removeItemListener();
	// 			}
	// 		}
	// 	}
	// }
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
				System.out.println(numeroEnviar);
			}

}

public void disableOthers(int number){
		this.btnEnviar.setEnabled(true);
		for(int l=0;l<24;l++)
		{
			dia[l].setEnabled(false);
			System.out.println("dis "+l);
		}
		 dia[number].setEnabled(true);
		 System.out.println("app"+number);
}
public void enableOthers(){
	this.btnEnviar.setEnabled(false);
	for(int l=0;l<24;l++){
		dia[l].setEnabled(true);
		System.out.println("todos"+l);
	}
}
}
