import javax.swing.*;

public class Campeonato {

    public static void main(String[] args) {
        
        //Vetores dos Nomes dos Time, A = América e E = Europa
        String timesA[] = new String[4];
        String timesE[] = new String[4];
       
        //Vetores dos Resultados dos Time
        String resultadoA[] = new String[4];
        String resultadoE[] = new String[4];
        
        GerenciamentoArquivos ger = new GerenciamentoArquivos();
        
        //Declaração dos Nomes dos Times
        timesA[0] = "Grêmio";
        timesA[1] = "Boca Juniors";
        timesA[2] = "Santos";
        timesA[3] = "Cúcuta";
        
        timesE[0] = "Milan";
        timesE[1] = "Real Madrid";
        timesE[2] = "Liverpool";
        timesE[3] = "Bayer de Munique";
        
        //Lendo os Resultados dos Jogos
        String[][] jogosA = ger.lerMatriz("matrizA.txt");
        int A[] = Pontos.calculaPontos(jogosA);
        
        String[][] jogosE = ger.lerMatriz("matrizE.txt");
        int E[] = Pontos.calculaPontos(jogosE);
        
        //Exportando Resultados
        ger.escreverResultado("ResultadoAmérica.txt", Pontos.classificador(timesA, A));
        ger.escreverResultado("ResultadoEuropa.txt", Pontos.classificador(timesE, E)); 

       //Inicializando Mundial de Clubes
        
        String Ame[] = new String[2];
        Ame = Pontos.classificarMundial(timesA, A);
        
        String Eur[] = new String[2];
        Eur = Pontos.classificarMundial(timesE, E);
        
        String Mundial[] = new String[4];
        Mundial[0] = Ame[0];
        Mundial[1] = Ame[1];
        Mundial[2] = Eur[0];
        Mundial[3] = Eur[1];
        
        //Lendo os Resultados dos Jogos
        String[][] jogosM = ger.lerMatriz("matrizM.txt");
        int M[] = Pontos.calculaPontos(jogosM);
        
        //Exportando Resultados
        ger.escreverResultado("Mundial.txt", Pontos.classificador(Mundial, M));
        
         JOptionPane.showMessageDialog(null,
                "Os resultados com o número de pontos de cada time nos" +
                "\ncampeonatos foram gravados em arquivos .txt");
    }
}
