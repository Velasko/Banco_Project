package br.ufc.dc.tpi.banco;

import br.ufc.dc.tpi.contas.ContaAbstrata;
import br.ufc.dc.tpi.contas.ContaEspecial;
import br.ufc.dc.tpi.contas.ContaPoupança;

import br.ufc.dc.tpi.implementações.*;


public class BancoIndependente implements IBanco{
	private IRepositorioConta contas;
	
	public BancoIndependente(IRepositorioConta contas){
		this.contas = contas;
	}

	public void cadastrar(ContaAbstrata conta){
		contas.inserir(conta);
	}
	
	public void debitar(String numero, double valor){
		ContaAbstrata conta = contas.procurar(numero);
		if (conta != null){
			conta.debitar(valor);
		}else{
			System.out.println("Conta inexistente!");
		}
	}
	
	public void creditar(String numero, double valor){
		ContaAbstrata conta;
		conta = procurar(numero);
		if(conta != null){
			conta.creditar(valor);
		} else {
			System.out.println("Conta Inexistente!");
		}
	}
	
	public double saldoTotal(){
		double saldocontado = 0;
		for(ContaAbstrata conta : contas.listar()){
			saldocontado += conta.saldo();
		}
		return(saldocontado);
	}
	
	public int numeroContas(){
		return(contas.tamanho());
	}
	
	public ContaAbstrata procurar(String numero){
		return(contas.procurar(numero));
	}
	
	public double saldo(String numero){
		return(procurar(numero).saldo());
	}
	
	public void transferir(String origem, String destino, double valor){
		procurar(origem).debitar(valor);
		procurar(destino).creditar(valor);
	}
	
	public void renderBonus(String numero){
		ContaAbstrata conta = procurar(numero);
		if(conta instanceof ContaEspecial){
			((ContaEspecial) conta).renderBonus();
		}else{
			System.out.println("Essa não é uma conta especial");
		}
	}
	
	public void renderJuros(String numero, double taxa){
		ContaAbstrata conta = procurar(numero);
		if(conta instanceof ContaPoupança){
			((ContaPoupança) conta).renderJuros(taxa);
		}else{
			System.out.println("Essa não é uma conta poupança");
		}
	}
}
