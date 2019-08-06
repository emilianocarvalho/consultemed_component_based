/**
 * 
 */
package br.com.consultemed.services;

import java.util.List;

import javax.inject.Inject;

import br.com.consultemed.models.Funcionario;
import br.com.consultemed.repository.repositories.FuncionarioRepository;
import br.com.consultemed.utils.Messages;

/**
 * @author carlosbarbosagomesfilho
 *
 */
public class FuncionarioService {

	@Inject
	private FuncionarioRepository dao;
	
	public List<Funcionario> listaFuncionario(){
		return this.dao.listaFuncionarios();
	}
	
	public Funcionario buscarPorCPF(Funcionario funcionario) {
		return this.dao.buscaPorCPF(funcionario);		
	}
	
	public void salvarFuncionario(Funcionario funcionario) {
//		Funcionario encontrado = this.buscarPorCPF(funcionario);
		 
//		if (encontrado == null) {
			this.dao.salvarFuncionario(funcionario);
//			Messages.sucessoMsg("Atualizado com Sucesso");
//		} else {
//			Messages.errorMsg("Funcionario existente");
//		}
	}
	
	public void deletarFuncionario(Long id) throws Exception {
		this.dao.deleteById(id);
	}
}
