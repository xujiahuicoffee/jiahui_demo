package com.coffee.jiahui.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "coin_message")
@Data
public class CoinMessage implements Serializable{

	private static final long serialVersionUID = 1L;

	private String coin;
	
	@Column(name = "short_name")
	private String shortName;
	
	@Column(name = "tag_1")
	private String tagOne;
	
	@Column(name = "tag_2")
	private String tagTwo;
	
}
