package org.neki.backend.projetoNeki.controller;

import java.util.List;

import org.neki.backend.projetoNeki.entity.UserEntity;
import org.neki.backend.projetoNeki.service.UserService;
import org.neki.backend.projetoNeki.vo.UserExibirVO;
import org.neki.backend.projetoNeki.vo.UserInserirVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins="http://localhost:3000")
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
		
	// Inserir
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	@ApiOperation(value = "Cadastrar usuários", notes = "Cadastrar usuários")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Usuários cadastrado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public UserExibirVO inserir(@RequestBody UserInserirVO userInserirVO){
		UserExibirVO userExibirVO = userService.inserirService(userInserirVO);
		return userExibirVO;
	}
	
	// Listagem de Skills por id do usuário	
	@GetMapping("/{id}")
	@ApiOperation(value = "Buscar usuários por ID", notes = "Buscar usuários por ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuários encontrado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })

	public ResponseEntity<UserExibirVO> buscarPorId(@PathVariable Long id) {
		UserExibirVO user = userService.listarPorIdService(id);
		if (null != user) {
			return ResponseEntity.ok(user);
		}
		return ResponseEntity.notFound().build();
	}
	
	// Atualizar
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualizar usuário", notes = "Atualizar usuário")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Usuário atualizado com sucesso"),
			@ApiResponse(code = 201, message = "Categoria criado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })

	public ResponseEntity<UserExibirVO> atualizar( @PathVariable Long id, @RequestBody UserInserirVO userInserirVO){
		UserExibirVO userExibirVO = userService.atualizar(id, userInserirVO);
		if (userExibirVO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(userExibirVO);
	}
	
	// Deletar
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletar determinada skill", notes = "Deletar skill")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Arquivo deletado com sucesso"),
			@ApiResponse(code = 204, message = "Sem Conteúdo"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		if (!userService.deletarService(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
	
	// login
	@PostMapping("/login")
	private UserEntity login(@RequestBody UserEntity userEntity){
		return userService.login(userEntity);
	}
	
}
