package procesamiento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Combo;
import modelo.ProductoMenu;


public class CargaDeRestaurante{
	public static ArrayList<ProductoMenu> leerInfoArchivoProductosMenu(String rutaArchivo)
	{

		ArrayList<ProductoMenu> productosMenu = new ArrayList<ProductoMenu>();
		BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
		String linea = br.readLine();   
		while (linea != null) 
		{
			String[] partes = linea.split(";");
			
			ProductoMenu nuevoProducto = new ProductoMenu(partes[0], Integer.parseInt(partes[1]));   
			productosMenu.add( nuevoProducto );

			linea = br.readLine(); 
		}
		br.close();
		return productosMenu;
	}
	
	public static ArrayList<Combo> leerInfoArchivoCombos(String rutaArchivo, ArrayList<ProductoMenu> productosMenu) 
	{
		
		ArrayList<Combo> combos = new ArrayList<Combo>();
		
		BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
		String linea = br.readLine();    
		
		while (linea != null) 
		{
		
			String[] partes = linea.split(";");
			double porcentaje = Double.parseDouble( partes[1].substring(0, partes[1].length()-1)); 

			Combo nuevoCombo = new Combo(partes[0], porcentaje);   

			for (int i = 2; i < partes.length; i++)
			{
				nuevoCombo.agregarProducto(partes[i]);
				                                          
			}

			combos.add( nuevoCombo );

			linea = br.readLine();
		}
		br.close();
		return combos;
	}
}