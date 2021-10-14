package com.justedlev.games.tictactoe.service;

import com.justedlev.games.tictactoe.api.Player;
import com.justedlev.games.tictactoe.api.Square;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("game-main")
public class GameService implements IGameService {
    private final int[][] lines = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6},
    };
    private final Player[] square = new Player[9];
    private Player player = Player.X;

    @Override
    public void setNext(int index) {
        if (square[index] == null) {
            square[index] = player;
            if (player.equals(Player.X)) {
                player = Player.O;
            } else {
                player = Player.X;
            }
        }
        for (Player p : square) {
            System.out.print(p + "|");
        }
        System.out.println();
    }

    @Override
    public Square getSquare() {
        return Square.builder()
                .line1(getPlayersLine(0))
                .line2(getPlayersLine(3))
                .line3(getPlayersLine(6))
                .build();
    }

    @Override
    public Player getWinner() {
        return winner();
    }

    private Player winner() {
        for (int[] line : lines) {
            if (square[line[0]] == square[line[1]] && square[line[0]] == square[line[2]]) {
                return square[line[0]];
            }
        }
        return null;
    }

    private Player[] getPlayersLine(int i) {
        return new Player[]{square[i], square[i + 1], square[i + 2]};
    }

}
