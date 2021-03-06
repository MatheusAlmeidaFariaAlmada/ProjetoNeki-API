package org.neki.backend.projetoNeki.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.neki.backend.projetoNeki.config.GlobalException;
import org.neki.backend.projetoNeki.entity.UserEntity;
import org.neki.backend.projetoNeki.repository.UserRepository;
import org.neki.backend.projetoNeki.vo.UserExibirVO;
import org.neki.backend.projetoNeki.vo.UserInserirVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
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
	
	// Service inserir
	public UserExibirVO inserirService (UserInserirVO userInserirVO) {
		UserEntity user = new UserEntity();
		
		user.setLogin(userInserirVO.getLogin());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(userInserirVO.getPassword()));
		user.setLastLoginDate(LocalDate.now());

		UserEntity user2 = userRepository.save(user);
		
		return new UserExibirVO(user2);
	}
	
	// Service atualizar
	public UserExibirVO atualizar(Long id, UserInserirVO userInserirVO) {
		UserEntity user = new UserEntity();
		if (!userRepository.existsById(id)) {
			return null;
		}
		user.setLogin(userInserirVO.getLogin());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(userInserirVO.getPassword()));
		user.setLastLoginDate(LocalDate.now());

		UserEntity user2 = userRepository.save(user);
		
		return new UserExibirVO(user2);
	}
	
	// Service deletar
	public boolean deletarService(Long id) {
		if (!userRepository.existsById(id)) {
			return false;
		}
		userRepository.deleteById(id);
		return true;
	}
	
	// Listagem de Skills por id do usu??rio	
	public UserExibirVO listarPorIdService(Long id) {
		Optional<UserEntity> user = userRepository.findById(id);
		if (!user.isPresent()) {
			return null;
		}
		return new UserExibirVO(user.get());
	}
	
	//login
	public void updateLastLogin(Long id) {
//		UserEntity user = findById(id);
//		user.setLastLoginDate(LocalDate.now());
//		userRepository.save(user);
	}
	
	//login
	public UserEntity login (UserEntity user) {
		if(userRepository.findByLogin(user.getLogin()) == null) {
			throw new GlobalException("Usu??rio n??o encontrado");
		}
		UserEntity usr = userRepository.findByLogin(user.getLogin());
		if(passwordEncoder.matches(user.getPassword(), usr.getPassword())) {
			updateLastLogin(usr.getId());
			return usr;
		} else {
			throw new GlobalException("Senha inv??lida");
		}
	}
}
