package Model.Entities.Car;

import Model.DataBase.DataBaseHandler;
import Model.Entities.Users.Client;
import Model.Entities.Users.Id;
import Model.Entities.Users.User;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

/**
 * Имеет 2 конструктора, для клиента и менеджера, чтобы не перегружать действиями по регистрации автомобиля обычного пользователя
 *
 * @see Id
 * Идентификационный номер уникальный для базы данных автомобилей
 */

@Setter
@Getter
public class Car {

    @Nullable
    private User owner;

    @Getter
    private final int ID = Id.getUniqueId(DataBaseHandler.getCarData());

    private String model;
    private String brand;

    private Integer yearOfProduction;

    private String color;

    private Integer price;

    private Integer mileAge;

    @Nullable
    private String description;

    private boolean booked = false;

    private String getBookText(){
        if(!booked)
            return "Есть в наличии";
        return "Забронирована";
    }

    public Car(@NotNull Client client,
               @NotNull String brand,
               @NotNull String model,
               @NotNull String color)
    {
        this.owner = client;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public Car(
               @NotNull String brand,
               @NotNull String model,
               @NotNull String color,
               @NotNull Integer yearOfProduction,
               @NotNull Integer mileAge,
               @NotNull String description,
               @NotNull Integer price)
    {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.yearOfProduction = yearOfProduction;
        this.price = price;
        this.mileAge = mileAge;
        this.description = description;
    }

    private Car(){}

    /**
     * Методы для показа анкеты автомобиля, пользователю при просмотре своих авто не требуется много информации
     */

    @Override
    public String toString() {
        return "| ID: " + ID +
                " | Производитель: " + brand +
                " | Модель: " + model + " | ";
    }

    public String getForm() {
        return "| ID: " + ID +
                " | Производитель: " + brand +
                " | Модель: " + model +
                " | Цвет: " + color +
                " | Пробег: " + mileAge +
                " | price: " + price +
                " | " + getBookText() +
                "\n Описание: " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return ID == car.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ID);
    }
}
