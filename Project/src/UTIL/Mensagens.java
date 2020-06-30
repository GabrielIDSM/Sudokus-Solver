package UTIL;

import static LT.Validade.DefineLinhaSudokuPorIndex;

public abstract class Mensagens {
    public static void ExibeSudokuTerminal(int[][][][] Sudoku){
        int[] auxLinha;
        for(int i = 0; i < 9; i++){
            auxLinha = DefineLinhaSudokuPorIndex(i, Sudoku);
            for(int j = 0; j < 9; j++){
                System.out.printf("[" + auxLinha[j] + "] ");
            }
            System.out.println("\n");
        }
    }
    public static void ExibeAreaSudokuTerminal(int[][] Area){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.printf("[" + Area[i][j] + "] ");
            }
            System.out.println("\n");
        }
    }
}
