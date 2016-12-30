package com.aj.james.dao;

import java.util.List;

import com.aj.james.model.Cart;
import com.aj.james.model.CartItem;


public interface CartItemDAO {
	
	void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId (String id,int cartId);
    
   List<CartItem> getAllCartItems(int cartId);

}
