package turma;

import javax.swing.JOptionPane;
import java.util.*;

// classe INACABADA! OK !!!
public class Turma
{
    ArrayList<String> listaAlunos = new ArrayList<String>();
    
    // m�todo pronto
    public void incluirAluno()
    {
        String nome = JOptionPane.showInputDialog("Digite o nome do aluno");
          this.incluirAluno(nome);
          JOptionPane.showMessageDialog(null, "Aluno Inclu�do!");
    }

    // m�todo inacabado OK !!!
    public void incluirAluno(String nome)
    {
       this.listaAlunos.add(nome);
    }
    
   // m�todo inacabado OK !!!
    public String procurarAluno(String nome)
    {
        String achou = null;
        
        achou = String.format
        ("O Aluno " + nome + " � o N�mero: " + (this.listaAlunos.indexOf(nome) +1));
        
        return achou;
    }
    
    // m�todo inacabado OK !!!
    public void excluirAluno()
    {
        String nome = JOptionPane.showInputDialog("Nome do aluno para excluir:");
        
        if (listaAlunos.isEmpty() != true){
        this.listaAlunos.remove(nome);
        JOptionPane.showMessageDialog(null, "Aluno Excluido!");}
        else JOptionPane.showMessageDialog(null, "Lista Vazia !!!");
    }

    // m�todo inacabado OK !!!
    public void ordenarAlunos()
    {    if (listaAlunos.isEmpty() != true){
       Collections.sort(listaAlunos);
       JOptionPane.showMessageDialog(null, "Alunos ordenados!");
       }
        else JOptionPane.showMessageDialog(null, "Lista Vazia !!!");
    }
    
    // m�todo inacabado OK !!!
    public void listarAlunos()
    {  if (listaAlunos.isEmpty() != true){
       String msg = "";
             for (int i = 0; i<this.listaAlunos.size(); i++)
                {msg +=(i+1) + ". " + this.listaAlunos.get(i) + "\n";}
       
       
       JOptionPane.showMessageDialog(null, msg);
       }
        else JOptionPane.showMessageDialog(null, "Lista Vazia !!!");
    }

    // m�todo pronto
    public void importarAlunos()
    {
       String nomeArqIn = JOptionPane.showInputDialog("Nome do arquivo?", "turma antiga.txt");
       Persistencia.importarAlunos(this, nomeArqIn);
       }
   
    // m�todo pronto
    public void exportarAlunos()
    {
       String nomeArqOut = JOptionPane.showInputDialog("Nome do arquivo?", "turma nova.txt");
       Persistencia.exportarAlunos(this.listaAlunos, nomeArqOut);
       }

}
