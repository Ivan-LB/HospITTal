package aplicacion.utilerias;


import javax.swing.*;
import java.awt.*;

public class Objeto extends JFrame{
  public String nombre;
  public String cel;
  public String mail;
  public String sangre;
  public String genero;
  public String fecha;
  public String dom;
  public String enfermedad;
  public String curp;

  public Objeto(String field1, String field2, String field3, String field4, String field5, String field6,String field7,String field8,String field9){
    this.nombre = field1;
    this.cel = field2;
    this.mail= field3;
    this.sangre= field4;
    this.genero= field5;
    this.fecha= field6;
    this.dom= field7;
    this.enfermedad= field8;
    this.curp=field9;
  }
}
