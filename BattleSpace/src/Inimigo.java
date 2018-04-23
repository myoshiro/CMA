/*
 * UFABC – BCT - BC0502
 * Inimigo.java
 *
 * Responsável: FERNANDO HENRIQUE SILVA
 *
 * Data: 09/08/2008. (data da atualiação mais recente)
 */

/**
 * Descrição
 *
 * Existem 5 tipos de inimigos.
 * Cada tipo de inimigo possui características diferentes.
 */
public class Inimigo extends Nave {

	/**
	 * Determina: dano causado pelo tiro, velocidade e vida
	 * Exemplo:
	 *    tipo 1:
	 *            dano = 1
	 *            velocidade = 2
	 *            vida = 3
	 */
	private int tipo;

	/**
	 * Define as características do inimigo
	 * @param _d quantidade de dano causada pelo tiro
	 * @param _v velocidade em pixels
	 * @param _vida vida da nave
	 * @param _p pontuação da nave
	 */
	private void caracteristicas (int _d, int _v, int _vida, int _p) {
		setDano(_d);
		setVelocidade(_v);
		setVida(_vida);
		setPontos(_p);
	}

	/**
	 * Define as características do inimigo através de seu tipo
	 * @param _tipo tipo do inimigo
	 */
	private void defineTipo (int _tipo) {
		tipo = _tipo;
		switch (tipo) {
			case 0:  caracteristicas (1,  8, 2, 1); break;
			case 1:  caracteristicas (1, 10, 2, 2); break;
			case 2:  caracteristicas (2, 15, 2, 3); break;
			case 3:  caracteristicas (3,  5, 1, 4); break;
			default: caracteristicas (2, 10, tipo, tipo); break;
		}
	}

	/**
	 * Construtor
	 * @param x posição inicial no eixo x
	 * @param y posição inicial no eixo y
	 * @param _tipo tipo do inimigo
	 */
	public Inimigo (int x, int y, int _tipo)
	{
		super (x, y, "alfa.png", 1, 1, 1);
		defineTipo(_tipo);
	}

	/**
	 * Movimenta o inimigo baseado na posição do jogador
	 * @param x posição do jogador no eixo x
	 * @param y posição do jogador no eixo y
	 */
	public void movimentar (int x, int y) {
		// Persegue o jogador

		if (tipo < 3) {
			// jogador a direita do inimigo
			if (x > getX()) x = getVelocidade();
			else x = - getVelocidade();

			// jogador acima do inimigo
			if (y > getY())
                            y = getVelocidade();
			else
                            y = - getVelocidade();

			setLocation (getX() + x , getY() + y);
		}
		else
		{
			// inimigo fica a uma distacia do jogador
			// porém na mesma "altura"
			setLocation (x + 400 , y);
		}
	}

	/**
	 * Faz a nave atirar
	 * @return Tiro da nave
	 */
	public Tiro atirar () {
		return new Tiro (getX() - getL()/2, getY()+getA()/2, "tiro2.png",
				getDano(), getVelocidade()*2, false,Math.random()/8,Math.random());
	}

	// gets
	public int getTipo () { return tipo; }

	// sets
	public void setTipo (int _tipo) { defineTipo(_tipo); }
}
