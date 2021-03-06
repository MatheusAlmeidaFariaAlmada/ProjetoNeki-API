package org.neki.backend.projetoNeki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import java.util.List;

import org.neki.backend.projetoNeki.service.UserSkillService;
import org.neki.backend.projetoNeki.vo.UserSkillExibirVO;
import org.neki.backend.projetoNeki.vo.UserSkillInserirVO;

@RestController
@RequestMapping("/userskill")
public class UserSkillController {

	@Autowired
	UserSkillService userSkillService;
	
	// Listar todos
	@GetMapping
	@ApiOperation(value = "Listar skill dos usuários ", notes = "Listar skill dos usuários")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Skills listadas com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
		
	public ResponseEntity<List<UserSkillExibirVO>> listarTodos() {
		List<UserSkillExibirVO> listaArquivo = userSkillService.buscarTodosService();
		return ResponseEntity.ok(listaArquivo);
	}
	
	// Esse serviço deve receber o id do usuário e retornar todas as skills associadas a ele
	@GetMapping("/{id}")
	@ApiOperation(value = "Buscar skill por ID do usuário", notes = "Buscar skill por ID do usuário")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Skill encontrada com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })

	public ResponseEntity<UserSkillExibirVO> buscarPorId(@PathVariable Long id) {
		UserSkillExibirVO userSkillExibirVO = userSkillService.listarPorIdService(id);
		if (null != userSkillExibirVO) {
			return ResponseEntity.ok(userSkillExibirVO);
		}
		return ResponseEntity.notFound().build();
	}
	
	// Inserir
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	@ApiOperation(value = "Cadastrar skill", notes = "Cadastrar skill")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Skill cadastrado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public UserSkillExibirVO inserir(@RequestBody UserSkillInserirVO userSkillInserirVO) {
		UserSkillExibirVO userSkillExibirVO = userSkillService.inserirService(userSkillInserirVO);
		return userSkillExibirVO;
	}
	
	// Atualizar
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualizar determinada Skill", notes = "Atualizar skill")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Skill atualizada com sucesso"),
			@ApiResponse(code = 201, message = "Skill criada com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<UserSkillExibirVO> atualizar(@PathVariable Long id, @RequestBody UserSkillInserirVO userSkillInserirVO){
		UserSkillExibirVO userSkillExibirVO = userSkillService.atualizar(id, userSkillInserirVO);
		if (userSkillExibirVO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(userSkillExibirVO);
	}
	
	// Esse serviço deve receber o id da associação da skill e excluir da base de dados
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deletar determinada skill", notes = "Deletar skill")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Arquivo deletado com sucesso"),
			@ApiResponse(code = 204, message = "Sem Conteúdo"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		if (!userSkillService.deletarService(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
}
