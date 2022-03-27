package by.iba.lab_4_git.model;

import by.iba.lab_4_git.annatation.ExcludeField;
import com.google.gson.annotations.Expose;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
public class Staff {
    private String name;
    @ExcludeField
    private int age;
    private transient String lastName;
    @Expose(serialize = true, deserialize = true)
    private String[] position;
    private List<String> skills;
    private Map<String, BigDecimal> salary;
}
