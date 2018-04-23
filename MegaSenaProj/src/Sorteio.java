import javax.swing.JOptionPane;

public class Sorteio {
    int i =0;
    int num [] = new int[6];
    
    // Sortear Números
    public int  sorteioDeNumero(){return (int) (Math.random() * 60 + 1);}
    
    //Guardar Número
    public void guardaNumeros() {
    for (i=0; i<num.length; i++){
    num [i] = sorteioDeNumero();
    }
    }
    
    //Mostrar Resultados
    public void mostraResultado(){
    String msg = "SORTEADOS";
        
    for (i = 0; i<num.length; i++){
    msg = msg + String.format("\n%2d", num[i]);}
    
    JOptionPane.showMessageDialog(null, msg);
    }
    
    //Verifica Repetição
    public void repeticao(){
    for (int j=0; j<num.length; j++){
    for (i = 0; i<6; i++){
	num[i] = this.sorteioDeNumero();
	j=0;
	while (j < i){
		while (num[i] == num[j]){
			num[i] = this.sorteioDeNumero();
			j = 0;}
	        j++;}
        }
    }   
  }

}
    