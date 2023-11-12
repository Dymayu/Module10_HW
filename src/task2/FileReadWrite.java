package task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReadWrite {
    private final List<User> userList = new ArrayList<>();
    public void readWriteFile() throws IOException {
        FileReader fileReader = new FileReader("file2.txt");
        // для зручності читання з файлу створюємо обєкт типу BufferedReader та передаємо inputStream reader - FileReader
        BufferedReader reader = new BufferedReader(fileReader);

        // зчитали перший рядок
        String line = reader.readLine();
        // читаємо починаючи з 2го рядка
        while((line = reader.readLine())!=null){
            String[] lineArr = line.split(" ");
             String name = lineArr[0];
             int age = Integer.parseInt(lineArr[1]);
             // створюємо обєкт типу User та присвоюємо полям значеннями name та age
            User user1 = new User(name, age);
            // добавляжмо в List створений обєкт
            userList.add(user1);
            // викликаємо метод запису в файл та передаємо туди обєкт List
            writeToJson(userList);
        }
        reader.close();

    }

    public void writeToJson(List<User> userList) throws IOException {
        // створюємо обєкт типа Gson для запису рядка в json з "красивим" форматуванням
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // для запису в файл створюємо обькти типу FileWriter (outputStream), вказуючи назву файлу куди записувати
        FileWriter writer = new FileWriter("user.json");
        // для запису в файл json використовуюм метод toJson що приймає рядок з ArrayList (List<User>) та обєкт FileWriter
        gson.toJson(userList,writer);
        // обовязково зактиваємо потік
        writer.close();

    }
}
