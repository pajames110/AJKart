package com.aj.james.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.springframework.stereotype.Component;



@Entity
@Component
public class Cart {
	
	@Id
    @GeneratedValue
    private int cartId;

	
   

    @OneToOne
    @JoinColumn(name = "userId")
   // @JsonIgnore
    private UsersDetail usersDetail;
    
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems;
        
	private double grandTotal;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
    
    public UsersDetail getUsersDetail() {
		return usersDetail;
	}

	public void setUsersDetail(UsersDetail usersDetail) {
		this.usersDetail = usersDetail;
	}
}
