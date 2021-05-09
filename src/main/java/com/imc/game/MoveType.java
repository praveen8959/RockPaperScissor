package com.imc.game;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MoveType {

    ROCK, PAPER, SCISSOR;

    protected static final List<String> moveTypeList = Arrays.stream(MoveType.values())
            .map(MoveType::name).collect(Collectors.toList());

    public static String getMove(String moveVal) {
        switch(moveVal){
            case "R":
                return ROCK.name();
            case "P":
                return PAPER.name();
            case "S":
                return SCISSOR.name();
            default:
                return "";
        }
    }

}
