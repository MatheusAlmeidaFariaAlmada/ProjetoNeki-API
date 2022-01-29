package org.neki.backend.projetoNeki.exception;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class ApiErrors {
	@Getter
	private List<String> erros;
		
	public ApiErrors(String mensagem) {
		this.erros = Arrays.asList(mensagem);
	}
		
	public ApiErrors(List<String> erros) {
		this.erros = erros;
	}
}

