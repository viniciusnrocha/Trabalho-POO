
public class Campus {
	private long id;
	private String Campus;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCampus() {
		return Campus;
	}
	public void setCampus(String campus) {
		Campus = campus;
	}
 

	public String[] listarCampus() {
		String[] s = Dados.lerDados("campus.txt"); // armazena em s[0] 
		String[]l = s[0].split(";");// define o separador 
		return l;// retorna um arrai com os "predios" um em cada posiçao do arrei				
	}	

	public boolean gravarCampus(String predio) {
		String[] d = Dados.lerDados("campus.txt");// le o arquivo do campus
		String[]l = d[0].split(";");// define o separador 		
		for(int x=0; x < l.length; x++) {// verifica se jpa está cadastrado						
			if(predio.equals(l[x])) {				
				System.out.println("Campus ou predio já cadastrado.");
				return false;				
			}	
		}		
		d[0] = d[0] + predio + ";";// soma o nome e o separador
		Dados.gravarDados("campus.txt", d[0]);// salva os dados 
		return true;
	}


	public void deletarCampus(String deletar) {
		String[] s = Dados.lerDados("campus.txt"); // armazena em s[0] 
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
		Dados.gravarDados("campus.txt", s[0]);// salva os dados
	}



}
