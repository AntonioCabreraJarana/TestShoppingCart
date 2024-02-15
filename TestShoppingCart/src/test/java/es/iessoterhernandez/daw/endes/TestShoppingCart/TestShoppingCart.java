package es.iessoterhernandez.daw.endes.TestShoppingCart;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit test for simple App.
 */
public class TestShoppingCart {
	
	private ShoppingCart carro1;
	Product aceitunas, anacardos;

	@BeforeEach
	public void inicio() {
		carro1 = new ShoppingCart();
		
		aceitunas = new Product("Aceitunas", 1);
		anacardos = new Product("anacados", 1.35);
	}

	@AfterEach
	public void finish() {
		carro1 = null;
		
		
	}

	@Test
	public void testGetBalance() {

		carro1.addItem(anacardos);
		carro1.addItem(aceitunas);		
		
		assertTrue((aceitunas.getPrice() + anacardos.getPrice()) == carro1.getBalance());
		assertFalse((aceitunas.getPrice() - anacardos.getPrice()) == carro1.getBalance());

	}
	
	@Test
	public void testRemove() throws ProductNotFoundException {
		
		
		carro1.addItem(anacardos);
		carro1.addItem(aceitunas);		
		
		assertThat(2, is(carro1.getItemCount()));
		carro1.removeItem(aceitunas);
		assertThat(1, is(carro1.getItemCount()));
		
		
	}
	@Test
    public void testRemoveItemThrowsException() {
        assertThrows(ProductNotFoundException.class, () -> {
            carro1.removeItem(aceitunas);
        });
    }
	
	@Test 
	public void testEmpty() {
		carro1.addItem(anacardos);
		carro1.addItem(aceitunas);	
		
		assertThat(2, is(carro1.getItemCount()));
		carro1.empty();
		assertThat(0, is(carro1.getItemCount()));
		
	}
	
	@Test
	public void testEquals() {
		assertTrue(aceitunas.equals(aceitunas));
		assertFalse(aceitunas.equals(anacardos));
		
	}

}
