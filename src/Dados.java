import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Dados {
	
	//Grava um texto no arquivo
	public static void gravarDados(String caminho,String str){		//str: Conteudo a ser gravado
		FileWriter arq;
		try {
			arq = new FileWriter(caminho);
			PrintWriter gravarArq = new PrintWriter(arq); 
			gravarArq.printf(str); 
			arq.close();
		} catch (IOException e) {
			System.out.println("Erro na gravação do arquivo ...");
		} 
	}

	//Retorna um array com o conteudo do arquivo separado por linhas
	
	public static String[] lerDados(String caminho){		//caminho: caminho do arquivo em disco
		ArrayList<String> list = new ArrayList<String>();
		String[] retorno = null;
		BufferedReader in;
		File f = new File(caminho);
		try {
			if(!f.exists()){
				f.createNewFile();
				gravarDados(caminho, "0");		//se não existir arquivo, ele cria e grava a string "0"
			}
			
			in = new BufferedReader(new FileReader(caminho));
			while (in.ready()) {
				String line = in.readLine();
				list.add(line);
			}
			in.close();
			retorno = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				retorno[i] = list.get(i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retorno;
	}
}