package co.ufps.edu.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;

public class LoginDao {

	SpringDbMgr springDbMgr = new SpringDbMgr();

	public String authenticate(String codigo, String contraseņa) {
		if (esAdmin(codigo, contraseņa)) {
			return "admin";
		} else if (esRol1(codigo, contraseņa)) {
			return "estudiante";
		} else if (esEvaluador(codigo, contraseņa)) {
			return "evaluador";
		}
		return "";
	}

	private boolean esAdmin(String codigo, String contraseņa) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("codigo", codigo);
		mapSqlParameterSource.addValue("contraseņa", contraseņa);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT email " + "	FROM usuario "
				+ "	WHERE email = :codigo " + " AND nombre = :contraseņa", mapSqlParameterSource);
		return (sqlRowSet.next());
	}

	private boolean esEvaluador(String codigo, String contraseņa) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("codigo", codigo);
		mapSqlParameterSource.addValue("contraseņa", contraseņa);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT codigo " + "	FROM evaluador "
				+ "	WHERE codigo = :codigo " + " AND contraseņa = :contraseņa", mapSqlParameterSource);
		return (sqlRowSet.next());
	}

	private boolean esRol1(String codigo, String contraseņa) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("CODIGO", codigo);
		mapSqlParameterSource.addValue("CLAVE", contraseņa);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT codigo " + "	FROM rol1 "
				+ "	WHERE CODIGO = :CODIGO " + " AND CLAVE = :CLAVE", mapSqlParameterSource);
		return (sqlRowSet.next());
	}
}
