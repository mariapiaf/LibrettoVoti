package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Libretto {

	private List<Voto> voti; // variabile di tipo lista
	private Map<String, Voto> votiMap; // identity map
	
	public Libretto() {
		this.voti = new ArrayList<Voto>(); // inizializzo la variabile con un nuovo oggetto
		this.votiMap = new HashMap<>();
	}
	
	public void add(Voto v) {
		this.voti.add(v);
		this.votiMap.put(v.getNome(), v);
	}
	
	public void stampaVotiUguali(int punteggio) {
		// il libretto stampa da solo i voti
	}
	/*
	public String votiUguali(int punteggio) {
		// calcola una stringa che contiene i voti
		// sarà poi il chiamante a stamparli
		// creo una stringa, che posso stampare o posso usare per altre cose
		// ma devo stampare solo il nome? o tutto l'esame?
	}
	*/
	public List<Voto> LisatVotiUguali(int punteggio){
		// restituisce solo i voti uguali al criterio
		List<Voto> risultato = new ArrayList<>();
		for(Voto v: this.voti) {
			if(v.getVoto() == punteggio) {
				risultato.add(v);
				// abbiamo agginto a una lista diversa un voto che c'era già
				// stesso oggetto contenuto in due liste diverse
				
			}
		}
		return risultato;
	}

	public Libretto votiUguali(int punteggio) {
		// è un libretto in cui ci metto solo quei voti
		// in questo libretto sono incluse tutte le operazioni che si possono fare su un libretto di partenza))
		Libretto risultato = new Libretto();
		for(Voto v: this.voti) {
			if(v.getVoto() == punteggio) {
				risultato.add(v);
//				risultato.voti.add(v);
			}
		}
		return risultato;
	}
	
	public Voto ricercaCorso(String nomeCorso) {
		/*Voto risultato = null;
		for(Voto v: this.voti) {
			if(v.getNome().equals(nomeCorso)) {
				risultato = v;
				break;
			}
		}
		return risultato;*/
		
		return this.votiMap.get(nomeCorso);
	}
	
	/**
	 * Verifica se nel libretto c'è già un voto con lo stesso esame e la
	 * stessa votazione
	 * @param v
	 * @return
	 */
	
	public boolean esisteDuplicato(Voto v) {
	/*	boolean trovato = false;
		for(Voto voto: this.voti) {
			if(voto.getNome().equals(v.getNome()) && voto.getVoto() != v.getVoto()) {
				trovato = true;
				break;
			}
		}
		return trovato;*/
		
		Voto trovato = this.votiMap.get(v.getNome());
		if(trovato == null)
			return false;
		if(trovato.getVoto()!=v.getVoto())
			return true;
		else
			return false;
		
	}
	
	/**
	 * Verifica se nel libretto c'è già un voto con lo stesso esame ma con voto diverso
	 * @return
	 */
	public boolean esisteConflitto(Voto v) {
		/*	boolean trovato = false;
		for(Voto voto: this.voti) {
			if(voto.getNome().equals(v.getNome()) && voto.getVoto() == v.getVoto()) {
				trovato = true;
				break;
			}
		}
		return trovato;*/
		
		Voto trovato = this.votiMap.get(v.getNome());
		if(trovato == null)
			return false;
		if(trovato.getVoto()==v.getVoto())
			return true;
		else
			return false;
		
		
	}
	public String toString() {
		String s = "";
		for(Voto v: this.voti) {
			s = s + v.toString()+"\n";
		}
		return s;
	}
}
