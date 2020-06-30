package LT;

import UI.FramePrincipal;
import java.util.ArrayList;

public class DiagramasCompostos {
    public static int Ciclos = 0;
    public int[][][][] DeterminaDiagramaTresPorTres(ArrayList<ArrayList<int[][]>> Diagramas){
        //Verificação de Dois em Dois
        for(int[][] a1 : Diagramas.get(0)){
            for(int[][] a2 : Diagramas.get(1)){
                if(!Validade.Verifica11e12(a1, a2)){
                    Ciclos++;
                    continue;
                }
                for(int[][] a4 : Diagramas.get(3)){
                    if(!Validade.Verifica11e21(a1, a4)){
                        Ciclos++;
                        continue;
                    }
                    for(int[][] a5 : Diagramas.get(4)){
                        if(!Validade.VerificaSudoku2Por2(a1, a2, a4, a5)){
                            Ciclos++;
                            continue;
                        }
                        System.out.println("Validade: Pré a7");
                        for(int[][] a7 : Diagramas.get(6)){
                            if(!Validade.VerificaColunaTripla(a1, a4, a7)){
                                Ciclos++;
                                continue;
                            }
                            System.out.println("Validade: Pré a8");
                            for(int[][] a8 : Diagramas.get(7)){
                                if (!Validade.VerificaColunaTripla(a2, a5, a8)) {
                                    Ciclos++;
                                    continue;
                                }
                                System.out.println("Validade: Pré a3");
                                for(int[][] a3 : Diagramas.get(2)){
                                    if (!Validade.VerificaLinhaTripla(a1, a2, a3)) {
                                        Ciclos++;
                                        continue;
                                    }
                                    System.out.println("Validade: Pré a6");
                                    for(int[][] a6 : Diagramas.get(5)){
                                        if (!Validade.VerificaLinhaTripla(a4, a5, a6)) {
                                            Ciclos++;
                                            continue;
                                        }
                                        System.out.println("Validade: Pré a9");
                                        for(int[][] a9 : Diagramas.get(8)){
                                            System.out.println("Ciclo final: " + Ciclos);
                                            if(Validade.VerificaColunaTripla(a3, a6, a9) && Validade.VerificaLinhaTripla(a7, a8, a9)){
                                                int[][][][] Sudoku = new int[3][3][3][3];
                                                Sudoku[0][0] = a1;
                                                Sudoku[0][1] = a2;
                                                Sudoku[0][2] = a3;
                                                Sudoku[1][0] = a4;
                                                Sudoku[1][1] = a5;
                                                Sudoku[1][2] = a6;
                                                Sudoku[2][0] = a7;
                                                Sudoku[2][1] = a8;
                                                Sudoku[2][2] = a9;
                                                return Sudoku;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
