package test4;

public class pond {
	
	private static int[] dirrow = {-1,0,1,0};
	private static int[] dircol = {0,1,0,-1};
	private static boolean check;
	static int pond[][] = { 
			  {0,0,0,0,0,0,0,0,0,0},
 			  {0,0,0,0,1,0,0,0,0,0},
 			  {0,0,0,1,1,1,0,0,0,0},
 			  {0,1,1,1,1,1,1,0,0,0},
 			  {0,1,1,1,1,1,1,1,1,0},
 			  {0,1,1,1,1,1,1,1,1,0},
 			  {0,0,1,1,1,1,1,1,0,0},
 			  {0,0,0,1,1,1,1,0,0,0},
 			  {0,0,0,0,1,0,0,0,0,0},
 			  {0,0,0,0,0,0,0,0,0,0}
			}; 
	
	public static void dfs(int row, int col) {
		for(int i = 0; i < pond.length; i++) {
			for(int j = 0; j < pond[i].length; j++) {
				for(int k = 0; k < 4; k++) {
					int r = i + dirrow[k];
					int c = j + dircol[k];
					
					if(r < 0 || r == pond.length || c < 0 || c == pond[i].length) {
						check = false;
						break;
					} else {
						check = true;
					}
				}
				
				if(check) {
					if(pond[i][j] != 0 && 
					   pond[i-1][j] >= pond[i][j] && 
					   pond[i+1][j] >= pond[i][j] && 
					   pond[i][j-1] >= pond[i][j] && 
					   pond[i][j+1] >= pond[i][j]) {
						pond[i][j] += 1;
						dfs(i,j);
					} 
				}
				
				
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		
		for(int i = 0; i < pond.length; i++) {
			for(int j = 0; j < pond[i].length; j++) {
				dfs(i,j);
				System.out.print(pond[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}
}
