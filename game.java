import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        char[][] board=new char[3][3];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j]=' ';
            }
        }
        char player='X';
        boolean gameOver=false;
        Scanner sc=new Scanner(System.in);
        while(!gameOver){
            printBoard(board);
            System.out.println("Player "+player+" enter row and col");
            int row=sc.nextInt();
            int col=sc.nextInt();
            if(board[row][col]==' '){
                //place the element
                board[row][col]=player;
                gameOver=hasWon(board,player);
                if(gameOver){
                    System.out.println("Player "+player+" has won");
                }
                else{
                    player=(player=='X') ? '0':'X';
                    // if(player=='X'){
                    //     player='0';
                    // }
                    // else{
                    //     player='X';
                    // }
                }
            }
            else{
                System.out.println("Invalid Move");
            }
        }
        printBoard(board);
    }
    public static void printBoard(char [][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
        }
    }

    public static boolean hasWon(char[][] board,char player){
        //check rows
        for(int i=0;i<board.length;i++){
            if(board[i][0]==player && board[i][1]==player && board[i][2]==player){
                return true;
            }
        }
        //check cols
        for(int j=0;j<board.length;j++){
            if(board[0][j]==player && board[1][j]==player && board[2][j]==player){
                return true;
            }
        }
        //diagonal
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
            return true;
        }
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
            return true;
        }
        return false;
    }

}
