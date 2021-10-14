package com.justedlev.games.tictactoe.service;

import com.justedlev.games.tictactoe.api.Player;
import com.justedlev.games.tictactoe.api.Square;

public interface IGameService {

    void setNext(int index);
    Square getSquare();
    Player getWinner();

}
