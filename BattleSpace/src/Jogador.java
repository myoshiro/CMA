/*
 * UFABC – BCT - BC0502
 * Jogador.java
 *
 * Responsável: FERNANDO HENRIQUE SILVA
 *
 * Data: 08/08/2008. (data da atualiação mais recente)
 */

/**
 * Descrição
 */
public class Jogador extends Nave {

	// Limita o número máximo de tiros
	private int maxTiros;

	// Número de tiros que estão na tela
	private int nTiros;
        
        private String lifebar;

	/**
	 * Construtor
	 * @param x posição inicial no eixo x
	 * @param y posição inicial no eixo y
	 * @param _imagem representação visual
	 * @param _d quantidade de dano causada pelo tiro
	 * @param _v velocidade em pixels
	 * @param _vida vida da nave
	 * @param m limite do número máximo de tiros
	 */
	public Jogador (int x, int y, String _imagem,
					int _v, int _d, int _vida, int m) {
		super (x, y, _imagem, _v, _d, _vida);
		maxTiros = m;
		nTiros = 0;
	}

	/**
	 * Movimenta a nave
	 * @param x incrementa posição no eixo x
	 * @param y incrementa posição no eixo y
	 */
	public void movimentar (int x, int y) {
		if(vida > 0)
			setLocation (getX() + x , getY() + y);
	}

	/**
	 * Faz a nave atirar
	 * @return Tiro da nave
	 */
	public Tiro atirar () {
		nTiros++;
		return new Tiro (getX() + getL(), getY()+getA()/2, "tiro1.png",
				getDano(), getVelocidade()*2 ,true);
	}

	/**
	 * Modifica o limite dos tiros
	 * @param l novo limite
	 */
	public void setMaxTiros (int l) { maxTiros = l; }

	// Um tiro saiu da tela ou atingiu um inimigo
	public void tiroSumiu () { nTiros--; }

	// gets
	public int getMaxTiros () { return maxTiros; }
	public int getNTiros () { return nTiros; }
        public String getLifebar()
        {
            return "vida"+this.getVida()+".png";
        }
        
        
        
}
