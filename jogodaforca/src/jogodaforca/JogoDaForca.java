/* GRUPO -> Luís Henrique Ferreira Freire e Cristopher Silva de Sousa  */

package jogodaforca;
import java.io.File;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Arrays;
import java.util.Scanner; // Import the Scanner class to read text files


public class JogoDaForca {
	private final int N;
	private String[] palavras = new String[4];
	private String[] dicas = new String[4];
	private String[] letras_reveladas = new String[6];
	private String palavra;
	private int indice = -1;
	private int acertos =0;
	private int erros = 0;
	private String[] penalidades = {"pés","pernas","mãos","braços","tronco","cabeça"};
	private String[] arquivos = {"pes.jpg","pernas.jpg","maos.jpg","bracos.jpg","tronco.jpg","cabeca.jpg"};
	private int count_position;
	
	
	public JogoDaForca(String nomearquivo) {
		int i = 0;
		File ab  = new File(nomearquivo);
        try{
             Scanner arq = new Scanner(ab);
             String linha;
             String work;
             String dic;
             
             while (arq.hasNextLine()) {
                    linha = arq.nextLine();
                    String line[] = linha.split(";");
                    work = line[0];
                    dic = line[1];

                    this.palavras[i] = work;
                    this.dicas[i] = dic;                  
                                    
                    i += 1;
                    
            }
             
                arq.close();
            } catch(FileNotFoundException e) {
                  System.out.println("An error occurred.");
                  e.printStackTrace();
            }
        this.N = i;
	}
		
		

	
	public void iniciar() { //feito
		int tamanho = this.palavras.length;
		this.indice = (int)(Math.random() * tamanho);  // 0 to 100
		
		this.palavra = this.palavras[this.indice];
		
	}

    public boolean adivinhou(String letra) {
    
    	boolean confirm_repeticao = false;
    	
    	if (this.palavra.contains(letra.toUpperCase())) {
    		
    		for(int x = 0; x < this.letras_reveladas.length; x++) {
				
				if(letra.toUpperCase().equals(this.letras_reveladas[x])) {
					System.out.println("Letra repetida!!");
					
					confirm_repeticao = true;
					this.erros += 1;
					return false;
					}
    		}
    		if(confirm_repeticao == false) {
    		String[] letras = this.palavra.split("");
    		for(int i=0 ; i<this.palavra.length(); i++) {
    			if(letras[i].equals(letra.toUpperCase())) {
    				
    				this.acertos =(this.acertos + 1);
    				}
    			
    			}
    		this.letras_reveladas[this.count_position]  = letra.toUpperCase();
    		//System.out.println(Arrays.toString(letras_reveladas));
			//this.palavra = this.palavra.replaceAll(letra,"X");
			this.count_position = (this.count_position + 1);
    		}
		}else {
			this.erros += 1;
			return false;
		}
			return true;
    	}

   public boolean terminou() {
	   if(this.acertos == this.palavra.length() || this.erros >= 6 ){
			return true;
		};
		return false;
    }

   public String getPalavra() {
		String[] letras_palavra = this.palavra.split("");
		Boolean confirm = true;
				
		for(int i = 0;i<letras_palavra.length;i++) {
			confirm = false;
			for(int x = 0; x < this.letras_reveladas.length; x++) {
				
					if(letras_palavra[i].equals(this.letras_reveladas[x])) {
						
						confirm = true;
						break;
						}
				
				}	
				
			if(confirm == false) {
				letras_palavra[i] = "*";
			}
			
		}
		
		String resultado_final = Arrays.toString(letras_palavra);
		resultado_final = resultado_final.replace(",", " ");
		resultado_final = resultado_final.replace("[", " ");
		resultado_final = resultado_final.replace("]", " ");
		
		return resultado_final;			
				
	}
		
   
    public String getDica() {
    	return this.dicas[this.indice];
    }


    public String getPenalidade() {
    	if(this.erros == 6) {
    		return "Forca";
    	};
    	return this.penalidades[this.erros - 1];
    }

    public int getAcertos() {
    	return this.acertos;
    }

    public int getErros() {
    	return this.erros;
    }

    public String getResultado() {
    	
    	String result = "Você foi enforcado";
		
		if(this.acertos==this.palavra.length()) {
			result = "Você ganhou";
		}
		
		return result;
    }
}
	
	


/*
1. Acessar cada letra da palavra:
String letra;
for(int i=0 ; i<palavra.length(); i++) {
letra = palavra.substring(i, i+1); //obtém a letra da posição i
System.out.println(letra);
}
2. Substituir todas as ocorrências da letra por ”-”:
String palavra2 = palavra1.replace(letra, “-”); //produz nova string

3. Obter um array com cada letra da palavra:
String[] letras = palavra.split(“”); //separa todas as letras da palavra

4. Clonar uma palavra:
String palavra1 = “...” ;
String palavra2 = new String(palavra1); // palavra2 é o clone da palavra1

5. Clonar uma palavra para maiúsculas:
String palavra1 = “...” ;
String palavra2 = palavra1.toUpperCase(); //palavra2 recebe nova string maiúscula
*/


// File myObj = new File("filename.txt"); // Specify the filename
