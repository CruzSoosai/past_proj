import java.util.Arrays;

/**
 * Given available projects and with their compensation and remaining deadlines
 * Find the schedule that will maximize profit.
 */
public class Max_Profit {

	public static int latest_due = 0;

	public static class Project implements Comparable<Project> {
		public String name;
		public int due;
		public int payment;


		public Project(String name, int due, int payment){
			this.name=name;
			this.due=due;
			this.payment=payment;
			if(due>latest_due) {
				latest_due = due;
			}
		}

		@Override
		public int compareTo(Project p) {
			if(this.payment < p.payment) {return 1;}
			else if(this.payment == p.payment) {
				if(this.due==p.due) {
					return 0;
				}
				else {
					return (this.due>p.due) ? -1 : 1;
				}
			}
			else { return -1;}
		}

		@Override
		public String toString() {
			return "\n[" + name + ": Payment for Completion = " + payment + ", Due in = " + due + "hrs]";
		}
	}

	public static Project[] findOptimalProjectScheule(Project[] projects){
		System.out.println("Available Projects:\n" + Arrays.toString(projects));
		Arrays.sort(projects);

		Project[] projSchedule = new Project[latest_due];
		for (int i=0; i < projSchedule.length; ++i) {
			projSchedule[i] = null;
		}
		for(Project p: projects) {
			place(p,projSchedule);
		}
		System.out.println("Optimized Schedule:\n" + Arrays.toString(projSchedule));
		return projSchedule;
	}

	static void place(Project p, Project[] pS) {
		int j = p.due-1;
		while(j>=0) {
			if(pS[j]==null) {
				pS[j]=p;
				return;
			}
			j--;
		}
	}




}
