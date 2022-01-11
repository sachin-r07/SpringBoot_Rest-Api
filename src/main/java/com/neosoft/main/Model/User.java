package com.neosoft.main.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;

	@NotNull
	private String uname;

	private String surname;

	private String pincode;

	private boolean deleted = Boolean.FALSE;

	@JsonFormat(pattern = "yyyy-MM--dd", shape = Shape.STRING)
	private String udob;

	@JsonFormat(pattern = "yyyy-MM--dd", shape = Shape.STRING)
	private String uJoindate;

}
