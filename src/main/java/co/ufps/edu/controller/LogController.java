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

import co.ufps.edu.dao.LoginDao;
import co.ufps.edu.model.Login;
import co.ufps.edu.util.JwtUtil;

@Controller
public class LogController {

	private JwtUtil jwtUtil = new JwtUtil();

	private LoginDao loginDao = new LoginDao();



	@GetMapping("/logout") // Base
	@ResponseBody
	public ModelAndView logout(@RequestParam("t") String token, HttpServletRequest request) {
		getLogOut(token, request);
		return new ModelAndView("index"); // Nombre del archivo jsp
	}

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

		if(!StringUtils.isEmpty(login.getCodigo()) && !StringUtils.isEmpty(login.getContrase�a())) {
			String resultado = loginDao.authenticate(Long.parseLong(login.getCodigo()), login.getContrase�a());
			
			if (!resultado.isEmpty()) {
				String jwt = jwtUtil.generateToken(resultado, String.valueOf(login.getCodigo()));
				request.setAttribute("token", jwt);
				request.getSession().setAttribute("codigo", login.getCodigo());
				HttpSession session = request.getSession();
				//template.opsForValue().set("SESSION:" + login.getCodigo(), jwt);
				session.setAttribute("codigo", login.getCodigo());
				if (resultado.equals("ROL1")) {
					session.setAttribute("user", "ROL1");
					return "INTERNO/ROL1/indexRol1";
				} else if (resultado.equals("evaluador")) {
					session.setAttribute("user", "Evaluador");
					return "Evaluador/indexEvaluador";
				} else if (resultado.equals("admin")) {
					session.setAttribute("user", "Administrador");
					return "Administrador/indexAdmin";
				}
			}else {
				model.addAttribute("wrong", "Usuario o contrase�a incorrectos.");	
			}
			return "Login";
		}else {
			model.addAttribute("wrong", "El usuario y la contrase�a no pueden ser nulos.");	
			return "Login";
		}
	}

	public void validarSesion(String token, HttpServletRequest request) {
		int codigo = jwtUtil.parseToken(token);
		/*if (token == null || token.isEmpty() || codigo == 0
				|| template.opsForValue().get("SESSION:" + codigo) == null) {
			throw new RuntimeException("FALTA TOKEN");
		}*/
		request.setAttribute("token", token);
		request.getSession().setAttribute("codigo", codigo);

	}

	private void getLogOut(String token, HttpServletRequest request) {
		request.getSession().invalidate();
		int codigo = jwtUtil.parseToken(token);
		//template.delete("SESSION:" + codigo);
	}

	
	@GetMapping("/indexRol1")
	public String indexRol1() {
		return "INTERNO/ROL1/indexRol1";
	}
}
