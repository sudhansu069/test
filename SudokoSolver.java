import java.util.*;
public class SudokoSolver{


	public static void main(String[] args) {

		SudokoSolver object = new SudokoSolver();
		
		char[][] board = {

			  {'3', '.', '6', '5', '.', '8', '4', '.', '.'},
			  {'5', '2', '.', '.', '.', '.', '.', '.', '.'},
			  {'.', '8', '7', '.', '.', '.', '.', '3', '1'},
			  {'.', '.', '3', '.', '1', '.', '.', '8', '.'},
			  {'9', '.', '.', '8', '6', '3', '.', '.', '5'},
			  {'.', '5', '.', '.', '9', '.', '6', '.', '.'},
			  {'1', '3', '.', '.', '.', '.', '2', '5', '.'},
			  {'.', '.', '.', '.', '.', '.', '.', '7', '4'},
			  {'.', '.', '5', '2', '.', '6', '3', '.', '.'}
		};
        object.printBoard(board);
        object.solve(board);
        object.printBoard(board);


	}


	public void printBoard(char[][] board){

          for(int i =0;i<board.length;i++){

          	 System.out.println(Arrays.toString(board[i]));
          }
          System.out.println();

	}
	

	  public boolean solve(char[][] board){


	  	   for(int i = 0;i<9;i++){

	  	   	   for(int j = 0;j<9;j++){

	  	   	   	   if(board[i][j] != '.')continue;

	  	   	   	   for(int k = 1;k<= 9;k++){

	  	   	   	   	   board[i][j] = (char)('0'+k);

	  	   	   	   	   if(isValid(board,i,j) && solve(board)){

	  	   	   	   	   	  return true;
	  	   	   	   	   }else{

	  	   	   	   	   	  board[i][j] = '.';
	  	   	   	   	   }
	  	   	   	   }
	  	   	   	   return false;
	  	   	   }
	  	   }

	  	   return true;
	  }

	  private boolean isValid(char[][] board,int i,int j){

          Set<Character> set = new HashSet<>();

          for(int k = 0;k<9;k++ ){

          	if(set.contains(board[i][k])){

          		return false;
          	}

          	if(board[i][k] != '.'){

          		set.add(board[i][k]);
          	}
          }

          set.clear();

           for(int k = 0;k<9;k++ ){

          	if(set.contains(board[k][j])){

          		return false;
          	}

          	if(board[k][j] != '.'){

          		set.add(board[k][j]);
          	}
          }

          set.clear();

          for(int m = 0;m <3;m++){

          	 for(int n = 0;n<3;n++){

          	 	  int x = i/3*3+m;
          	 	  int y = j/3*3+n;

          	 	  if(set.contains(board[x][y])){

          	 	  	 return false;
          	 	  }

          	 	  if(board[x][y] != '.'){

          	 	  	  set.add(board[x][y]);
          	 	  }
          	 }
          }

          return true;

	  }
}