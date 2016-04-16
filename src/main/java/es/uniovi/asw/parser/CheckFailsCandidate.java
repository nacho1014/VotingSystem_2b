package es.uniovi.asw.parser;

import es.uniovi.asw.model.Candidate;

public class CheckFailsCandidate {

	public static boolean check(Candidate candidate){
		return comprobarFallosDni(candidate) && comprobarFallosNombre(candidate)
				&& comprobarFallosPartido(candidate);
	}
	
	public static boolean comprobarFallosNombre(Candidate candidate){
		if (candidate.getName() == null || candidate.getName().equals("")) {
			System.out.println(" Nombre vacío --- ---");
			return false;
		}
		return true;
	}
	
	public static boolean comprobarFallosPartido(Candidate candidate){
		if (candidate.getCandidature() == null){
			System.out.println(" Partido vacío --- ---");
			return false;
		}
		return true;
	}
	
	public static boolean comprobarFallosDni(Candidate candidate){
		if (candidate.getDNI() == null || candidate.getDNI().equals("")) {
			System.out.println(" NIF vacío --- ---");
			return false;
		} else if ((!Character.isLetter(candidate.getDNI().charAt(candidate.getDNI().length() - 1))) 
				|| (!(candidate.getDNI().length() == 9))) {
			System.out.println(" NIF no válido --- " + candidate.getDNI() + " ---");
			return false;
		}
		return true;
	}
}
