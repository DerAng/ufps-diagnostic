package co.ufps.edu.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;

public class LoginDao {

	SpringDbMgr springDbMgr = new SpringDbMgr();

	public String authenticate(long codigo, String contrase�a) {
		if (esRol1(codigo, contrase�a)) {
			return "ROL1";
		} else if (esAdmin(codigo, contrase�a)) {
			return "admin";
		} else if (esEvaluador(codigo, contrase�a)) {
			return "evaluador";
		}
		return "";
	}

	private boolean esAdmin(long codigo, String contrase�a) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("codigo", codigo);
		mapSqlParameterSource.addValue("contrase�a", contrase�a);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT codigo " + "	FROM administrador "
				+ "	WHERE codigo = :codigo " + " AND contrase�a = :contrase�a", mapSqlParameterSource);
		return (sqlRowSet.next());
	}

	private boolean esEvaluador(long codigo, String contrase�a) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("codigo", codigo);
		mapSqlParameterSource.addValue("contrase�a", contrase�a);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT codigo " + "	FROM evaluador "
				+ "	WHERE codigo = :codigo " + " AND contrase�a = :contrase�a", mapSqlParameterSource);
		return (sqlRowSet.next());
	}

	private boolean esRol1(long codigo, String contrase�a) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("CODIGO", codigo);
		mapSqlParameterSource.addValue("CLAVE", contrase�a);
		SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT codigo " + "	FROM rol1 "
				+ "	WHERE CODIGO = :CODIGO " + " AND CLAVE = :CLAVE", mapSqlParameterSource);
		return (sqlRowSet.next());
	}
}
