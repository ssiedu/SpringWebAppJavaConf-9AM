package com.ssi.model;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
@Entity
@Table(name="products")
public class Product {
	@Id
	//@Min(111)
	//@Max(10000)
	@Range(min=111,max=10000,message="code must be in range of 111 to 10000 only")
	private int pcode;
	@Size(min=3,max=15,message="product-name must be 3-15 chars long")
	@Pattern(regexp="[a-zA-Z]*", message="only alphabates are allowed for product name") 
	private String pname;
	@Min(value=100,message="minimum price allowed is : 100")
	private int price;
	private int discount;
	private Blob picture;
}
