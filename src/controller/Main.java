package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import dao.CityDAO;
import dao.TeamDAO;
import model.City;
import model.Team;

public class Main 

{
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		CityDAO citydao=new CityDAO();
		TeamDAO teamdao=new TeamDAO();
		
		System.out.println("Enter City Name");
		String cityName=br.readLine();
		
		System.out.println("Enter id");
		long id=Long.parseLong(br.readLine());
		
		City city=new City(id,cityName);
		
		System.out.println("Enter Name");
		String name=br.readLine();
		System.out.println("Enter Coach Name");
		String CoachName=br.readLine();	
		System.out.println("Enter Captain Name");
		String CaptianName=br.readLine();
		Team team=new Team(name,CoachName,CaptianName,city);
		
		teamdao.createTeam(team);
		
		System.out.println(" Enter team name to get deatils of cityname and cityID");
		
		String check=br.readLine();
	   city=	citydao.getCityByName(check);
	
	System.out.println("City id = "+city.getCityId());
	System.out.println("city name = "+city.getCityName());
		
	}
	
}
