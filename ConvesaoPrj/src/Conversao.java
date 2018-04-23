import javax.swing.JOptionPane;
public class Conversao {

    public static void main(String[] args) {
        
        double x;
        //Declarando Indices Para Linhas(i) e Colunas(j)
        int i, j, pergunta =0;
        
        //Laço de Repetição While
        
        while (pergunta ==0){
        // Entrada do Volume
        double Vi = Double.parseDouble
                    (JOptionPane.showInputDialog(null,"Digite O Volume"));
        
        //Entrada de Opção para Undades 
        i = Integer.parseInt(JOptionPane.showInputDialog
                (null,"O Dado Foi Fornecido em: (Digite o Número da Opção)\n" +
                "1. Metros Cúbicos\n" +
                "2. Litros\n" +
                "3. Galões Americanos\n" +
                "4. Galões Ingleses\n" +
                "5. Barris\n" +
                "6. Pés Cúbicos\n"));
        
       j = Integer.parseInt(JOptionPane.showInputDialog
                (null,"Deseja Converter Para: (Digite o Número da Opção)\n" +
                "1. Metros Cúbicos\n" +
                "2. Litros\n" +
                "3. Galões Americanos\n" +
                "4. Galões Ingleses\n" +
                "5. Barris\n" +
                "6. Pés Cúbicos\n"));
        
        //Intanciando e Alocando nova Matris
        double dados[][] = new double [6][6];
        
        //Inicializando dados da Matriz
        dados[0][0] = 1;
        dados[0][1] = 1000;
        dados[0][2] = 261.2;
        dados[0][3] = 220;
        dados[0][4] = 6.289;
        dados[0][5] = 35.3147;
        dados[1][0] = 0.001;
        dados[1][1] = 1;
        dados[1][2] = 0.2642;
        dados[1][3] = 0.220;
        dados[1][4] = 0.006289;
        dados[1][5] = 0.0353147;
        dados[2][0] = 0.0038;
        dados[2][1] = 3.785;
        dados[2][2] = 1;
        dados[2][3] = 0.8327;
        dados[2][4] = 0.02381;
        dados[2][5] = 0.1337;
        dados[3][0] = 0.0045;
        dados[3][1] = 4.546;
        dados[3][2] = 1.201;
        dados[3][3] = 1;
        dados[3][4] = 0.02859;
        dados[3][5] = 0.1605;
        dados[4][0] = 0.159;
        dados[4][1] = 159;
        dados[4][2] = 42;
        dados[4][3] = 34.97;
        dados[4][4] = 1;
        dados[4][5] = 5.615;
        dados[5][0] = 0.0283;
        dados[5][1] = 28.3;
        dados[5][2] = 7.48;
        dados[5][3] = 6.229;
        dados[5][4] = 0.1781;
        dados[5][5] = 1;
        
        //Calculo
        double Vf = Vi * dados[i-1][j-1];
        
        //Imprimindo Resultado
        String msg = String.format("O Volume Convertido é: %.3f", Vf);
        pergunta = JOptionPane.showConfirmDialog(null, msg + 
                "\n\nDeseja Fazer Outra Conversão?");
      }  
      }
}

