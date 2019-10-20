package co.ufps.edu.constantes;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Constantes {

	public static final String ROL_ESTUDIANTE="ESTUDIANTE";
	public static final String ROL_PROFESOR="PROFESOR";
	public static final String ROL_DIRECTOR="DIRECTOR";
	public static final String ROL_VICERRECTOR="VICERRECTOR";
	
	
	public static final String PROYECTO = "ufps-diagnostic";
	// For development
	// public static final String RUTA = "ufps-graduados";
	// For production
	public static final String RUTA = "/";
	// For development
	// public static final String SERVER = "/";
	// For production
	public static final String SERVER = "";

	private static String getServer() {
		try {
			return InetAddress.getLocalHost().getCanonicalHostName().split("/")[0];
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return "";
	}

}
