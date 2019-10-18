package co.ufps.edu.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.ufps.edu.dao.ModuloADao;
import co.ufps.edu.dao.ModuloEDao;
import co.ufps.edu.model.ModuloA;
import co.ufps.edu.model.ModuloE;

@Controller
public class ModuloEController {
	
	
	private ModuloEDao moduloEDao= new ModuloEDao();
	

	@GetMapping("/listarModuloE")
	public String listar(Model model) {
		model.addAttribute("modulosE", moduloEDao.getModulosE());
		return "INTERNO/ROL1/MODULOE/LISTARMODULOSE"; // nombre del jsp
	}
	
	
	
	@ModelAttribute("moduloE")
	public ModuloE setUpUserForm() {
		return new ModuloE();
	}
	
	
	@GetMapping("/registrarModuloE")
	public String registrarModuloE(Model model) {
		
		return "INTERNO/ROL1/MODULOE/INSERTARMODULOE"; // nombre del jsp
	}
	
	
	
	
	@PostMapping("/guardarModuloE")
	public String guardarModuloE(@ModelAttribute("moduloE") ModuloE moduloE, Model model) {
		
		String mensaje = moduloEDao.registrarModuloE(moduloE);
		
		if (mensaje.equals("Registro exitoso")) {
	        model.addAttribute("result", "Modulo registrado con éxito.");
	        return listar(model);
	    } else {
	    	model.addAttribute("wrong", mensaje);
	        return registrarModuloE(model);
	    }

	}
	
	
	
	
	@GetMapping("/actualizarModuloE")
	public String actualizarModuloE(@RequestParam("id") long idModuloE,Model model) {
		ModuloE m = moduloEDao.getModuloPorId(idModuloE);
		model.addAttribute("moduloECargado",m);
		
		
				
		return "INTERNO/ROL1/MODULOE/EDITARMODULOE";
	}
	
	
	@PostMapping("/modificarModuloE")
	public String modificarModuloE(@ModelAttribute("moduloE") ModuloE moduloE, Model model) {
		
		String mensaje=moduloEDao.actualizarModuloE(moduloE);
		if (mensaje.equals("Actualizacion exitosa")) {
	        model.addAttribute("result", "ModuloE actualizado con éxito.");
	        return listar(model);
	    } else {
	    	model.addAttribute("wrong", mensaje);
	        return actualizarModuloE(moduloE.getId(),model);
	    }
		
	}
	
	
	
	@GetMapping("/eliminarModuloE")
	public String eliminarModuloE(@RequestParam("id") long idModuloE,Model model) {
		ModuloE m = moduloEDao.getModuloPorId(idModuloE);
		model.addAttribute("moduloECargado",m);
	
		return "INTERNO/ROL1/MODULOE/ELIMINARMODULOE";
	}
	
	
	
	@PostMapping("/borrarModuloE")
	public String borrarModuloE(@ModelAttribute("moduloE") ModuloE moduloE, Model model) {
		String mensaje=moduloEDao.eliminarModuloE(moduloE);
		if (mensaje.equals("Eliminacion exitosa")) {
	        model.addAttribute("result", "ModuloE eliminado con éxito.");
	        return listar(model);
	    } else {
	    	model.addAttribute("wrong", mensaje);
	        return eliminarModuloE(moduloE.getId(),model);
	    }
	}


}
