
import javax.swing.JOptionPane;

public abstract class Contato {

    String apelido, nome, email, aniversario;

    public Contato() {
        nome = JOptionPane.showInputDialog("Entre com o Nome: ");
        apelido = JOptionPane.showInputDialog("Entre com o Apelido: ");
        email = JOptionPane.showInputDialog("Entre com o Email: ");
        aniversario = JOptionPane.showInputDialog("Entre com a Data do Aniversário: ");
    }

    public abstract String imprimirContato();
    
    public String imprimirBasico() {
        String dados = "Nome: " + nome + "\nApelido: " + apelido +
                "\nEmail: " + email + "\nAniversário: " + aniversario;
        return dados;
    }
}
