package pl.michalgorski.phonebook.models;

import java.util.Objects;

public class NumberModel {
    private String number;
    private String name;
    private String surname;

    public NumberModel(String number, String name, String surname) {
        this.number = number;
        this.name = name;
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberModel that = (NumberModel) o;
        return Objects.equals(number, that.number) &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(number, name, surname);
    }

    @Override
    public String toString() {
        return "NumberModel{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}


