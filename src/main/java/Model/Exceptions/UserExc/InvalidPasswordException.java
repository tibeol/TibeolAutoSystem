package Model.Exceptions.UserExc;

import Controller.Controller;
import Model.LoggerUtil.Levels;
import Model.LoggerUtil.LogActions;

public class InvalidPasswordException extends Exception {
    public InvalidPasswordException() {
        Controller.logger.log(Levels.ERR, LogActions.ERROR.getText() + " Неверный пароль!");
    }
}
