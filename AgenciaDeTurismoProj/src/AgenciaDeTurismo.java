import javax.swing.JOptionPane;

public class AgenciaDeTurismo {

   public static void main(String[] args) {
      int pergunta, opc;
       Atendimento A = new Atendimento();
       int cont[] = new int[10];
      
      do{
      pergunta = Integer.parseInt(JOptionPane.showInputDialog(" AGÊNCIA DE TURISMO\n\n" +
               "1.Cadastrar Novo Pacote\n2.Efetuar Venda\n3.Sair"));
      switch (pergunta){
           
          case 1:{A.cadastro();
               break;}
               
           case 2:{do
           {int x =Integer.parseInt(JOptionPane.showInputDialog(A.listarPacotes()
                                        +"Digite a Opção Desejada:"));
            
            cont[x-1] = cont[x-1] +1;
            
            String t = String.format("Opção: %d\n Vendidos: %d\n Lucro com este pacote: R$%.2f\n", 
                    x, cont[x-1], A.calcLucro(cont[x-1], x-1));
            JOptionPane.showMessageDialog(null, t);
            
            double total=0;
            for (int h =-1; h<x;h++){if (cont[x+h] !=0)
            total += A.calcLucro(cont[x+h], x+h);}
            
            String tabela = "ESTATÍSTICA\n\n";
            tabela += String.format("O Lucro Total é R$%.2f", total);
            JOptionPane.showMessageDialog(null, tabela);
            opc = JOptionPane.showConfirmDialog(null, "Deseja Efetuar outra Venda?");
           }
           while (opc ==0);
           
           
           
           break;}
           
           case 3: {JOptionPane.showMessageDialog(null, "SAINDO DO SISTEMA...");
                    break;}
           
           default : JOptionPane.showMessageDialog(null,"Comando Inválido");
       }
       
    }
while (pergunta != 3);
}
}