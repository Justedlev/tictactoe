package com.justedlev.games.tictactoe.api;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Square {

    Player[] line1;
    Player[] line2;
    Player[] line3;

}
