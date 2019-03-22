package com.coffee.jiahui.domain;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="z_gis")
public class ZGis {
	
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="gis")
	private String gis;
	
	@Column(name="geohash")
	private String geohash;
}
