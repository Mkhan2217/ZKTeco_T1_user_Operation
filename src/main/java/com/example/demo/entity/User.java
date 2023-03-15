package com.example.demo.entity;

import java.sql.Date;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_info")
public class User {
		@Id
		@Column(name = "user_id",length = 36,unique = true)
		@NotBlank(message = "Please fill id")
		private String userId;
		@NotBlank(message = "Please fill your firstName")
		@Column(nullable = false,length = 50)
		private String firstName;
		@Column(nullable = false,length = 50)
		private String lastName;
		@Column(name = "email",unique = true)
		@NotBlank(message = "Please fill your email Address")
		@Pattern(regexp ="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,}", message = "enter valid email")
		private String email;
		@NotBlank(message = "Please fill your phone")
		@Column(name = "phone",unique = true)
		@Pattern(regexp = "[\\\\\\\\+]+[0-9]{2}+[-]+[0-9]{10}")
		private String phone;
		@NotBlank(message = "Please fill your password")
		@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[A-Za-z0-9]).{8,20}$")
		private String password;
		private String profilePhoto;
		private Date dateOfBirth;
		private LocalDate createDate;
		private LocalDate updateDate;
		@Pattern(regexp ="(?:[M|F|O])" )
		private String gender;
		 
}
