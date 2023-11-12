package task1;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberChecker {
    public void phoneNumberValidator() throws IOException {
        File file = new File("file.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        String line = reader.readLine();

        while (line != null) {
            Pattern pattern = Pattern.compile("([0-9]{3}-[0-9]{3}-[0-9]{4})|(\\([0-9]{3}\\)\\s[0-9]{3}-[0-9]{4})");
            Matcher matcher = pattern.matcher(line);
            boolean matchFound = matcher.find();

            if (matchFound) {
                System.out.println(line);
            }
            line = reader.readLine();
        }
        reader.close();
    }

    public static void main(String[] args) throws IOException {
        PhoneNumberChecker pnc = new PhoneNumberChecker();
        pnc.phoneNumberValidator();
    }
}
