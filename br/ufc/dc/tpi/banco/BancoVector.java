package br.ufc.dc.tpi.banco;

import br.ufc.dc.tpi.contas.ContaAbstrata;
import br.ufc.dc.tpi.contas.ContaEspecial;

import java.util.Vector;

public class BancoVector {

	private Vector<ContaAbstrata> contas;
	
	public BancoVector(){
		contas = new Vector<ContaAbstrata>();
	}
	
	public void cadastrar(ContaAbstrata conta){
		contas.add(conta);
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
		ContaAbstrata conta;
		conta = procurar(numero);
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
