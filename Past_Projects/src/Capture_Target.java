import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * Given a board representing a 3D Building
 * Move from breaching point(B) along spaces(_) to the target (T) 
 * Can move and breach up/down floors, left/right and forward/back except if blocked(X) and no diagonals
 * Find the minimum number of moves to reach the target.
 */
public class Capture_Target {
	public static int find_target(String[][][] building) {
		int nZ = building.length; // floors
		int nY = (building[0]).length; // length
		int nX = (building[0][0]).length; // width
		boolean[][][] visited = new boolean[nZ][nY][nX];
		String s = "B";
		int [] start = new int [3];
		boolean none = true;
		outerloop:
			for(int i=0; i < building.length ; i++){
				for( int j=0 ; j < building[i].length ; j++){
					for(int k=0 ; k < building[i][j].length ; k++){
						if( building[i][j][k].equals("B") || building[i][j][k].equals("T") ) {
							start = new int [] {i,j,k};
							s = (building[i][j][k].equals("B")) ?  "T" : "B";
							none=false;
							break outerloop;
						}
						else {
							visited [i][j][k] = true;
						}
					}
				}
			}
		if(none) return -1;
		visited = new boolean[nZ][nY][nX];
		int r = bf_search(start, building, visited, s);
		if(r==0) return -1;
		return r;
	}

	static int bf_search(int [] startLoc, String[][][] building, boolean[][][] visited, String match) {
		int count = 0;
		Queue<int []> queue = new LinkedList<>();
		int[] depth_marker = {-1};
		queue.offer(startLoc);
		queue.offer(depth_marker);
		int z = startLoc[0]; int y = startLoc[1]; int x = startLoc[2];
		visited[z][y][x] = true;

		while(true) {
			int [] loc = queue.poll();
			if (loc[0] == -1) {
				if (queue.isEmpty()) break;
				queue.offer(depth_marker);
				count++;
			} 
			else {
				int zc = loc[0]; int yc = loc[1]; int xc = loc[2];

				if(building[zc][yc][xc].equals(match)) {
					return count;
				}
				visited[zc][yc][xc] = true;

				List<int []> proximal_locs = adjacent_locs(building, new int [] {zc,yc,xc});
				if (proximal_locs != null) {
					for (int [] next : proximal_locs) {
						int zp = next[0]; int yp = next[1]; int xp = next[2];
						if (!visited[zp][yp][xp]) {
							visited[zp][yp][xp] = true;
							queue.offer(next);
						}
					}
				}
			}
		}

		return count;
	}

	static List<int []> adjacent_locs(String[][][] building, int [] position){
		List<int []> proximal_locs = new ArrayList<int []>();
		int nZ = building.length; int nY = (building[0]).length; int nX = (building[0][0]).length;
		int z = position[0]; int y = position[1]; int x = position[2];
		if(x>0) {
			if(!building[z][y][x-1].equals("X")) {
				proximal_locs.add(new int [] {z,y,x-1});
			}
		}
		if(x<nX-1) {
			if(!building[z][y][x+1].equals("X")) {
				proximal_locs.add(new int [] {z,y,x+1});
			}
		}
		if(y>0) {
			if(!building[z][y-1][x].equals("X")) {
				proximal_locs.add(new int [] {z,y-1,x});
			}
		}
		if(y<nY-1) {
			if(!building[z][y+1][x].equals("X")) {
				proximal_locs.add(new int [] {z,y+1,x});
			}
		}
		if(z>0) {
			if(!building[z-1][y][x].equals("X")) {
				proximal_locs.add(new int [] {z-1,y,x});
			}
		}
		if(z<nZ-1) {
			if(!building[z+1][y][x].equals("X")) {
				proximal_locs.add(new int [] {z+1,y,x});
			}
		}
		return proximal_locs;
	}

}
