import java.util.*;
import javax.swing.*;

public class Ordenacao {

       public static void main(String[] args) {
        
        //Criando ArrayList de Experimentos   
        ArrayList <Experimento> Lista = new ArrayList <Experimento>();
        Lista = Experimento.lerArquivo();
        
        /**
        //Gerando e Adicionando Experimentos
        Experimento e1 = new Experimento();
        Lista.add(e1);
        
        Experimento e2 = new Experimento();
        Lista.add(e2);
        
        Experimento e3 = new Experimento();
        Lista.add(e3);
        
        Experimento e4 = new Experimento();
        Lista.add(e4);
        
        Experimento e5 = new Experimento();
        Lista.add(e5);
        */
                
        int a = 0, o;
        String impressao = "";
        
        String msg = ("*****      DIGITE UMA DAS OPÇÕES         *****\n\n" +
                " 1. Imprimir Experimentos Por Ordem Crescente de Temperatura\n" +
                " 2. Imprimir os 3 experimentos que possuem a temperatura mais baixa\n" +
                " 3. Imprimir todos os experimentos com as pressões em ordem decrescente\n" +
                " 4. Imprimir os 3 experimentos que possuem a pressão mais alta\n" +
                " 5. Imprimir Todos os Experimentos com Temperatura de 30\n" +
                " 6. Imprimir todos os experimentos com pressão igual a 0,05 N/m2\n" +
                " 7. Imprimir todos os experimentos por ordem alfabética do nome do responsável\n" +
                " 8. Excluir Experimentos Apartir de Parâmetros\n" +
                " 9. Adicionar Experimento\n" +
                "10. Sair");
        
        do{          
        
        o = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
            
            switch (o){
        
                case 1:{
                    Collections.sort(Lista, new ExpCompTemperatura());
                    
                    impressao ="Experimentos";
                    for (int i =0; i<Lista.size(); i++){
                    impressao += Lista.get(i).mensagem();}
                    JOptionPane.showMessageDialog(null, impressao);
                    break;}
                
               
                
                case 2: {
                    
                    Collections.sort(Lista, new ExpCompTemperatura());
                    
                    impressao ="Experimentos";
                    
                    if(Lista.size() > 3){
                    for (int i =0; i<3; i++){
                    impressao += Lista.get(i).mensagem();}
                    JOptionPane.showMessageDialog(null, impressao);}
                    
                else JOptionPane.showMessageDialog(null, "Não Há Três Elementos");
                break;
                }
                    
                    
                
                                       
                
                case 3:{
                    Collections.sort(Lista, new ExpCompPressao());
                    Collections.reverse(Lista);
                    
                    impressao ="Experimentos";
                    for (int i =0; i<Lista.size(); i++){
                    impressao += Lista.get(i).mensagem();}
                    JOptionPane.showMessageDialog(null, impressao);
                    break;}
                
                
                
                case 4: {
                    
                    Collections.sort(Lista, new ExpCompPressao());
                    Collections.reverse(Lista);
                    
                    if (Lista.size() > 3){
                    impressao ="Experimentos";
                    for (int i =0; i<3; i++){
                    impressao += Lista.get(i).mensagem();}
                    JOptionPane.showMessageDialog(null, impressao);}
                    else JOptionPane.showMessageDialog(null, "Não Há Três Elementos");
                    break;}
                
                
                
                case 5: {
                    Collections.sort(Lista, new ExpCompTemperatura());
                    impressao = "";
                    
                    for (int l =0; l<Lista.size(); l++){
                           if (Lista.get(l).temperatura == 30){
                           impressao +=Lista.get(l).mensagem();}}
                                                
                    JOptionPane.showMessageDialog(null, impressao);
                    break;
                }
                
                
                
                case 6: {
                    Collections.sort(Lista, new ExpCompTemperatura());
                    impressao = "";
                    
                    for (int l =0; l<Lista.size(); l++){
                           if (Lista.get(l).pressao == 0.05){
                           impressao +=Lista.get(l).mensagem();}}
                                                
                    JOptionPane.showMessageDialog(null, impressao);
                    break;
                }
                
                
                
                case 7:{
                Collections.sort(Lista, new ExpCompNome());
                
                impressao ="Experimentos";
                
                for (int i =0; i<Lista.size(); i++){
                impressao += Lista.get(i).mensagem();}
                
                JOptionPane.showMessageDialog(null, impressao);
                
                break;}
                
                
                
                case 8:{
                int g = Integer.parseInt(JOptionPane.showInputDialog
                        (null,"Excluir Experimento Por\n\n" + "1. Temperatura\n" +
                        "2. Pressão\n" + "3. Volume\n"));
                
                switch (g){
                //Case das Temperaturas
                    case 1:{
                        Collections.sort(Lista, new ExpCompTemperatura());
                        
                        int f = Integer.parseInt(JOptionPane.showInputDialog
                        (null,"Excluir Experimentos com Temperatura\n" +
                                "1.Maior que o Determinado\n2.Menor que o Determinado"));
                        
                        switch (f){
                            
                            case 1: {Collections.sort(Lista, new ExpCompTemperatura());
                            double r = Double.parseDouble(JOptionPane.showInputDialog
                        (null,"Excluir Experimentos com Temperatura Maior que:"));
                            
                           for (int l =0; l<Lista.size(); l++){
                           if (Lista.get(l).temperatura > r){
                           Lista.remove(l);}}
                            break;
                            }
                            
                           case 2:{Collections.sort(Lista, new ExpCompTemperatura());
                               double r = Double.parseDouble(JOptionPane.showInputDialog
                        (null,"Excluir Experimentos com Temperatura Menor que:"));
                            
                           for (int l =0; l<Lista.size(); l++){
                           if (Lista.get(l).temperatura < r){
                           Lista.remove(l);}}
                                break;
                           } 
                            default:JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA"); break;
                        }
                    break;
                    }
                    //Case das Pressões
                    case 2:{
                    Collections.sort(Lista, new ExpCompPressao());
                        int k = Integer.parseInt(JOptionPane.showInputDialog
                        (null,"Excluir Experimentos com Pressão\n" +
                                "1.Maior que o Determinado\n2.Menor que o Determinado"));
                        
                        switch (k){
                            
                            case 1: {Collections.sort(Lista, new ExpCompPressao());
                            double r = Double.parseDouble(JOptionPane.showInputDialog
                        (null,"Excluir Experimentos com Pressão Maior que:"));
                            
                            for (int l =0; l<Lista.size(); l++){
                           if (Lista.get(l).pressao > r){
                           Lista.remove(l);}}
                            break;
                            }
                            
                           case 2:{Collections.sort(Lista, new ExpCompPressao());
                               double r = Double.parseDouble(JOptionPane.showInputDialog
                        (null,"Excluir Experimentos com Pressão Menor que:"));
                            
                            for (int l =0; l<Lista.size(); l++){
                           if (Lista.get(l).pressao < r){
                           Lista.remove(l);}}
                            
                               break;
                         }
                           
                            default:JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA"); break;
                        }
                        break;
                    }
                    
                    //Case dos Volumes
                        case 3:{
                            Collections.sort(Lista, new ExpCompPressao());
                        int w = Integer.parseInt(JOptionPane.showInputDialog
                        (null,"Excluir Experimentos com Volume\n" +
                                "1.Maior que o Determinado\n2.Menor que o Determinado"));
                        
                        switch (w){
                            
                            case 1: {Collections.sort(Lista, new ExpCompPressao());
                            double r = Double.parseDouble(JOptionPane.showInputDialog
                        (null,"Excluir Experimentos com Volume Maior que:"));
                            
                            for (int l =0; l<Lista.size(); l++){
                           if (Lista.get(l).volume > r){
                           Lista.remove(l);}}
                            break;
                            }
                        
                           case 2:{Collections.sort(Lista, new ExpCompPressao());
                               double r = Double.parseDouble(JOptionPane.showInputDialog
                        (null,"Excluir Experimentos com Volume Menor que:"));
                            
                            for (int l =0; l<Lista.size(); l++){
                           if (Lista.get(l).volume < r){
                           Lista.remove(l);}}
                            break;
                         }
                           
                    default:JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA"); break;}                        
                        }
                
                }
                break;
                }//Final do Case 8
                
                
                
                case 9:{
                Lista.add(new Experimento());
                break;
                }
                
                
                case 10: {a =1; break;}
                
                
                
                default : JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA"); break;
        }
            
        Experimento.salvarArquivo(Lista);}
        while (a ==0);
    }

}
