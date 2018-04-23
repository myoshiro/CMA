
import javax.swing.JOptionPane;

public class Familia extends Contato {

    String parentesco;

    public Familia() {
        super();
        parentesco = JOptionPane.showInputDialog("Entre com o grau de Parentesco" +
                " (por ex.: mãe, irmão, ...): ");
    }

    public String getParentesco(){
        return parentesco;
    }
    
    public String imprimirContato() {
        String dados = super.imprimirBasico() +
                "\nParentesco: " + parentesco;
        return dados;
    }
}
