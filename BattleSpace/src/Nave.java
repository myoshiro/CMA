/*
 * UFABC – BCT - BC0502
 * Nave.java
 *
 * Responsável: LUCAS PEREIRA OLIVEIRA
 *
 * Data: 08/08/2008. (data da atualiação mais recente)
 * 
 * Descrição
 * 
 * esta é a classe abstrata que modela todas as naves do jogo, tanto a do jogador quanto
 * as inimigas, herda Entidade e é clasce mãe de Jogador e Inimigo, contém todos
 * atributos e métodos abstratos comuns a todas as naves.
 * 
 * Nave() construtor da clasce, inicializa todas as variáveis através de parâmetros
 * atirar(): método abstrato é implementado em jogador.
 * movimentar(): método abstrato, tem implementações diferentes em jogador e Inimigo.
 * além dos métodos getters e setters.
 */


public abstract class Nave extends Entidade {

	/**
	 * Define a vida da nave.
	 * Se for igual ou menor a zero a nave é destruída.
	 */
	protected int vida;

	/**
	 * Define a pontuação da nave ou a quantidade de
	 * pontos que é dada ao Jogador quando um inimigo é destruído.
	 */
	private int pontos;

	/**
	 * Construtor
	 * @param x posição inicial no eixo x
	 * @param y posição inicial no eixo y
	 * @param _imagem representação visual
	 * @param _d quantidade de dano causada pelo tiro
	 * @param _v velocidade em pixels
	 * @param _vida vida da nave
	 */
        
	public Nave (int x, int y, String _imagem, int _d, int _v, int _vida) {
		super (x, y, _imagem, _d, _v);
		vida = _vida;
		pontos = 0;
	}

	/**
	 * Movimenta a nave
	 * @param x ver classe filha
	 * @param y ver classe filha
	 */
	public abstract void movimentar (int x, int y);

	/**
	 * Faz a nave atirar
	 * @return Tiro da nave
	 */
	public abstract Tiro atirar();

	// gets
	public int getVida () { return vida; }
	public int getPontos() { return pontos; }

	// sets
	public void setVida (int _vida) { vida = _vida; }
	public void setPontos (int _pontos) { pontos = _pontos; }
}
