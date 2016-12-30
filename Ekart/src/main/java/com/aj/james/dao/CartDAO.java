package com.aj.james.dao;

import java.io.IOException;

import com.aj.james.model.Cart;


public interface CartDAO {
	
	 Cart getCartById (int cartId);
	    
	   Cart validate(int cartId) throws IOException;  
	    
	    public void update(Cart cart);

}
