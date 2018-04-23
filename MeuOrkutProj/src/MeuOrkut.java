
import javax.swing.JOptionPane;

public class MeuOrkut {

    public static void main(String[] args) {
        final int MAX = 20;

        //Familia[] familiares = new Familia[MAX];
        //Amigos[] amizades = new Amigos[MAX];
        //Trabalho[] colegas = new Trabalho[MAX];

        Contato meusContatos[] = new Contato[MAX];

        String resp;
        //int cf = 0, ca = 0, ct = 0; //contadores de Familia, Amigos e Trabalho
        int cc = 0;
        do {
            String tipoStr = "Escolha o tipo\n" +
                    "1.Família\n2.Amigos\n3.Trabalho";
            int tipo = 0;
            do {
                tipo = Integer.parseInt(JOptionPane.showInputDialog(tipoStr));
                switch (tipo) {
                    case 1:
                        meusContatos[cc] = new Familia();
                        cc++;
                        break;
                    case 2:
                        meusContatos[cc] = new Amigos();
                        cc++;
                        break;
                    case 3:
                        meusContatos[cc] = new Trabalho();
                        cc++;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "TIPO INVÁLIDO!");
                        break;
                }
            } while (!(tipo >= 1 && tipo <= 3));
            resp = JOptionPane.showInputDialog("Deseja continuar? (SIM/NÃO)");
            if (resp.equalsIgnoreCase("NAO")) {
                break;
            }
        } while (cc < MAX);//(cf < MAX && ca < MAX && ct < MAX);

        do {
            String acaoStr = "Escolha a ação:\n1. Imprimir Família" +
                    "\n2. Imprimir Amigos\n3. Imprimir Trabalho\n4. Imprimir Todos";
            int acao = Integer.parseInt(JOptionPane.showInputDialog(acaoStr));

            switch (acao) {
                case 1:
                    String imprFam = "Todos os familiares:\n\n";
                    for (Contato fam : meusContatos) {
                        if (fam == null) {
                            break;
                        }
                        if (fam instanceof Familia) {
                            imprFam += fam.imprimirContato() + "\n\n";
                        }
                    }
                    JOptionPane.showMessageDialog(null, imprFam);
                    break;
                case 2:
                    String imprAmi = "Todos os amigos:\n\n";
                    for (Contato ami : meusContatos) {
                        if (ami == null) {
                            break;
                        }
                        if (ami instanceof Amigos) {
                            imprAmi += ami.imprimirContato() + "\n\n";
                        }
                    }
                    JOptionPane.showMessageDialog(null, imprAmi);
                    break;
                case 3:
                    String imprTra = "Todos os colegas de trabalho:\n\n";
                    for (Contato tra : meusContatos) {
                        if (tra == null) {
                            break;
                        }
                        if (tra instanceof Trabalho) {
                            imprTra += tra.imprimirContato() + "\n\n";
                        }
                    }
                    JOptionPane.showMessageDialog(null, imprTra);
                    break;
                case 4:
                    String imprTodos = "Todos os contatos:\n\n";
                    for (Contato fam : meusContatos) {
                        if (fam == null) {
                            break;
                        }
                        if (fam instanceof Amigos) {
                            Amigos amigo = (Amigos) fam;
                            if (amigo.getGrau() == 1) {
                                imprTodos += fam.imprimirContato() + "\n\n";
                            }
                        }
                        if (fam instanceof Familia){
                            Familia fami = (Familia)fam;
                            if (fami.getParentesco().equals("irmão")){
                                imprTodos += fam.imprimirContato() + "\n\n";
                            }
                        }
                        if (fam instanceof Trabalho){
                            Trabalho traba = (Trabalho)fam;
                            if (traba.getTipo().equals("colega")){
                                imprTodos += fam.imprimirContato() + "\n\n";
                            }
                        }
                        
                    }

                    JOptionPane.showMessageDialog(null, imprTodos);
                    break;
            }
            resp = JOptionPane.showInputDialog("Deseja continuar? (SIM/NÃO)");
        } while (resp.equalsIgnoreCase("SIM"));
    }
}
