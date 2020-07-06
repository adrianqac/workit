package com.workit.examen;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.workit.beans.FilterApp;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//Configuracion de spring mediante anotaciónes, aunque tambien se podría configurar con el archivo applicationContext.xml
        AnnotationConfigApplicationContext contexto= new AnnotationConfigApplicationContext();
        contexto.register(FilterApp.class);
        contexto.refresh();
        
        FilterApp filterApp= (FilterApp) contexto.getBean(FilterApp.class);               
        filterApp.handler(args);
    }
}
