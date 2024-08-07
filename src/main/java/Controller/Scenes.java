package Controller;

import lombok.Getter;

/**
 *  Представляет собой перечисление (enum) в Java, которое определяет различные сцены или состояния в приложении. Каждая сцена имеет уникальный номер
 */


public enum Scenes {

    GREETING(1),
    CHOOSING_ROLE(2),
    REGISTRATION(3),
    AUTHORIZATION(4),
    ACTIONS(5),
    EXIT_FROM_ACCOUNT(6),
    SHUT_DOWN(7);

    @Getter
    private int number;

    Scenes(int number){
        this.number = number;
    }

    Scenes nextStep(){
        if(number==8) return Scenes.SHUT_DOWN;
        return Scenes.values()[number];
    }
}
