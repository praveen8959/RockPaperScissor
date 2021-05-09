package com.imc.game;

import static com.imc.game.RockPaperScissorUtil.getComputerMove;
import static com.imc.game.RockPaperScissorUtil.getPlayerMove;
import static com.imc.game.RockPaperScissorUtil.validateWinner;
import static java.lang.System.out;

import java.util.Scanner;

/**
 *
 * Rock Paper Scissor game takes player input and plays with computer move.
 *
 */
public class RockPaperScissor {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new RockPaperScissor().run();
    }

    public void run() {
        out.println("Lets Play Rock Paper Scissor !!!!!!");
        String playOrExit;
        do {
            playGame();
            out.println("Want to play again ??? (Y/N)");
            playOrExit = scanner.nextLine();
        } while ("Y".equalsIgnoreCase(playOrExit));
        scanner.close();
    }

    private void playGame() {
        out.println("Please enter your move \n R - Rock \n P - Paper \n S - Scissor ");
        String computerMove = getComputerMove();
        String playerMove = getPlayerMove(scanner);
        out.println("You played : " + playerMove);
        out.println("Computer played : " + computerMove);
        validateWinner(computerMove, playerMove);
    }

}
