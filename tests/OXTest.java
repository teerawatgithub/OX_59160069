import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OXTest {
    @Test
    void getTableString(){
        OX ox = new OX();
        assertEquals(" 012\n" +
                "0---\n" +
                "1---\n" +
                "2---\n", ox.getTableString());
    }
    @Test
    void getCurrentPlayer(){
        OX ox = new OX();
        assertEquals("X", ox.getCurrentPlayer());
    }

    @Test
    void switchPlayer(){
        OX ox = new OX ();
        ox.switchPlayer();
        assertEquals("O", ox.getCurrentPlayer());
    }

    @Test
    void pushAt0_0(){
        OX ox = new OX();
        ox.push(0, 0);
        assertEquals(" 012\n" +
                "0X--\n" +
                "1---\n" +
                "2---\n", ox.getTableString());
    }

    @Test
    void pushAt0_0Tw(){
        OX ox = new OX();
        assertTrue(ox.push(0, 0));
        assertFalse(ox.push(0, 0));
    }

    @Test
    void pushOverTable(){
        OX ox = new OX();
        assertFalse(ox.push(0, -1));
        assertFalse(ox.push(0, 3));
        assertFalse(ox.push(3, -1));
        assertFalse(ox.push(-1, 3));
    }

    @Test
    void getAt0_0(){
        OX ox = new OX();
        ox.push(0, 0);
        assertEquals(" 012\n" +
                "0X--\n" +
                "1---\n" +
                "2---\n", ox.getTableString());
        assertEquals("X", ox.get(0, 0));
    }
    @Test
    void getOver(){
        OX ox = new OX();
        assertNull(ox.get(0, -1));
        assertNull(ox.get(0, 3));
        assertNull(ox.get(3, -1));
        assertNull(ox.get(-1, 3));
    }
}