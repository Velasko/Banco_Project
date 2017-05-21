package br.ufc.dc.tpi.banco;

import br.ufc.dc.tpi.contas.ContaAbstrata;
import br.ufc.dc.tpi.contas.ContaEspecial;

public class BancoArray {

	private ContaAbstrata[] contas;
	private int indice = 0;
	
	public BancoArray(){
		contas = new ContaAbstrata[100];
	}
	
	public void cadastrar(ContaAbstrata conta){
		contas[indice] = conta;
		indice++;
	}
	
	private ContaAbstrata procurar (String numero){
		for(ContaAbstrata conta : contas){
			if (numero.equals(conta.numero())){
				return(conta);
			}
		}
		return(null);
	}
	
	public void debitar(String numero, double valor){
		ContaAbstrata conta = procurar(numero);
		if(conta != null){
			conta.debitar(valor);
		} else {
			System.out.println("Conta Inexistente!");
		}
	}
	
	public double saldo(String numero){
		ContaAbstrata conta = procurar(numero);
		if(conta != null){
			return(conta.saldo());
		} else{
			return(Double.MIN_VALUE);
		}
		
	}
	
	public void renderBonus(String numero){
		ContaAbstrata conta = procurar(numero);
		if(conta instanceof ContaEspecial){
			((ContaEspecial) conta).renderBonus();
		}
	}
	
}
