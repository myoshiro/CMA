/*
 * UFABC – BCT - BC0502
 * Tiro.java
 *
 * Responsável: MARCO YOSHIRO KUBOYAMA DE CAMARGO
 *
 * Data: 08/08/2008. (data da atualiação mais recente)
 */

/**
 * Descrição
 *
 * Filha da classe abstrata Entidade por isso herda todos os atributos e métodos 
 * da super classe, cria o atributo privado id e é responsavel pelo gerenciamento 
 * de objetos do seu tipo através dos métodos:
 * 
 * -Tiro()
 *      Construtor desta classe, recorre ao construtor da classe mãe para inicializar
 *     as variáveis herdadas e depois inicializa seu atributo especifico;
 * 
 * -movimentar()
 *          Método responsavél pela movimentação de um objeto desta classe na tela do jogo;
 * 
 * -getId*()
 *          Método que retorna variável id, necessario devido ao encapsulamento do atributo;
 */
public class Tiro extends Entidade {

	/**
	 * Identificação do tiro
	 * true  = Jogador
	 * false = Inimigo
	 */
	private boolean id;
        
        private double precisao =0;
        boolean imprecisao;

	/**
	 * Construtor
	 * @param x posição inicial no eixo x
	 * @param y posição inicial no eixo y
	 * @param _imagem representação visual
	 * @param _d quantidade de dano causada pelo tiro
	 * @param _v velocidade em pixels
	 * @param _id indica de quem é o tiro
	 */
	public Tiro (int x, int y, String _imagem, int _d,
		   		int _v, boolean _id) {

		super (x, y, _imagem, _d, _v);
		id = _id;

		// Inverte o sentido do tiro se for do inimigo
		if ( ! id )
		   setVelocidade( - getVelocidade() );
	}
        public Tiro (int x, int y, String _imagem, int _d,
		   		int _v, boolean _id,double _precisao,double erro) {

		super (x, y, _imagem, _d, _v);
                
                if (erro>0.5) imprecisao=true;
                precisao=_precisao;
		id = _id;

		// Inverte o sentido do tiro se for do inimigo
		if ( ! id )
		   setVelocidade( - getVelocidade() );
	}

	/**
	 * Movimenta o tiro
	 */
	public void movimentar () {
            if(!id) //inimigo
            {
                if (imprecisao)
                setLocation (getX() + getVelocidade() , getY()+(int)(getVelocidade()*precisao));
                else
                 setLocation (getX() + getVelocidade() , getY()-(int)(getVelocidade()*precisao));    
            }
            else//jogador
            {
                int abc=(int)(Math.random()*10);
                if(Math.random()<0.5) abc=-abc;
                setLocation (getX() + getVelocidade() , getY()+abc);
            }
	}

	// gets
	public boolean getId () { return id; }
}
