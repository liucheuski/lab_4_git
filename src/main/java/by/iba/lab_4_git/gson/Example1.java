package by.iba.lab_4_git.gson;

import by.iba.lab_4_git.model.Staff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example1 {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithModifiers(Modifier.STATIC, Modifier.TRANSIENT)
                //.excludeFieldsWithoutExposeAnnotation()
                .setExclusionStrategies(
                        new CustomExclusionStrategy(CustomExclusionStrategy.class))
                .create();
        Staff staff1 = createStaffObject("Oleg", 35);
        Staff staff2 = createStaffObject("Pavel", 40);
        List<Staff> staff = List.of(staff1, staff2);
        try (
                FileWriter writer = new FileWriter("json/student.json")) {
            gson.toJson(staff, writer);
            System.out.println(staff);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static Staff createStaffObject(String name, int age) {
        Staff staff = new Staff();
        staff.setName(name);
        staff.setLastName("SomeSureName");
        staff.setAge(age);
        staff.setPosition(new String[]{"Founder", "SEO", "coder"});
        Map<String, BigDecimal> salary = new HashMap() {{
            put("2010", new BigDecimal(10000));
            put("2012", new BigDecimal(12000));
            put("2018", new BigDecimal(14000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "python", "node", "kotlin"));
        return staff;
    }

}