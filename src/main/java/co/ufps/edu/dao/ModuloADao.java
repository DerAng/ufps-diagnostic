package co.ufps.edu.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.model.ModuloA;


public class ModuloADao {

	private SpringDbMgr springDbMgr;
	
	
	
	public ModuloADao() {
		springDbMgr = new SpringDbMgr();
	}

	public List<ModuloA> getModulosA(){
		List<ModuloA> modulosA = new ArrayList<>();
		
		// Consulta para realizar en base de datos
	    SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT * FROM moduloa");

	    // Recorre cada registro obtenido de base de datos
	    while (sqlRowSet.next()) {
	    	ModuloA m = new ModuloA();
	    	
	    	m.setId(sqlRowSet.getInt("ID"));
	    	m.setNombre(sqlRowSet.getString("NOMBRE"));
	    	m.setApellido(sqlRowSet.getString("APELLIDO"));
	    	m.setEmail(sqlRowSet.getString("EMAIL"));
	    	m.setGenero(sqlRowSet.getString("GENERO"));

	    	modulosA.add(m);
	    }

		return modulosA;
	}
	
	public String registrarModuloA(ModuloA moduloA) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("nombre", moduloA.getNombre()); // Variables bind
		map.addValue("apellido", moduloA.getApellido());
		map.addValue("email", moduloA.getEmail());
		if(moduloA.getGenero().toUpperCase().equals("MASCULINO")) {
			map.addValue("genero", "M");
		}else {
			map.addValue("genero", "F");
		}
		
		
		
		// Armar la sentencia de actualización debase de datos
	    String query =
	        "INSERT INTO moduloA(NOMBRE,APELLIDO,EMAIL,GENERO) VALUES(:nombre,:apellido,:email,:genero)";

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

	public ModuloA getModuloPorId(long idModuloA) {
		// Lista para retornar con los datos
	    ModuloA moduloA = new ModuloA();

	    // Consulta para realizar en base de datos
	    MapSqlParameterSource map = new MapSqlParameterSource();
	    map.addValue("id", idModuloA);
	    SqlRowSet sqlRowSet = springDbMgr.executeQuery(" SELECT * FROM moduloA WHERE ID = :id", map);

	    // Consulto si la actividad existe
	    if (sqlRowSet.next()) {
	      // Almaceno los datos de la actividad
	    	moduloA.setId(sqlRowSet.getInt("ID"));
	    	moduloA.setNombre(sqlRowSet.getString("NOMBRE"));
	    	moduloA.setApellido(sqlRowSet.getString("APELLIDO"));
	    	moduloA.setEmail(sqlRowSet.getString("EMAIL"));
	    	if(sqlRowSet.getString("GENERO").equals("M")) {
	    		moduloA.setGenero("Masculino");
	    	}else {
	    		moduloA.setGenero("Femenino");
	    	}
	    }
	    // Retorna la actividad desde base de datos
	    return moduloA;
	}

	public String actualizarModuloA(ModuloA moduloA) {
		// Agrego los datos del registro (nombreColumna/Valor)
	    MapSqlParameterSource map = new MapSqlParameterSource();
	    map.addValue("id", moduloA.getId());
	    map.addValue("nombre", moduloA.getNombre()); // Variables bind
		map.addValue("apellido", moduloA.getApellido());
		map.addValue("email", moduloA.getEmail());
		if(moduloA.getGenero().toUpperCase().equals("MASCULINO")) {
			map.addValue("genero", "M");
		}else {
			map.addValue("genero", "F");
		}


	    // Armar la sentencia de actualización debase de datos
	    String query =
	        "UPDATE moduloa SET NOMBRE = :nombre, APELLIDO = :apellido, EMAIL = :email, GENERO = :genero  WHERE ID = :id";

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

	public String eliminarModuloA(ModuloA moduloA) {
		// Agrego los datos de la eliminación (nombreColumna/Valor)
	    MapSqlParameterSource map = new MapSqlParameterSource();
	    map.addValue("id", moduloA.getId());

	    // Armar la sentencia de actualización debase de datos
	    String query = "DELETE FROM moduloa WHERE ID = :id";

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
