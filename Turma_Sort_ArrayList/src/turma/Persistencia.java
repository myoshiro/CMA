package turma;

import java.io.*;
import javax.swing.JOptionPane;
import java.util.*;

// classe TOTALMENTE pronta!
public class Persistencia
{
    
    public static void exportarAlunos(Collection<String> alunos, String nomeArq)
    {
        try
        {
            PrintWriter pw = new PrintWriter(new FileWriter(nomeArq));
            for (String aluno: alunos)
            {
               pw.println(aluno);
            }
            
            pw.close();
            JOptionPane.showMessageDialog(null,
                    "Dados exportados com sucesso para arquivo " + nomeArq);
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na exportação dos dados!");
        }
    }

    public static void importarAlunos(Turma minhaTurma, String nomeArq)
    {
        
        try
        {               
            BufferedReader br = new BufferedReader(new FileReader(nomeArq));
            String linha;
            String[] campos = null;
            while ((linha = br.readLine()) != null)
            {
                minhaTurma.incluirAluno(linha);
            }            
            br.close();
            JOptionPane.showMessageDialog(null,
                 "Dados importados com sucesso do arquivo " + nomeArq);
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro na importação dos dados!");
        }        
    }   
}