package serviciorest.persistencia;

import java.util.ArrayList;





import java.util.List;

import org.springframework.stereotype.Component;

import serviciorest.entidad.Videojuego;

/**
 * DAO ES EL OBJETO QUE SE ENCARGA DE HACER LAS CONSULTAS
 * CON LA ANOTACIÓN @Component, DAMOS DE ALTA EL OBJETO ÚNICO
 * 
 */
@Component
public class DaoVideojuego {

	public List<Videojuego> listaVideojuegos;
	public int contador;
	
	/**
	 * LISTA DONDE ESTARÁN LOS VIDEOJUEGOS QUE PODRÁN CONSUMIR NUESTROS CLIENTES
	 */
	public DaoVideojuego() {
		System.out.println("DaoVideojuego -> Creando la lista de videojuegos!");
		listaVideojuegos = new ArrayList<Videojuego>();
		Videojuego p1 = new Videojuego(contador++,"FORTNITE", "EPIC GAMES", 7);//ID: 0
		Videojuego p2 = new Videojuego(contador++,"FIFA 21", "EA", 8);//ID: 1
		Videojuego p3 = new Videojuego(contador++,"CALL OF DUTTY", "ACTIVISION", 9);//ID: 2
		Videojuego p4 = new Videojuego(contador++,"AMONG US", "INNERSLOTH", 6);//ID:3
		Videojuego p5 = new Videojuego(contador++,"NBA 2K21", "2K SPORTS", 7);//ID:4
		
		
		
		listaVideojuegos.add(p1);
		listaVideojuegos.add(p2);
		listaVideojuegos.add(p3);
		listaVideojuegos.add(p4);
		listaVideojuegos.add(p5);
		
	}
	
	/**
	 *DEVUELVE EL VIDEOJUEGO EN FUNCIÓN DE SU POSICIÓN
	 *
	 */
	
	
	
	public Videojuego get(int id) {
		
			for(Videojuego p : listaVideojuegos) {
				if(p.getId() == id) {
					return p;
				}
						
			}
			
		return null;
	}
  
	/**
	 * DEVUELVE TODOS LOS VIDEOJUEGOS
	 */
	public List<Videojuego> list() {
		return listaVideojuegos;
	}
	
	/**
	 * MÉTODO AÑADIR VIDEOJUEGOS
	 */
	public String add(Videojuego p) {
		
		for(Videojuego v : listaVideojuegos) {
			if (v.getNombre().equalsIgnoreCase(p.getNombre())) {
				return null;
			}
		}
		p.setId(contador++);
		listaVideojuegos.add(p);
		return "añadido";
		




	}
		
	
	/**
	 * BORRAR UN VIDEOJUEGO
	 */
	
		public Videojuego delete(int id) {
		try {
			
			Videojuego vAux = get(id);
			
			int posicion = listaVideojuegos.indexOf(vAux);
			
			return listaVideojuegos.remove(posicion);					
			 
		} catch (Exception e) {
			System.out.println("delete -> Videojuego fuera de rango");
			return null;
		}
	}
	
	
	/**
	 * MÉTODO QUE MODIFICA UN VIDEOJUEGO
	 */
	public Videojuego update(Videojuego p) {
		try {
				Videojuego pAux = get(p.getId());	
				pAux.setNombre(p.getNombre());
				pAux.setCompañia(p.getCompañia());
				pAux.setNota(p.getNota());
			
			return pAux;
		} catch (IndexOutOfBoundsException iobe) {
			System.out.println("update -> VIDEOJUEGO fuera de rango");
			return null;
		}
	}
	
	
	/**
	 *MÉTODO QUE DEVUELVE TODOS LOS VIDEOJUEGOS POR NOMBRE
	 */
	/*
	public List<Videojuego> listByName(String nombre){
		List<Videojuego> listaVideojuegosAux = new ArrayList<Videojuego>();
		for(Videojuego p : listaVideojuegos) {
			if(p.getNombre().equalsIgnoreCase(nombre)) {
				listaVideojuegosAux.add(p);
			}
		}
		return listaVideojuegosAux;
	}
	
	
	
	/**
	 * METODO QUE DEVUELVE TODOS LOS VIDEOJUEGOS POR ID
	 */
	/*
	public List<Videojuego> listById(int id){
		List<Videojuego> listaVideojuegosAux = new ArrayList<Videojuego>();
		for(Videojuego p : listaVideojuegos) {
			if(p.getId() == id) {
				listaVideojuegosAux.add(p);
			}
		}
		return listaVideojuegosAux;
	}
	*/
	
	
	
	
	
	
}
