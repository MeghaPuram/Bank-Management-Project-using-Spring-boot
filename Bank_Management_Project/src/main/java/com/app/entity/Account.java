package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long account_no;
	private String account_holder_name;
	private Double account_balance;

}
