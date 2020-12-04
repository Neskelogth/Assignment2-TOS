////////////////////////////////////////////////////////////////////
// [Samuel] [Kostadinov] [1187605]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

import it.unipd.tos.model.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.junit.Before;

public class UserTest {

    User user;

    @Before
    public void setUp() {
        user = new User("Mario", "Rossi", 29, 0);
    }
    @Test
    public void getNameTest(){	
        assertEquals("Mario", user.getName());
    }	
    @Test
    public void getSurnameTest(){	
        assertEquals("Rossi", user.getSurname());
    }
    @Test
    public void getAge(){	
        assertEquals(29, user.getAge());
    }
    @Test
    public void isMinorenne(){
        assertFalse(user.isMinorenne());
    }	
    @Test
    public void getId(){
        assertEquals(0, user.getId());
    }
}
