package serviciorest;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import serviciorest.entidad.Videojuego;
import serviciorest.persistencia.DaoVideojuego;



//AQUÍ ARRANCARÁ NUESTRA APLICACIÓN 
//CON LA ANOTACIÓN @SpringBootApplication HACEMOS QUE SPRINGBOOT:
//1. BUSQUE ANOTACIONES .
//2. SE AUTOCONFIGURE
//3. BUSCA METODOS CON @BEAN

@SpringBootApplication
public class Application {	
	
	
	 
	
	public static void main(String[] args) {
		System.out.println("Servicio Rest -> El contexto de Spring se está cargando, espere unos instantes....");
		//CON EL MÉTODO RUN ARRANCAREMOS EL CONTEXTO SPRING
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		System.out.println("Servicio Rest -> Contexto de Spring cargado!");
		
		
		 
		 
		
		
		
		
			
			
		
				
	}

	
}
