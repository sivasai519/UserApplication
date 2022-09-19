package com.userinfo.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.userinfo.exception.UserAlreadyExistException;
import com.userinfo.exception.UserNotFoundException;
import com.userinfo.model.User;
import com.userinfo.repository.UserRepository;
import com.userinfo.utilites.UserResponse;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public UserResponse addUser(User user) {
		User user1 = userRepository.findById(user.getUserId()).orElse(null);
		if (user1 == null) {
			userRepository.save(user);
			return new UserResponse("200", "User added Successfully");
		}
		throw new UserAlreadyExistException("User already exist with this " + user1.getUserId());
	}

	public User findByUserId(int userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("No user found with this " + userId));
	}

	public List<User> findByMultipleValues(User user) {
		return userRepository.findAll(new Specification<User>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			List<Predicate> predicates = new ArrayList<>();

			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

				if (user.getUserId() != 0 && user.getUserId() > 0) {
					predicates.add(criteriaBuilder.equal(root.get("userId"), user.getUserId()));
				}
				if (user.getUserAddress() != null) {
					predicates.add(criteriaBuilder.equal(root.get("userAddress"), user.getUserAddress()));
				}
				if (user.getUserDesignation() != null && !user.getUserDesignation().isEmpty()) {
					predicates.add(criteriaBuilder.equal(root.get("userDesignation"), user.getUserDesignation()));
				}
				if (user.getUserName() != null && !user.getUserName().isEmpty()) {
					predicates.add(criteriaBuilder.equal(root.get("userName"), user.getUserName()));
				}
				if (user.getUserPhNumber() != null && !user.getUserPhNumber().isEmpty()) {
					predicates.add(criteriaBuilder.equal(root.get("userPhNumber"), user.getUserPhNumber()));
				}

				return criteriaBuilder.and(predicates.toArray(new Predicate[] {}));
			}

		});
	}

	public UserResponse userDeleteById(int userId) {
		User deleteUser = userRepository.findById(userId).orElse(null);
		if (deleteUser != null) {
			userRepository.deleteById(userId);
			return new UserResponse("200", "User Deleted successfully");
		} else {
			throw new UserNotFoundException("No user found with this " + userId);
		}
	}

	public UserResponse updateUser(User user) {
		User existingUser = userRepository.findById(user.getUserId()).orElse(null);

		if (existingUser == null) {
			throw new UserNotFoundException("No user found with this " + user.getUserId());
		} else {
			userRepository.save(user);
			return new UserResponse("200", "User updated successfully");
		}
	}
}
