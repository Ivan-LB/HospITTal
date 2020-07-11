package aplicacion.utilerias;

import java.awt.*;
import javax.swing.*;

public class ColoredToggleButton extends JToggleButton
{

  String texto;

  Color motaQuemada = new Color(12,73,11);

  Color amarillo = new Color(255,203,116);

    public ColoredToggleButton(String texto){
      this.setText(texto);
      this.setForeground(Color.BLACK);
      UIManager.put("ToggleButton.select", motaQuemada);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Color bg;
        if (isSelected()){
            bg = Color.green;
            this.setForeground(Color.white);
            //UIManager.put("ColoredToggleButton.select",Color.green);
            this.setText("Selecto");

        } else {
            bg = amarillo;
            this.setForeground(Color.BLACK);
            this.setText("Disponible");
        }
        setBackground(bg);
        super.paintComponent(g);

    }
    public void cambiarNombre(String texto){
      this.setText(texto);
    }
}
