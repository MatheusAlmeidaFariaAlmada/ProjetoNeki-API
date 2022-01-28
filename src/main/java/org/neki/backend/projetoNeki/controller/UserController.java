package org.neki.backend.projetoNeki.controller;

import java.util.List;

import org.neki.backend.projetoNeki.service.UserService;
import org.neki.backend.projetoNeki.vo.UserExibirVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	// Listar todos
		@GetMapping
		@ApiOperation(value = "Listar usuários ", notes = "Listar usuários")
		@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuários listados com sucesso"),
				@ApiResponse(code = 401, message = "Erro de autenticação"),
				@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
				@ApiResponse(code = 404, message = "Recurso Indisponivel"),
				@ApiResponse(code = 500, message = "Erros interno do servidor"),
				@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
		
		public ResponseEntity<List<UserExibirVO>> listarTodos() {
			List<UserExibirVO> listaArquivo = userService.buscarTodosService();
			return ResponseEntity.ok(listaArquivo);
			
		}
}
