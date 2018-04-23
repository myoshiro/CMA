import javax.swing.JOptionPane;

public class Atendimento {
    int pergunta, cont;
    Pacote pac[] = new Pacote[10];
    
    
    public Atendimento (){
    pac[0] = new Pacote();
    pac[0].destino = "Fortaleza";
    pac[0].transporte = "Avião";
    pac[0].tempo = "2h 30min";
    pac[0].valor = 800.5;
    
    pac[1] = new Pacote();
    pac[1].destino = "Londrina";
    pac[1].transporte = "Ônibus";
    pac[1].tempo = "6h 15min";
    pac[1].valor = 550;
    }
    
        
    //Método Para Cadastrar Pacote
    public void cadastro(){
    int x =2; 
    pac[x] = new Pacote();
    do{        
    pac[x].destino = JOptionPane.showInputDialog("Digite o Destino");
    pac[x].transporte = JOptionPane.showInputDialog("Digite o Meio de Transporte");
    pac[x].tempo = JOptionPane.showInputDialog("Digite o Tempo de Viagem");
    pac[x].valor = Double.parseDouble(JOptionPane.showInputDialog
            ("Digite o Valor da Viagem:", "R$: 0,00"));
    
    x++;
    pergunta = JOptionPane.showConfirmDialog(null,"Deseja Cadastrar Mais Pacotes?");
    }
    while (pergunta == 0);
    }
    
    //Método Para Contar Pacotes Vendidos
    public int contaVendidos(){   
        for(int i =0; i<pac.length;i++){
            for (int y =0; y<pac.length; y++){
        if (pac[y].destino.equalsIgnoreCase(pac[i].destino))
            cont ++;
            }
            }
        return cont;
    }
    //Método Para Calcular Lucro
    public double calcLucro(int conta,int x){double lucro = conta * pac[x].valor; return lucro;}
    
    //Metodo Para Listar Pacotes
    public String listarPacotes(){
    String msg = "PACOTES\n\n"; 
    for (int i =0; i<pac.length; i++){
    if (pac[i] != (null)){msg += (i+1); msg+="." +pac[i].destino; 
    msg+= "\n Transporte: " + pac[i].transporte;
    msg+= "\n Tempo: " + pac[i].tempo;
    msg+= String.format("\n Valor: R$%.2f\n\n", pac[i].valor);
    }
    }
    return msg;
}
}