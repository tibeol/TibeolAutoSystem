package Model.DataBase;

import lombok.Getter;

public enum UsersDataFields {
    ID("id",0),
    NAME("name",1),
    PASSWORD("password",2),
    PHONE_NUMBER("phone_number",3),
    ROLE("role",4);

    private final String value;

    @Getter
    private final int index;

    UsersDataFields(String value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public String toString() {
        return value;
    }
}
