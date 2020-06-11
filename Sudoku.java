import java.util.ArrayList;

public class Sudoku {
	static ArrayList a = new ArrayList();
	static ArrayList b = new ArrayList();
	static ArrayList c = new ArrayList();
	static ArrayList d = new ArrayList();
	static ArrayList e = new ArrayList();
	static ArrayList f = new ArrayList();
	static ArrayList g = new ArrayList();
	static ArrayList h = new ArrayList();
	static ArrayList i = new ArrayList();

	public static void main(String[] args) {


		/*ArrayList<Integer> a = new ArrayList<Integer>(); 
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		ArrayList<Integer> d = new ArrayList<Integer>();
		ArrayList<Integer> e = new ArrayList<Integer>();
		ArrayList<Integer> f = new ArrayList<Integer>();
		ArrayList<Integer> g = new ArrayList<Integer>();
		ArrayList<Integer> h = new ArrayList<Integer>();
		ArrayList<Integer> i = new ArrayList<Integer>();*/
		//a.add(1);
		//System.out.println(a);



		int[][] puzzle = {  { 0, 0, 0, 2, 6, 0, 7, 0, 1 }, 
				{ 6, 8, 0, 0, 7, 0, 0, 9, 0 },
				{ 1, 9, 0, 0, 0, 4, 5, 0, 0 },
				{ 8, 2, 0, 1, 0, 0, 0, 4, 0 }, 
				{ 0, 0, 4, 6, 0, 2, 9, 0, 0 },
				{ 0, 5, 0, 0, 0, 3, 0, 2, 8 },
				{ 0, 0, 9, 3, 0, 0, 0, 7, 4 }, 
				{ 0, 4, 0, 0, 5, 0, 0, 3, 6 }, 
				{ 7, 0, 3, 0, 1, 8, 0, 0, 0 } };

		int col = 0;
		int row = 0;

		for(int i = 0; i < puzzle.length; i++) {
			for(int j = 0; j < puzzle[i].length; j++) {
				if(puzzle[i][j] != 0) {
					isInSameBox(puzzle, i, j);
				}
			}
		}


		solvePuzzle(puzzle, row, col);

		printPuzzle(puzzle);

	}

