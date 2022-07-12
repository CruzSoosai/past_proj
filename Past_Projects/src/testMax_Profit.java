

public class testMax_Profit {
	
	public static void main(String[] args) {
		Max_Profit.Project[] projects = {
			new Max_Profit.Project("a", 3, 5),
			new Max_Profit.Project("b", 2, 20),
			new Max_Profit.Project("c", 2, 15),
			new Max_Profit.Project("d", 3, 1),
			new Max_Profit.Project("e", 1, 10)
		};
		
		Max_Profit.findOptimalProjectScheule(projects);
	}
	
}
