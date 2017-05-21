package br.ufc.dc.tpi.contas;

public class ContaEspecial extends Conta{

	double bonus;
	
	public ContaEspecial(String numero){
		super(numero);
		bonus = 0;
	}
	
	public void renderBonus(){
		super.creditar(bonus);
		bonus = 0;
	}
	
	public void creditar(double valor){
		bonus += valor*0.01;
		super.creditar(valor);
	}
	
	public double getBonus(){
		return(bonus);
	}
}
