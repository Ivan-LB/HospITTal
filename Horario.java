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
Boolean[] btnsOcupados = new Boolean[24];

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
		btnEnviar.setBounds(0,650,100,30);

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

		this.add(panel);


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
		 if(this.dia[0].isSelected()){
			 dia[0].setBackground(Color.green);
			 SwingUtilities.updateComponentTreeUI(dia[0]);
			 btnsOcupados[0]=true;

		 }else if (!this.dia[0].isSelected()){
			 dia[0].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[0]);
			 btnsOcupados[0]=false;

		 }
		 else if(this.dia[1].isSelected()){
			 dia[1].setBackground(Color.GREEN);
			 SwingUtilities.updateComponentTreeUI(dia[1]);
			 btnsOcupados[1]=true;

		 }else if (!this.dia[1].isSelected()){
			 dia[1].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[1]);
			 btnsOcupados[1]=false;

		 }
		 else if(this.dia[2].isSelected()){
			 dia[2].setBackground(Color.GREEN);
			 SwingUtilities.updateComponentTreeUI(dia[2]);
			 btnsOcupados[2]=true;

		 }else if (!this.dia[2].isSelected()){
			 dia[2].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[2]);
			 btnsOcupados[2]=false;

		 }
		 else if(this.dia[3].isSelected()){
			 dia[3].setBackground(Color.GREEN);
			 SwingUtilities.updateComponentTreeUI(dia[3]);
			 btnsOcupados[2]=true;

		 }else if (!this.dia[0].isSelected()){
			 dia[3].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[3]);
			 btnsOcupados[3]=false;

		 }
		 else if(this.dia[4].isSelected()){
			 dia[4].setBackground(Color.GREEN);
			 SwingUtilities.updateComponentTreeUI(dia[4]);
			 btnsOcupados[4]=true;

		 }else if (!this.dia[4].isSelected()){
			 dia[4].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[4]);
			 btnsOcupados[4]=false;

		 }
		 else if(this.dia[5].isSelected()){
			 dia[5].setBackground(Color.GREEN);
			 SwingUtilities.updateComponentTreeUI(dia[5]);
			 btnsOcupados[5]=true;

		 }else if (!this.dia[5].isSelected()){
			 dia[5].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[5]);
			 btnsOcupados[5]=false;

		 }
		 else if(this.dia[6].isSelected()){
			 dia[6].setBackground(Color.GREEN);
			 SwingUtilities.updateComponentTreeUI(dia[6]);
			 btnsOcupados[6]=true;

		 }else if (!this.dia[6].isSelected()){
			 dia[6].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[6]);
			 btnsOcupados[6]=false;

		 }
		 else if(this.dia[7].isSelected()){
			 dia[7].setBackground(Color.GREEN);
			 SwingUtilities.updateComponentTreeUI(dia[7]);
			 btnsOcupados[7]=true;

		 }else if (!this.dia[7].isSelected()){
			 dia[7].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[7]);
			 btnsOcupados[7]=false;

		 }
		 else if(this.dia[8].isSelected()){
			 dia[8].setBackground(Color.GREEN);
			 SwingUtilities.updateComponentTreeUI(dia[8]);
			 btnsOcupados[8]=true;

		 }else if (!this.dia[8].isSelected()){
			 dia[8].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[8]);
			 btnsOcupados[8]=false;

		 }
		 else if(this.dia[9].isSelected()){
			 dia[9].setBackground(Color.GREEN);
			 SwingUtilities.updateComponentTreeUI(dia[9]);
			 btnsOcupados[9]=true;

		 }else if (!this.dia[9].isSelected()){
			 dia[9].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[9]);
			 btnsOcupados[9]=false;

		 }
		 else if(this.dia[10].isSelected()){
			 dia[10].setBackground(Color.GREEN);
			 SwingUtilities.updateComponentTreeUI(dia[10]);
			 btnsOcupados[10]=true;

		 }else if (!this.dia[10].isSelected()){
			 dia[10].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[10]);
			 btnsOcupados[10]=false;

		 }
		 else if(this.dia[11].isSelected()){
			 dia[11].setBackground(Color.GREEN);
			 SwingUtilities.updateComponentTreeUI(dia[11]);
			 btnsOcupados[11]=true;

		 }else if (!this.dia[11].isSelected()){
			 dia[11].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[11]);
			 btnsOcupados[11]=false;

		 }
		 else if(this.dia[12].isSelected()){
			 dia[12].setBackground(Color.GREEN);
			 SwingUtilities.updateComponentTreeUI(dia[12]);
			 btnsOcupados[12]=true;

		 }else if (!this.dia[12].isSelected()){
			 dia[12].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[12]);
			 btnsOcupados[12]=false;

		 }
		 else if(this.dia[13].isSelected()){
			 dia[13].setBackground(Color.GREEN);
			 SwingUtilities.updateComponentTreeUI(dia[13]);
			 btnsOcupados[13]=true;

		 }else if (!this.dia[13].isSelected()){
			 dia[13].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[13]);
			 btnsOcupados[13]=false;

		 }
		 else if(this.dia[14].isSelected()){
			 dia[14].setBackground(Color.GREEN);
			 SwingUtilities.updateComponentTreeUI(dia[14]);
			 btnsOcupados[14]=true;

		 }else if (!this.dia[14].isSelected()){
			 dia[14].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[14]);
			 btnsOcupados[14]=false;

		 }
		 else if(this.dia[15].isSelected()){
			 dia[15].setBackground(Color.GREEN);
			 SwingUtilities.updateComponentTreeUI(dia[15]);
			 btnsOcupados[15]=true;

		 }else if (!this.dia[15].isSelected()){
			 dia[15].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[15]);
			 btnsOcupados[15]=false;

		 }
		 else if(this.dia[17].isSelected()){
			 dia[17].setBackground(Color.GREEN);
			 SwingUtilities.updateComponentTreeUI(dia[17]);
			 btnsOcupados[17]=true;

		 }else if (!this.dia[17].isSelected()){
			 dia[17].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[17]);
			 btnsOcupados[17]=false;

		 }
		 else if(this.dia[18].isSelected()){
			 dia[18].setBackground(Color.GREEN);
			 SwingUtilities.updateComponentTreeUI(dia[18]);
			 btnsOcupados[18]=true;

		 }else if (!this.dia[18].isSelected()){
			 dia[18].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[18]);
			 btnsOcupados[18]=false;

		 }
		 else if(this.dia[19].isSelected()){
			 dia[19].setBackground(Color.GREEN);
			 SwingUtilities.updateComponentTreeUI(dia[19]);
			 btnsOcupados[19]=true;

		 }else if (!this.dia[1].isSelected()){
			 dia[19].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[19]);
			 btnsOcupados[19]=false;

		 }
		 else if(this.dia[20].isSelected()){
			 dia[20].setBackground(Color.GREEN);
			 SwingUtilities.updateComponentTreeUI(dia[20]);
			 btnsOcupados[20]=true;

		 }else if (!this.dia[20].isSelected()){
			 dia[20].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[20]);
			 btnsOcupados[20]=false;

		 }
		 else if(this.dia[21].isSelected()){
			 dia[21].setBackground(Color.GREEN);
			 SwingUtilities.updateComponentTreeUI(dia[21]);
			 btnsOcupados[21]=true;

		 }else if (!this.dia[21].isSelected()){
			 dia[21].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[21]);
			 btnsOcupados[21]=false;

		 }

		 else if(this.dia[22].isSelected()){
			 dia[22].setBackground(Color.GREEN);
			 SwingUtilities.updateComponentTreeUI(dia[22]);
			 btnsOcupados[22]=true;

		 }else if (!this.dia[22].isSelected()){
			 dia[22].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[22]);
			 btnsOcupados[22]=false;

		 }
		 else if(this.dia[23].isSelected()){
			 dia[23].setBackground(Color.GREEN);
			 SwingUtilities.updateComponentTreeUI(dia[23]);
			 btnsOcupados[23]=true;

		 }else if (!this.dia[22].isSelected()){
			 dia[23].setBackground(Color.BLUE);
			 SwingUtilities.updateComponentTreeUI(dia[23]);
			 btnsOcupados[23]=false;

		 }
	}
public void actionPerformed(ActionEvent event){
		 	if(event.getSource() == this.btnEnviar){
				int cont=0;
				for (int i=0; i<btnsOcupados.length; i++) {
					if(btnsOcupados[i].equals(true)){
						cont++;
					}
				}
				if(cont==0){
					JOptionPane.showMessageDialog(null,"Favor de Seleccionar una cita");
				}else if(cont>1){
					JOptionPane.showMessageDialog(null,"Favor de solamente seleccinar una cita");
				}else{
					System.out.println("Se agendo correctamente");
				}
			}

}
}
