package it.polito.tdp.exam.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.exam.db.BaseballDAO;

public class Model {
	
	private BaseballDAO dao;
	
	List<Team> vertici;
	
	List<Adiacenze> anni;
	
	List<Salary> s1;
	
	List<Salary> s2;
	
	Map<Integer, Team> idMap;
	
	private Graph<Team, DefaultWeightedEdge> grafo;
	
	
	public Model() {
		
		dao = new BaseballDAO();
		
		vertici = new ArrayList<>();
		
		anni = new ArrayList<>();
		
		idMap = new HashMap<>();
		
		s1 = new ArrayList<>();
		
		s2 = new ArrayList<>();
		
		
	}
	
	public void creaGrafo(String name) {
		
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		//Vertici
		
		vertici = this.dao.getVertici(name,idMap);
			
		Graphs.addAllVertices(this.grafo, vertici);
		
		//Archi
		
		anni = this.dao.getAdianceze(name, idMap);
		
		
		
		for(Adiacenze a : anni) {
			Double costo1 = 0.0;
			Double costo2 = 0.0;
			s1 = dao.getSalary(a.getT1().getTeamCode());
			s2 = dao.getSalary(a.getT1().getTeamCode());
			for(Salary s: s1) {
				costo1 += s.getSalary();
			}
			
				Graphs.addEdgeWithVertices(this.grafo, a.getT1(), a.getT2(), 0);
		}

		
		
	}
	
	
	
	
	
	
	public List<String> getSquadre() {
		List<String> squadre = new ArrayList<>(this.dao.readSquadre());
		return squadre;
	}
	
	

	public List<Team> getVertici() {
		return vertici;
	}

	public int nVertici() {
		return this.grafo.vertexSet().size();
	}

	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	
}
