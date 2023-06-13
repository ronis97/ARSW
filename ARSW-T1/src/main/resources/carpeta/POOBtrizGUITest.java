package Presentacion;

import Dominio.TetrominoeC;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * La clase POOBtrizGUITest es la encargadda de hacer
 * las pruebas de unidad del juego
 *
 * @author Cesar Vasquez - Ronaldo Henao
 * @version 1.0  (December 09, 2021)
 */
public class POOBtrizGUITest {


    POOBtrizGUI gui = new POOBtrizGUI("poobtriz");
    String nick = "pepito";
    String nick2 = "papita";
    Tetris tetris = Tetris.loadGame(gui,nick,null);


    @Test
    public void deberiaCargarTablero1Jugador(){
        Tetris tetris = Tetris.loadGame(gui,nick,null);
        BoardPanel board = tetris.getBoard1();
        assertTrue(board != null);
    }

    @Test
    public void deberiaCargar2Tableros(){
        Tetris.isTwoPlayer = true;
        Tetris tetris = Tetris.loadGame(gui,nick,nick2);
        BoardPanel board1 = tetris.getBoard1();
        BoardPanel board2 = tetris.getBoard2();
        assertTrue(board1 != null);
        assertTrue(board2 != null);
    }

    @Test
    public void deberiaCargarPieza(){
        Tetris.isTwoPlayer = false;
        Tetris tetris = Tetris.loadGame(gui,nick,null);
        tetris.getMaingame().resetGame();
        TetrominoeC piece = tetris.getMaingame().getNextPieceType();
        assertTrue(piece != null);
        tetris.Dispose();
    }

    @Test
    public void deberiaCargarTableroValido(){
        Tetris.isTwoPlayer = false;
        Tetris tetris = Tetris.loadGame(gui,nick,null);
        boolean condicion = tetris.getBoard1().getBoard().isValidAndEmpty();
        assertTrue(condicion);
        tetris.dispose();
    }

}