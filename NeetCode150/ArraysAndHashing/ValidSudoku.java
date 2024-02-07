package NeetCode150.ArraysAndHashing;

import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> hs = new HashSet<>();
        int n = board.length;
        int m = board[0].length;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m ;j++){
                if(board[i][j] != '.'){
                    String rowStr ="row" + Integer.toString(i) + board[i][j];
                    String colStr ="col" + Integer.toString(j) + board[i][j];
                    int boxNum = (i/3) * 3 + (j/3);
                    String boxStr ="box" + Integer.toString(boxNum)  + board[i][j];
                    if(hs.contains(rowStr) || hs.contains(colStr) || hs.contains(boxStr) ){
                        return false;
                    }else{
                        hs.add(rowStr);
                        hs.add(colStr);
                        hs.add(boxStr);
                    }
                }
            }
        }
        return true;
    }
}
