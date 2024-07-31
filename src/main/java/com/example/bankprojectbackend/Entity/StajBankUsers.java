package com.example.bankprojectbackend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="STAJBANKNEW")
public class StajBankUsers {
    @Id
    @Column(name="MUSTERIHESAPNO")
    private Long musteriHesapno;

    @Column(name="MUSTERINAME")
    private String musteriName;

    @Column(name="MUSTERISURNAME")
    private String musteriSurname;

    @Column(name="MUSTERIBAKIYE")
    private int musteriBakiye;

    @Column(name="MUSTERIAGE")
    private int musteriAge;

    @Column(name="MUSTERITCNO")
    private long musteriTCNo;


    public StajBankUsers(Long musteriHesapno, String musteriName, String musteriSurname, int musteriBakiye, int musteriAge, long musteriTCNo) {
        this.musteriHesapno = musteriHesapno;
        this.musteriName = musteriName;
        this.musteriSurname = musteriSurname;
        this.musteriBakiye = musteriBakiye;
        this.musteriAge = musteriAge;
        this.musteriTCNo = musteriTCNo;
    }

    public StajBankUsers() {

    }

    public Long getMusteriHesapno() {
        return musteriHesapno;
    }

    public void setMusteriHesapno(Long musteriHesapno) {
        this.musteriHesapno = musteriHesapno;
    }

    public String getMusteriName() {
        return musteriName;
    }

    public void setMusteriName(String musteriName) {
        this.musteriName = musteriName;
    }

    public String getMusteriSurname() {
        return musteriSurname;
    }

    public void setMusteriSurname(String musteriSurname) {
        this.musteriSurname = musteriSurname;
    }

    public int getMusteriBakiye() {
        return musteriBakiye;
    }

    public void setMusteriBakiye(int musteriBakiye) {
        this.musteriBakiye = musteriBakiye;
    }

    public int getMusteriAge() {
        return musteriAge;
    }

    public void setMusteriAge(int musteriAge) {
        this.musteriAge = musteriAge;
    }

    public long getMusteriTCNo() {
        return musteriTCNo;
    }

    public void setMusteriTCNo(long musteriTCNo) {
        this.musteriTCNo = musteriTCNo;
    }

    public StajBankUsers(Long musteriHesapno) {
        this.musteriHesapno = musteriHesapno;
    }
}
