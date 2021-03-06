package org.neki.backend.projetoNeki.controller;

import java.util.List;

import org.neki.backend.projetoNeki.service.SkillService;
import org.neki.backend.projetoNeki.vo.SkillExibirVO;
import org.neki.backend.projetoNeki.vo.SkillInserirVO;
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
@RequestMapping("/skill")
public class SkillController {
	
	@Autowired
	SkillService skillService;
	
	// Listar todos
	@GetMapping
	@ApiOperation(value = "Listar skill ", notes = "Listar skill")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Skill listados com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
		
	public ResponseEntity<List<SkillExibirVO>> listarTodos() {
		List<SkillExibirVO> listaArquivo = skillService.buscarTodosService();
		return ResponseEntity.ok(listaArquivo);	
	}
	
	// Listar por ID
	@GetMapping("/{id}")
	@ApiOperation(value = "Buscar skill por ID do usuário", notes = "Buscar skill por ID do usuário")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Skill encontrada com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })

	public ResponseEntity<SkillExibirVO> buscarPorId(@PathVariable Long id) {
		SkillExibirVO skillExibirVO = skillService.listarPorIdService(id);
		if (null != skillExibirVO) {
			return ResponseEntity.ok(skillExibirVO);
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
	
	public SkillExibirVO inserir(@RequestBody SkillInserirVO skillInserirVO){
		SkillExibirVO skillExibirVO = skillService.inserirService(skillInserirVO);
		return skillExibirVO;
	}
	
	// Atualizar
	@PutMapping("/{id}")
	@ApiOperation(value = "Atualizar skill", notes = "Atualizar skill")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Skill atualizado com sucesso"),
			@ApiResponse(code = 201, message = "Categoria criado com sucesso"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso Indisponivel"),
			@ApiResponse(code = 500, message = "Erros interno do servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })

	public ResponseEntity<SkillExibirVO> atualizar(@PathVariable Long id, @RequestBody SkillInserirVO skillInserirVO){
		SkillExibirVO skillExibirVO = skillService.atualizar(id, skillInserirVO);
		if (skillExibirVO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(skillExibirVO);
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
		if (!skillService.deletarService(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
	
}
