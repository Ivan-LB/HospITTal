package aplicacion.servidor;

import aplicacion.utilerias.Objeto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

class IniciarServidor{
  public static ServerSocket server;
  //public ArrayList<Socket> clientes = new ArrayList<Socket>();
  public static void main(String[] args){
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
