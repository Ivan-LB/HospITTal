package aplicacion.servidor;

import aplicacion.utilerias.Objeto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

class IniciarServidor{

  public static void main(String[] args){
    ServerSocket server;
		try{
			server = new ServerSocket(9000);
      while(true){
        Socket socket = server.accept();
        Servidor s = new Servidor(server,socket);
  		}
		}catch(Exception e){
      e.printStackTrace();
    }

  }
}
