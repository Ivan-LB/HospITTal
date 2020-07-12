package aplicacion.cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Doctores extends JFrame implements ActionListener{

	JButton btnDoc1;
	JButton btnDoc2;
	JButton btnDoc3;
	JButton btnDoc4;
  JButton btnAC1;JButton btnAC2;JButton btnAC3;JButton btnAC4;
	JPanel panel;
  JLabel pl;
	String paciente;


	boolean t1= false;
	boolean t2= false;
	boolean t3= false;
	boolean t4= false;
	boolean t5= false;

  JLabel top; JLabel end;
  JLabel nombre= new JLabel ("Nombre:",SwingConstants.CENTER);
  JLabel especialidad= new JLabel("Especialidad:",SwingConstants.CENTER);
  JLabel turno= new JLabel("Turno:",SwingConstants.CENTER);
  JLabel cedula= new JLabel("Cedula:",SwingConstants.CENTER);
  JLabel escuela= new JLabel("Escuela:",SwingConstants.CENTER);


   JLabel lbl1;JLabel doc1Nombre; JLabel doc1Esp; JLabel doc1Turno; JLabel doc1Cedula;JLabel doc1Escuela;
   JLabel lbl2;JLabel doc2Nombre; JLabel doc2Esp; JLabel doc2Turno; JLabel doc2Cedula;JLabel doc2Escuela;
   JLabel lbl3;JLabel doc3Nombre; JLabel doc3Esp; JLabel doc3Turno; JLabel doc3Cedula;JLabel doc3Escuela;
   JLabel lbl4;JLabel doc4Nombre; JLabel doc4Esp; JLabel doc4Turno; JLabel doc4Cedula;JLabel doc4Escuela;

    Color color1= new Color(7,3,26);//Azul oscuro
    Color color2= new Color(255,203,116);//AMARILLO
    Color color3= new Color(79,138,139);// Azul claro
    Color color4= new Color(244,246,255);// blanco azulado


	public Doctores(String paciente){
			this.paciente = paciente;
			System.out.println(this.paciente);
    	panel = new JPanel();
    	panel.setLayout(null);
      panel.setBackground(color1);
    	// foto de doctores
    	lbl1=new JLabel(new ImageIcon(((new ImageIcon("./imagenes/D1.jpg")).getImage()).getScaledInstance(80,120,java.awt.Image.SCALE_SMOOTH)));
 		  lbl1.setBounds(60,120,80,140);

      lbl2=new JLabel(new ImageIcon(((new ImageIcon("./imagenes/D2.jpg")).getImage()).getScaledInstance(80,120,java.awt.Image.SCALE_SMOOTH)));
      lbl2.setBounds(60,120,80,140);

      lbl3=new JLabel(new ImageIcon(((new ImageIcon("./imagenes/D3.jpg")).getImage()).getScaledInstance(80,120,java.awt.Image.SCALE_SMOOTH)));
      lbl3.setBounds(60,120,80,140);

      lbl4=new JLabel(new ImageIcon(((new ImageIcon("./imagenes/D4.jpg")).getImage()).getScaledInstance(80,120,java.awt.Image.SCALE_SMOOTH)));
      lbl4.setBounds(60,120,80,140);

      //etiquetas;
      nombre.setBounds(200,90,80,30);
      nombre.setBackground(color2);
      nombre.setOpaque(true);
      especialidad.setBounds(200,130,80,30);
      especialidad.setBackground(color2);
      especialidad.setOpaque(true);
      turno.setBounds(200,170,80,30);
      turno.setBackground(color2);
      turno.setOpaque(true);
      cedula.setBounds(200,210,80,30);
      cedula.setBackground(color2);
      cedula.setOpaque(true);
      escuela.setBounds(200,250,80,30);
      escuela.setBackground(color2);
      escuela.setOpaque(true);
			nombre.setVisible(t5);especialidad.setVisible(t5);turno.setVisible(t5);cedula.setVisible(t5);escuela.setVisible(t5);

    	//Descripcion de los doctores

    	doc1Nombre= new JLabel("Jairo Lopez",SwingConstants.CENTER);
    	doc1Nombre.setBounds(290,90,150,30);
      doc1Nombre.setBackground(color4);
      doc1Nombre.setOpaque(true);
    	doc1Esp = new JLabel("Cardiologo",SwingConstants.CENTER);
    	doc1Esp.setBounds(290,130,150,30);
      doc1Esp.setBackground(color4);
      doc1Esp.setOpaque(true);
    	doc1Turno= new JLabel("Matutino",SwingConstants.CENTER);
    	doc1Turno.setBounds(290,170,150,30);
      doc1Turno.setBackground(color4);
      doc1Turno.setOpaque(true);
    	doc1Cedula= new JLabel("Cedula",SwingConstants.CENTER);
    	doc1Cedula.setBounds(290,210,150,30);
      doc1Cedula.setBackground(color4);
      doc1Cedula.setOpaque(true);
    	doc1Escuela= new JLabel("UABC-TJ",SwingConstants.CENTER);
    	doc1Escuela.setBounds(290,250,150,30);
      doc1Escuela.setBackground(color4);
      doc1Escuela.setOpaque(true);

    	lbl1.setVisible(t1);doc1Nombre.setVisible(t1);doc1Esp.setVisible(t1);doc1Turno.setVisible(t1);doc1Cedula.setVisible(t1);doc1Escuela.setVisible(t1);

    	doc2Nombre= new JLabel("Pepe Aguilar",SwingConstants.CENTER);
      doc2Nombre.setBounds(290,90,150,30);
      doc2Nombre.setBackground(color4);
      doc2Nombre.setOpaque(true);
    	doc2Esp = new JLabel("Traumatologo",SwingConstants.CENTER);
    	doc2Esp.setBounds(290,130,150,30);
      doc2Esp.setBackground(color4);
      doc2Esp.setOpaque(true);
    	doc2Turno= new JLabel("Vespertino",SwingConstants.CENTER);
    	doc2Turno.setBounds(290,170,150,30);
      doc2Turno.setBackground(color4);
      doc2Turno.setOpaque(true);
    	doc2Cedula= new JLabel("Cedula",SwingConstants.CENTER);
    	doc2Cedula.setBounds(290,210,150,30);
      doc2Cedula.setBackground(color4);
      doc2Cedula.setOpaque(true);
    	doc2Escuela= new JLabel("UABC-TJ",SwingConstants.CENTER);
    	doc2Escuela.setBounds(290,250,150,30);
      doc2Escuela.setBackground(color4);
      doc2Escuela.setOpaque(true);

    	lbl2.setVisible(t2);doc2Nombre.setVisible(t2);doc2Esp.setVisible(t2);doc2Turno.setVisible(t2);doc2Cedula.setVisible(t2);doc2Escuela.setVisible(t2);

    	doc3Nombre= new JLabel("Dante Cambrano",SwingConstants.CENTER);
    	doc3Nombre.setBounds(290,90,150,30);
      doc3Nombre.setBackground(color4);
      doc3Nombre.setOpaque(true);
    	doc3Esp = new JLabel("Pediatra",SwingConstants.CENTER);
    	doc3Esp.setBounds(290,130,150,30);
      doc3Esp.setBackground(color4);
      doc3Esp.setOpaque(true);
    	doc3Turno= new JLabel("Matutino",SwingConstants.CENTER);
    	doc3Turno.setBounds(290,170,150,30);
      doc3Turno.setBackground(color4);
      doc3Turno.setOpaque(true);
    	doc3Cedula= new JLabel("Cedula",SwingConstants.CENTER);
    	doc3Cedula.setBounds(290,210,150,30);
      doc3Cedula.setBackground(color4);
      doc3Cedula.setOpaque(true);
    	doc3Escuela= new JLabel("UABC-TJ",SwingConstants.CENTER);
    	doc3Escuela.setBounds(290,250,150,30);
      doc3Escuela.setBackground(color4);
      doc3Escuela.setOpaque(true);

    	lbl3.setVisible(t3);doc3Nombre.setVisible(t3);doc3Esp.setVisible(t3);doc3Turno.setVisible(t3);doc3Cedula.setVisible(t3);doc3Escuela.setVisible(t3);


    	doc4Nombre= new JLabel("Estefania Alba",SwingConstants.CENTER);
    	doc4Nombre.setBounds(290,90,150,30);
      doc4Nombre.setBackground(color4);
      doc4Nombre.setOpaque(true);
    	doc4Esp = new JLabel("Ginecologa",SwingConstants.CENTER);
    	doc4Esp.setBounds(290,130,150,30);
      doc4Esp.setBackground(color4);
      doc4Esp.setOpaque(true);
    	doc4Turno= new JLabel("Matutino",SwingConstants.CENTER);
    	doc4Turno.setBounds(290,170,150,30);
      doc4Turno.setBackground(color4);
      doc4Turno.setOpaque(true);
    	doc4Cedula= new JLabel("Cedula",SwingConstants.CENTER);
    	doc4Cedula.setBounds(290,210,150,30);
      doc4Cedula.setBackground(color4);
      doc4Cedula.setOpaque(true);
    	doc4Escuela= new JLabel("UABC-TJ",SwingConstants.CENTER);
    	doc4Escuela.setBounds(290,250,150,30);
      doc4Escuela.setBackground(color4);
      doc4Escuela.setOpaque(true);

    	lbl4.setVisible(t4);doc4Nombre.setVisible(t4);doc4Esp.setVisible(t4);doc4Turno.setVisible(t4);doc4Cedula.setVisible(t4);doc4Escuela.setVisible(t4);

    	//botones
    	btnDoc1= new JButton("Dr. 1");
    	btnDoc1.setBounds(100,50,70,30);

    	btnDoc2= new JButton("Dr. 2");
    	btnDoc2.setBounds(180,50,70,30);

    	btnDoc3= new JButton("Dr. 3");
    	btnDoc3.setBounds(260,50,70,30);

    	btnDoc4= new JButton("Dr. 4");
    	btnDoc4.setBounds(340,50,70,30);

      btnAC1= new JButton("Agendar cita");
      btnAC1.setBounds(195,340,130,30);
      btnAC1.setVisible(t1);

      btnAC2= new JButton("Agendar cita");
      btnAC2.setBounds(195,340,130,30);
      btnAC2.setVisible(t2);

      btnAC3= new JButton("Agendar cita");
      btnAC3.setBounds(195,340,130,30);
      btnAC3.setVisible(t3);

      btnAC4= new JButton("Agendar cita");
      btnAC4.setBounds(195,340,130,30);
      btnAC4.setVisible(t4);

      top=new JLabel("Seleccione un boton para conocer los datos del Doctor",SwingConstants.CENTER);
      top.setBackground(color3);
      top.setForeground(color4);
      top.setBounds(0,0,525,30);
      top.setOpaque(true);
      end= new JLabel("");
      end.setBackground(color2);
      end.setBounds(0,450,525,10);
      end.setOpaque(true);

      panel.add(top);panel.add(end);
      panel.add(nombre);panel.add(especialidad);panel.add(turno);panel.add(cedula);panel.add(escuela);
    	panel.add(btnDoc1);panel.add(btnDoc2);panel.add(btnDoc3);panel.add(btnDoc4);panel.add(btnAC1);panel.add(btnAC2);panel.add(btnAC3);panel.add(btnAC4);

    	panel.add(lbl1);panel.add(doc1Nombre);panel.add(doc1Esp);panel.add(doc1Turno);panel.add(doc1Cedula);panel.add(doc1Escuela);
    	panel.add(lbl2);panel.add(doc2Nombre);panel.add(doc2Esp);panel.add(doc2Turno);panel.add(doc2Cedula);panel.add(doc2Escuela);
    	panel.add(lbl3);panel.add(doc3Nombre);panel.add(doc3Esp);panel.add(doc3Turno);panel.add(doc3Cedula);panel.add(doc3Escuela);
    	panel.add(lbl4);panel.add(doc4Nombre);panel.add(doc4Esp);panel.add(doc4Turno);panel.add(doc4Cedula);panel.add(doc4Escuela);

    	btnDoc1.addActionListener(this);btnDoc2.addActionListener(this);btnDoc3.addActionListener(this);btnDoc4.addActionListener(this);btnAC1.addActionListener(this);btnAC2.addActionListener(this);btnAC3.addActionListener(this);btnAC4.addActionListener(this);

    this.add(panel);
		this.setTitle("Lista de Doctores");
		this.setBounds(500,200,525,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

  public void actionPerformed(ActionEvent event){
  	if(event.getSource() == this.btnDoc1) {
  		t1=true; t2=false;t3=false;t4=false;t5= true;
			nombre.setVisible(t5);especialidad.setVisible(t5);turno.setVisible(t5);cedula.setVisible(t5);escuela.setVisible(t5);
      btnAC1.setVisible(t1);btnAC2.setVisible(t2);btnAC3.setVisible(t3);btnAC4.setVisible(t4);
  	  lbl1.setVisible(t1);doc1Nombre.setVisible(t1);doc1Esp.setVisible(t1);doc1Turno.setVisible(t1);doc1Cedula.setVisible(t1);doc1Escuela.setVisible(t1);
  		lbl2.setVisible(t2);doc2Nombre.setVisible(t2);doc2Esp.setVisible(t2);doc2Turno.setVisible(t2);doc2Cedula.setVisible(t2);doc2Escuela.setVisible(t2);
  		lbl3.setVisible(t3);doc3Nombre.setVisible(t3);doc3Esp.setVisible(t3);doc3Turno.setVisible(t3);doc3Cedula.setVisible(t3);doc3Escuela.setVisible(t3);
  		lbl4.setVisible(t4);doc4Nombre.setVisible(t4);doc4Esp.setVisible(t4);doc4Turno.setVisible(t4);doc4Cedula.setVisible(t4);doc4Escuela.setVisible(t4);
  	}
  	if(event.getSource() == this.btnDoc2){
  		t2=true;t1=false;t3=false;t4=false;t5= true;
			nombre.setVisible(t5);especialidad.setVisible(t5);turno.setVisible(t5);cedula.setVisible(t5);escuela.setVisible(t5);
      btnAC1.setVisible(t1);btnAC2.setVisible(t2);btnAC3.setVisible(t3);btnAC4.setVisible(t4);
  		lbl1.setVisible(t1);doc1Nombre.setVisible(t1);doc1Esp.setVisible(t1);doc1Turno.setVisible(t1);doc1Cedula.setVisible(t1);doc1Escuela.setVisible(t1);
  		lbl2.setVisible(t2);doc2Nombre.setVisible(t2);doc2Esp.setVisible(t2);doc2Turno.setVisible(t2);doc2Cedula.setVisible(t2);doc2Escuela.setVisible(t2);
  		lbl3.setVisible(t3);doc3Nombre.setVisible(t3);doc3Esp.setVisible(t3);doc3Turno.setVisible(t3);doc3Cedula.setVisible(t3);doc3Escuela.setVisible(t3);
  		lbl4.setVisible(t4);doc4Nombre.setVisible(t4);doc4Esp.setVisible(t4);doc4Turno.setVisible(t4);doc4Cedula.setVisible(t4);doc4Escuela.setVisible(t4);

  	}
  	if (event.getSource() == this.btnDoc3) {
  		t3=true;t1=false;t2=false;t4=false;t5= true;
			nombre.setVisible(t5);especialidad.setVisible(t5);turno.setVisible(t5);cedula.setVisible(t5);escuela.setVisible(t5);
      btnAC1.setVisible(t1);btnAC2.setVisible(t2);btnAC3.setVisible(t3);btnAC4.setVisible(t4);
  		lbl1.setVisible(t1);doc1Nombre.setVisible(t1);doc1Esp.setVisible(t1);doc1Turno.setVisible(t1);doc1Cedula.setVisible(t1);doc1Escuela.setVisible(t1);
  		lbl2.setVisible(t2);doc2Nombre.setVisible(t2);doc2Esp.setVisible(t2);doc2Turno.setVisible(t2);doc2Cedula.setVisible(t2);doc2Escuela.setVisible(t2);
  		lbl3.setVisible(t3);doc3Nombre.setVisible(t3);doc3Esp.setVisible(t3);doc3Turno.setVisible(t3);doc3Cedula.setVisible(t3);doc3Escuela.setVisible(t3);
  		lbl4.setVisible(t4);doc4Nombre.setVisible(t4);doc4Esp.setVisible(t4);doc4Turno.setVisible(t4);doc4Cedula.setVisible(t4);doc4Escuela.setVisible(t4);
  	}
  	if (event.getSource() == this.btnDoc4) {
  		t4=true;t1=false;t2=false;t3=false;t5= true;
			nombre.setVisible(t5);especialidad.setVisible(t5);turno.setVisible(t5);cedula.setVisible(t5);escuela.setVisible(t5);
      btnAC1.setVisible(t1);btnAC2.setVisible(t2);btnAC3.setVisible(t3);btnAC4.setVisible(t4);
  		lbl1.setVisible(t1);doc1Nombre.setVisible(t1);doc1Esp.setVisible(t1);doc1Turno.setVisible(t1);doc1Cedula.setVisible(t1);doc1Escuela.setVisible(t1);
  		lbl2.setVisible(t2);doc2Nombre.setVisible(t2);doc2Esp.setVisible(t2);doc2Turno.setVisible(t2);doc2Cedula.setVisible(t2);doc2Escuela.setVisible(t2);
  		lbl3.setVisible(t3);doc3Nombre.setVisible(t3);doc3Esp.setVisible(t3);doc3Turno.setVisible(t3);doc3Cedula.setVisible(t3);doc3Escuela.setVisible(t3);
  		lbl4.setVisible(t4);doc4Nombre.setVisible(t4);doc4Esp.setVisible(t4);doc4Turno.setVisible(t4);doc4Cedula.setVisible(t4);doc4Escuela.setVisible(t4);
  	}
    if (event.getSource()== this.btnAC1) {
			Horario h = new Horario(doc1Nombre.getText(),this.paciente);

    }
    if (event.getSource()== this.btnAC2) {
			Horario h = new Horario(doc2Nombre.getText(),this.paciente);

    }
    if (event.getSource()== this.btnAC3) {
			Horario h = new Horario(doc3Nombre.getText(),this.paciente);

    }
    if (event.getSource()== this.btnAC4) {
			Horario h = new Horario(doc4Nombre.getText(),this.paciente);
    }

  }
}
