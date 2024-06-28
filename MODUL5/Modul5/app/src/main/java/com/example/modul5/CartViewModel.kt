package com.example.modul5

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.modul5.network.ProductEntry

class CartViewModel : ViewModel() {

    private val _cartItems = MutableLiveData<List<ProductEntry>>()
    val cartItems: LiveData<List<ProductEntry>> get() = _cartItems

    init {
        _cartItems.value = emptyList()
    }

    fun addItemToCart(product: ProductEntry) {
        val updatedCart = _cartItems.value.orEmpty().toMutableList()
        updatedCart.add(product)
        _cartItems.value = updatedCart
    }

    fun removeItemFromCart(product: ProductEntry) {
        val updatedCart = _cartItems.value.orEmpty().toMutableList()
        updatedCart.remove(product)
        _cartItems.value = updatedCart
    }
}
