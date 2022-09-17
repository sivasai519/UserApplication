package com.userinfo.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
		userRepository.save(user);
		return new UserResponse("200", "User added Successfully");
	}

	public ResponseEntity<User> findByUserId(int userId) {
		return ResponseEntity.of(userRepository.findById(userId));
	}

	public List<User> findByMultipleValues(User user) {

		return userRepository.findAll(new Specification<User>() {

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
}
