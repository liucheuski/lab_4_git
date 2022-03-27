package by.iba.lab_4_git;

import by.iba.lab_4_git.entity.Office;
import by.iba.lab_4_git.entity.Student;
import by.iba.lab_4_git.service.OfficeService;
import by.iba.lab_4_git.service.StudentAction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Scanner;

@SpringBootApplication
public class Lab4GitApplication {

    StudentAction action = new StudentAction();
    OfficeService officeService = new OfficeService();

    public static void main(String[] args) {
        String DbOperation = "EXIT(0), ADD_STUDENT(1), UPDATE_STUDENT(2), DELETE_STUDENT(3), FETCHBY_STUDENTID(4), FETCH_STUDENTBYEMAIL(5), FETCH_STUDENTBYMOBNO(6), FETCH_STUDENTBYNAME(7),"
                + "FETCH_STUDENTBYCITY(8), " + "\n" + "FETCH_STUDENTBYSALRANGE(9), FETCH_STUDENTBYDOB(10), FETCH_STUDENTBYDOJRANGE(11), FETCHALL_STUDENT(12), "
                + "ADD_OFFICE(13), UPDATE_OFFICE(14), DELETE_OFFICE(15), FINDBYOFFICEID(16)";
        Lab4GitApplication mainclass = new Lab4GitApplication();
        int value;
        do {
            System.out.println("valid operations are");
            System.out.println(DbOperation);
            System.out.println("Enter valid operation number 0-16");
            Scanner scanner = new Scanner(System.in);
            value = scanner.nextInt();
            switch (value) {
                case 1:
                    mainclass.addStudent();
                    break;
                case 2:
                    mainclass.updateStudent();
                    break;
                case 3:
                    mainclass.deleteStudent();
                    break;
                case 4:
                    mainclass.fetchStudentById();
                    break;
                case 5:
                    mainclass.fetchStudentByEmail();
                    break;
                case 6:
                    mainclass.fetchStudentByMobileNo();
                    break;
                case 7:
                    mainclass.fetchStudentByName();
                    break;
                case 8:
                    mainclass.fetchStudentByCity();
                    break;
                case 9:
                    mainclass.fetchStudentBySalaryRange();
                    break;
                case 10:
                    mainclass.fetchStudentByDob();
                    break;
                case 11:
                    mainclass.fetchStudentByDOjRange();
                    break;
                case 12:
                    mainclass.fetchAllStudent();
                    break;
                case 13:
                    mainclass.addOffice();
                    break;
                case 14:
                    mainclass.updateOffice();
                    break;
                case 15:
                    mainclass.deleteOffice();
                    break;
                case 16:
                    mainclass.findByOfficeId();
                    break;
                case 0:
                    System.out.println("Exiting code");
                    break;
                default:
                    System.out.println("Not a valid entry");
            }
        } while (value != 0);
    }

    private Office findByOfficeId() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Office Id");
        int id = insert.nextInt();
        return officeService.findById(id);
    }

    private void deleteOffice() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Office Id");
        int id = insert.nextInt();
        officeService.delete(id);
    }

    private void updateOffice() {
        Office office = new Office();
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Office Id");
        office.setId(insert.nextInt());
        System.out.println("Enter office number");
        office.setNumber(insert.nextInt());
        System.out.println("Enter office name");
        office.setName(insert.next());
        System.out.println("Enter office address");
        office.setAddress(insert.next());
        System.out.println("Enter office post code");
        office.setPostCode(insert.next());
        System.out.println("Enter office phone number");
        office.setPhoneNumber(insert.next());
        officeService.update(office);
    }

    private void addOffice() {
        Office office = new Office();
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter office number");
        office.setNumber(insert.nextInt());
        System.out.println("Enter office name");
        office.setName(insert.next());
        System.out.println("Enter office address");
        office.setAddress(insert.next());
        System.out.println("Enter office post code");
        office.setPostCode(insert.next());
        System.out.println("Enter office phone number");
        office.setPhoneNumber(insert.next());
        officeService.insert(office);
    }

    public void addStudent() {
        Student student = new Student();
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter First Name");
        student.setFname(insert.next());
        System.out.println("Enter Last Name");
        student.setLname(insert.next());
        System.out.println("Enter Address");
        student.setAddress(insert.next());
        System.out.println("Enter Mobile Number");
        student.setMobileNo(insert.next());
        System.out.println("Enter Mail Id");
        student.setMailId(insert.next());
        System.out.println("Enter City");
        student.setCity(insert.next());
        System.out.println("Enter Designation");
        student.setDesignation(insert.next());
        System.out.println("Enter Dob (yyyy-mm-dd)");
        student.setDob(Date.valueOf(insert.next()));
        System.out.println("Enter Doj  (yyyy-mm-dd)");
        student.setDoj(Date.valueOf(insert.next()));
        System.out.println("Enter Salary");
        student.setSalary(insert.nextBigDecimal());
        action.insert(student);
    }

    public void updateStudent() {
        Student student = new Student();
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Id");
        student.setId(insert.nextLong());
        System.out.println("Enter First Name");
        student.setFname(insert.next());
        System.out.println("Enter Last Name");
        student.setLname(insert.next());
        System.out.println("Enter Address");
        student.setAddress(insert.next());
        System.out.println("Enter Mobile Number");
        student.setMobileNo(insert.next());
        System.out.println("Enter Mail Id");
        student.setMailId(insert.next());
        System.out.println("Enter City");
        student.setCity(insert.next());
        System.out.println("Enter Designation");
        student.setDesignation(insert.next());
        System.out.println("Enter Dob (yyyy-mm-dd)");
        student.setDob(Date.valueOf(insert.next()));
        System.out.println("Enter Doj  (yyyy-mm-dd)");
        student.setDoj(Date.valueOf(insert.next()));
        System.out.println("Enter Salary");
        student.setSalary(insert.nextBigDecimal());
        action.update(student);
    }

    public void deleteStudent() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Id");
        long id = insert.nextLong();
        action.delete(id);
    }

    public void fetchStudentById() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Id");
        long id = insert.nextLong();
        action.fetchById(id);
    }

    public void fetchStudentByEmail() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Mail Id");
        String mailId = insert.next();
        action.fetchByEmailId(mailId);
    }

    public void fetchStudentByMobileNo() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Mobile Number");
        String mobileNo = insert.next();
        action.fetchByMobileNo(mobileNo);
    }

    public void fetchStudentByName() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Name");
        String name = insert.next();
        System.out.println("Enter Student Lname");
        String lName = insert.next();
        action.searchByName(name, lName);
    }

    public void fetchStudentByCity() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student City");
        String city = insert.next();
        action.fetchByCity(city);
    }

    public void fetchStudentBySalaryRange() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Salary Start Range");
        BigDecimal salaryRange1 = insert.nextBigDecimal();
        System.out.println("Enter Salary End Range");
        BigDecimal salaryRange2 = insert.nextBigDecimal();
        action.fetchBySalaryRange(salaryRange1, salaryRange2);
    }

    public void fetchStudentByDob() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Date of Birth (yyyy-mm-dd)");
        String dob = insert.next();
        action.fetchByDob(Date.valueOf(dob));
    }

    public void fetchStudentByDOjRange() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Start Date of Joining (yyyy-mm-dd)");
        String dob1 = insert.next();
        System.out.println("Enter End Date of Joining (yyyy-mm-dd)");
        String dob2 = insert.next();
        action.fetchByRangeDoj(Date.valueOf(dob1), Date.valueOf(dob2));
    }

    public void fetchAllStudent() {
        action.fetchAll();
        System.out.println("Some changes " +
                "" +
                "4");
    }

}
