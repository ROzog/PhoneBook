package pl.michalgorski.phonebook.views;

import pl.michalgorski.phonebook.models.NumberModel;

import java.util.List;

public class MainView {

    public void showWelcomeMessege() {
        System.out.println("Witaj w książce telefonicznej!");
    }
    public void showMenu() {
        System.out.println("Wybierz opcję: ");
        System.out.println("1 - Dodaj numer:");
        System.out.println("2 - Wyświetl wszytskie numery:");
        System.out.println("3 - Wyjście!");
    }
    public void showComandNotExist() {
        System.out.println("Taki wybór nie istnieje!");
    }
    public void showNumberRequest(String format) {
        System.out.println("Podaj numer w formacie: " + format);
    }
    public void showNameRequest() {
        System.out.println("Podaj imie: ");
    }
    public void showSurnameRequest() {
        System.out.println("Podaj nazwisko: ");
    }
    public void showAddedInformation() {
        System.out.println("Dodałeś numer do książki telefonicznej!");
    }
    public void showNameOfPhoneBook() {
        System.out.println("Spis numerów książki telefonicznej: ");
        System.out.println("------------------------------------");
    }
    public void showAllPhoneNumbers(List<NumberModel> numbers) {

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(i+1 + ". " + numbers.get(i).getNumber() + " " + numbers.get(i).getName() + " " +
            numbers.get(i).getSurname());
        }
        System.out.println("------------------------------------");
    }
    public void showInfoUsedNumber() {
        System.out.println("Ten numer już jest w książce!");
    }
    public void showNumberNotCorrectInfo() {
        System.out.println("Numer nie został poprawnie wpisany!");
    }
    public void showNameNotCorrectInfo() {
        System.out.println("Imie nie zostało poprawnie wpisany!");
    }
    public void showSurnameNotCorrectInfo() {
        System.out.println("Nazwisko nie zostało poprawnie wpisane!");
    }

}



