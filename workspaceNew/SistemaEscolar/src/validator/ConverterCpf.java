package validator;

public class ConverterCpf {
	
	public String cpfLimpo(String cpf){
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-","");
		
		return cpf;
	}
	
	

}
