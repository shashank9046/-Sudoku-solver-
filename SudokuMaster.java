public class SudokuMaster {
	static boolean solve(int grid [] [],int N) {
		int i = 0;
		int j = 0;
		boolean flag=false;
		for(i=0;i<N;i++) {
			for(j=0;j<N;j++) {
				if(grid[i][j]==0) {
					flag=true;
					break;
				}
			}
			if(flag) {
				break;
			}
		}
		if(!flag) {
			return true;
		}
		for(int k=1;k<=N;k++) {
			if(safe(grid,i,j,k,N)) {
				grid[i][j]=k;
				if(solve(grid,N)) {
					return true;
				}
				else {
					grid[i][j]=0;
				}
			}
		}
		return false;
	}
	static boolean safe(int grid [][],int i,int j,int k,int N) {
		for(int l=0;l<N;l++) {
			if(grid[l][j]==k||grid[i][l]==k) {
				return false;
			}
		}
		int s=(int)Math.sqrt(N);
		int rs= i-i%s;
		int cs= j-j%s;
		for(int m=0;m<s;m++) {
			for(int n=0;n<s;n++) {
				if(grid[m+rs][n+cs]==k) {
					return false;
				}
			}
		}
		return true;
	}
	static void print(int grid[][],int N) {
		 for (int r = 0; r < N; r++) { 
	            for (int c = 0; c < N; c++) { 
	                System.out.print(grid[r][c]); 
	                System.out.print(" "); 
	            } 
	            System.out.print("\n"); 
	  
	            if ((r + 1) % (int)Math.sqrt(N) == 0) { 
	                System.out.print(""); 
	            } 
	        } 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = new int[][] { 
            { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 }, 
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, 
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 } 
        }; 
        int N = grid.length; 
        System.out.println("The input grid is...");
        System.out.println();                                                                              
        print(grid,N);
        System.out.println();
        System.out.println("x-----------x-----------x-----------x");
        System.out.println();
        if (solve(grid, N)) { 
            // print solution 
        	System.out.println("The solution is...");
        	System.out.println();
            print(grid, N); 
        } 
        else { 
            System.out.println("No solution"); 
        } 
    } 
} 
