package org.neki.backend.projetoNeki.service;

import java.util.ArrayList;
import java.util.List;

import org.neki.backend.projetoNeki.entity.UserEntity;
import org.neki.backend.projetoNeki.repository.UserRepository;
import org.neki.backend.projetoNeki.vo.UserExibirVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	// Listar todos
	public List<UserExibirVO> buscarTodosService() {
		List<UserExibirVO> userExibirVO = new ArrayList<UserExibirVO>();
		List<UserEntity> userEntity = userRepository.findAll();
		
		for (UserEntity userEntity1 : userEntity) {
			UserExibirVO userVO = new UserExibirVO(userEntity1);
			userExibirVO.add(userVO);
		}
		return userExibirVO;
	}
}
