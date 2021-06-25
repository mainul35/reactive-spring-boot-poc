package com.mainul35.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User implements Serializable {
	private String uuid;
	private String username;
	private String email;
	private String password;
}
