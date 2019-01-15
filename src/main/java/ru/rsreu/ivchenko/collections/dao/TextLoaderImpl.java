package ru.rsreu.ivchenko.collections.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextLoaderImpl implements TextLoader {

    public List<String> getText(String textSource) {
        List<String> sentencesList = new ArrayList<>();
        try {
            FileReader myFile = new FileReader(textSource);
            BufferedReader bufferedReader = new BufferedReader(myFile);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sentencesList.add(line);
            }
            bufferedReader.close();
            myFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sentencesList;
    }
}
