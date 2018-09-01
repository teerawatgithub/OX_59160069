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

    @Test
        void checkWinCol0(){
        OX ox = new OX();
        ox.push(0, 0);
        ox.push(0, 1);
        ox.push(0, 2);
        assertTrue(ox.checkWin(0, 0));
        assertTrue(ox.checkWin(0, 1));
        assertTrue(ox.checkWin(0, 2));
        assertFalse(ox.checkWin(1, 0));
        assertFalse(ox.checkWin(1, 1));
        assertFalse(ox.checkWin(1, 2));
    }

    @Test
    void checkWinCol2(){
        OX ox = new OX();
        ox.push(2, 0);
        ox.push(2, 1);
        ox.push(2, 2);
        assertTrue(ox.checkWin(2, 0));
        assertTrue(ox.checkWin(2, 1));
        assertTrue(ox.checkWin(2, 2));
        assertFalse(ox.checkWin(1, 0));
        assertFalse(ox.checkWin(1, 1));
        assertFalse(ox.checkWin(1, 2));
    }

    @Test
    void checkWinRow2(){
        OX ox = new OX();
        ox.push(0, 2);
        ox.push(1, 2);
        ox.push(2, 2);
        assertTrue(ox.checkWin(0, 2));
        assertTrue(ox.checkWin(1, 2));
        assertTrue(ox.checkWin(2, 2));
        assertFalse(ox.checkWin(1, 0));
        assertFalse(ox.checkWin(1, 1));
        assertFalse(ox.checkWin(2, 1));
    }

    @Test
    void check_ES_Win(){
        OX ox = new OX();
        ox.push(0, 0);
        ox.push(1, 1);
        ox.push(2, 2);
        assertTrue(ox.checkWin(0, 0));
        assertTrue(ox.checkWin(1, 1));
        assertTrue(ox.checkWin(2, 2));
    }

    @Test
    void check_SS_Win(){
        OX ox = new OX();
        ox.push(2, 0);
        ox.push(1, 1);
        ox.push(0, 2);
        assertTrue(ox.checkWin(2, 0));
        assertTrue(ox.checkWin(1, 1));
        assertTrue(ox.checkWin(0, 2));
    }

    @Test
    void reset(){
        OX ox = new OX();
        ox.push(2, 0);
        ox.push(1, 1);
        ox.push(0, 2);
        ox.reset();
        assertEquals(" 012\n" +
                "0---\n" +
                "1---\n" +
                "2---\n", ox.getTableString());
        assertEquals("X", ox.getCurrentPlayer());
        assertEquals(0, ox.getTurnCount());
    }

    @Test
    void getTurnCount(){
        OX ox = new OX();
        assertEquals(0, ox.getTurnCount());
        ox.push(0, 0);
        assertEquals(1, ox.getTurnCount());
    }

    @Test
    void isDraw(){
        OX ox = new OX();
        ox.push(0, 0);
        ox.push(0, 1);
        ox.push(0, 2);
        assertFalse(ox.isDraw());
        ox.push(1, 0);
        ox.push(1, 1);
        ox.push(1, 2);
        assertFalse(ox.isDraw());
        ox.push(2, 0);
        ox.push(2, 1);
        ox.push(2, 2);
        assertTrue(ox.isDraw());
    }

    @Test
    void getScoreX(){
        OX ox = new OX();
        assertEquals(0, ox.getScoreX());
        ox.push(0, 0);
        ox.push(0, 1);
        ox.push(0, 2);
        assertEquals(1, ox.getScoreX());
    }

    @Test
    void getScoreO(){
        OX ox = new OX();
        ox.switchPlayer();
        assertEquals(0, ox.getScoreO());
        ox.push(0, 0);
        ox.push(1, 1);
        ox.push(2, 2);
        assertEquals(1, ox.getScoreO());
    }

    @Test
    void getScoreDraw(){
        OX ox = new OX();
        assertEquals(0, ox.getScoreDraw());
        ox.push(0, 0);
        ox.push(0, 1);
        ox.push(0, 2);
        assertFalse(ox.isDraw());
        ox.push(1, 0);
        ox.push(1, 1);
        ox.push(1, 2);
        assertFalse(ox.isDraw());
        ox.push(2, 0);
        ox.push(2, 1);
        ox.push(2, 2);
        assertTrue(ox.isDraw());
        assertEquals(1, ox.getScoreDraw());
    }
}