package es.uniovi.asw.parser;

import es.uniovi.asw.model.Candidature;

public class CheckFailsCandidature {

	public static boolean check(Candidature candidature){
		return comprobarFallosNombre(candidature) && comprobarFallosInitial(candidature)
				&& comprobarFallosDescripcion(candidature);
	}

	public static boolean comprobarFallosDescripcion(Candidature candidature) {
		if (candidature.getDescription() == null || candidature.getDescription().equals("")) {
			System.out.println(" Descripción vacía --- ---");
			return false;
		}
		return true;
	}

	public static boolean comprobarFallosInitial(Candidature candidature) {
		if (candidature.getInitial() == null || candidature.getInitial().equals("")) {
			System.out.println(" Inicio vacío --- ---");
			return false;
		}
		return true;
	}

	public static boolean comprobarFallosNombre(Candidature candidature) {
		if (candidature.getName() == null || candidature.getName().equals("")) {
			System.out.println(" Nombre de la candidatura vacío --- ---");
			return false;
		}
		return true;
	}
}
