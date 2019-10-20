package co.ufps.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import co.ufps.edu.config.SessionManager;
import co.ufps.edu.constantes.Constantes;
import co.ufps.edu.dao.LoginDao;
import co.ufps.edu.dto.Login;
import co.ufps.edu.util.JwtUtil;

@Controller
public class LogController {

	private JwtUtil jwtUtil = new JwtUtil();

	private LoginDao loginDao = new LoginDao();

	private SessionManager sessionManager = new SessionManager();

	/*@GetMapping("/logout") // Base
	@ResponseBody
	public ModelAndView logout(@RequestParam("t") String token, HttpServletRequest request) {
		getLogOut(token, request);
		return new ModelAndView("index"); // Nombre del archivo jsp
	}*/

	@GetMapping("/login") // Base
	public String index() {
		return "EXTERNO/Login"; // Nombre del archivo jsp
	}

	@GetMapping("/") // Base
	public String main() {
		return "EXTERNO/index"; // Nombre del archivo jsp
	}

	@ModelAttribute("login")
	public Login setUpUserForm() {
		return new Login();
	}
	

	@PostMapping("/autenticar")
	public String authenticateUser(@ModelAttribute("login") Login login, Model model, HttpServletRequest request) {

		/*
	     * Consulto si los datos no vienen nulos
	     */
	    if (!StringUtils.isEmpty(login.getCorreo())) {
	      // Consulto en base de datos si se encuentra ese correo
	      String resultado = loginDao.authenticate(login.getCorreo());

	      // Si el resultado no es vacio es por que si existe ese correo y esa contraseña
	      if (!resultado.isEmpty()) {

	        // Creo un Json Web Token para validar si la sesión esta activa
	        String jwt = jwtUtil.generateToken(resultado, login.getCorreo());

	        // Guardo el JWT como atributo de sesión
	        request.getSession().setAttribute("token", jwt);

	        // Guarda la sesion en el manejador de sesiones
	        sessionManager.guardarSession("SESSION:" + login.getCorreo(), jwt);

	        // Redirijo al index debido a que el usuario ya fue autenticado con exito
	        
	        if (resultado.equals(Constantes.ROL_ESTUDIANTE)) {
	        	request.getSession().setAttribute("user", Constantes.ROL_ESTUDIANTE);
				return indexEstudiante();
			} else if (resultado.equals(Constantes.ROL_PROFESOR)) {
				request.getSession().setAttribute("user", Constantes.ROL_PROFESOR);
				return indexProfesor();
			} else if (resultado.equals(Constantes.ROL_DIRECTOR)) {
				request.getSession().setAttribute("user", Constantes.ROL_DIRECTOR);
				return indexDirector();
			} else if (resultado.equals(Constantes.ROL_VICERRECTOR)) {
				request.getSession().setAttribute("user", Constantes.ROL_VICERRECTOR);
				return indexVicerRector();
			}
	        
	      } else {

	        /**
	         * Guardo en una variable el mensaje de error indicando que el usuario o la contraseña
	         * fueron incorrectos debido a que no se encuentran en la base de datos y asi pueda ser
	         * entendida por los archivos .JSP
	         */
	        model.addAttribute("wrong", "Errores de autenticación con google. Contacte a su administrador del sistema.");
	      }
	      // Redirecciono al login debido a que la autenticación fue incorrecta
	      return "EXTERNO/Login";
	    } else {
	      /**
	       * Guardo en una variable el mensaje de error indicando que el usuario o la contraseña son
	       * nulos siendo estos datos son obligatorios, y asi pueda ser entendida por los archivos .JSP
	       */
	      model.addAttribute("wrong", "Google no esta enviando el correo.");
	      // Redirecciono al login debido a que la autenticación fue incorrecta
	      return "EXTERNO/Login";
	    }
		
	}
	@GetMapping("/logout")
	  private String getLogOut(String token, HttpServletRequest request) {
	    request.getSession().invalidate();
	    String correo = jwtUtil.parseToken(token);
	    sessionManager.eliminarSesion("SESSION:" + correo);
	    return "EXTERNO/Login"; // Nombre del archivo jsp
	  }


	
	@GetMapping("/indexEstudiante")
	public String indexEstudiante() {
		return "INTERNO/ESTUDIANTE/indexEstudiante";
	}
	
	@GetMapping("/indexProfesor")
	public String indexProfesor() {
		return "INTERNO/PROFESOR/indexProfesor";
	}
	
	@GetMapping("/indexDirector")
	public String indexDirector() {
		return "INTERNO/DIRECTOR/indexDirector";
	}
	
	@GetMapping("/indexVicerRector")
	public String indexVicerRector() {
		return "INTERNO/VICERRECTOR/indexVicerRector";
	}
}
