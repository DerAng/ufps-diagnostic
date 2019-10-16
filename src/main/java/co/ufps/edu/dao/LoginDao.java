package co.ufps.edu.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;

public class LoginDao {

	SpringDbMgr springDbMgr = new SpringDbMgr();

	public String authenticate(String codigo, String contrase�a) {
		if (esAdmin(codigo, contrase�a)) {
			return "admin";
		} else if (esRol1(codigo, contrase�a)) {
			return "estudiante";
		} else if (esEvaluador(codigo, contrase�a)) {
			return "evaluador";
		}
		return "";
	}

	private boolean esAdmin(String codigo, String contrase�a) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("codigo", codigo);
		mapSqlParameterSource.addValue("contrase�a", contrase�a);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT email " + "	FROM usuario "
				+ "	WHERE email = :codigo " + " AND nombre = :contrase�a", mapSqlParameterSource);
		return (sqlRowSet.next());
	}

	private boolean esEvaluador(String codigo, String contrase�a) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("codigo", codigo);
		mapSqlParameterSource.addValue("contrase�a", contrase�a);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT codigo " + "	FROM evaluador "
				+ "	WHERE codigo = :codigo " + " AND contrase�a = :contrase�a", mapSqlParameterSource);
		return (sqlRowSet.next());
	}

	private boolean esRol1(String codigo, String contrase�a) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("CODIGO", codigo);
		mapSqlParameterSource.addValue("CLAVE", contrase�a);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT codigo " + "	FROM rol1 "
				+ "	WHERE CODIGO = :CODIGO " + " AND CLAVE = :CLAVE", mapSqlParameterSource);
		return (sqlRowSet.next());
	}
}
