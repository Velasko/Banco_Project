package br.ufc.dc.tpi.contas;

public class ContaImposto extends ContaAbstrata{

	public ContaImposto(String numero){
		super(numero);
	}

	public void debitar(double valor, double juros){
		saldo -= valor * (1 + juros);
	}
	
	public void debitar(double valor){
		this.debitar(valor, 0.001);
	}
}
