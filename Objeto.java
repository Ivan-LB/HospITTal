package aplicacion;

import javax.swing.*;
import java.awt.*;

public class Objeto extends JFrame{
  public String nombre;
  public String nss;
  public String sangre;
  public String genero;
  public String alergias;
  public String estCivil;
  public String cel;
  public String enfermedad;
  public String curp;

  public Objeto(String field1, String field2, String field3, String field4, String field5, String field6,String field7,String field8,String field9){
    this.nombre = field1;
    this.nss = field2;
    this.sangre= field3;
    this.genero= field4;
    this.alergias= field5;
    this.estCivil= field6;
    this.cel= field7;
    this.enfermedad= field8;
    this.curp=field9;
  }
}
