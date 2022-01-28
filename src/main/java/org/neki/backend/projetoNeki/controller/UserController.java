package org.neki.backend.projetoNeki.controller;

import java.util.List;

import org.neki.backend.projetoNeki.service.UserService;
import org.neki.backend.projetoNeki.vo.UserExibirVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	// Listar todos
		@GetMapping
		public ResponseEntity<List<UserExibirVO>> listarTodos() {
			List<UserExibirVO> listaArquivo = userService.buscarTodosService();
			return ResponseEntity.ok(listaArquivo);
			
		}
}
