/*Comando Ensinado Pelo Professor na Aula
 JOptionPane.showConfirmDialog(null, "");*/

import javax.swing.JOptionPane;

public class MegaSena {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int resposta;
    
    Sorteio M = new Sorteio();
    do {M.guardaNumeros();
        M.repeticao();
        M.mostraResultado();
        
        resposta =JOptionPane.showConfirmDialog
            (null,"Deseja Sortear Novamente?");} 
   while(resposta == 0);
}
}
