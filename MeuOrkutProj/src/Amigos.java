
import javax.swing.JOptionPane;

public class Amigos extends Contato {

    int grau;

    public Amigos() {
        String grauStr = JOptionPane.showInputDialog("Qual é o grau? " +
                "(1=melhor amigo, 2=amigo, 3=conhecido)");
        grau = Integer.parseInt(grauStr);
    }

    public int getGrau(){
            return grau;
    }
    
    public String imprimirContato() {
        String[] grauDeAmizade = {"Melhor amigo", "Amigo", "Conhecido"};
        String dados = super.imprimirBasico() +
                "\nGrau de amizade: " + grauDeAmizade[grau - 1];
        return dados;
    }
}
