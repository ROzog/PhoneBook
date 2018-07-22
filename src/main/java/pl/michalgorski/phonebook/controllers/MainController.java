package pl.michalgorski.phonebook.controllers;

import pl.michalgorski.phonebook.models.ConfigModel;
import pl.michalgorski.phonebook.models.NumberModel;
import pl.michalgorski.phonebook.models.services.NumberService;
import pl.michalgorski.phonebook.views.MainView;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainController {
    private MainView mainView;
    private Scanner scanner;
    private NumberService numberService;

    public MainController() {
        mainView = new MainView();
        scanner = new Scanner(System.in);
        numberService = new NumberService();
    }

    public void start() {
        mainView.showWelcomeMessege();

        createMenu();
    }

    private void createMenu() {
        String choose;

        do {
            mainView.showMenu();
            choose = scanner.nextLine();

            switch (choose) {
                case "1": {
                    addNumber();
                    break;
                }
                case "2": {
                    getAllNumberText();
                    break;
                }
                case "3": {
                    System.exit(0);
                }
                default: {
                    mainView.showComandNotExist();
                }
            }
        } while (!choose.equals("3"));
    }

    private void addNumber() {
        String number, name, surname;
        boolean isNumberExist = false;

        mainView.showNumberRequest(ConfigModel.NUMBER_FORMAT);
        number = scanner.nextLine();

        try {
            isNumberExist = numberService.isNumberExistInFile(number);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

        if (isNumberExist) {
            mainView.showInfoUsedNumber();
            createMenu();
        }

        if (!numberService.isNumberCorrect(number)) {
            mainView.showNumberNotCorrectInfo();
            createMenu();
        }

        mainView.showNameRequest();
        name = scanner.nextLine();

        if (!numberService.isNameCorrect(name)) {
            mainView.showNameNotCorrectInfo();
            createMenu();
        }

        mainView.showSurnameRequest();
        surname = scanner.nextLine();

        if (!numberService.isSurnameCorrect(surname)) {
            mainView.showSurnameNotCorrectInfo();
            createMenu();
        }

        NumberModel numberModel = new NumberModel(number, name, surname);

        try {
            numberService.addNumber(numberModel);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        mainView.showAddedInformation();
    }

    private List<NumberModel> getAllNumber() {

        List<NumberModel> numberModelList = null;
        mainView.showNameOfPhoneBook();

        try {
            numberModelList = numberService.getAllNumber();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return numberModelList;
    }

    private void getAllNumberText() {
        mainView.showAllPhoneNumbers(getAllNumber());
    }


}














