package jogodaforca;
import java.util.Scanner;
public class index {

	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);

		JogoDaForca jogo = new JogoDaForca("C:\\Users\\2001h\\eclipse-workspace\\jogodaforca\\src\\jogodaforca\\palavras.txt");
		jogo.iniciar();
		String letra;
		do {
			System.out.println("palavra=" + jogo.getPalavra());
			System.out.println("dica=" + jogo.getDica());

			System.out.println("digite uma letra da palavra ");
			letra = teclado.nextLine();
			
			if (jogo.adivinhou(letra)) {
				System.out.println("voce acertou a letra "+ letra);
				System.out.println("total de acertos="+jogo.getAcertos());
			} 
			else {
				System.out.println("Voce errou a letra "+ letra);
				System.out.println("total de erros="+jogo.getErros());
				System.out.println("Penalidade: "+jogo.getPenalidade());
			}
		}
		while(!jogo.terminou());
		
		teclado.close();
		
		System.out.println("game over");
		System.out.println("resultado final="+jogo.getResultado() );

	}

}
