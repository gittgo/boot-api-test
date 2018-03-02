package com.example.bootapitest.people.entity;


import javax.persistence.*;
import java.util.Date;

@Table(name = "people")
@Entity
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int peopleId;

    @Column
    private String peoplePhone;
    @Column
    private String peopleName;
    @Column
    private String peoplePassword;
    @Column
    private Date peopleDatetime;
    @Column
    private String peopleMail;
    @Column
    private int peopleState;
    @Column
    private String peopleCode;
    @Column
    private Date peopleCodesenddate;
    @Column
    private int peoplePhonecheck;
    @Column
    private int peopleMaillcheck;


    public int getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(int peopleId) {
        this.peopleId = peopleId;
    }

    public String getPeoplePhone() {
        return peoplePhone;
    }

    public void setPeoplePhone(String peoplePhone) {
        this.peoplePhone = peoplePhone;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public String getPeoplePassword() {
        return peoplePassword;
    }

    public void setPeoplePassword(String peoplePassword) {
        this.peoplePassword = peoplePassword;
    }

    public Date getPeopleDatetime() {
        return peopleDatetime;
    }

    public void setPeopleDatetime(Date peopleDatetime) {
        this.peopleDatetime = peopleDatetime;
    }

    public String getPeopleMail() {
        return peopleMail;
    }

    public void setPeopleMail(String peopleMail) {
        this.peopleMail = peopleMail;
    }

    public int getPeopleState() {
        return peopleState;
    }

    public void setPeopleState(int peopleState) {
        this.peopleState = peopleState;
    }

    public String getPeopleCode() {
        return peopleCode;
    }

    public void setPeopleCode(String peopleCode) {
        this.peopleCode = peopleCode;
    }

    public Date getPeopleCodesenddate() {
        return peopleCodesenddate;
    }

    public void setPeopleCodesenddate(Date peopleCodesenddate) {
        this.peopleCodesenddate = peopleCodesenddate;
    }

    public int getPeoplePhonecheck() {
        return peoplePhonecheck;
    }

    public void setPeoplePhonecheck(int peoplePhonecheck) {
        this.peoplePhonecheck = peoplePhonecheck;
    }

    public int getPeopleMaillcheck() {
        return peopleMaillcheck;
    }

    public void setPeopleMaillcheck(int peopleMaillcheck) {
        this.peopleMaillcheck = peopleMaillcheck;
    }
}
