package provaDNivel;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Planets {
	private List<Planets> planets;

	public Planets() {
		this.planets = new ArrayList<>();
	}

	public void registerPlanet(Planets planet) {
		planets.add(planet);
	}

	public Planets getPlanetWithBiggestRadius() {
		return planets.stream()
			.max((p1, p2) -> Double.compare(p1.getRadius(), p2.getRadius()))
			.orElse(null);
	}	

	public List<Planets> getPlanetsSortedBySatellites() {
		return planets.stream()
			.sorted((p1, p2) -> Integer.compare(p2.getNumberOfSatellites(), 
											  p1.getNumberOfSatellites()))
			.collect(Collectors.toList());
	}		

	public static void main(String[] args) {
		Planets solarSystem = new Planets();
//Ejemplo de uso
		Planets earth = new Planets();
		Satellite moon = new Satellite("Moon", 1.62, 7.34767309e22, 1.737e6, 27.32, 27.32);
		earth.addSatellite(moon);
		
		solarSystem.registerPlanet(earth);
		

		
		Planets biggestPlanet = solarSystem.getPlanetWithBiggestRadius();
		System.out.println("Planet with the biggets radius " + biggestPlanet.getName());

		
		List<Planets> sortedPlanets = solarSystem.getPlanetsSortedBySatellites();
		System.out.println("Planets sorted by number of satellites");
		sortedPlanets.forEach(p -> 
			System.out.println(p.getName() + ": " + p.getNumberOfSatellites()));
	}

	private String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	private int getNumberOfSatellites() {
		// TODO Auto-generated method stub
		return 0;
	}

	private void addSatellite(Satellite moon) {
		// TODO Auto-generated method stub
		
	}
}
