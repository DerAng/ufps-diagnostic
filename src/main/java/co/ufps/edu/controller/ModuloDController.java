package co.ufps.edu.controller;

import java.util.Arrays;

import org.springframework.data.redis.connection.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.ufps.edu.dao.ModuloDDao;
import co.ufps.edu.model.ModuloA;
import co.ufps.edu.model.ModuloD;

@Controller
public class ModuloDController {
	
	private ModuloDDao moduloDDao = new ModuloDDao();
	
	@GetMapping("/listarModuloD")
	public String listar(Model model) {
		
		model.addAttribute("modulosD", moduloDDao.getModulosD());
		
		return "INTERNO/ROL1/MODULOD/LISTARMODULOSD";
	}
	
	@ModelAttribute("moduloD")
	public ModuloD setUpUserForm() {
		return new ModuloD();
	}
	
	@GetMapping("/registrarModuloD")
	public String registrarModuloD(Model model) {
		return "INTERNO/ROL1/MODULOD/INSERTARMODULOD";
	}
	
	@PostMapping("/guardarModuloD")
	public String guardarModuloD(@ModelAttribute("moduloD") ModuloD moduloD, Model model) {
		
		String mensaje = moduloDDao.registrarModuloD(moduloD);
		
		if(mensaje.equals("Registro exitoso")) {
			
			model.addAttribute("result", "ModuloD registrado con éxito.");
			return listar(model);
			
		}
		else {
			
			model.addAttribute("wrong", mensaje);
			return registrarModuloD(model);
		}
	}
	
	@GetMapping("/actualizarModuloD")
	public String actualizarModuloD(@RequestParam("id") long idModuloD,Model model) {
		ModuloD m = moduloDDao.getModuloPorId(idModuloD);
		model.addAttribute("moduloDCargado",m);				
		return "INTERNO/ROL1/MODULOD/EDITARMODULOD";
	}
	
	@PostMapping("/modificarModuloD")
	public String modificarModuloD(@ModelAttribute("moduloD") ModuloD moduloD, Model model) {
		
		String mensaje=moduloDDao.actualizarModuloD(moduloD);
		if (mensaje.equals("Actualizacion exitosa")) {
	        model.addAttribute("result", "ModuloD actualizado con éxito.");
	        return listar(model);
	    } else {
	    	model.addAttribute("wrong", mensaje);
	        return actualizarModuloD(moduloD.getId(),model);
	    }
		
	}
	
	@GetMapping("/eliminarModuloD")
	public String eliminarModuloD(@RequestParam("id") long idModuloD,Model model) {
		ModuloD m = moduloDDao.getModuloPorId(idModuloD);
		model.addAttribute("moduloDCargado",m);
		return "INTERNO/ROL1/MODULOD/ELIMINARMODULOD";
	}
	
	@PostMapping("/borrarModuloD")
	public String borrarModuloD(@ModelAttribute("moduloD") ModuloD moduloD, Model model) {
		String mensaje=moduloDDao.eliminarModuloD(moduloD);
		if (mensaje.equals("Eliminacion exitosa")) {
	        model.addAttribute("result", "ModuloD eliminado con éxito.");
	        return listar(model);
	    } else {
	    	model.addAttribute("wrong", mensaje);
	        return eliminarModuloD(moduloD.getId(),model);
	    }
	}
}
