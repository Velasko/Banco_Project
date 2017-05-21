package br.ufc.dc.tpi.contas;

public class ContaPoupança extends Conta{
	
	public ContaPoupança(String numero){
		super(numero);
	}

	public void renderJuros(double taxa){
		creditar(saldo*taxa);
	}

}
