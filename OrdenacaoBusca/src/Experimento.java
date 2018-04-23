import java.io.*;
import java.util.*;
import javax.swing.*;
 
public class Experimento {
    
    protected String nomeDoResponsavel;
    protected double temperatura, pressao, volume;
    
    Experimento(String name,double temp, double press, double v){
    this.nomeDoResponsavel= name;
    this.temperatura =temp;
    this.pressao =press;
    this.volume =v;
    }
    
    Experimento(){
    nomeDoResponsavel = JOptionPane.showInputDialog
            (null, "Digite o Nome do Responsável pelo Experimento");
    
    temperatura = Double.parseDouble(JOptionPane.showInputDialog
            (null, "Digite a Temperatura do Exprimento (Celcius)"));
   
    pressao = Double.parseDouble(JOptionPane.showInputDialog
            (null, "Digite a Pressão do Exprimento (N/m²)"));
    
    volume = Double.parseDouble(JOptionPane.showInputDialog
            (null, "Digite o Volume do Exprimento (m³)"));
    }
    
    public String mensagem () {
    String msg = "\n\n Nome do Responsável: "  + this.nomeDoResponsavel + 
            "\n Temperatura: " + this.temperatura + "K\n Pressão: " + pressao + 
            "N/m²\nVolume: " + volume + "m³\n";
    
    return msg;
    }
    
    public static void salvarArquivo (ArrayList <Experimento> Lista){
        
    try {
	BufferedWriter out = new BufferedWriter (new FileWriter ("Experimentos.txt"));
	
        String msg = "";
	for (int i=0; i < Lista.size(); i++)
	 msg += Lista.get(i).nomeDoResponsavel  +":" + Lista.get(i).temperatura +
                 ":" + Lista.get(i).pressao +":" + Lista.get(i).volume +"\n";
	 out.write (msg);
	 out.close();
		}
		catch (IOException erro) {
			JOptionPane.showMessageDialog(null, erro);}
	}
    
    public static ArrayList<Experimento> lerArquivo (){
    ArrayList <Experimento> Lista = new ArrayList <Experimento>();
        try {
	BufferedReader in = new BufferedReader (new FileReader ("Experimentos.txt"));

	Lista.clear();
	String linha = "" , campos[] = null;

	while ( (linha = in.readLine()) != null ) {
	campos = linha.split (":");
				
	String n = campos[0];
        double t = Double.parseDouble(campos[1]);
        double p = Double.parseDouble(campos[2]);
        double v = Double.parseDouble(campos[3]);
        
       Lista.add (new Experimento(n,t,p,v)); }
			in.close();}
    catch (IOException erro) {JOptionPane.showMessageDialog(null, erro);}
    
    return Lista;
    }
    
    
    
    }


