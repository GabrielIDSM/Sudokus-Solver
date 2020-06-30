package LT;

public abstract class Validade {
    public static Boolean VerificaSudokuPorLinha(int[][][][] Sudoku){
        int[] auxLinha;
        for(int i = 0; i < 9; i++){
            auxLinha = DefineLinhaSudokuPorIndex(i, Sudoku);
            if(VerificaNumerosIguais(auxLinha)) return false;
        }
        return true;
    }
    public static Boolean VerificaSudokuPorColuna(int[][][][] Sudoku){
        int[] auxColuna;
        for(int i = 0; i < 9; i++){
            auxColuna = DefineColunaSudokuPorIndex(i, Sudoku);
            if(VerificaNumerosIguais(auxColuna)) return false;
        }
        return true;
    }
    public static Boolean VerificaSudokuPorArea(int[][][][] Sudoku){
        int[] Area = new int[9];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                 Area[0] = Sudoku[i][j][0][0];
                 Area[1] = Sudoku[i][j][0][1];
                 Area[2] = Sudoku[i][j][0][2];
                 Area[3] = Sudoku[i][j][1][0];
                 Area[4] = Sudoku[i][j][1][1];
                 Area[5] = Sudoku[i][j][1][2];
                 Area[6] = Sudoku[i][j][2][0];
                 Area[7] = Sudoku[i][j][2][1];
                 Area[8] = Sudoku[i][j][2][2];
                 if(VerificaNumerosIguais(Area)) return false;
            }
        }
        return true;
    }
    public static Boolean Verifica11e12(int[][] a1, int[][] a2){
        int[] auxLinha;
        for(int i = 0; i < 3; i++){
            auxLinha = DefineLinhaSudoku2Por2PorIndex(i, a1, a2, null, null);
            if(VerificaNumerosIguais(auxLinha)) return false;
        }
        return true;
    }
    public static Boolean Verifica11e21(int[][] a1, int[][] a4){
        int[] auxColuna;
        for(int i = 0; i < 3; i++){
            auxColuna = DefineColunaSudoku2Por2PorIndex(i, a1, null, a4, null);
            if(VerificaNumerosIguais(auxColuna)) return false;
        }
        return true;
    }
    public static Boolean VerificaSudoku2Por2(int[][] a1, int[][] a2, int[][] a4, int[][] a5){
        int[] auxLinha;
        for(int i = 0; i < 6; i++){
            auxLinha = DefineLinhaSudoku2Por2PorIndex(i, a1, a2, a4, a5);
            if(VerificaNumerosIguais(auxLinha)) return false;
        }
        int[] auxColuna;
        for(int i = 0; i < 6; i++){
            auxColuna = DefineColunaSudoku2Por2PorIndex(i, a1, a2, a4, a5);
            if(VerificaNumerosIguais(auxColuna)) return false;
        }
        return true;
    }
    public static Boolean VerificaLinhaTripla(int[][] a, int[][] b, int[][] c){
        int[][] auxLinhaT = DefineLinhaTripla(a, b, c);
        for(int i = 0; i < 3; i++){
            if(VerificaNumerosIguais(auxLinhaT[i])) return false;
        }
        return true;
    }
    public static Boolean VerificaColunaTripla(int[][] a, int[][] b, int[][] c){
        int[][] auxColunaT = DefineColunaTripla(a, b, c);
        for(int i = 0; i < 3; i++){
            if(VerificaNumerosIguais(auxColunaT[i])) return false;
        }
        return true;
    }
    public static int[] DefineLinhaSudokuPorIndex(int index, int[][][][] Sudoku){
        int[] Linha = new int[9];
        if(index == 0 || index == 3 || index == 6){
            Linha[0] = Sudoku[index/3][0][0][0];
            Linha[1] = Sudoku[index/3][0][0][1];
            Linha[2] = Sudoku[index/3][0][0][2];
            Linha[3] = Sudoku[index/3][1][0][0];
            Linha[4] = Sudoku[index/3][1][0][1];
            Linha[5] = Sudoku[index/3][1][0][2];
            Linha[6] = Sudoku[index/3][2][0][0];
            Linha[7] = Sudoku[index/3][2][0][1];
            Linha[8] = Sudoku[index/3][2][0][2];
        }else if(index == 1 || index == 4 || index == 7){
            Linha[0] = Sudoku[index/3][0][1][0];
            Linha[1] = Sudoku[index/3][0][1][1];
            Linha[2] = Sudoku[index/3][0][1][2];
            Linha[3] = Sudoku[index/3][1][1][0];
            Linha[4] = Sudoku[index/3][1][1][1];
            Linha[5] = Sudoku[index/3][1][1][2];
            Linha[6] = Sudoku[index/3][2][1][0];
            Linha[7] = Sudoku[index/3][2][1][1];
            Linha[8] = Sudoku[index/3][2][1][2];
        }else if(index == 2 || index == 5 || index == 8){
            Linha[0] = Sudoku[index/3][0][2][0];
            Linha[1] = Sudoku[index/3][0][2][1];
            Linha[2] = Sudoku[index/3][0][2][2];
            Linha[3] = Sudoku[index/3][1][2][0];
            Linha[4] = Sudoku[index/3][1][2][1];
            Linha[5] = Sudoku[index/3][1][2][2];
            Linha[6] = Sudoku[index/3][2][2][0];
            Linha[7] = Sudoku[index/3][2][2][1];
            Linha[8] = Sudoku[index/3][2][2][2];
        }else{
            return null;
        }
        return Linha;
    }
    public static int[] DefineColunaSudokuPorIndex(int index, int[][][][] Sudoku){
        int[] Coluna = new int[9];
        if(index == 0 || index == 3 || index == 6){
            Coluna[0] = Sudoku[0][index/3][0][0];
            Coluna[1] = Sudoku[0][index/3][1][0];
            Coluna[2] = Sudoku[0][index/3][2][0];
            Coluna[3] = Sudoku[1][index/3][0][0];
            Coluna[4] = Sudoku[1][index/3][1][0];
            Coluna[5] = Sudoku[1][index/3][2][0];
            Coluna[6] = Sudoku[2][index/3][0][0];
            Coluna[7] = Sudoku[2][index/3][1][0];
            Coluna[8] = Sudoku[2][index/3][2][0];
        }else if(index == 1 || index == 4 || index == 7){
            Coluna[0] = Sudoku[0][index/3][0][1];
            Coluna[1] = Sudoku[0][index/3][1][1];
            Coluna[2] = Sudoku[0][index/3][2][1];
            Coluna[3] = Sudoku[1][index/3][0][1];
            Coluna[4] = Sudoku[1][index/3][1][1];
            Coluna[5] = Sudoku[1][index/3][2][1];
            Coluna[6] = Sudoku[2][index/3][0][1];
            Coluna[7] = Sudoku[2][index/3][1][1];
            Coluna[8] = Sudoku[2][index/3][2][1];
        }else if(index == 2|| index == 5 || index == 8){
            Coluna[0] = Sudoku[0][index/3][0][2];
            Coluna[1] = Sudoku[0][index/3][1][2];
            Coluna[2] = Sudoku[0][index/3][2][2];
            Coluna[3] = Sudoku[1][index/3][0][2];
            Coluna[4] = Sudoku[1][index/3][1][2];
            Coluna[5] = Sudoku[1][index/3][2][2];
            Coluna[6] = Sudoku[2][index/3][0][2];
            Coluna[7] = Sudoku[2][index/3][1][2];
            Coluna[8] = Sudoku[2][index/3][2][2];
        }else{
            return null;
        }
        return Coluna;
    }
    public static int[] DefineLinhaSudoku2Por2PorIndex(int index, int[][] a1, int[][] a2, int[][] a4, int[][] a5){
        int[] Linha = new int[6];
        if(index == 0 || index == 1 || index == 2){
            Linha[0] = a1[index][0];
            Linha[1] = a1[index][1];
            Linha[2] = a1[index][2];
            Linha[3] = a2[index][0];
            Linha[4] = a2[index][1];
            Linha[5] = a2[index][2];
        }else if(index == 3 || index == 4 || index == 5){
            Linha[0] = a4[index%3][0];
            Linha[1] = a4[index%3][1];
            Linha[2] = a4[index%3][2];
            Linha[3] = a5[index%3][0];
            Linha[4] = a5[index%3][1];
            Linha[5] = a5[index%3][2];
        }
        return Linha;
    }
    public static int[] DefineColunaSudoku2Por2PorIndex(int index, int[][] a1, int[][] a2, int[][] a4, int[][] a5){
        int[] Coluna = new int[6];
        if(index == 0 || index == 1 || index == 2){
            Coluna[0] = a1[0][index];
            Coluna[1] = a1[1][index];
            Coluna[2] = a1[2][index];
            Coluna[3] = a4[0][index];
            Coluna[4] = a4[1][index];
            Coluna[5] = a4[2][index];
        }else if(index == 3 || index == 4 || index == 5){
            Coluna[0] = a2[0][index%3];
            Coluna[1] = a2[1][index%3];
            Coluna[2] = a2[2][index%3];
            Coluna[3] = a5[0][index%3];
            Coluna[4] = a5[1][index%3];
            Coluna[5] = a5[2][index%3];
        }
        return Coluna;
    }
    public static int[][] DefineLinhaTripla(int[][] a, int[][] b, int[][] c){
        int[][] linhaT = new int[3][9];
        for(int i = 0; i < 3; i++){
            linhaT[i][0] = a[i][0];
            linhaT[i][1] = a[i][1];
            linhaT[i][2] = a[i][2];
            linhaT[i][3] = b[i][0];
            linhaT[i][4] = b[i][1];
            linhaT[i][5] = b[i][2];
            linhaT[i][6] = c[i][0];
            linhaT[i][7] = c[i][1];
            linhaT[i][8] = c[i][2];
        }
        return linhaT;
    }
    public static int[][] DefineColunaTripla(int[][] a, int[][] b, int[][] c){
        int[][] Coluna = new int[3][9];
        for(int i = 0; i < 3; i++){
            Coluna[i][0] = a[0][i];
            Coluna[i][1] = a[1][i];
            Coluna[i][2] = a[2][i];
            Coluna[i][3] = b[0][i];
            Coluna[i][4] = b[1][i];
            Coluna[i][5] = b[2][i];
            Coluna[i][6] = c[0][i];
            Coluna[i][7] = c[1][i];
            Coluna[i][8] = c[2][i];
        }
        return Coluna;
    }
    public static Boolean VerificaNumerosIguais(int[] Linha){
        for(int i = 0; i < Linha.length; i++){
            for(int j = 0; j < Linha.length; j++){
                if(Linha[i] == Linha[j] && i != j && Linha[i] != 0) return true;
            }
        }
        return false;
    }
    public static int VerificaQuantidadeDeCelulasPreenchidas(int[][][][] Sudoku){
        int cont = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int l = 0; l < 3; l++) {
                    for (int m = 0; m < 3; m++) {
                        if (Sudoku[i][j][l][m] != 0) {
                            cont++;
                        }
                    }
                }
            }
        }
        return cont;
    }
}
