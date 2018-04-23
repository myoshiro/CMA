/*
 * UFABC – BCT - BC0502
 * Pontuacao.java
 *
 * Responsável: MARCO YOSHIRO KUBOYAMA DE CAMARGO
 *
 * Data: 03/08/2008. (data da atualiação mais recente)
 */

/**
 * Descrição
 *
 * Classe responsável por gerenciar o ranking do aplicativo através dos eus métodos, 
 * ela implementa a a interface Comparator e obrigatoriamento o método compare.
 *
 *  - Pontuacao()
 *        Construtor da classe que inicializa as variáveis nome e pontos;
 *
 *  - compare()
 *        método da interface Comparator para ordenar os objetos
 * 
 * - getNome()
 *        Método implementado para retornar a variável nome fora classe devido ao 
 *          encapsulamento dessa variavel
 * 
 * - getPontos()
 *        Método implementado para retornar a variável pontos fora classe devido ao 
 *          encapsulamento dessa variavel
 */

import java.util.Comparator;

public class Pontuacao implements Comparator <Pontuacao> {

	private String nome;
	private int pontos;

	/**
	 * Construtor, inicializa as variáveis de acordo com os parâmetros
	 * @param nomeIn nome de quem possui a pontuação
	 * @param pontosIn quantidade de pontos
	 */
	public Pontuacao (String nomeIn, int pontosIn) {
		nome = nomeIn;
		pontos = pontosIn;
	}

	// ordem DEcrescente (maior pontuação vem primeiro)
	public int compare (Pontuacao p1, Pontuacao p2) {
		if (p1.pontos < p2.pontos) return 1;
		else if (p1.pontos == p2.pontos) return 0;
		else return -1;
	}

	// gets
	public String getNome() { return nome; }
	public int getPontos() { return pontos; }
}
