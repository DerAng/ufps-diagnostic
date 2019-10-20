package co.ufps.edu.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;

public class LoginDao {

	SpringDbMgr springDbMgr = new SpringDbMgr();

	public String authenticate(String correo) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("correo", correo);		
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT x.nombre ROL FROM rol x, rolUsuario y, usuario z WHERE x.id = y.rol AND y.idUsuario = z.id AND  z.correo = :correo", mapSqlParameterSource);
		String resultado = "";
		if(sqlRowSet.next()) {
			resultado = sqlRowSet.getString("ROL");
		}
		return resultado;
	}
	
	public List<String> getServiciosPorUsuario(String correo) {
		List<String> servicios = new ArrayList<String>();
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("correo", correo);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT s.servicio servicios FROM servicios s, rolUsuario r, usuario u WHERE s.rol=r.rol AND r.idUsuario = u.id AND u.correo= :correo");
		
		while(sqlRowSet.next()) {
			servicios.add(sqlRowSet.getString("servicios"));
		}
		return servicios;
	}

}
