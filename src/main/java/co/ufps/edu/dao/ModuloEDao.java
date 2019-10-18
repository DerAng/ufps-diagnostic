package co.ufps.edu.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;

import co.ufps.edu.model.ModuloE;

public class ModuloEDao {
	
	
private SpringDbMgr springDbMgr;
	
	
	
	public ModuloEDao() {
		springDbMgr = new SpringDbMgr();
	}
	
	

	public List<ModuloE> getModulosE(){
		
		List<ModuloE> modulosE = new ArrayList<>();
		
		// Consulta para realizar en base de datos
	    SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT * FROM moduloe");

	    // Recorre cada registro obtenido de base de datos
	    while (sqlRowSet.next()) {
	    	ModuloE m = new ModuloE();
	    	
	    	m.setId(sqlRowSet.getInt("ID"));
	    	m.setNombre(sqlRowSet.getString("NOMBRE"));
	    	m.setGramaje(sqlRowSet.getInt("GRAMAJE"));
	    	m.setDescripcion(sqlRowSet.getString("DESCRIPCION"));
	    	
	    

	    	modulosE.add(m);
	    }

		return modulosE;
	}
	
	
	
	
	
	public String registrarModuloE(ModuloE moduloe) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id", moduloe.getId()); // Variables bind
		map.addValue("nombre", moduloe.getNombre());
		map.addValue("gramaje", moduloe.getGramaje());
		map.addValue("descripcion", moduloe.getDescripcion());
		
		
		
		
		// Armar la sentencia de actualización debase de datos
	    String query =
	        "INSERT INTO moduloE(ID,NOMBRE,GRAMAJE,DESCRIPCION) VALUES(:id,:nombre,:gramaje,:descripcion)";

	    // Ejecutar la sentencia
	    int result = 0;
	    try {
	      result = springDbMgr.executeDml(query, map);
	    } catch (Exception e) {
	      new Exception();
	    }
	    // Si hubieron filas afectadas es por que si hubo registro, en caso contrario muestra el mensaje
	    // de error.
	    return (result == 1) ? "Registro exitoso"
	        : "Error al registrar la actividad. Contacte al administrador del sistema.";
		
	}
	
	

	public ModuloE getModuloPorId(long idModuloE) {
		// Lista para retornar con los datos
	    ModuloE moduloE = new ModuloE();

	    // Consulta para realizar en base de datos
	    MapSqlParameterSource map = new MapSqlParameterSource();
	    map.addValue("id", idModuloE);
	    SqlRowSet sqlRowSet = springDbMgr.executeQuery(" SELECT * FROM moduloe WHERE ID = :id", map);

	    // Consulto si la actividad existe
	    if (sqlRowSet.next()) {
	      // Almaceno los datos de la actividad
	    	moduloE.setId(sqlRowSet.getInt("ID"));
	    	moduloE.setNombre(sqlRowSet.getString("NOMBRE"));
	    	moduloE.setGramaje(sqlRowSet.getInt("GRAMAJE"));
	    	moduloE.setDescripcion(sqlRowSet.getString("DESCRIPCION"));
	    	
	    // Retorna la actividad desde base de datos
	    }
	    	
	    return moduloE;
	}
	
	

	public String actualizarModuloE(ModuloE moduloE) {
		
		// Agrego los datos del registro (nombreColumna/Valor)
		
	    MapSqlParameterSource map = new MapSqlParameterSource();
	    map.addValue("id", moduloE.getId());
	    map.addValue("nombre", moduloE.getNombre()); // Variables bind
		map.addValue("gramaje", moduloE.getGramaje());
		map.addValue("descripcion", moduloE.getDescripcion());
		


	    // Armar la sentencia de actualización debase de datos
	    String query =
	        "UPDATE moduloe SET NOMBRE = : nombre, GRAMAJE = :gramaje, DESCRIPCION = :descripcion  WHERE ID = :id";

	    // Ejecutar la sentencia
	    
	    int result = 0;
	    try {
	      result = springDbMgr.executeDml(query, map);
	    } catch (Exception e) {
	      e.printStackTrace();
	      new Exception();
	    }
	    // Si hubieron filas afectadas es por que si hubo registro, en caso contrario muestra el mensaje
	    // de error.
	    return (result == 1) ? "Actualizacion exitosa"
	        : "Error al actualizar la actividad. Contacte al administrador del sistema.";
	}
	
	
	

	public String eliminarModuloE(ModuloE moduloE) {
		// Agrego los datos de la eliminación (nombreColumna/Valor)
	    MapSqlParameterSource map = new MapSqlParameterSource();
	    map.addValue("id", moduloE.getId());

	    // Armar la sentencia de actualización de base de datos
	    String query = "DELETE FROM moduloe WHERE ID = :id";

	    // Ejecutar la sentencia
	    int result = 0;
	    try {
	      result = springDbMgr.executeDml(query, map);
	    } catch (Exception e) {
	      new Exception();
	    }
	    // Si hubieron filas afectadas es por que si hubo registro, en caso contrario muestra el mensaje
	    // de error.
	    return (result == 1) ? "Eliminacion exitosa"
	        : "Error al eliminar la actividad. Contacte al administrador del sistema.";
	}
	

	

}
