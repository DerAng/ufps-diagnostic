package co.ufps.edu.config;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import co.ufps.edu.constantes.Constantes;
import co.ufps.edu.dao.LoginDao;
import co.ufps.edu.util.JwtUtil;

public class SessionManager implements HandlerInterceptor  {

	private JwtUtil jwtUtil;
	public HashMap<String, String> sesiones;	
	public LoginDao loginDao;

	/**
	 * Constructor de la clase que inicializa las variables
	 */
	public SessionManager() {
		sesiones = new HashMap<>();
		jwtUtil = new JwtUtil();
	}

	/**
	 * Metodo que guarda una sesion en el sistema
	 * 
	 * @param sesion
	 * @param token
	 */
	public void guardarSession(String sesion, String token) {
		sesiones.put(sesion, token);
	}

	public void eliminarSesion(String sesion) {
		sesiones.remove(sesion);
	}

	// This method is called before the controller
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (request.getSession().getAttribute("token") == null) {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.sendRedirect(Constantes.RUTA + "/");
			return false;
		} else {
			// Se extrae el token de sesion
			String token = request.getSession().getAttribute("token").toString();

			// Se valida el token
			boolean permission = validarToken(token);
			
			boolean servicePermission = validarServicio(token,request);

			// Si el token es valido se permite la continuidad
			if (permission) {
				return true;
				// Si el token no es valido se envia un mensaje de no autorizado.
			} else {
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
				response.sendRedirect(Constantes.SERVER + Constantes.RUTA + "/");
				return false;
			}
		}
	}

	private boolean validarServicio(String token, HttpServletRequest request) {
		String correo = jwtUtil.parseToken(token);
		String servicio = "";
		if(correo!=null) {
			List<String> servicios = loginDao.getServiciosPorUsuario(correo);
			if(servicios.contains(servicio)) {
				return true;
			}
		}
		return false;
	}

	private boolean validarToken(String token) {
		String correo = jwtUtil.parseToken(token);
		if (token == null || token.isEmpty() || StringUtils.isEmpty(correo)
				|| sesiones.get("SESSION:" + correo) == null) {
			return false;
		}

		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
