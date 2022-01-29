package org.neki.backend.projetoNeki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.neki.backend.projetoNeki.service.UserSkillService;
import org.neki.backend.projetoNeki.vo.UserSkillExibirVO;
import org.neki.backend.projetoNeki.vo.UserSkillInserirVO;

@RestController
@RequestMapping("/userskill")
public class userSkillController {

	@Autowired
	UserSkillService userSkillService;
	
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
