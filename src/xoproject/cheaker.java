/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xoproject;

/**
 *
 * @author saids
 */
public class cheaker {
    int checkWinner(char Board[][]) {
    //  2: X winner
    // -2: O winner
    //  0: Tie
    //  1: No winner

    // For rows
    for (int i = 0; i < 3; i++) {
        if (Board[i][0]== Board[i][1]&& Board[i][1]== Board[i][2]&&Board[i][0]!=' ') {
           /* return Board[i][0] == 'X' ? 2 : -2;*/
            if (Board[i][0] == 'X')
            {
                return 2;
            }
            else
            {
                return -2;
            }
        }
    }

    // For colums
    for (int i = 0; i < 3; i++) {
        if (Board[0][i]== Board[1][i]&& Board[1][i]== Board[2][i]&&Board[0][i]!=' ') {
          /*  return Board[0][i] == 'X' ? 2 : -2;*/
            if (Board[0][i] == 'X')
            {
                return 2;
            }
            else
            {
                return -2;
            }
        }
    }

    // Diagonal 1
    if (Board[0][0]== Board[1][1]&& Board[1][1]== Board[2][2]&&Board[0][0]!=' ') {
        if (Board[0][0] == 'X')
        {
            return 2;
        }
        else
        {
            return -2;
        }
    }

    // Diagonal 2
    if (Board[2][0]== Board[1][1]&& Board[1][1]== Board[0][2]&&Board[2][0]!=' ') {
        if (Board[2][0] == 'X')
        {
            return 2;
        }
        else
        {
            return -2;
        }
    }

    // For Tie Case
    boolean tie = true;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (Board[i][j] == ' ') {
                tie = false;
            }
        }
    }
    if (tie) return 0;

    // Else
    return 1;
}
    
    
  int minimax(char Board[][], int depth, boolean isMaximizing, boolean firstTime ) {
    int result = checkWinner(Board);
    if (depth == 0 || result != 1) {
        return result;
    }

    if (isMaximizing) {
        int finalScore = -10;
        int finalI =0, finalJ =0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Board[i][j] == ' ') {
                    Board[i][j] = 'X';
                    int score = minimax(Board, depth - 1, false, false);
                    Board[i][j] = ' ';
                    if (score > finalScore) {
                        finalScore = score;
                        finalI = i;
                        finalJ = j;
                    }
                    if (firstTime) {
//                        cout << "score," << i << "," << j << ": " << score << "\n";
                    }
                }
            }
        }
        if (firstTime) {
            Board[finalI][finalJ] = 'O';
        }
        return finalScore;
    }
    else {
        int finalScore = 10;
        int finalI = 0, finalJ = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Board[i][j] == ' ') {
                    Board[i][j] = 'O';
                    int score = minimax(Board, depth - 1, true, false);
                    Board[i][j] = ' ';
                    if (score < finalScore) {
                        finalScore = score;
                        finalI = i;
                        finalJ = j;
                    }
                    if (firstTime) {
//                        cout << "score," << i << "," << j << ": " << score << "\n";
                    }
                }
            }
        }
        if (firstTime) {
            Board[finalI][finalJ] = 'O';
        }
        return finalScore;
    }
}  
    
    
    
    
}
