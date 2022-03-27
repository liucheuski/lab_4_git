package by.iba.lab_4_git.entity;

import java.util.Objects;

public class Office {

    private int id;
    private int number;
    private String name;
    private String address;
    private String postCode;
    private String phoneNumber;

    public Office() {
    }

    public Office(int id, int number, String name, String address, String postCode, String phoneNumber) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.address = address;
        this.postCode = postCode;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", postCode='" + postCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Office)) return false;
        Office office = (Office) o;
        return id == office.id && number == office.number && name.equals(office.name) && address.equals(office.address) && postCode.equals(office.postCode) && phoneNumber.equals(office.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, name, address, postCode, phoneNumber);
    }
}
