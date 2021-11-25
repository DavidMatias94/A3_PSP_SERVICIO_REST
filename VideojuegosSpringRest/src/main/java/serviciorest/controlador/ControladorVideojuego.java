 package serviciorest.controlador;

import java.util.ArrayList;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import serviciorest.entidad.Videojuego;
import serviciorest.persistencia.DaoVideojuego;

//CRUD COMPLETO
@RestController
public class ControladorVideojuego {

	
	//USAMOS @Autowired PARA HACER INYECCIONES DE DEPENDENCIAS 
	
	@Autowired
	private DaoVideojuego daoVideojuego;
	
	//GET VIDEOJUEGO POR ID
	//SE DEVOLVERÁ UNA PERSONA POR ID
	//EL RESULTADO SERÁ JSON
	//DARÁ UN Nº DE RESPUESTA EN FUNCIÓN DE SI ES CORRECTO O NO
	
	
	
	@GetMapping(path="videojuegos/{id}",produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<Videojuego> getVideojuego(@PathVariable("id") int id) {
		System.out.println("Buscando videojuego con id: " + id);
		Videojuego p =  daoVideojuego.get(id);
		if(p != null) {
			return new ResponseEntity<Videojuego>(p,HttpStatus.OK);//200 OK
		}else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}
	
	//POST 
	//DAR DE ALTA UN VIDEOJUEGO
	//EN ESTE MÉTODO TANTO SI INTRODUCIMOS UN ID O UN NOMBRE YA EXISTENTE NO LO AÑADIRÁ
	// Y SACARÁ UN BAD REQUEST EN POSTMAN ASÍ COMO UN MENSAJE POR CONSOLA ADVIRTIENDO DE QUE EL JUEGO YA EXISTE
	
	
	@PostMapping(path="videojuegos",consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> altaVideojuego(@RequestBody Videojuego p) {
		System.out.println("altaVideojuego: objeto videojuego: " + p);
		
		String añadir = daoVideojuego.add(p);
		
		if (añadir != null ) {
			
			System.out.println("ESTÁS INTENTANDO DAR DE ALTA UN JUEGO YA EXISTENTE");
			
			return new ResponseEntity<Videojuego>(p,HttpStatus.CREATED);//201 CREATED
			

		}else {

			
			return new ResponseEntity<Videojuego>(HttpStatus.BAD_REQUEST);
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	//GET LISTA VIDEOJUEGOS
	//PEDIREMOS TODOS LOS VIDEOJUEGOS

	@GetMapping(path="videojuegos",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Videojuego>> listarVideojuegos() {
	
		
		System.out.println(daoVideojuego.list());
		return new ResponseEntity<List<Videojuego>>(daoVideojuego.list(),HttpStatus.OK);
	}
	
	//PUT
	//ESTE MÉTODO SE UTILIZA PARA MODIFICAR UN VIDEOJUEGO
	@PutMapping(path="videojuegos/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> modificarVideojuego(
			@PathVariable("id") int id, 
			@RequestBody Videojuego p) {
		System.out.println("ID a modificar: " + id);
		System.out.println("Datos a modificar: " + p);
		p.setId(id);
		Videojuego pUpdate = daoVideojuego.update(p);
		if(pUpdate != null) {
			return new ResponseEntity<Videojuego>(HttpStatus.OK);//200 OK
		}else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}
	
	//DELETE
	//MÉTODO PARA ELIMINAR UN VIDEOJUEGO
	
	@DeleteMapping(path="videojuegos/{id}")
	public ResponseEntity<Videojuego> borrarVideojuego(@PathVariable int id) {
		System.out.println("ID a borrar: " + id);
		Videojuego p = daoVideojuego.delete(id);
		if(p != null) {
			return new ResponseEntity<Videojuego>(p,HttpStatus.OK);//200 OK
		}else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}
}
