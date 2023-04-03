
public class Professor {
	private String Professor;
	
	
	
	
	public String getProfessor() {
		return Professor;
	}

	public void setProfessor(String professor) {
		Professor = professor;
	}
	
	public String[] listarProfessor() {
		String[] s = Dados.lerDados("professor.txt"); // armazena em s[0] 
		String[]l = s[0].split(";");// define o separador 
		return l;// retorna um arrai com os "predios" um em cada posiçao do arrey
	}	

	public boolean gravarProfessor(String gravar) {
		String[] d = Dados.lerDados("professor.txt");// le o arquivo do campus
		String[] l = d[0].split(";");// define o separador 		
		for(int x=0; x < l.length; x++) {// verifica se jpa está cadastrado						
			if(gravar.equals(l[x])) {				
				System.out.println("Campus ou predio já cadastrado.");
				return false;				
			}	
		}		
		d[0] = d[0] + gravar + ";";// soma o nome e o separador
		Dados.gravarDados("professor.txt", d[0]);// salva os dados 
		return true;
	}
	
	public void deletarProfessor(String deletar) {
		String[] s = Dados.lerDados("professor.txt"); // armazena em s[0] 
		String[]l = s[0].split(";");// define o separador 
		String save="";
		for(int x=0; x < l.length; x++) {						
			if(!deletar.equals(l[x])) {				
				save = save + l[x] + ";" ;				
			}else {
			System.out.println("deletado: "+ l[x]+ x);
			}			
		}
		s[0]= save;
		Dados.gravarDados("professor.txt", s[0]);// salva os dados
	}
}
