package br.com.api.pessoas.http.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DadosPessoaRequest {
	
	private String nome;
	private String cpf;

}
