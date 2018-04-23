package turma;

import javax.swing.JOptionPane;

// classe INACABADA! OK !!!
public class Main
{
    
    public static void main(String[] args)
    {
        int opcao;  

        Turma minhaTurma = new Turma();
        
        do
        {
          String menu = "Escolha a opção\n1 - Incluir aluno na turma\n2 - Excluir aluno\n" +
                "3 - Listar alunos (COM n.o)\n4 - Exportar para arquivo (SEM n.o)\n" + 
                 "5 - Importar de arquivo (SEM n.o)\n6 - Ordenar alunos (alfabeticamente)\n7 - Procurar Aluno \n8 - Sair\n";
          opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));   

          switch (opcao){
              
              case 1: minhaTurma.incluirAluno(JOptionPane.showInputDialog("Digite o Nome do Aluno")); break;
              
              case 2: minhaTurma.excluirAluno(); break;
              
              case 3: minhaTurma.listarAlunos(); break;
              
              case 4: minhaTurma.exportarAlunos(); break;
              
              case 5: minhaTurma.importarAlunos(); break;
              
              case 6: minhaTurma.ordenarAlunos(); break;
              
              case 7: JOptionPane.showMessageDialog(null, minhaTurma.procurarAluno
                      (JOptionPane.showInputDialog("Digite o Nome do Aluno")));
                      break;
              
              }
           
        } while (opcao != 8);
    }
}
