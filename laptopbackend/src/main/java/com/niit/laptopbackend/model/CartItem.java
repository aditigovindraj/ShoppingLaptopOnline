package com.niit.laptopbackend.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;



	@Entity
	@Table
	@Component

	public class CartItem
	{
		private static final long SerialVersionUID=1l;
		@Id
		private String ct_id;
		float price;
						public float getPrice() {
			return price;
		}




		public void setPrice(float price) {
			this.price = price;
		}
						@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="p_id")
		private Product product;
		
		@ManyToOne
		@JoinColumn(name="c_id")
		Cart cart;
		
		public Product getProduct() {
					return product;
				}




				public void setProduct(Product product) {
					this.product = product;
				}




				public Cart getCart() {
					return cart;
				}




				public void setCart(Cart cart) {
					this.cart = cart;
				}




		public CartItem()
		
		{
			this.ct_id="C"+UUID.randomUUID().toString().substring(30).toUpperCase();
		}
		
		
		
		
		public String getCt_id() {
			return ct_id;
		}
		public void setCt_id(String ct_id) {
			this.ct_id = ct_id;
		}
		

}


	