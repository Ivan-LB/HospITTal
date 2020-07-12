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

	boolean t1= false;
	boolean t2= false;
	boolean t3= false;
	boolean t4= false;


   JLabel lbl1;JLabel doc1Nombre; JLabel doc1Esp; JLabel doc1Turno; JLabel doc1Cedula;JLabel doc1Escuela;
   JLabel lbl2;JLabel doc2Nombre; JLabel doc2Esp; JLabel doc2Turno; JLabel doc2Cedula;JLabel doc2Escuela;
   JLabel lbl3;JLabel doc3Nombre; JLabel doc3Esp; JLabel doc3Turno; JLabel doc3Cedula;JLabel doc3Escuela;
   JLabel lbl4;JLabel doc4Nombre; JLabel doc4Esp; JLabel doc4Turno; JLabel doc4Cedula;JLabel doc4Escuela;


	public Doctores(){
    	panel = new JPanel();
    	panel.setLayout(null);
    	// foto de doctores
    	lbl1=new JLabel(new ImageIcon(((new ImageIcon("./imagenes/doc1.jpg")).getImage()).getScaledInstance(120,70,java.awt.Image.SCALE_SMOOTH)));
 		  lbl1.setBounds(300,40,120,140);

      lbl2=new JLabel(new ImageIcon(((new ImageIcon("./imagenes/doc2.jpg")).getImage()).getScaledInstance(120,70,java.awt.Image.SCALE_SMOOTH)));
      lbl2.setBounds(300,40,120,140);

      lbl3=new JLabel(new ImageIcon(((new ImageIcon("./imagenes/doc3.jpg")).getImage()).getScaledInstance(120,70,java.awt.Image.SCALE_SMOOTH)));
      lbl3.setBounds(300,40,120,140);

      lbl4=new JLabel(new ImageIcon(((new ImageIcon("./imagenes/doc4.jpg")).getImage()).getScaledInstance(120,70,java.awt.Image.SCALE_SMOOTH)));
      lbl4.setBounds(300,40,120,140);

    	//Descripcion de los doctores

    	doc1Nombre= new JLabel("Jairo");
    	doc1Nombre.setBounds(50,50,80,30);
    	doc1Esp = new JLabel("Cardiologo");
    	doc1Esp.setBounds(50,70,80,30);
    	doc1Turno= new JLabel("Matutino");
    	doc1Turno.setBounds(50,90,80,30);
    	doc1Cedula= new JLabel("tas bn1");
    	doc1Cedula.setBounds(50,110,80,30);
    	doc1Escuela= new JLabel("escuela perrona1");
    	doc1Escuela.setBounds(50,130,110,30);

    	lbl1.setVisible(t1);doc1Nombre.setVisible(t1);doc1Esp.setVisible(t1);doc1Turno.setVisible(t1);doc1Cedula.setVisible(t1);doc1Escuela.setVisible(t1);

    	doc2Nombre= new JLabel("Pepe");
    	doc2Nombre.setBounds(50,50,80,30);
    	doc2Esp = new JLabel("Traumatologo");
    	doc2Esp.setBounds(50,70,80,30);
    	doc2Turno= new JLabel("Vespertino");
    	doc2Turno.setBounds(50,90,80,30);
    	doc2Cedula= new JLabel("tas bn2");
    	doc2Cedula.setBounds(50,110,80,30);
    	doc2Escuela= new JLabel("escuela perrona2");
    	doc2Escuela.setBounds(50,130,110,30);

    	lbl2.setVisible(t2);doc2Nombre.setVisible(t2);doc2Esp.setVisible(t2);doc2Turno.setVisible(t2);doc2Cedula.setVisible(t2);doc2Escuela.setVisible(t2);

    	doc3Nombre= new JLabel("elFEDE");
    	doc3Nombre.setBounds(50,50,80,30);
    	doc3Esp = new JLabel("Pediatra");
    	doc3Esp.setBounds(50,70,80,30);
    	doc3Turno= new JLabel("Matutino");
    	doc3Turno.setBounds(50,90,80,30);
    	doc3Cedula= new JLabel("tas bn3");
    	doc3Cedula.setBounds(50,110,80,30);
    	doc3Escuela= new JLabel("escuela perrona3");
    	doc3Escuela.setBounds(50,130,110,30);

    	lbl3.setVisible(t3);doc3Nombre.setVisible(t3);doc3Esp.setVisible(t3);doc3Turno.setVisible(t3);doc3Cedula.setVisible(t3);doc3Escuela.setVisible(t3);


    	doc4Nombre= new JLabel("Petronila");
    	doc4Nombre.setBounds(50,50,80,30);
    	doc4Esp = new JLabel("Ginecologa");
    	doc4Esp.setBounds(50,70,80,30);
    	doc4Turno= new JLabel("Matutino");
    	doc4Turno.setBounds(50,90,80,30);
    	doc4Cedula= new JLabel("tas bn4");
    	doc4Cedula.setBounds(50,110,80,30);
    	doc4Escuela= new JLabel("escuela perrona4");
    	doc4Escuela.setBounds(50,130,110,30);

    	lbl4.setVisible(t4);doc4Nombre.setVisible(t4);doc4Esp.setVisible(t4);doc4Turno.setVisible(t4);doc4Cedula.setVisible(t4);doc4Escuela.setVisible(t4);

    	//botones
    	btnDoc1= new JButton("Dr. 1");
    	btnDoc1.setBounds(100,10,70,30);

    	btnDoc2= new JButton("Dr. 2");
    	btnDoc2.setBounds(180,10,70,30);

    	btnDoc3= new JButton("Dr. 3");
    	btnDoc3.setBounds(260,10,70,30);

    	btnDoc4= new JButton("Dr. 4");
    	btnDoc4.setBounds(340,10,70,30);

      btnAC1= new JButton("Agendar cita");
      btnAC1.setBounds(195,250,130,30);
      btnAC1.setVisible(t1);

      btnAC2= new JButton("Agendar cita");
      btnAC2.setBounds(195,250,130,30);
      btnAC2.setVisible(t2);

      btnAC3= new JButton("Agendar cita");
      btnAC3.setBounds(195,250,130,30);
      btnAC3.setVisible(t3);

      btnAC4= new JButton("Agendar cita");
      btnAC4.setBounds(195,250,130,30);
      btnAC4.setVisible(t4);


    	panel.add(btnDoc1);panel.add(btnDoc2);panel.add(btnDoc3);panel.add(btnDoc4);panel.add(btnAC1);panel.add(btnAC2);panel.add(btnAC3);panel.add(btnAC4);

    	panel.add(lbl1);panel.add(doc1Nombre);panel.add(doc1Esp);panel.add(doc1Turno);panel.add(doc1Cedula);panel.add(doc1Escuela);
    	panel.add(lbl2);panel.add(doc2Nombre);panel.add(doc2Esp);panel.add(doc2Turno);panel.add(doc2Cedula);panel.add(doc2Escuela);
    	panel.add(lbl3);panel.add(doc3Nombre);panel.add(doc3Esp);panel.add(doc3Turno);panel.add(doc3Cedula);panel.add(doc3Escuela);
    	panel.add(lbl4);panel.add(doc4Nombre);panel.add(doc4Esp);panel.add(doc4Turno);panel.add(doc4Cedula);panel.add(doc4Escuela);

    	btnDoc1.addActionListener(this);btnDoc2.addActionListener(this);btnDoc3.addActionListener(this);btnDoc4.addActionListener(this);btnAC1.addActionListener(this);btnAC2.addActionListener(this);btnAC3.addActionListener(this);btnAC4.addActionListener(this);

    this.add(panel);
		this.setTitle("Lista de Doctores");
		this.setBounds(500,200,525,350);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

  public void actionPerformed(ActionEvent event){
  	if(event.getSource() == this.btnDoc1) {
  		t1=true; t2=false;t3=false;t4=false;

      btnAC1.setVisible(t1);btnAC2.setVisible(t2);btnAC3.setVisible(t3);btnAC4.setVisible(t4);
  	  lbl1.setVisible(t1);doc1Nombre.setVisible(t1);doc1Esp.setVisible(t1);doc1Turno.setVisible(t1);doc1Cedula.setVisible(t1);doc1Escuela.setVisible(t1);
  		lbl2.setVisible(t2);doc2Nombre.setVisible(t2);doc2Esp.setVisible(t2);doc2Turno.setVisible(t2);doc2Cedula.setVisible(t2);doc2Escuela.setVisible(t2);
  		lbl3.setVisible(t3);doc3Nombre.setVisible(t3);doc3Esp.setVisible(t3);doc3Turno.setVisible(t3);doc3Cedula.setVisible(t3);doc3Escuela.setVisible(t3);
  		lbl4.setVisible(t4);doc4Nombre.setVisible(t4);doc4Esp.setVisible(t4);doc4Turno.setVisible(t4);doc4Cedula.setVisible(t4);doc4Escuela.setVisible(t4);
  	}
  	if(event.getSource() == this.btnDoc2){
  		t2=true;t1=false;t3=false;t4=false;

      btnAC1.setVisible(t1);btnAC2.setVisible(t2);btnAC3.setVisible(t3);btnAC4.setVisible(t4);
  		lbl1.setVisible(t1);doc1Nombre.setVisible(t1);doc1Esp.setVisible(t1);doc1Turno.setVisible(t1);doc1Cedula.setVisible(t1);doc1Escuela.setVisible(t1);
  		lbl2.setVisible(t2);doc2Nombre.setVisible(t2);doc2Esp.setVisible(t2);doc2Turno.setVisible(t2);doc2Cedula.setVisible(t2);doc2Escuela.setVisible(t2);
  		lbl3.setVisible(t3);doc3Nombre.setVisible(t3);doc3Esp.setVisible(t3);doc3Turno.setVisible(t3);doc3Cedula.setVisible(t3);doc3Escuela.setVisible(t3);
  		lbl4.setVisible(t4);doc4Nombre.setVisible(t4);doc4Esp.setVisible(t4);doc4Turno.setVisible(t4);doc4Cedula.setVisible(t4);doc4Escuela.setVisible(t4);

  	}
  	if (event.getSource() == this.btnDoc3) {
  		t3=true;t1=false;t2=false;t4=false;

      btnAC1.setVisible(t1);btnAC2.setVisible(t2);btnAC3.setVisible(t3);btnAC4.setVisible(t4);
  		lbl1.setVisible(t1);doc1Nombre.setVisible(t1);doc1Esp.setVisible(t1);doc1Turno.setVisible(t1);doc1Cedula.setVisible(t1);doc1Escuela.setVisible(t1);
  		lbl2.setVisible(t2);doc2Nombre.setVisible(t2);doc2Esp.setVisible(t2);doc2Turno.setVisible(t2);doc2Cedula.setVisible(t2);doc2Escuela.setVisible(t2);
  		lbl3.setVisible(t3);doc3Nombre.setVisible(t3);doc3Esp.setVisible(t3);doc3Turno.setVisible(t3);doc3Cedula.setVisible(t3);doc3Escuela.setVisible(t3);
  		lbl4.setVisible(t4);doc4Nombre.setVisible(t4);doc4Esp.setVisible(t4);doc4Turno.setVisible(t4);doc4Cedula.setVisible(t4);doc4Escuela.setVisible(t4);
  	}
  	if (event.getSource() == this.btnDoc4) {
  		t4=true;t1=false;t2=false;t3=false;

      btnAC1.setVisible(t1);btnAC2.setVisible(t2);btnAC3.setVisible(t3);btnAC4.setVisible(t4);
  		lbl1.setVisible(t1);doc1Nombre.setVisible(t1);doc1Esp.setVisible(t1);doc1Turno.setVisible(t1);doc1Cedula.setVisible(t1);doc1Escuela.setVisible(t1);
  		lbl2.setVisible(t2);doc2Nombre.setVisible(t2);doc2Esp.setVisible(t2);doc2Turno.setVisible(t2);doc2Cedula.setVisible(t2);doc2Escuela.setVisible(t2);
  		lbl3.setVisible(t3);doc3Nombre.setVisible(t3);doc3Esp.setVisible(t3);doc3Turno.setVisible(t3);doc3Cedula.setVisible(t3);doc3Escuela.setVisible(t3);
  		lbl4.setVisible(t4);doc4Nombre.setVisible(t4);doc4Esp.setVisible(t4);doc4Turno.setVisible(t4);doc4Cedula.setVisible(t4);doc4Escuela.setVisible(t4);
  	}
    if (event.getSource()== this.btnAC1) {
			Horario h = new Horario(doc1Nombre.getText());
      //System.out.println("BTN1");
    }
    if (event.getSource()== this.btnAC2) {
			Horario h = new Horario(doc2Nombre.getText());
      //System.out.println("BTN2");
    }
    if (event.getSource()== this.btnAC3) {
			Horario h = new Horario(doc3Nombre.getText());
      //System.out.println("BTN3");
    }
    if (event.getSource()== this.btnAC4) {
			Horario h = new Horario(doc4Nombre.getText());
      //System.out.println("BTN4");
    }

  }
}
