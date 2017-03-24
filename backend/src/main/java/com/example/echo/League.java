package com.example.echo;


import java.util.ArrayList;
import java.util.List;

public class League{

	private List<Team> teams;

	public League(){
		teams = new ArrayList<Team>();
		addTeamsToList();
	}

	public List<Team> getTeamList(){
	return teams;
	}


	public void addTeamsToList(){
		Team AmericaDeCali = new Team("America De Cali", 13, 1927);
		Team Nacional = new Team("Atletico Nacional", 15, 1947);
		Team Cali = new Team("Deportivo Cali", 9, 1912);
		Team SantaFe = new Team("Independiente SantaFe", 9, 1941);
		Team Junior = new Team("Junior de Barranquilla", 7, 1924);
		Team Medellin = new Team("Independiente Medellin", 6, 1913);
		Team OnceCaldas = new Team("Once Caldas", 4, 1947);
		Team Tolima = new Team("Deportes Tolima", 1, 1954);
		Team Pasto = new Team("Deportivo Pasto", 1, 1949);
		Team Equidad = new Team("La Eauidad", 0, 1982);
		Team Quindio = new Team("Deportes Quindio", 1, 1951);
		Team Chico = new Team("Boyacá Chicó", 1, 2002);
		Team Magdalena = new Team("Union Magdalena", 1, 1953);
		Team Cucuta = new Team("Cucuta Deportivo",1, 1924);

		teams.add(AmericaDeCali);
		teams.add(Nacional);
		teams.add(Cali);
		teams.add(SantaFe);
		teams.add(Junior);
		teams.add(Medellin);
		teams.add(OnceCaldas);
		teams.add(Tolima);
		teams.add(Pasto);
		teams.add(Equidad);
		teams.add(Quindio);
		teams.add(Chico);
		teams.add(Magdalena);
		teams.add(Cucuta);

	}

	public Team searchTeamWithName(Team team){
		Team found = null;
		for(int i = 0; i < teams.size();i++){
			found = teams.get(i);
			if(found.getName().trim().contains(team.getName().trim()))
				return found;
		}
		return null;
	}

	public Team deleteTeam(Team team){
		Team found = null;
		boolean end = false;
		for(int i = 0; i < teams.size()-1 && !end;i++){
			found = teams.get(i);
			if(found.getName().contains(team.getName())){
				end = true;
				teams.remove(i);
			}
				
		}
		return found;
	}

	public Team editTeam(String name, int cantidadDeTitulos,int fundationYear){
		Team t = searchTeamWithName(new Team(name));
    	t.setFundationYear(fundationYear);
    	t.setCantidadDeTitulos(cantidadDeTitulos);
		return t;
	}

	public Team createTeam(String name, int cantidadDeTitulos,int fundationYear){
		Team t = searchTeamWithName(new Team(name));
    	if(t == null){
    		t = new Team(name, cantidadDeTitulos,fundationYear);
    		teams.add(t);
    	}
    		
		return t;
	}
}