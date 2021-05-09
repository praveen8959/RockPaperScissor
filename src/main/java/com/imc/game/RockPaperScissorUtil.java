package com.imc.game;

import static com.imc.game.MoveType.PAPER;
import static com.imc.game.MoveType.ROCK;
import static com.imc.game.MoveType.SCISSOR;
import static com.imc.game.MoveType.moveTypeList;
import static java.lang.System.out;

import java.util.Random;
import java.util.Scanner;

public final class RockPaperScissorUtil {

    private RockPaperScissorUtil() {
    }

    public static void validateWinner(String computerMove, String playerMove) {
        if (computerMove.equals(playerMove)) {
            out.println("Tie game!!!");
        } else if (ROCK.name().equals(playerMove) && SCISSOR.name().equals(computerMove)
                || PAPER.name().equals(playerMove) && ROCK.name().equals(computerMove)
                || SCISSOR.name().equals(playerMove) && PAPER.name().equals(computerMove)) {
            out.println("You win");
        } else {
            out.println("You loose");
        }
    }

    public static String getComputerMove() {
        return moveTypeList.get(new Random().nextInt(moveTypeList.size()));
    }

    public static String getPlayerMove(Scanner scanner) {
        String playerMove;
        do {
            String playerInput = scanner.nextLine().toUpperCase();
            playerMove = MoveType.getMove(playerInput);
            if (playerMove.isEmpty()) {
                out.println(playerMove + " is not a valid move. Try Again!!!");
            }
        } while (playerMove.isEmpty());
        return playerMove;
    }

}
