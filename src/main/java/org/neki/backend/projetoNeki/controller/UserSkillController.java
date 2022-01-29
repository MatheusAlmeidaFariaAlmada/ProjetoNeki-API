package org.neki.backend.projetoNeki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@ApiOperation(value = "Buscar skill por ID dp usuário", notes = "Buscar skill por ID dp usuário")
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
}
