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
import co.ufps.edu.dao.ModuloCDao;
import co.ufps.edu.model.ModuloA;
import co.ufps.edu.model.ModuloC;

@Controller
public class ModuloCController {
	
	private ModuloCDao moduloCDao= new ModuloCDao();

	@GetMapping("/listarModuloC")
	public String listar(Model model) {
		model.addAttribute("modulosC", moduloCDao.getModulosC());
		return "INTERNO/ROL1/MODULOC/LISTARMODULOSC"; // nombre del jsp
	}
	
		
	@GetMapping("/registrarModuloC")
	public String registrarModuloC(Model model) {
		return "INTERNO/ROL1/MODULOC/INSERTARMODULOC"; // nombre del jsp
	}
	
	@ModelAttribute("moduloC")
	public ModuloC setUpUserForm() {
		return new ModuloC();
	}
	
	
	
	@PostMapping("/guardarModuloC")
	public String guardarModuloC(@ModelAttribute("moduloC") ModuloC moduloC, Model model) {
		
		String mensaje = moduloCDao.registrarModuloC(moduloC);
		
		if (mensaje.equals("Registro exitoso")) {
	        model.addAttribute("result", "ModuloC registrado con éxito.");
	        return listar(model);
	    } else {
	    	model.addAttribute("wrong", mensaje);
	        return registrarModuloC(model);
	    }

	}
	
	/*
	
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
	*/
	
}
