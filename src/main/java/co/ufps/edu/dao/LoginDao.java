package co.ufps.edu.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;

public class LoginDao {

	SpringDbMgr springDbMgr = new SpringDbMgr();

	public String authenticate(String codigo, String contraseña) {
		if (esAdmin(codigo, contraseña)) {
			return "admin";
		} else if (esRol1(codigo, contraseña)) {
			return "estudiante";
		} else if (esEvaluador(codigo, contraseña)) {
			return "evaluador";
		}
		return "";
	}

	private boolean esAdmin(String codigo, String contraseña) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("codigo", codigo);
		mapSqlParameterSource.addValue("contraseña", contraseña);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT email " + "	FROM usuario "
				+ "	WHERE email = :codigo " + " AND nombre = :contraseña", mapSqlParameterSource);
		return (sqlRowSet.next());
	}

	private boolean esEvaluador(String codigo, String contraseña) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("codigo", codigo);
		mapSqlParameterSource.addValue("contraseña", contraseña);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT codigo " + "	FROM evaluador "
				+ "	WHERE codigo = :codigo " + " AND contraseña = :contraseña", mapSqlParameterSource);
		return (sqlRowSet.next());
	}

	private boolean esRol1(String codigo, String contraseña) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("CODIGO", codigo);
		mapSqlParameterSource.addValue("CLAVE", contraseña);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT codigo " + "	FROM rol1 "
				+ "	WHERE CODIGO = :CODIGO " + " AND CLAVE = :CLAVE", mapSqlParameterSource);
		return (sqlRowSet.next());
	}
}
