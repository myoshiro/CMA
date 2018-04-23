import java.io.*;
import javax.swing.*;

public class GerenciamentoArquivos {
    
    
    public void escreverResultado(String nomeArq, String[] resultado) {
        
        try{
            FileWriter arq = new FileWriter( nomeArq );
            PrintWriter out = new PrintWriter( arq );
           
            String msg =""; // "*****       RESULTADOS          *****\r\n\r";
            
            for ( int i=0; i<resultado.length; i++ ){
            msg+= "\n" + resultado[i] + "\r";}
            
            out.println(msg);
            out.close();
        }
        catch ( IOException erro ){
            JOptionPane.showMessageDialog(null,erro);}
        
    } //fim do método escrita()

    public String[][] lerMatriz(String nomeArq) {
        String linha;
        String[][] matriz = new String[4][4];

        try {
            FileReader ent = new FileReader(nomeArq);
            BufferedReader br = new BufferedReader(ent);

            for (int nl = 0; nl < 4; nl++) {
                linha = br.readLine();
                matriz[nl] = linha.split(";");
            }

            br.close();
        } catch (IOException erro) {
            JOptionPane.showMessageDialog(null, "Erro na leitura dos dados");
        }
        return matriz;
    } // Fim do método lerMatriz
} // Fim da classe GerenciamentoArquivos
