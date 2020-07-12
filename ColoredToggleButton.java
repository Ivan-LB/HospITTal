package aplicacion.utilerias;

import java.awt.*;
import javax.swing.*;

public class ColoredToggleButton extends JToggleButton
{

  String texto;

  Color verdeOscuro = new Color(12,73,11);

  Color amarillo = new Color(255,203,116);

  Color rojoOscuro = new Color(195,0,0);

  boolean disponible = true;

    public ColoredToggleButton(){
      this.setForeground(Color.BLACK);
      UIManager.put("ToggleButton.select", verdeOscuro);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Color bg;
        if(disponible){
        if (isSelected()){
            bg = verdeOscuro;
            this.setForeground(Color.white);
            //UIManager.put("ColoredToggleButton.select",Color.green);
            this.setText("Selecto");
            this.setBackground(bg);
            super.paintComponent(g);

        } else if(!isSelected()) {
            bg = amarillo;
            this.setForeground(Color.BLACK);
            this.setText("Disponible");
            this.setBackground(bg);
            super.paintComponent(g);
        }
      }else{
          this.setText("Ocupado");
          this.setForeground(Color.white);
          this.setBackground(rojoOscuro);
        }
        super.paintComponent(g);
    }

    public void desactivar(boolean check)
    {
      this.disponible = check;
      this.repaint();
    }

}
