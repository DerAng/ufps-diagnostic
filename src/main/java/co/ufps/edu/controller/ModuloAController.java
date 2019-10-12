package co.ufps.edu.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.ufps.edu.dao.ModuloADao;
import co.ufps.edu.model.ModuloA;

@Controller
public class ModuloAController {
	
	private ModuloADao moduloADao= new ModuloADao();

	@GetMapping("/listarModuloA")
	public String listar(Model model) {
		model.addAttribute("modulosA", moduloADao.getModulosA());
		return "INTERNO/ROL1/MODULOA/LISTARMODULOSA"; // nombre del jsp
	}
	
	@ModelAttribute("moduloA")
	public ModuloA setUpUserForm() {
		return new ModuloA();
	}
	
	@GetMapping("/registrarModuloA")
	public String registrarModuloA(Model model) {
		model.addAttribute("generos", Arrays.asList("Masculino","Femenino"));
		return "INTERNO/ROL1/MODULOA/INSERTARMODULOA"; // nombre del jsp
	}
	
	@PostMapping("/guardarModuloA")
	public String guardarModuloA(@ModelAttribute("moduloA") ModuloA moduloA, Model model) {
		
		String mensaje = moduloADao.registrarModuloA(moduloA);
		
		if (mensaje.equals("Registro exitoso")) {
	        model.addAttribute("result", "ModuloA registrado con éxito.");
	        return listar(model);
	    } else {
	    	model.addAttribute("wrong", mensaje);
	        return registrarModuloA(model);
	    }

	}
	
	@GetMapping("/actualizarModuloA")
	public String actualizarModuloA(@RequestParam("id") long idModuloA,Model model) {
		ModuloA m = moduloADao.getModuloPorId(idModuloA);
		model.addAttribute("moduloACargado",m);
		
		if(m.getGenero().equals("Masculino")){
			model.addAttribute("generos", Arrays.asList("Femenino"));
			model.addAttribute("idGeneroSeleccionado", "M");
		}else {
			model.addAttribute("generos", Arrays.asList("Masculino"));
			model.addAttribute("idGeneroSeleccionado", "F");
		}
				
		return "INTERNO/ROL1/MODULOA/EDITARMODULOA";
	}
	
	@PostMapping("/modificarModuloA")
	public String modificarModuloA(@ModelAttribute("moduloA") ModuloA moduloA, Model model) {
		
		String mensaje=moduloADao.actualizarModuloA(moduloA);
		if (mensaje.equals("Actualizacion exitosa")) {
	        model.addAttribute("result", "ModuloA actualizado con éxito.");
	        return listar(model);
	    } else {
	    	model.addAttribute("wrong", mensaje);
	        return actualizarModuloA(moduloA.getId(),model);
	    }
		
	}
	
	@GetMapping("/eliminarModuloA")
	public String eliminarModuloA(@RequestParam("id") long idModuloA,Model model) {
		ModuloA m = moduloADao.getModuloPorId(idModuloA);
		model.addAttribute("moduloACargado",m);
		return "INTERNO/ROL1/MODULOA/ELIMINARMODULOA";
	}
	
	@PostMapping("/borrarModuloA")
	public String borrarModuloA(@ModelAttribute("moduloA") ModuloA moduloA, Model model) {
		String mensaje=moduloADao.eliminarModuloA(moduloA);
		if (mensaje.equals("Eliminacion exitosa")) {
	        model.addAttribute("result", "ModuloA eliminado con éxito.");
	        return listar(model);
	    } else {
	    	model.addAttribute("wrong", mensaje);
	        return eliminarModuloA(moduloA.getId(),model);
	    }
	}
	
}
