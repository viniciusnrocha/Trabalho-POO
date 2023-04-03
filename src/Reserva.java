
public class Reserva {
	
	private String campus;
	private String laboratorio;
	private String data;
	private String horaInicio;
	private String horaFinal;
	private String professor;	
	

	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	
	public boolean gravarReserva (String data, String horaInicial, String horaFinal, String sala, String predio, String professor) {
		
			String[] d = Dados.lerDados("reserva.txt");// le o arquivo da reserva
			String[]l = d[0].split(";");// define o separador de cada reserva		
			for(int x=0; x < l.length; x++) {// verifica se jpa está cadastrado						
				if(predio.equals(l[x])) {				
					System.out.println("reserva já cadastrada");
					return false;				
				}	
			}		
			d[0] = d[0] + data +", "+ horaInicial +", "+ horaFinal +", "+ sala +", "+ predio + ", "+ professor + ";";// soma o nome e o separador
			Dados.gravarDados("reserva.txt", d[0]);// salva os dados 
			return true;
		}
	public  String[] listarReserva() {
		String[] s = Dados.lerDados("reserva.txt"); // armazena em s[0] 
		String[]l = s[0].split(";");// define o separador 
		return l;// retorna um arrai com os "predios" um em cada posiçao do arrei			
	}
	
	public void deletarReserva(String deletar) {
		String[] s = Dados.lerDados("reserva.txt"); // armazena em s[0] 
		String[]l = s[0].split(";");// define o separador 
		String save="";
		for(int x=0; x < l.length; x++) {						
			if(!deletar.equals(l[x])) {				
				save = save + l[x] + ";" ;
			}else {
				System.out.println("deletado: "+ l[x]);
			}			
		}
		s[0]= save;
		Dados.gravarDados("reserva.txt", s[0]);// salva os dados
	}
	

}
