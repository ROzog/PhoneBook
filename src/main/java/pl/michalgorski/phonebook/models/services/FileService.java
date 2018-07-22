package pl.michalgorski.phonebook.models.services;

import pl.michalgorski.phonebook.models.ConfigModel;
import pl.michalgorski.phonebook.models.NumberModel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public void addNumberToFile(NumberModel numberModel) throws IOException {
        File file = new File(ConfigModel.PATH_TO_FILE);

        String numberModelAsString = numberModel.getNumber() + ConfigModel.IN_FILE_SEPARATOR +
                numberModel.getName() + ConfigModel.IN_FILE_SEPARATOR +
                numberModel.getSurname() + "\r\n";

        Files.write(file.toPath(), numberModelAsString.getBytes(), StandardOpenOption.APPEND);
    }

    public List<NumberModel> readAllNumber() throws IOException {
        File file = new File(ConfigModel.PATH_TO_FILE);

        List<String> listOfString = Files.readAllLines(file.toPath());
        List<NumberModel> numbers = new ArrayList<>();
        for(String s : listOfString) {
            String[] simpleData = s.split(ConfigModel.IN_FILE_SEPARATOR);
            numbers.add(new NumberModel(simpleData[0], simpleData[1], simpleData[2]));
        }
        return numbers;
    }


}
