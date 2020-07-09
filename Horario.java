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

JButton agendar;
JComboBox doctores;

String [] doctor = {"pepe","Petronila","El Fede","Jairo"};

JButton dia[] = new JButton[6];

	public Horario()
	{
    panel = new JPanel();
    panel.setLayout(null);

		for (int x=0;x<dia.length;x++) {
			dia[x] = new JButton("Disponible");
			dia[x].setBounds(100*(x+1),100,100,100);
			dia[x].addActionListener(this);
			panel.add(dia[x]);
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

		agendar.addActionListener(this);
	}

public void actionPerformed(ActionEvent event){


	}


}
