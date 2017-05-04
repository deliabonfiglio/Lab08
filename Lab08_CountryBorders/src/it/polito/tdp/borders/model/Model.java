package it.polito.tdp.borders.model;

import java.util.*;

import org.jgrapht.*;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.*;
import it.polito.tdp.borders.db.BordersDAO;

public class Model {
	private UndirectedGraph<Country,DefaultEdge> graph;
	
	//ci sono 2 classi definite dalla libreria che sono DefaultEdge e DefalutVertex
	//i vertici sono le nazioni e gli archi sono DefaultEdge
	private BordersDAO dao;
	private List<Country> allcountries;
	private int anno;
	
	public Model(){
		dao = new BordersDAO();	
		this.allcountries= new ArrayList<Country>(dao.loadAllCountries());
		//System.out.println(allcountries.toString());
		anno=0;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public Set<Country> creaGrafo(){
		this.graph= new SimpleGraph<Country, DefaultEdge>(DefaultEdge.class);
		
//3. faccio fare tutto al DAO==> mi deve dare un insieme di coppie di vertici legate da archi
//non itero sui vertici ma chiedo al dao un elenco di coppie di country adiacenti
	//Complessità = grado* 1 query
		
		//System.out.println("---\n"+dao.getCountryPairs(anno).size());
		
		for(Border cp: dao.getCountryPairs(anno)){	
			Country c1 =this.findCountry(cp.getCod1());
			Country c2 = this.findCountry(cp.getCod2());
				
			graph.addVertex(c1);
			graph.addVertex(c2);
			graph.addEdge(c1, c2);
		}
		System.out.println(graph.toString());
		System.out.println("\nn vertici: "+graph.vertexSet().size());
		return graph.vertexSet();
		
	}
	
//il metodo displayNeighbours non funzionava perchè cercava sul grafo che ancora non era stato riempito con i vertici!
	
	public int numNeighbours(Country ctemp){
		return graph.degreeOf(ctemp);
	}
	
//quell'accrocco con il get che prendeva il country uguale dalla lista non funzionava, chiedi perchè!!!
	//Ho dovuto fare il metodo che lo fa:
	
	private Country findCountry(int code){		
		for(Country ctemp: allcountries){
			if(ctemp.getCcode()==code)
				return ctemp;
		}
		return null;
	}
	
//punto 4 :  numero di componenti connesse nel grafo.
	public int getNumberOfConnectedComponents(){
		ConnectivityInspector<Country,DefaultEdge> c= new ConnectivityInspector<Country,DefaultEdge>(graph);		
//Returns a list of Set s, where each set contains all vertices that are in the same maximally connected component.
		return c.connectedSets().size();
	}
}
