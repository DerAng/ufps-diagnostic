package co.ufps.edu.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import co.ufps.edu.bd.SpringDbMgr;
import co.ufps.edu.model.ModuloA;
import co.ufps.edu.model.ModuloD;

public class ModuloDDao {

	private SpringDbMgr springDbMgr;
	
	
	public ModuloDDao() {
		
		springDbMgr = new SpringDbMgr();
		
	}
	
	public List<ModuloD> getModulosD(){
		
		List<ModuloD> ModuloD = new ArrayList<>();
		
		// Consulta para realizar en base de datos
	    SqlRowSet sqlRowSet = springDbMgr.executeQuery("SELECT * FROM modulod");
		
	    while(sqlRowSet.next()) {
	    	
	    	ModuloD d = new ModuloD();
	    	
	    	d.setId(sqlRowSet.getInt("id"));
	    	d.setActividad(sqlRowSet.getString("actividad"));
	    	d.setLocalidad(sqlRowSet.getString("localidad"));
	    	d.setSabor(sqlRowSet.getString("sabor"));
	    	
	    	ModuloD.add(d);	
	    	
	    }
	    
	    return ModuloD;
	}
	
	public String registrarModuloD(ModuloD moduloD) {
		
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("actividad", moduloD.getActividad());
		map.addValue("localidad", moduloD.getLocalidad());
		map.addValue("sabor", moduloD.getSabor());
		
		
		// Armar la sentencia de actualización debase de datos
		String query = "INSERT INTO modulod(actividad,localidad,sabor) VALUES (:actividad,:localidad,:sabor)";
		
		int result = 0;
		try {
			result= springDbMgr.executeDml(query, map);
		} catch (Exception e) {
			new Exception();
		}
		
		 // Si hubieron filas afectadas es por que si hubo registro, en caso contrario muestra el mensaje
	    // de error.
		return(result == 1) ? "Registro exitoso"
				:"Error al registrar la actividad. Contacte al administrador del sistema.";
	}
	
	public ModuloD getModuloPorId(long idModuloD) {
		// Lista para retornar con los datos
	    ModuloD moduloD = new ModuloD();

	    // Consulta para realizar en base de datos
	    MapSqlParameterSource map = new MapSqlParameterSource();
	    map.addValue("id", idModuloD);
	    SqlRowSet sqlRowSet = springDbMgr.executeQuery(" SELECT * FROM modulod WHERE id = :id", map);

	    // Consulto si la actividad existe
	    if (sqlRowSet.next()) {
	      // Almaceno los datos de la actividad
	    	moduloD.setId(sqlRowSet.getInt("id"));
	    	moduloD.setActividad(sqlRowSet.getString("actividad"));
	    	moduloD.setLocalidad(sqlRowSet.getString("localidad"));
	    	moduloD.setSabor(sqlRowSet.getString("sabor"));
	    }
	    // Retorna la actividad desde base de datos
	    return moduloD;
	}

	public String actualizarModuloD(ModuloD moduloD) {
		// Agrego los datos del registro (nombreColumna/Valor)
	    MapSqlParameterSource map = new MapSqlParameterSource();
	    map.addValue("id", moduloD.getId());
	    map.addValue("actividad", moduloD.getActividad()); // Variables bind
		map.addValue("localidad", moduloD.getLocalidad());
		map.addValue("sabor", moduloD.getSabor());


	    // Armar la sentencia de actualización debase de datos
	    String query =
	        "UPDATE modulod SET actividad = :actividad, localidad = :localidad, sabor = :sabor WHERE id = :id";

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

	public String eliminarModuloD(ModuloD moduloD) {
		// Agrego los datos de la eliminación (nombreColumna/Valor)
	    MapSqlParameterSource map = new MapSqlParameterSource();
	    map.addValue("id", moduloD.getId());

	    // Armar la sentencia de actualización debase de datos
	    String query = "DELETE FROM modulod WHERE id = :id";

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
