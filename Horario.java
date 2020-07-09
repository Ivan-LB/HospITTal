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

class Horario extends JFrame implements ActionListener{
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
Boolean seleccionado = new Boolean(true);

JButton agendar;
JComboBox doctores;

boolean confirmado = true;

String [] doctor = {"pepe","Petronila","El Fede","Jairo"};

JButton dia[] = new JButton[24];

	public Horario()
	{

		panel = new JPanel();
		panel.setLayout(null);

		for(int y=1;y<5;y++){
		for (int x=0;x<6;x++,i++) {

			dia[i] = new JButton("Disponible");
			dia[i].setBounds(100*(x+1),100*y,100,100);
			dia[i].addActionListener(this);
			if(seleccionado.equals(true)){
				dia[i].setBackground(Color.BLUE);
			}
			panel.add(dia[i]);
		}
	}

		uno = new JLabel("8:00-10:00",JLabel.CENTER);
		uno.setFont(new Font("Serif", Font.PLAIN, 22));
		uno.setBounds(0,100,100,100);
		uno.setOpaque(false);

		dos = new JLabel("11:00-1:00",JLabel.CENTER);
		dos.setFont(new Font("Serif", Font.PLAIN, 22));
		dos.setBounds(0,200,100,100);
		dos.setOpaque(false);

		tres = new JLabel("1:00-3:00",JLabel.CENTER);
		tres.setFont(new Font("Serif", Font.PLAIN, 24));
		tres.setBounds(0,300,100,100);
		tres.setOpaque(false);

		cuatro = new JLabel("3:00-5:00",JLabel.CENTER);
		cuatro.setFont(new Font("Serif", Font.PLAIN, 24));
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


		this.add(panel);


		SwingUtilities.updateComponentTreeUI(this);
		this.pack();
		this.setTitle("CREA TU CITA");
		this.setBounds(20,40,760,720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(null);

	}

public void actionPerformed(ActionEvent event)
	 {
		 if(event.getSource() == this.dia[0])
		 {
			 if(seleccionado.equals(true)){
				 dia[0].setBackground(Color.RED);
				 seleccionado = false;
			 }else if(seleccionado.equals(false)){
				 dia[0].setBackground(Color.GREEN);
				 seleccionado = true;
			 }
		 }

		 	if(event.getSource() == this.dia[1])
			{
				if(seleccionado.equals(true)){
		 		 dia[1].setBackground(Color.RED);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[1].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}

			else if(event.getSource() == this.dia[2])
			{
				if(seleccionado.equals(true)){
		 		 dia[2].setBackground(Color.RED);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[2].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}

			else if(event.getSource() == this.dia[3])
			{
				if(seleccionado.equals(true)){
		 		 dia[3].setBackground(Color.RED);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[3].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}

			else if(event.getSource() == this.dia[4])
			{
				if(seleccionado.equals(true)){
		 		 dia[4].setBackground(Color.RED);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[4].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}

			else if(event.getSource() == this.dia[5])
			{
				if(seleccionado.equals(true)){
		 		 dia[5].setBackground(Color.RED);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[5].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}

			else if(event.getSource() == this.dia[6])
			{
				if(seleccionado.equals(true)){
		 		 dia[6].setBackground(Color.RED);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[6].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}

			else if(event.getSource() == this.dia[7])
			{
				if(seleccionado.equals(true)){
		 		 dia[7].setBackground(Color.RED);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[7].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}

			else if(event.getSource() == this.dia[8])
			{
				if(seleccionado.equals(true)){
		 		 dia[8].setBackground(Color.RED);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[8].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}

			else if(event.getSource() == this.dia[9])
			{
				if(seleccionado.equals(true)){
		 		 dia[9].setBackground(Color.RED);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[9].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}

			else if(event.getSource() == this.dia[10])
			{
				if(seleccionado.equals(true)){
		 		 dia[10].setBackground(Color.RED);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[10].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}

			else if(event.getSource() == this.dia[11])
			{
				if(seleccionado.equals(true)){
		 		 dia[11].setBackground(Color.RED);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[11].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}

			else if(event.getSource() == this.dia[12])
			{
				if(seleccionado.equals(true)){
		 		 dia[12].setBackground(Color.RED);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[12].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}

			else if(event.getSource() == this.dia[13])
			{
				if(seleccionado.equals(true)){
		 		 dia[13].setBackground(Color.RED);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[13].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}

			else if(event.getSource() == this.dia[14])
			{
				if(seleccionado.equals(true)){
		 		 dia[14].setBackground(Color.RED);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[14].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}

			else if(event.getSource() == this.dia[15])
			{
				if(seleccionado.equals(true)){
		 		 dia[15].setBackground(Color.RED);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[15].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}

			else if(event.getSource() == this.dia[16])
			{
				if(seleccionado.equals(true)){
		 		 dia[16].setBackground(Color.RED);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[16].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}

			else if(event.getSource() == this.dia[17])
			{
				if(seleccionado.equals(true)){
		 		 dia[17].setBackground(Color.RED);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[17].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}

			else if(event.getSource() == this.dia[18])
			{
				if(seleccionado.equals(true)){
		 		 dia[18].setBackground(Color.RED);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[18].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}

			else if(event.getSource() == this.dia[19])
			{
				if(seleccionado.equals(true)){
		 		 dia[19].setBackground(Color.RED);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[19].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}

			else if(event.getSource() == this.dia[20])
			{
				if(seleccionado.equals(true)){
		 		 dia[20].setBackground(Color.BLUE);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[20].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}

			else if(event.getSource() == this.dia[21])
			{
				if(seleccionado.equals(true)){
		 		 dia[21].setBackground(Color.BLUE);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[21].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}

			else if(event.getSource() == this.dia[22])
			{
				if(seleccionado.equals(true)){
		 		 dia[22].setBackground(Color.BLUE);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[22].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}

			else if(event.getSource() == this.dia[23])
			{
				if(seleccionado.equals(true)){
		 		 dia[23].setBackground(Color.BLUE);
		 		 seleccionado = false;
		 	 }else if(seleccionado.equals(false)){
		 		 dia[23].setBackground(Color.GREEN);
		 		 seleccionado = true;
		 	 }
			}
/*
confirmar: imprimir en consola SampleDate
Archivo de texto, se detecte los seleccionados con anterioridad

*/

}

}
