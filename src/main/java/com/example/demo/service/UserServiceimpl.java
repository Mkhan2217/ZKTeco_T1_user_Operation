package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.error.UserNotFoundException;
import com.example.demo.repository.UserRepository;
@Service
public class UserServiceimpl  implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		user.setCreateDate(LocalDate.now());
		
		return userRepository.save(user);
	}
	
	@Override
	public User fetchByIdByEmailByPhone(String userId, String email, String phone) throws UserNotFoundException{
		
		User user1= userRepository.findByUserIdOrEmailOrPhone(userId, email, phone);
		if (user1!=null) throw new UserNotFoundException("UserId not found");
		return user1;
	}


	@Override
	public void deleteUserById(String userId)throws UserNotFoundException {
		if (userId!=null) throw new UserNotFoundException("UserId not found");
		userRepository.deleteById(userId);
	}

	@Override
	public List<User> getListOfUsers() throws UserNotFoundException {
		List<User> us1=userRepository.findAll();
		if (us1.size()==0) throw new UserNotFoundException("Users not found");
		return us1;
	}

	@Override
	public User updateById(String userId, User user) {
		User us1= userRepository.findById(userId).get();
			if (Objects.nonNull(user.getFirstName())&&!"".equalsIgnoreCase(user.getFirstName())) {
				us1.setFirstName(user.getFirstName());
			}
			if (Objects.nonNull(user.getLastName())&&!"".equalsIgnoreCase(user.getLastName())) {
				us1.setLastName(user.getLastName());
			}
			if (Objects.nonNull(user.getEmail())&&!"".equalsIgnoreCase(user.getEmail())) {
				us1.setEmail(user.getEmail());
			}
			if (Objects.nonNull(user.getPhone())&&!"".equalsIgnoreCase(user.getPhone())) {
				us1.setPhone(user.getPhone());
			}
			if (Objects.nonNull(user.getDateOfBirth())) {
				us1.setDateOfBirth(user.getDateOfBirth());
			}
			if (Objects.nonNull(user.getGender())&&!"".equalsIgnoreCase(user.getGender())) {
				us1.setGender(user.getGender());
			}
			
			us1.setUpdateDate(LocalDate.now());
				
		return userRepository.save(us1);
	}

	@Override
	public List<User> saveListOfUsers(List<User> user) {
		for(int i=0; i>user.size(); i++) {
			user.get(i).setCreateDate(LocalDate.now());
			user.get(i).setUpdateDate(LocalDate.now());
		}
		return  userRepository.saveAll(user);
	}
	@Override
	public List<User> findByCreateDateBetween(LocalDate date1, LocalDate date2) {
		return userRepository.findByCreateDateBetween(date1, date2);
	}
	 



	


	

	 
}
