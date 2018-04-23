/*
 * UFABC – BCT - BC0502
 * Jogo.java
 *
 * Responsável:  MARCO YOSHIRO KUBOYAMA DE CAMARGO
 *               FERNANDO HENRIQUE SILVA
 *               LUCAS PEREIRA OLIVEIRA
 *
 * Data: 09/08/2008. (data da atualiação mais recente)
 */

/**
 * Descrição
 * 
 * Classe responsável pelo funcionamento do jogo
 * Herda a classe JFrame
 * Implementa as interfaces KeyListener e ActionListener
 * 
 * Jogo()
 *      Construtor, cria a janela com menus e inicia o jogo
 * 
 * criaMenu()
 *      Cria o menu da janela
 * 
 * actionPerformed()
 *	Ação de cada menu
 * 
 * iniciar()
 *      Inicia um jogo novo
 * 
 * keyPressed()
 * keyTyped()
 * keyReleased()
 *      ações do teclado, métodos implementados devido a interface KeyListener
 * 
 * teclado()
 *      ações do teclado
 * 
 * colisaoTiro()
 *      verifica colisão com os tiros e alguma nave
 * 
 * acoesInimigos()
 *      Excecuta as ações dos inimigos
 * 
 * moverTiros()
 *      Move os tiros
 * 
 * jogoLoop()
 *      núcleo do jogo
 * 
 * gameover()
 *      O que acontece quando o jogo acaba
 */

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Jogo extends JFrame implements KeyListener , ActionListener {

	// Jogador, inimigos e tiros
	private Jogador jogador;
	private ArrayList <Inimigo> inimigo = new ArrayList <Inimigo>(3);
	private ArrayList <Tiro> tiro = new ArrayList <Tiro>();
        
        private JLabel lifebar;
        private int fase;

	// Cronômetro para excecutar alguns métodos periodicamente
	Timer cronometro;

	/**
	 * Construtor, cria uma janela com menus
	 * @param titulo título da janela
	 * @param largura largura da tela em pixels
	 * @param altura altura  da tela em pixels
	 */
	public Jogo (String titulo, int largura, int altura) {

		// Cria janela
		super (titulo);

		// arruma o modo como as coisas aparecem manualmente
		setLayout(null);

		// Ajusta a tela
		setBounds(0, 0, largura, altura);

		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		addKeyListener (this); // Permite a janela processar eventos do teclado

		criaMenu();

		// A cada 40 milisegundos excecuta um método
		cronometro = new Timer (40, new ActionListener() {
			public void actionPerformed (ActionEvent evt) {
				jogoLoop(); } } );

		// Inicia o jogo
		iniciar();
	}

	/**
	 * Cria o menu da janela
	 */
	public void criaMenu () {
		// Adiciona a barra de menu a janela
		setJMenuBar (BattleSpace.criaMenu());

		// Adiciona eventos aos menus
		JMenu m = getJMenuBar().getMenu(0);
		m.addActionListener(this);
		for (int i=0; i < m.getItemCount(); i++)
			m.getItem(i).addActionListener (this);
	}

	// Eventos relacionados ao menu da janela
	public void actionPerformed (ActionEvent evento){
		Object o = evento.getSource();
		JMenu m = getJMenuBar().getMenu(0);

		if (o == m.getItem(0)) // Novo
			iniciar();
		else if (o == m.getItem(1)) // Placar
			BattleSpace.mostrarPlacar();
		else if (o == m.getItem(2)) // Sair
			System.exit(0);
	}

	/**
         * Inicia um jogo novo
         */
	public void iniciar () {

		// Limpa tudo
                fase = 0;
		if (jogador != null) remove (jogador);
		for (int i=0; i < inimigo.size(); i++) remove (inimigo.get(i));
                if (lifebar != null) remove (lifebar);
		inimigo.clear();
		for (int i=0; i < tiro.size(); i++) remove (tiro.get(i));
		tiro.clear();
		getContentPane().setBackground (Color.BLACK); // Cor de fundo
                

		// Jogador
                jogador = new Jogador (0, 0, "ufo.gif", 1, 25, 20, 5);
                lifebar= new JLabel(new ImageIcon("vida20.png"));
                lifebar.setBounds(100, 500,lifebar.getIcon().getIconWidth(),lifebar.getIcon().getIconHeight());
                add (jogador);
                add (lifebar);
		lifebar.setVisible(true);
		// Cria inimigos
		for (int i=0; i < 3; i++)
			inimigo.add (new Inimigo ( getWidth() ,
						(int) (Math.random() * getHeight()) , 0));
		for (int i=0; i < inimigo.size(); i++)
			add (inimigo.get(i));

		// Reinicia cronômetro
		cronometro.restart();

		// Desenha tela inicial
		repaint();
		setVisible(true);
	}

	// Quando uma tecla é pressionada
	public void keyPressed (KeyEvent evento) { teclado (evento); }
	public void keyTyped   (KeyEvent evento) { teclado (evento); }
	// Quando uma tecla é solta
	public void keyReleased (KeyEvent evento) {  }

	/**
	 * Ações do jogador via teclado
	 */
	public void teclado (KeyEvent evento) {

		int limite = 0;

		/**
		 * 1) Verifica a tecla pressionada
		 * 2) Movimenta o jogador
		 * 3) Não deixa o jogador sair da tela
		 */
		switch ( evento.getKeyCode() ) {

			// Baixo
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_NUMPAD2:
			case KeyEvent.VK_S:
			case KeyEvent.VK_J:
				jogador.movimentar (0, jogador.getVelocidade());
				limite = getHeight() - jogador.getA()*4;
				if (jogador.getY() > limite)
					jogador.setY (limite);
				break;

			// Cima
			case KeyEvent.VK_UP:
			case KeyEvent.VK_NUMPAD8:
			case KeyEvent.VK_W:
			case KeyEvent.VK_K:
				jogador.movimentar (0, -jogador.getVelocidade());
				if (jogador.getY() < limite)
					jogador.setY (limite);
				break;

			// Esquerda
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_NUMPAD4:
			case KeyEvent.VK_A:
			case KeyEvent.VK_H:
				jogador.movimentar (-jogador.getVelocidade(), 0);
				if (jogador.getX() < limite)
					jogador.setX (limite);
				break;

			// Direita
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_NUMPAD6:
			case KeyEvent.VK_D:
			case KeyEvent.VK_L:
				jogador.movimentar (jogador.getVelocidade(), 0);
				limite = getWidth()/2 - jogador.getL();
				if (jogador.getX() > limite)
					jogador.setX (limite);
				break;

			// Atira
			case KeyEvent.VK_COMMA:
                        case KeyEvent.VK_CONTROL:
				if (jogador.getNTiros() < jogador.getMaxTiros()) {
					tiro.add (jogador.atirar());
					add( tiro.get( tiro.size() - 1 ) );
					setVisible(true); // Para o tiro aparecer na tela
				}
				break;

			// Sai do Jogo
			case KeyEvent.VK_ESCAPE: System.exit(0); break;
			default: break;
		}
	}

	/**
	 * Verifica se houve alguma colisão com os tiros e alguma nave.
	 * Se houve, tira um pouco da vida (-1) e remove o tiro da tela
	 * @param nave nave que pode ter colidido com o tiro
	 */
	public void colisaoTiro(Nave nave) {
		for (int i = 0; i < tiro.size(); i++) {
			if (tiro.get(i).colisao(nave)) {
				nave.setVida (nave.getVida() - tiro.get(i).getDano());
                                lifebar.setIcon(new ImageIcon(jogador.getLifebar()));
				tiro.get(i).setImagem("");
				// Se o tiro for do jogador
				if (tiro.get(i).getId()) {
                                    jogador.tiroSumiu();
                                    jogador.setPontos(jogador.getPontos() + nave.getPontos());
				}
                                else { // se o tiro for do inimigo
                                    if (nave instanceof Inimigo)
                                        nave.setVida (nave.getVida() + tiro.get(i).getDano());
                                }
				tiro.remove(i);
			}
		}
	}

	// Excecuta as ações dos inimigos
	public void acoesInimigos () {
		// tiro dos inimigos
		for (int i=0; i < inimigo.size(); i++) {
			if ((int) (Math.random() * (1+inimigo.get(i).getTipo())*7) == 3) {
				tiro.add (inimigo.get(i).atirar());
				add (tiro.get( tiro.size() - 1));
			}
		}
		setVisible(true); // Para o tiro aparecer na tela

		// Move os inimigos
		for (int i=0; i < inimigo.size(); i++)
			inimigo.get(i).movimentar (jogador.getX(), jogador.getY());
	}

	// Move os tiros
	public void moverTiros () {
		for (int i=0; i < tiro.size(); i++) {
			tiro.get(i).movimentar();
			// Remove o tiro se sair da tela
			if (tiro.get(i).getX() > getWidth() || tiro.get(i).getX() < 0) {
				tiro.get(i).setImagem("");
				// Se o tiro for do jogador
				if (tiro.get(i).getId())
					jogador.tiroSumiu();
				tiro.remove(i);
			}
		}
	}

	/**
	 * Loop do jogo
	 * É excecutado de acordo com o cronômetro
	 */
	public void jogoLoop () {
		// Move os tiros e excecuta ações dos inimigos
		moverTiros();
		acoesInimigos();

		// Tiros e jogador
		colisaoTiro (jogador);
		// Tiros e todos os inimigos
		for (int i=0; i < inimigo.size(); i++) {
			colisaoTiro (inimigo.get(i));

			// Se algum inimigo bateu no jogador, o inimigo morre
			if (jogador.colisao( inimigo.get(i) )) {
				jogador.setPontos( jogador.getPontos()
								+ inimigo.get(i).getPontos() );
				inimigo.get(i).setVida(0);
				jogador.setVida (jogador.getVida() - 1);
                                lifebar.setIcon(new ImageIcon(jogador.getLifebar()));
                                break;
			}
		}

		// Verifica se algum inimigo morrreu
		for (int i=0; i < inimigo.size(); i++) {
			if (inimigo.get(i).getVida() < 1) {
				inimigo.get(i).setLocation (getWidth(), (int) (Math.random() * getHeight()));
				inimigo.get(i).setTipo ((int) (Math.random() * 5));
                                fase++;
                                // quando passar de fase (número múltiplo de 10)
                                // adiciona um inimigo e restaura a vida do jogador
                                if (fase%10 == 0) {
                                    jogador.setVida(20);
                                    inimigo.add(new Inimigo(getWidth(),
                                                (int) (Math.random() * getHeight()), 0));
                                    add(inimigo.get(i));
                                    setVisible(true);
                                    JOptionPane.showMessageDialog(null,"    PROXÍMA FASE    \n\n NÍVEL  " + (fase/10+1),"Battle Space",1);
                                }
			}
		}

		// Verifica se o jogador morrreu
		if (jogador.getVida() < 1)
			gameover();
	}

	/**
	 * O que acontece quando o jogo acaba
	 */
	public void gameover () {
		cronometro.stop();

		// Pinta o fundo de vermelho para indicar que o jogo acabou
		getContentPane().setBackground (Color.RED);

		BattleSpace.salvarPlacar (jogador.getPontos());
	}
}
