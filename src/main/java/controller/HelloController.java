package controller;

import org.springframework.web.bind.annotation.RestController;

import services.BusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class HelloController {
	
	@Value("${introduction.spring.nombre}")
	private String nombre;

	private final BusinessService businessService; // declaramos una constante porque nos obliga a la hora de crea el constructor
	// esto es otra forma de leer el servicio sin utilizar la annotacion
	
	@Autowired
	public HelloController (BusinessService businessService) {
		this.businessService = businessService;
	}
	
	@RequestMapping("/")
	  public String index() {
		  String respuesta = "Nombre del proyecto: " + this.nombre;
		  respuesta += "%n "+ businessService.getSaludo();
		  return  respuesta;
	  }
	
  @RequestMapping(value="/saludar/{nombre}", method=RequestMethod.GET)
  public String index(@PathVariable String nombre ) {
	  
	  if(nombre.equals("Pilar")){
	  return  "Hola señorita:  " + nombre;
	  }else {
		  return " Hola señor: " +nombre;
	  }
  }
  

}