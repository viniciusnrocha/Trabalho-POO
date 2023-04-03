import java.util.*;
import java.text.*;


public class DataEHora {

	public String DataAtual(){
		Date x=new Date();//inicia Date()
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy"); //você pode usar outras máscaras
		return(sdf1.format(x));// retorna a data atual formatada	
	}
	public String DataFinal() {
		Date x=new Date();//inicia Date()
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy"); //formata a data evocê pode usar outras máscaras
		return(sdf1.format(x.getTime()+(1000*60*60*24*2)));// retorna a data atual + 2 dias	
	}
	public String HoraAtual() {		
		SimpleDateFormat sdf1= new SimpleDateFormat("HH:mm"); //formata a hora
		Date y=new Date();//inicia Date()
		return (sdf1.format(y));//retorna a hora atual formatada			
	}
	public String HoraFinal() {
		SimpleDateFormat sdf1= new SimpleDateFormat("HH:mm"); //você pode usar outras máscaras
		Date y=new Date();//inicia Date()
		return (sdf1.format(y.getTime()+(1000*60*60*2)));//retorna a hora atual + 2 horas
	}
	//data e calendar
	
	
}
