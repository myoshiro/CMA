/*
 * UFABC – BCT - BC0502
 * Entidade.java
 *
 * Responsável: LUCAS PEREIRA OLIVEIRA
 *
 * Data: 07/08/2008. (data da atualiação mais recente)
 * 
 * Descrição:
 * esta é a classe abstrata que modela todas as entidades do jogo, ou seja,é a classe mãe
 * de todos os objetos do jogo,  portanto, contem todos atributos e métodos 
 * basicos comuns a todos objetos. Ela herda a clasce javax.swing.JLabel, 
 * pois usa varios atributos e métodos da mesma.
 * 
 * Entidade(): construtor da clasce, inicializa as variáveis através de 
 * parâmetros passados ao construtor.
 * colisão()recebe como parâmetro outra entidade, verifica se houve uma colisão
 * e retorna uma variavel tipo boolean com valor true caso as duas entidades 
 * tenham colidido ou false caso contrário.
 * além dos métodos setters e getters.
 */

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Descrição
 */
public abstract class Entidade extends JLabel {

	// Quantidade de dano
	private int dano;

	// velocidade
	int velocidade;

	/**
	 * Construtor
	 * @param x posição inicial no eixo x
	 * @param y posição inicial no eixo y
	 * @param _imagem representação visual
	 * @param _d quantidade de dano
	 * @param _v velocidade em pixels
	 */
	public Entidade (int x, int y, String _imagem, int _d, int _v) {
		setIcon (new ImageIcon(_imagem));
		setBounds (x , y, getIcon().getIconWidth(), getIcon().getIconHeight());
		dano = _d;
		velocidade = _v;
	}

	/**
	 * Verifica se houve colisão
	 * @param outro
	 * @return true  colidiu
	 * @return false não colidiu
	 */
	public boolean colisao(Entidade outro)
	{
		//colisão horizontal
		if (getX()+getL()>outro.getX()
			&&outro.getX()+outro.getL()>getX()
			//colisão vertical
			&& getY()+getA()>outro.getY()
			&& outro.getY()+outro.getA()>getY())
				return true;

		return false;
	}

	// gets
	// getX() e getY() são herdados do JFrame
	public int getL () { return getIcon().getIconWidth(); }
	public int getA () { return getIcon().getIconHeight(); }
	public int getDano () { return dano; }
	public int getVelocidade () { return velocidade; }

	// sets
	public void setX (int x) { setLocation (x, getY()); }
	public void setY (int y) { setLocation (getX(), y); }
	public void setImagem (String _imagem) { setIcon (new ImageIcon(_imagem)); }
	public void setDano (int _d) { dano = _d; }
	public void setVelocidade (int _v) { velocidade = _v; }
}
