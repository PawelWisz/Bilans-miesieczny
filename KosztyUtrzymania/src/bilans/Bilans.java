package bilans;

import java.util.Scanner;
import java.util.regex.Pattern;

import utrzymanie.*;

public class Bilans {

public static Przychod przychod = new Przychod();
public static Wynejem wynajem = new Wynejem();
public static Zycie zycie = new Zycie();
public static Koszta koszt = new Koszta();


	public Double getDochod1() {
		 Double Dochod1;
		 Dochod1 = przychod.getP1();
		return Dochod1;
	}

	public Double getDochod2() {
		Double  Dochod2;
		Dochod2 = przychod.getP2();
		return Dochod2;
	}

	public Double getSuma() {
		Double suma;
		suma = przychod.getSumaprzychodow();
		return suma;
	}
	
	public Double getCzynsz() {
		Double czynsz = wynajem.getCzynsz();
		return czynsz;
	}

	public Double getPrad() {
		Double prad = wynajem.getPrad();
		return prad;
	}
	
	public Double getTV() {
		Double TV = wynajem.getInternet();
		return TV;
	}

	public Double getSumaRach() {
		Double suma = wynajem.getSumaWynajmu();
		return suma;
	}
	
	public Double getJedzenie() {
		double jedzenie = zycie.getJedzienie();
	return jedzenie;
	}
	
	public Double getRestauracjce() {
		double restauracje = zycie.getRestauracje();
	return restauracje;
	}	
	
	public Double getPyszne() {
		double pyszne = zycie.getPszynepl();
	return pyszne;
	}
	
	public Double getSumaJed() {
		double suma = zycie.getSumaZycia();
		return suma;
	}
	
	public Double getPapierosy() {
		double papierosy = koszt.getPapierosy();
		return papierosy;
	}
	
	public Double getLucek() {
		double lucek = koszt.getLucek();
		return lucek;
	}

	public Double getHonda() {
		double honda = koszt.getHonda();
		return honda;
	}

	public Double getKredyt() {
		double kredyt = koszt.getKredyt();
		return kredyt;
	}
	
	public Double getDziadek() {
		double dziadek = koszt.getDziadek();
		return dziadek;
	}
	
	public Double getInne() {
		double inne = koszt.getInne();
		return inne;
	}
	
	public Double getSumaOP() {
		double oplaty=koszt.getSumaKosztow();
		return oplaty;
	}
	
	public Double getBilansMiesiaca() {
		double bilans = przychod.getSumaprzychodow()-(wynajem.getSumaWynajmu()+zycie.getSumaZycia()+koszt.getSumaKosztow());
		return bilans;
	}

	public void SumaPrzychodow(String jeden, String dwa) {

		double sumaPrzychodow;
	
		double pomoc2;
			if(Pattern.matches("[0-9]+\\.?[0-9]*",jeden)==true) {
				pomoc2 =Double.parseDouble(jeden);
				przychod.setP1(pomoc2);}
			else {
			}
		
			if(Pattern.matches("[0-9]+\\.?[0-9]*",dwa)==true) {
				pomoc2 =Double.parseDouble(dwa);
				przychod.setP2(pomoc2);}
			else {
			}

		
	sumaPrzychodow=przychod.getP1()+przychod.getP2();	
	
	przychod.setSumaprzychodow(sumaPrzychodow);
	System.out.println(przychod.getSumaprzychodow());
	
	
	
	
	}

	public void Rachunki(String czynsz, String prad, String TV/*,String inne*/) {

		
		double rachunki;

		
		double pomoc2;

			if(Pattern.matches("[0-9]+\\.?[0-9]*",czynsz)==true) {
				pomoc2 = Double.parseDouble(czynsz);
				wynajem.setCzynsz(pomoc2);}
			else {}

	if(Pattern.matches("[0-9]+\\.?[0-9]*",prad)==true) {
		pomoc2 = Double.parseDouble(prad);
		wynajem.setPrad(pomoc2);}
	else {}

			if(Pattern.matches("[0-9]+\\.?[0-9]*",TV)==true) {
				pomoc2 = Double.parseDouble(TV);
				wynajem.setInternet(pomoc2);}
			else {}


		rachunki = wynajem.getCzynsz()+wynajem.getPrad()+wynajem.getInternet();
		wynajem.setSumaWynajmu(rachunki);
		System.out.println(wynajem.getSumaWynajmu());
	}
	
	public void Zycie(String jedzenie, String restauracje, String pyszne) {
		double rachunki;
	
		double pomoc2;
		

		if(Pattern.matches("[0-9]+\\.?[0-9]*",jedzenie)==true) {
			pomoc2 = Double.parseDouble(jedzenie);
			zycie.setJedzienie(pomoc2);}
		else
			System.out.println("Blad w zapisie, powtorz");
		
		if(Pattern.matches("[0-9]+\\.?[0-9]*",restauracje)==true) {
			pomoc2 = Double.parseDouble(restauracje);
			zycie.setRestauracje(pomoc2);}
		else
			System.out.println("Blad w zapisie, powtorz");

		if(Pattern.matches("[0-9]+\\.?[0-9]*",pyszne)==true) {
			pomoc2 = Double.parseDouble(pyszne);
			zycie.setPszynepl(pomoc2);}
		else
			System.out.println("Blad w zapisie, powtorz");
		

		rachunki = zycie.getJedzienie()+zycie.getRestauracje()+zycie.getPszynepl();
		
		zycie.setSumaZycia(rachunki);
		
		}
		
	public void Koszta(String papierosy,String lucek, String honda, String kredyt, String dziadek, String inne){
		double pomoc2;
		double suma;
		
		if(Pattern.matches("[0-9]+\\.?[0-9]*",papierosy)==true) {
			pomoc2 = Double.parseDouble(papierosy);
			koszt.setPapierosy(pomoc2);}
		else
			System.out.println("Blad w zapisie, powtorz");
		
		if(Pattern.matches("[0-9]+\\.?[0-9]*",lucek)==true) {
			pomoc2 = Double.parseDouble(lucek);
			koszt.setLucek(pomoc2);}
		else
			System.out.println("Blad w zapisie, powtorz");
		
		if(Pattern.matches("[0-9]+\\.?[0-9]*",honda)==true) {
			pomoc2 = Double.parseDouble(honda);
			koszt.setHonda(pomoc2);}
		else
			System.out.println("Blad w zapisie, powtorz");
		
		if(Pattern.matches("[0-9]+\\.?[0-9]*",kredyt)==true) {
			pomoc2 = Double.parseDouble(kredyt);
			koszt.setKredyt(pomoc2);}
		else
			System.out.println("Blad w zapisie, powtorz");
		
		if(Pattern.matches("[0-9]+\\.?[0-9]*",dziadek)==true) {
			pomoc2 = Double.parseDouble(dziadek);
			koszt.setDziadek(pomoc2);}
		else
			System.out.println("Blad w zapisie, powtorz");
		
		if(Pattern.matches("[0-9]+\\.?[0-9]*",inne)==true) {
			pomoc2 = Double.parseDouble(inne);
			koszt.setInne(pomoc2);}
		else
			System.out.println("Blad w zapisie, powtorz");
		
		suma = koszt.getPapierosy()+koszt.getLucek()+koszt.getHonda()+koszt.getKredyt()+koszt.getDziadek()+koszt.getInne();
	
		koszt.setSumaKosztow(suma);
	}
		
		
	
}
		
		
		
		
		
		
		


