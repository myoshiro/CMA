/*
* UFABC – BCT - BC0502
* BattleSpace.java
*
* Responsável: MARCO YOSHIRO KUBOYAMA DE CAMARGO
*
* Data: 08/08/2008. (data da atualiação mais recente)
*/

/**
 * Descrição
 *
 * Classe responsável pelo programa (jogo, menus e placar)
 */

import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class BattleSpace implements ActionListener{

	private static Jogo jogo;
	private static ArrayList <Pontuacao> pontuacao;
 	private static String arqPlacar = "placar.txt";
        static JFrame abertura;

	// main
	public static void main (String[] args) {
		pontuacao = new ArrayList <Pontuacao>();
              
                abertura = new JFrame ();
                abertura.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		abertura.setBounds(0, 0 , 800, 600);                
		abertura.getContentPane().setBackground(Color.BLACK);
                
                     
                JButton I = new JButton("INICIAR");
                I.addActionListener(new BattleSpace());
                I.setBounds(350, 450, 100,20);
		abertura.add(I);
                abertura.add(new JLabel (new ImageIcon ("BattleSpace.png")));
		abertura.setVisible(true);
               
	}

	/**
	 * Cria um menu com as opções:
	 *    Novo = Inicia um novo jogo
	 *    Placar = Mostra o placar
	 *    Sair = Sai do jogo
	 * @return Barra de menu
	 */
	public static JMenuBar criaMenu () {

		// Barra de menu
		JMenuBar menubar = new JMenuBar();

		// Menu
		JMenu menu = new JMenu ("Jogo");
		menu.setMnemonic ('o'); // Tecla de atalho

		// Submenus
		JMenuItem submenu[] = new JMenuItem[3];

		submenu[0] = new JMenuItem ("Novo");
		submenu[0].setMnemonic ('N');

		submenu[1] = new JMenuItem ("Placar");
		submenu[1].setMnemonic ('P');

		submenu[2] = new JMenuItem ("Sair");
		submenu[2].setMnemonic ('S');

		// Adiciona os submenus ao menu
		for (int i=0; i < submenu.length; i++)
			menu.add ( submenu[i] );

		// Adiciona o menu a barra de menu
		menubar.add (menu);

		return menubar;
	}

	/**
	 * Pega todas as pontuações do arquivo
	 * e armazena no arraylist pontuacao
	 */
	public static void getPlacar () {
		try {
			BufferedReader in = new BufferedReader (
				new FileReader (arqPlacar));

			pontuacao.clear();
			String linha = "" , campos[] = null;

			while ( (linha = in.readLine()) != null ) {
				campos = linha.split (":");
				// é necessário a linha ter somente dois campos
				if (campos.length == 2)
					pontuacao.add (new Pontuacao (campos[1],
							   	Integer.parseInt (campos[0])));
			}
			in.close();
		}
		// se o arquivo não existe, ele é criado
		catch (FileNotFoundException erro) {
			try {
				BufferedWriter out = new BufferedWriter (
						new FileWriter (arqPlacar));
				out.close();
			} catch (IOException ioerro) { System.out.println (erro); }
		}
		catch (IOException erro) {
			System.out.println ("Erro na leitura dos dados");
		}
	}

	/**
	 * Mostra todas as pontuações
	 */
	public static void mostrarPlacar () {
		getPlacar();
		// ordena da maior pontuação para a menor
		Collections.sort( pontuacao, new Pontuacao("",0) );

		String msg = "";
		for (int i=0; i <10; i++)
			msg +=  String.format((i+1)+". %s\t .............................\t %4d\n",
                                pontuacao.get(i).getNome(), pontuacao.get(i).getPontos() );
		JOptionPane.showMessageDialog (null, msg, "*****    SPACE   RANKING     *****",1);
	}

	/**
	 * Salva a pontuação do jogador no placar
	 * @param pontos pontuação que irá para o placar
	 */
	public static void salvarPlacar (int pontos) {
		// pede o nome do jogador
		String nome = "";
		while (nome.isEmpty()) {
			try { nome = JOptionPane.showInputDialog ("DIGITE SEU NOME"); }
			catch (Exception erro) { nome = ""; }
		}
		// remove os ":" para não dar erro na hora de ler o arquivo
		nome = nome.replaceAll(":","");

		getPlacar();
		// adiciona a nova pontuação
		pontuacao.add (new Pontuacao (nome, pontos));

		// ordena da maior pontuação para a menor
		Collections.sort( pontuacao, new Pontuacao("",0) );

		// salva no arquivo
		try {
			BufferedWriter out = new BufferedWriter (
					new FileWriter (arqPlacar));
			String msg = "";
			for (int i=0; i < pontuacao.size(); i++)
				 msg += pontuacao.get(i).getPontos() + ":" +
						pontuacao.get(i).getNome()   + "\n";
			out.write (msg);
			out.close();
		}
		catch (IOException erro) {
			System.out.println ("Erro na escrita dos dados");
		}
	}

    public void actionPerformed(ActionEvent e) {
         jogo = new Jogo ("BattleSpace", 800, 600);
         abertura.setVisible(false);
    }
}
