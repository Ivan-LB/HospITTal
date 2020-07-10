  import java.awt.*;
import javax.swing.*;

public class ColoredToggleButton extends JToggleButton
{

  String texto;

  Color motaQuemada = new Color(12,73,11);

    public ColoredToggleButton(String texto){
      this.setText(texto);
      this.setForeground(Color.white);
      UIManager.put("ToggleButton.select", motaQuemada);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Color bg;
        if (isSelected()){
            bg = Color.green;
            //UIManager.put("ColoredToggleButton.select",Color.green);
            this.setText("Selecto");

        } else {
            bg = Color.blue;
            this.setText("Disponible");
        }
        setBackground(bg);
        super.paintComponent(g);

    }
}
