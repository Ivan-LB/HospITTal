package aplicacion.utilerias;

import java.io.*;
import java.util.*;

public class Archivo
{
	public static ArrayList<String> leerTodo(String nombreArchivo)
	{
		ArrayList<String> contenido = new ArrayList<String>();
		String cadena = new String();

		try(FileInputStream fis = new FileInputStream(nombreArchivo);
		DataInputStream din = new DataInputStream(fis);
		BufferedReader br = new BufferedReader(new InputStreamReader(din));)
		{
			cadena = br.readLine();
			while(cadena != null)
			{
				contenido.add(cadena);
				cadena = br.readLine();
			}
			return contenido;
		}
		catch(Exception error)
		{}
		return null;
	}
	public static void CrearArchivo(String contenido, String nombre){
		try
		{
			String ruta = "./UsuariosContrasennas/" + nombre;
			File file = new File(ruta);
			if(!file.exists())
			{
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file,true);
      BufferedWriter bw = new BufferedWriter(fw);
			bw.write(contenido);
			bw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void CrearArchivoP(String contenido, String nombre)
	{
		try
		{
			String ruta = "./UsuariosContrasennas/" + nombre;
			File file = new File(ruta);

			if(!file.exists())
			{
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file,true);
      BufferedWriter bw = new BufferedWriter(fw);
			bw.write("\n"+contenido);
			bw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void guardarTodo(ArrayList<String> informacion, String nombre){
		try{
			String ruta = "./Citas/"+nombre;
			File f = new File(ruta);
			FileWriter fw = new FileWriter(f);
			BufferedWriter escritura = new BufferedWriter(fw);
			for(int i=0;i<informacion.size();i++){
					escritura.write(informacion.get(i));
					escritura.newLine();
			}
			escritura.close();
		}
		catch(Exception e){
			System.out.println("error");
		}

}

}
