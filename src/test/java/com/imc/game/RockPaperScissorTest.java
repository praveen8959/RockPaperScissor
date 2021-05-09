package com.imc.game;

import static com.imc.game.MoveType.PAPER;
import static com.imc.game.MoveType.ROCK;
import static com.imc.game.MoveType.SCISSOR;
import static com.imc.game.MoveType.moveTypeList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class RockPaperScissorTest {

    private final PrintStream           standardOut        = System.out;
    private final InputStream           standardIn         = System.in;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    private static Stream<Arguments> playerAndComputerMoves() {
        return Stream.of(
                arguments(ROCK.name(), PAPER.name()),
                arguments(PAPER.name(), SCISSOR.name()),
                arguments(SCISSOR.name(), ROCK.name()));
    }

    @ParameterizedTest
    @MethodSource("playerAndComputerMoves")
    void testValidateWinner_whenPlayerWin(String computerMove, String playerMove) {
        RockPaperScissorUtil.validateWinner(computerMove, playerMove);
        assertEquals("You win", outputStreamCaptor.toString()
                .trim());
    }

    @ParameterizedTest
    @MethodSource("playerAndComputerMoves")
    void testValidateWinner_whenPlayerLoose(String playerMove, String computerMove) {
        RockPaperScissorUtil.validateWinner(computerMove, playerMove);
        assertEquals("You loose", outputStreamCaptor.toString()
                .trim());
    }

    @ParameterizedTest
    @ValueSource(strings = { "R", "P", "S" })
    void testGetPlayerMove_whenValidInput(String move) {
        System.setIn(new ByteArrayInputStream(move.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(standardIn);
        String playerMove = RockPaperScissorUtil.getPlayerMove(scanner);
        assertTrue(moveTypeList.contains(playerMove));
    }

    @ParameterizedTest
    @ValueSource(strings = { "R", "P", "S" })
    void testGetMove_wheValidInput(String move) {
        String moveType = MoveType.getMove(move);
        assertTrue(moveTypeList.contains(moveType));
    }

    @ParameterizedTest
    @ValueSource(strings = { "X", "Y", "Z" })
    void testGetMove_whenInvalidInput(String move) {
        String moveType = MoveType.getMove(move);
        assertTrue(moveType.isEmpty());
    }

    @Test
    void testGetComputerMove() {
        String playerMove = RockPaperScissorUtil.getComputerMove();
        assertTrue(moveTypeList.contains(playerMove));
    }
}
