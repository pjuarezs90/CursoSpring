package com.bolsaideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;

import com.bolsaideas.springboot.web.app.models.Usuario;


/*
 * @author pjuarezs
 * Ejemplo de una clase controller Spring
 * */

@Controller
@RequestMapping("/app") //Agregando ruta raiz
public class IndexController {
	
	//Método que carga vista index 
	//@RequestMapping: se mapea indicando un Url
	//@PostMapping: enviar
	//@GetMapping: Obtiene una URL
	//{ "/index","/","/home"} Metodo mapeado a mas de url  
	@GetMapping({ "/index","/","/home",""})
	public String index(Model model) {
		model.addAttribute("titulo","Hola Spring con Model");		
		return "index";
	
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Pablo ");
		usuario.setApellido("Juárez");
		usuario.setEmail("pablo.juarez@gmail.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo","Perfil del usuario ".concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios=new ArrayList<Usuario>();
		usuarios.add(new Usuario("Pablo","Juárez","pablo.juarez@gmail.com"));
		usuarios.add(new Usuario("Pedro","Santana","pedro@gmail.com"));
		usuarios.add(new Usuario("Delia Guadalupe","Rosario","ailedrom@gmail.com"));
		usuarios.add(new Usuario("Juan","Bahena","juan@gmail.com"));
		usuarios.add(new Usuario("Mayra","Bahena","mayra@gmail.com"));
		usuarios.add(new Usuario("Juan","Bahena","juan@gmail.com"));
		usuarios.add(new Usuario("Rosa","Guzmán","rosa@gmail.com"));
		
		model.addAttribute("titulo","Listado de usuarios");
		model.addAttribute("usuarios",usuarios);
		
		
		return "listar";
		
	}
	
	//Otra forma de pasar datos a la vista com @ModelAttribute se debe espeficicar el objeto
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios= Arrays.asList(new Usuario("Pablo","Juárez","pablo.juarez@gmail.com"),
				new Usuario("Pedro","Santana","pedro@gmail.com"),
				new Usuario("Delia Guadalupe","Rosario","ailedrom@gmail.com"),
				new Usuario("Juan","Bahena","juan@gmail.com"));
		
		return usuarios;
		
		
	}

}
