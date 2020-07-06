package com.workit.beans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FilterApp {
	
	private File archivo = null;
    private FileReader fr = null;
    private FileWriter fileOut = null;
    private BufferedReader br = null;
    private ArrayList<String> wordsConsoleParameter = new ArrayList<String>();
    private ArrayList<String> wordsInFile = new ArrayList<String>();
    private ArrayList<String> wordsInOutputFile = new ArrayList<String>();
    String homeUsuario = System.getProperty("user.home");
    
    public void handler(String[] args) {	    	
    	int size = args.length;
    	if(size == 0) {
    		System.out.println("Necesita ingresar parametros. El primer parametro será la ruta del archivo a leer y los subsecuentes las palabras a comprar");
    	} else {
	    	if(size>1) {    		
	    		for(int i = 1; i<size; i++) {
	    			wordsConsoleParameter.add(args[i]);
	    		}
	    	}    	
	    	readFile(args[0]);
    	}
	}
	
	private void readFile(String fileName) {
		try {
			System.out.println("Nombre del archivo de lectura: " + fileName);
			File archivo = new File(fileName);			
			FileReader fr = new FileReader (archivo);
			BufferedReader br = new BufferedReader(fr);
			// Lectura del fichero
	         String linea;
	         while((linea=br.readLine())!=null)
	        	 wordsInFile.add(linea);
	         filter();
		} catch(Exception e) {
			System.out.println("Ocurrió un error");
		      e.printStackTrace();
		} finally {
			try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
		}
		
	}
	
	private void filter() {
		System.out.println("parametros de consola:");
		for(String parametro : wordsConsoleParameter) {
			System.out.println(parametro);
			for(String palabra: wordsInFile) {
				if(parametro.equals(palabra)) {
					wordsInOutputFile.add(parametro);
				}
			}
		}
		filterOut();
	}
	
	
	private void filterOut() {
		try {					
			File out = new File(homeUsuario + "\\out.txt");			
            if (!out.exists()) {
            	out.createNewFile();
            } 
            fileOut = new FileWriter(out);
			// Escribimos linea a linea en el fichero
			for (String word : wordsInOutputFile) {
				fileOut.write(word + "\n");
			}

			fileOut.close();
			System.out.println("Archivo creado correctamente en " + homeUsuario + "\\out.txt");
		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
	}
	
}
