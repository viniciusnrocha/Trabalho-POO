
public class Laboratorio {
	private String laboratorio;
	private String campus;	

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio; 
	}

	public String[] listarLaboratorio() {
		String[] s = Dados.lerDados("laboratorio.txt"); // armazena em s[0] 
		String[]l = s[0].split(";");// define o separador 
		return l;// retorna um arrai com os "predios" um em cada posiçao do arrei				
	}	

	public boolean gravarLaboratorio(String laboratorio) {		
		String[] d = Dados.lerDados("laboratorio.txt");// le o arquivo do campus		
		String[]l = d[0].split(";");// define o separador 		
		for(int x=0; x < l.length; x++) {// verifica se jpa está cadastrado						
			if(laboratorio.equals(l[x])) {				
				System.out.println("laboratorio já cadastrado.");
				return false;				
			}	
		}		
		d[0] = d[0] + laboratorio + ";";// soma o nome e o separador
		Dados.gravarDados("laboratorio.txt", d[0]);// salva os dados 
		return true;
	}
	
	public void deletarLaboratorio(String deletar) {
		String[] s = Dados.lerDados("laboratorio.txt"); // armazena em s[0] 
		String[]l = s[0].split(";");// define o separador 
		String save="";
		for(int x=0; x < l.length; x++) {// verifica qual é para apagar e apaga 						
			if(!deletar.equals(l[x])) {				
				save = save + l[x] + ";" ;
			}else {
				System.out.println("deletado: "+ l[x]);
			}			
		}
		s[0]= save; // armazena em um arrey de string
		Dados.gravarDados("laboratorio.txt", s[0]);// grava os dados
	}
}

