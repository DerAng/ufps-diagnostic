package co.ufps.edu.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.model.ModuloA;
import co.ufps.edu.model.ModuloC;


public class ModuloCDao {

	private SpringDbMgr springDbMgr;
	
	
	
	public ModuloCDao() {
		springDbMgr = new SpringDbMgr();
	}

	public List<ModuloC> getModulosC(){
		List<ModuloC> modulosC = new ArrayList<>();
		
		// Consulta para realizar en base de datos
	    SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT * FROM moduloc");

	    // Recorre cada registro obtenido de base de datos
	    while (sqlRowSet.next()) {
	    	ModuloC m = new ModuloC();
	    	
	    	m.setId(sqlRowSet.getInt("id"));
	    	m.setSobrenombre(sqlRowSet.getString("sobrenombre"));
	    	m.setEmail(sqlRowSet.getString("email"));
	    	m.setCantidad(sqlRowSet.getInt("Cantidad"));

	    	modulosC.add(m);
	    }

		return modulosC;
	}
	
	
	 	
	public String registrarModuloC(ModuloC moduloC) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("sobrenombre", moduloC.getSobrenombre()); // Variables bind
		map.addValue("email", moduloC.getEmail());
		map.addValue("cantidad", moduloC.getCantidad());
				
		
		// Armar la sentencia de actualización debase de datos
	    String query =
	        "INSERT INTO moduloC(sobrenombre,email,cantidad) VALUES(:sobrenombre,:email,:cantidad)";

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
	
	/*

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
	
	*/


}
