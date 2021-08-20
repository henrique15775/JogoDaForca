package jogodaforca;

import java.io.File;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Arrays;
import java.util.Scanner; // Import the Scanner class to read text files


public class JogoDaForca {
	private final int N;
	private String[] palavras = new String[4];
	private String[] dicas = new String[4];
	private String[] letras_reveladas = new String[26];
	private String palavra;
	private int indice = -1;
	private int acertos =0;
	private int erros = 0;
	private String[] penalidades = {"pés","pernas","mãos","braços","tronco","cabeça"};
	private String[] arquivos = {"pes.jpg","pernas.jpg","maos.jpg","bracos.jpg","tronco.jpg","cabeca.jpg"};
	private int count_position;
	private boolean confirm = false;
	
	/*
	 
	 */
	
	public JogoDaForca(String nomearquivo) {
		this.N = 0;
		File ab  = new File(nomearquivo);
        try{
             Scanner arq = new Scanner(ab);
             String linha;
             //String line[];
             String work;
             String dic;
             int i = 0;
             while (arq.hasNextLine()) {

                    linha = arq.nextLine();
                    System.out.println(linha);
                    String line[] = linha.split(";");
                    System.out.println(line[0] + " E " + line[1]);
                    work = line[0];
                    dic = line[1];

                    this.palavras[i] = work;
                    this.dicas[i] = dic;
                    
                    System.out.println("Palavra:" + work);
                    System.out.println("Dica:" + this.dicas);
                    i += 1;

                }
                arq.close();
            } catch(FileNotFoundException e) {
                  System.out.println("An error occurred.");
                  e.printStackTrace();
                }
    
	}
		
		

	
	public void iniciar() { //feito
		int tamanho = this.palavras.length;
		this.indice = (int)(Math.random() * tamanho);  // 0 to 100
		
		this.palavra = this.palavras[this.indice];
		
		System.out.println("Palavra da vez -> " + this.palavra);
	}

    public boolean adivinhou(String letra) {
    	
    	if (this.palavra.contains(letra)) {
    		String[] letras = this.palavra.split("");
    		//System.out.println(palavra.substring(0,1));
    		for(int i=0 ; i<this.palavra.length(); i++) {
    			//String letra_local = palavra.substring(i, i+1);
    			//System.out.println(palavra.substring(i,i+1));
    			if(letras[i].equals(letra)) {
    				
    				//System.out.println("Executou");
    				
    				this.acertos =(this.acertos + 1);
    				}
    			
    			}
    		this.letras_reveladas[this.count_position]  = letra;
    		//System.out.println(Arrays.toString(letras_reveladas));
			//this.palavra = this.palavra.replaceAll(letra,"X");
			this.count_position = (this.count_position + 1);
		}else {
			this.erros += 1;
			return false;
		}
			return true;
    	}

   public boolean terminou() {
	   if(this.acertos == this.palavra.length() || this.erros == this.palavra.length()) {
			return true;
		};
		return false;
    }

   public String getPalavra() {
		String[] letras_palavra = this.palavra.split("");
		
		for(int i = 0;i<letras_palavra.length;i++) {
			this.confirm = false;
			for(int x = 0; x<this.letras_reveladas.length;x++) {
				if(letras_reveladas[x] != null) {
				//System.out.println(x);
				
					if(letras_palavra[i].equals(this.letras_reveladas[x])) {
						
						this.confirm = true;
						System.out.println("CONFIRMOU");
						break;
						}
				}
					//System.out.println("oiii");
				}	
				
			if(this.confirm == false) {
				System.out.println("FALSEOU");
				letras_palavra[i] = "*";
			}
			
			}
		
		String resultado_final = Arrays.toString(letras_palavra);
		resultado_final = resultado_final.replace(",", " ");
		resultado_final = resultado_final.replace("[", " ");
		resultado_final = resultado_final.replace("]", " ");
		
		
		return resultado_final;			
				
			}
		
		
		
	   /*
	   String[] letras = palavra.split(""); //separa todas as letras da palavra
	   //String palavra2 = palavra1.replace(letra, "-"); //produz nova string
	   for(String i: this.letras_reveladas) {
		   		
			}
	   return "oi";*/
   
    public String getDica() {
    	return this.dicas[this.indice];
    }


    public String getPenalidade() {
    	return "Eaeeeee";
    }

    public int getAcertos() {
    	return this.acertos;
    }

    public int getErros() {
    	return this.erros;
    }

    public String getResultado() {
    	return "Ola";
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