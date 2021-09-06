package com.example.studentManagement;


import javax.persistence.*;

@Entity
public class StudentMarks {

    @Id
    private int id;

    private int telugu;

    private int hindi;

    private int english;

    private int maths;

    private int total;


    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}

    public int getTelugu() {return telugu;}

    public void setTelugu(int telugu) {this.telugu = telugu;}

    public int getHindi() {return hindi;}

    public void setHindi(int hindi) {this.hindi = hindi;}

    public int getEnglish() {return english;}

    public void setEnglish(int english) {this.english = english;}

    public int getMaths() {return maths;}

    public void setMaths(int maths) {this.maths = maths;}

    public int getTotal() {return total;}

    public void setTotal() {this.total = telugu+hindi+english+maths;}

}
