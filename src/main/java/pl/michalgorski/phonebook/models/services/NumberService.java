package pl.michalgorski.phonebook.models.services;

import pl.michalgorski.phonebook.models.NumberModel;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

public class NumberService {
    private FileService fileService;

    public NumberService() {
        fileService = new FileService();
    }

    public void addNumber(NumberModel numberModel) throws IOException {
        fileService.addNumberToFile(numberModel);
    }

    public List<NumberModel> getAllNumber() throws IOException{
        return fileService.readAllNumber();
    }

    public boolean isNumberExistInFile(String number) throws IOException{
        List<NumberModel> numbers = fileService.readAllNumber();
        return numbers.stream().anyMatch(s -> s.getNumber().equals(number));
    }

    public boolean isNumberCorrect(String number) {
        return Pattern.matches("[0-9]{3}-[0-9]{3}-[0-9]{3}", number);
    }

    public boolean isNameCorrect(String name) {
        return Pattern.matches("[A-ZĄĆĘŁŃÓŚŻŹ][a-ząćęłńóśźż]{2,30}", name);
    }

    public boolean isSurnameCorrect(String surname) {
        return Pattern.matches("[A-ZĄĆĘŁŃÓŚŻŹ][a-ząćęłńóśźż]{2,30}", surname);
    }
}














