package by.iba.lab_4_git.gson;

import by.iba.lab_3.model.Staff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Example2 {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        Type listOfStaff = new TypeToken<ArrayList<Staff>>() {}.getType();
        try (Reader reader = new FileReader("json/student.json")) {
            List<Staff> staff = gson.fromJson(reader, listOfStaff);
            System.out.println(staff);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
