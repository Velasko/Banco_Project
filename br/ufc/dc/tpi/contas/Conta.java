package br.ufc.dc.tpi.contas;

public class Conta extends ContaAbstrata{

	public Conta(String numero){
		super(numero);
	}

	public void debitar(double valor){
		saldo -= valor;
	}	
}
