package com.reddit.reddit.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VerificationToken {
	@Id
	 @GeneratedValue(strategy = IDENTITY)
	private Long id;	
	private String token;
	@OneToOne(fetch = LAZY)
	private User user;
	private Instant expiryDate;
}
