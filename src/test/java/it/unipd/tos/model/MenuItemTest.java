////////////////////////////////////////////////////////////////////
// [Samuel] [Kostadinov] [1187605]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

import it.unipd.tos.model.MenuItem;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

public class MenuItemTest {
    MenuItem item;
    @Before
    public void setUp() {
        item = new MenuItem("Cola", MenuItem.items.Bevanda, 2.50);
    }
    @Test
    public void getNameTest() {
        assertEquals("Cola", item.getName());
    }	
    @Test
    public void getTypeTest() {	
        assertEquals(MenuItem.items.Bevanda, item.getType());
    }
    @Test
    public void getPrice() {	
        assertEquals(2.50, item.getPrice(), 0.0);
    }
}