	public static void printPuzzle(int [][] board) {
		for(int row = 0; row < board.length; row++) {

			for(int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col] + " ");
			}
			System.out.println();
		}
	}

	public static boolean solvePuzzle(int [][] puzzle, int row, int col){
		if(col ==9 ) {
			row++;
			col = 0;
			if(row==9) {
				return true;
			}
		}
		if(puzzle[row][col] != 0) {
			return solvePuzzle(puzzle,row,col+1);
		}
		for(int c = 1; c <=9; c++) {
			int choice = c;
			if(isChoiceValid(puzzle, row, col, choice)){
				puzzle[row][col] = choice;
				//isInSameBox(puzzle, row, col);
				
				if(solvePuzzle(puzzle, row, col+1)){ //this part only returns true when the puzzle is finished
					return true;
				}
				
			}
			//puzzle[row][col] = 0;




			//}
		}
		puzzle[row][col] = 0;	

		return false;

	}

	public static boolean isChoiceValid(int [][] puzzle, int row, int col, int choice) {
		//split up into separate cases
		//might need an overarching if statement to make sure current space is empty


		//check row, possibly only right section of row
		for(int i = 0; i < 9; i++) {
			if(puzzle[row][i] == choice) {
				return false;
			}
		}

		//check column, possibly only bottom part of column 
		for(int j = 0; j < 9; j++) {
			if(puzzle[j][col] == choice) {
				return false;
			}
		}

		//check if in same 3x3 box //need two int variables inside for loop to manipulate both row and column
		if(			row==0 && col==0 || row==0 && col==1 || row==0 && col==2 
				||  row==1 && col==0 || row==1 && col==1 || row==1 && col==2
				||  row==2 && col==0 || row==2 && col==1 || row==2 && col==2) {
			if(a.contains(choice)) {
				return false;

			}


		}
		//b
		if(			row==0 && col==3 || row==0 && col==4 || row==0 && col==5
				||  row==1 && col==3 || row==1 && col==4 || row==1 && col==5
				||  row==2 && col==3 || row==2 && col==4 || row==2 && col==5) {
			if(b.contains(choice)) {
				return false;
			}

		}
		//c
		if(			row==0 && col==6 || row==0 && col==7 || row==0 && col==8 
				||  row==1 && col==6 || row==1 && col==7 || row==1 && col==8
				||  row==2 && col==6 || row==2 && col==7 || row==2 && col==8) {
			if(c.contains(choice)) {
				return false;
			}


		}
		//d
		if(			row==3 && col==0 || row==3 && col==1 || row==3 && col==2 
				||  row==4 && col==0 || row==4 && col==1 || row==4 && col==2
				||  row==5 && col==0 || row==5 && col==1 || row==5 && col==2) {
			if(d.contains(choice)) {
				return false;
			}

		}
		//e
		if(			row==3 && col==3 || row==3 && col==4 || row==3 && col==5 
				||  row==4 && col==3 || row==4 && col==4 || row==4 && col==5
				||  row==5 && col==3 || row==5 && col==4 || row==5 && col==5) {
			if(e.contains(choice)) {
				return false;
			}

		}
		//f
		if(			row==3 && col==6 || row==3 && col==7 || row==3 && col==8 
				||  row==4 && col==6 || row==4 && col==7 || row==4 && col==8
				||  row==5 && col==6 || row==5 && col==7 || row==5 && col==8) {
			if(f.contains(choice)) {
				return false;
			}

		}
		//g
		if(			row==6 && col==0 || row==6 && col==1 || row==6 && col==2 
				||  row==7 && col==0 || row==7 && col==1 || row==7 && col==2
				||  row==8 && col==0 || row==8 && col==1 || row==8 && col==2) {
			if(g.contains(choice)) {
				return false;
			}

		}
		//h
		if(			row==6 && col==3 || row==6 && col==4 || row==6 && col==5 
				||  row==7 && col==3 || row==7 && col==4 || row==7 && col==5
				||  row==8 && col==3 || row==8 && col==4 || row==8 && col==5) {
			if(h.contains(choice)) {
				return false;
			}

		}
		//i
		if(			row==6 && col==6 || row==6 && col==7 || row==6 && col==8 
				||  row==7 && col==6 || row==7 && col==7 || row==7 && col==8
				||  row==8 && col==6 || row==8 && col==7 || row==8 && col==8) {
			if(i.contains(choice)) {
				return false;
			}

		}

		return true;
	}

	//maybe make separate method to check box


	//helper method for isChoiceValid, specifically to check 3x3 box
	//we'll basically section off each 3x3 section into an ArrayList
	public static ArrayList isInSameBox (int[][] puzzle, int row, int col) {
		//we'll need 9 separate ArrayLists for the 9 separate boxes 
		/*ArrayList<Integer> a = new ArrayList<Integer>(); 
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		ArrayList<Integer> d = new ArrayList<Integer>();
		ArrayList<Integer> e = new ArrayList<Integer>();
		ArrayList<Integer> f = new ArrayList<Integer>();
		ArrayList<Integer> g = new ArrayList<Integer>();
		ArrayList<Integer> h = new ArrayList<Integer>();
		ArrayList<Integer> i = new ArrayList<Integer>();*/

		//a
		if(			row==0 && col==0 || row==0 && col==1 || row==0 && col==2 
				||  row==1 && col==0 || row==1 && col==1 || row==1 && col==2
				||  row==2 && col==0 || row==2 && col==1 || row==2 && col==2) {
			if(puzzle[row][col] != 0) {
				a.add(puzzle[row][col]);
			}
			return a;

		}
		//b
		if(			row==0 && col==3 || row==0 && col==4 || row==0 && col==5
				||  row==1 && col==3 || row==1 && col==4 || row==1 && col==5
				||  row==2 && col==3 || row==2 && col==4 || row==2 && col==5) {
			if(puzzle[row][col] != 0) {
				b.add(puzzle[row][col]);
			}
			return b;
		}
		//c
		if(			row==0 && col==6 || row==0 && col==7 || row==0 && col==8 
				||  row==1 && col==6 || row==1 && col==7 || row==1 && col==8
				||  row==2 && col==6 || row==2 && col==7 || row==2 && col==8) {
			if(puzzle[row][col] != 0) {
				c.add(puzzle[row][col]);
			}
			return c;

		}
		//d
		if(			row==3 && col==0 || row==3 && col==1 || row==3 && col==2 
				||  row==4 && col==0 || row==4 && col==1 || row==4 && col==2
				||  row==5 && col==0 || row==5 && col==1 || row==5 && col==2) {
			if(puzzle[row][col] != 0) {
				d.add(puzzle[row][col]);
			}
			return d;
		}
		//e
		if(			row==3 && col==3 || row==3 && col==4 || row==3 && col==5 
				||  row==4 && col==3 || row==4 && col==4 || row==4 && col==5
				||  row==5 && col==3 || row==5 && col==4 || row==5 && col==5) {
			if(puzzle[row][col] != 0) {
				e.add(puzzle[row][col]);
			}
			return e;
		}
		//f
		if(			row==3 && col==6 || row==3 && col==7 || row==3 && col==8 
				||  row==4 && col==6 || row==4 && col==7 || row==4 && col==8
				||  row==5 && col==6 || row==5 && col==7 || row==5 && col==8) {
			if(puzzle[row][col] != 0) {
				f.add(puzzle[row][col]);
			}
			return f;	
		}
		//g
		if(			row==6 && col==0 || row==6 && col==1 || row==6 && col==2 
				||  row==7 && col==0 || row==7 && col==1 || row==7 && col==2
				||  row==8 && col==0 || row==8 && col==1 || row==8 && col==2) {
			if(puzzle[row][col] != 0) {
				g.add(puzzle[row][col]);
			}
			return g;
		}
		//h
		if(			row==6 && col==3 || row==6 && col==4 || row==6 && col==5 
				||  row==7 && col==3 || row==7 && col==4 || row==7 && col==5
				||  row==8 && col==3 || row==8 && col==4 || row==8 && col==5) {
			if(puzzle[row][col] != 0) {
				h.add(puzzle[row][col]);
			}
			return h;
		}
		//i
		if(			row==6 && col==6 || row==6 && col==7 || row==6 && col==8 
				||  row==7 && col==6 || row==7 && col==7 || row==7 && col==8
				||  row==8 && col==6 || row==8 && col==7 || row==8 && col==8) {
			if(puzzle[row][col] != 0) {
				i.add(puzzle[row][col]);
			}
			return i;
		}
		return a;
	}

	public static boolean isFinished(int [][] puzzle) {
		for(int i = 0; i < puzzle.length; i++) {
			for(int j = 0; j < puzzle[i].length; j++) {
				if(puzzle[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}



}
