package by.iba.lab_4_git.service;


import by.iba.lab_4_git.dao.OfficeDao;
import by.iba.lab_4_git.entity.Office;

public class OfficeService {
    OfficeDao dao = new OfficeDao();
    int st;

    public void insert(Office office) {
        st = dao.insert(office);
        if (st == 1) {
            System.out.println("Office Inserted Successfully");
        } else if (st == -1) {
            System.out.println("Office Already exists");
        } else {
            System.out.println("Unable to Insert Office");
        }
    }

    public void update(Office office) {
        st = dao.update(office);
        if (st == 1) {
            System.out.println("Office Updated Successfully");
        } else {
            System.out.println("Unable to update Office");
        }
    }

    public void delete(int id) {
        st = dao.delete(id);
        if (st == 1) {
            System.out.println("Office Deleted Successfully");
        } else {
            System.out.println("No Record Found");
        }
    }

    public Office findById (int id) {
        Office office = dao.findById(id);
        if (office.getId() == 0) {
            System.out.println("No Record Found");
        } else {
            System.out.println("Office Details are :");
            System.out.println(office);
        }
        return office;
    }

}
