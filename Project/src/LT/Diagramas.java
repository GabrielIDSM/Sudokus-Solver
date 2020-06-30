package LT;

import UI.FramePrincipal;
import UTIL.Mensagens;
import java.util.ArrayList;
import java.util.List;

public class Diagramas {
    static int ciclos = 0;
    public ArrayList<int[][]> DeterminaDiagramasPorArea(int[][] Area){
        ArrayList<int[][]> Areas = new ArrayList<>();
        Areas.add(Area);
        List<Integer> numerosValidos = new ArrayList<>();
        //Determinar que numeros faltam a serem inseridos
        Boolean jaExiste = false;
        for(int i = 1; i < 10; i++){
            for(int j = 0; j < 3; j++){
                for(int l = 0; l < 3; l++){
                    if(i == Area[j][l]) jaExiste = true;
                }
            }
            if(!jaExiste) numerosValidos.add(i);
            jaExiste = false;
        }
        //Determinar os Diagramas existentes
        for(Integer i : numerosValidos){
            Areas = DeterminaDiagramasPorNumero(Areas, i);
        }
        //Retornar os Diagramas
        return Areas;
    }
    public ArrayList<int[][]> DeterminaDiagramasPorNumero(ArrayList<int[][]> Areas, int n){
        ArrayList<int[][]> AreasResult = new ArrayList<>();
        //Verificar o numeros de espaços a serem substituidos
        int[][] auxNumeroEspacos = (int[][]) Areas.get(0).clone();
        int nDeEspacos = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(auxNumeroEspacos[i][j] == 0) nDeEspacos++;
            }
        }
        //Definir os diagramas
        int cont = 0;
        int[][] auxA = new int[3][3];
        for(int[][] a : Areas){
            for(int i = 0; i < nDeEspacos; i++){
                for(int j = 0; j < 3; j++){
                    for(int l = 0; l < 3; l++){
                        if(a[j][l] == 0 && cont == i){
                            auxA[j][l] = n;
                        }else{
                            auxA[j][l] = a[j][l];
                        }
                        if(a[j][l] == 0) cont++;
                    }
                }
                AreasResult.add(auxA);
                cont = 0;
                auxA = new int[3][3];
                System.out.println("Numero de ciclos: "+ciclos); ciclos++;
            }
        }
        return AreasResult;
    }
    public ArrayList<ArrayList<int[][]>> DeterminaTodosDiagramasPorArea(int[][][][] Sudoku, FramePrincipal fP){
        ArrayList<ArrayList<int[][]>> TodosDiagramas = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                TodosDiagramas.add(DeterminaDiagramasPorArea(Sudoku[i][j]));
            }
        }
        return TodosDiagramas;
    }
}
