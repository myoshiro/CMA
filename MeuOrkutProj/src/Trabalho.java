
import javax.swing.JOptionPane;

public class Trabalho extends Contato {

    String tipo;

    public Trabalho() {
        super();
        tipo = JOptionPane.showInputDialog("Tipo de relação (chefe, colega, ...): ");
    }

    public String getTipo(){
        return tipo;
    }
    public String imprimirContato() {
        String dados = super.imprimirBasico() + "\nTipo: " + tipo;
        return dados;
    }
}
