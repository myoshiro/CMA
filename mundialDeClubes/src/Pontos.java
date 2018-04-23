public class Pontos {

    /* Este método recebe como parâmetro a matriz de resultados do campeonato e devolve
    um vetor de inteiros onde o 1.o elemento é o n.o de pontos do time A, o 2.o elemento
    é o n.o de pontos do time B e assim por diante */
    public static int[] calculaPontos(String matriz[][]) {
        int dim = matriz[0].length;
        int pontos[] = new int[dim];

        for (int nl = 0; nl < dim; nl++) {
            for (int nc = 0; nc < dim; nc++) {
                // contabiliza vitória do time da casa
                if (matriz[nl][nc].equals("v")) {
                    pontos[nl] += 3;                // contabiliza vitória no campo adversário
                }
                if (matriz[nl][nc].equals("d")) {
                    pontos[nc] += 3;                // contabiliza os empates
                }
                if (matriz[nl][nc].equals("e")) {
                    pontos[nl]++;
                    pontos[nc]++;
                }
            }
        }
        return pontos;
    }
    
    public static String[] classificador(String timesA[], int A[]){
        int A1 =0;
        int A2 =0;
        int A3 =0;
        int A4 =0;
        String msgA[] = new String [4];
        
        for (int i =0; i<A.length; i++)
        {if (A[i]>A1)
         {A1=A[i];msgA[0] = timesA[i] + " foi o CAMPEÃO deste grupo " + A1 + " pontos";}}
        
        for (int i =0; i<A.length; i++)
        {if (A[i]>A2 && A[i]<A1)
         {A2=A[i];msgA[1] = timesA[i] + " foi o VICE-CAMPEÃO deste grupo " + A2 + " pontos";}}
        
        for (int i =0; i<A.length; i++)
        {if (A[i]>A3 && A[i]<A2)
         {A3=A[i];msgA[2] = timesA[i] + " foi o TERCEIRO deste grupo " + A3 + " pontos";}}
        
        for (int i =0; i<A.length; i++)
        {if (A[i]>A4 && A[i]<A3)
         {A4=A[i];msgA[3] = timesA[i] + " foi o QUARTO deste grupo " + A4 + " pontos";}}
         
        return msgA;
        }
    
    public static String[] classificarMundial(String timesA[], int A[]){
        int A1 =0;
        int A2 =0;
        String msgT[] = new String [2];
        
        for (int i =0; i<A.length; i++)
        {if (A[i]>A1)
         {A1=A[i];msgT[0] = timesA[i];}
        
        for (int m =0; m<A.length; m++)
        {if (A[m]>A2 && A[m]<A1)
         A2=A[m];msgT[1] = timesA[m];
        break;}}
        
         return msgT;}
}
