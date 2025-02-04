package com.ohgiraffers.section02.superkeyword;

import java.util.Date;

public class Computer extends Product {
    private String cpu;
    private int hdd;
    private int ram;
    private String operatingSystem;

    public Computer() {
        //super();
    }

    public Computer(String cpu, int hdd, int ram, String operatingSystem) {
        //super();
        this.cpu = cpu;
        this.hdd = hdd;
        this.ram = ram;
        this.operatingSystem = operatingSystem;
    }

    // 자식 생성자 생성시 부모 생성자 경우 또한  선택 가능
    public Computer(String code, String brand, String name, int price, Date manufactureDate) {
        super(code, brand, name, price, manufactureDate);   // 부모 필드까지 초기화 가능
    }

    public Computer(String code, String brand, String name, int price, Date manufactureDate, String cpu, int hdd, int ram, String operatingSystem) {
        super(code, brand, name, price, manufactureDate);   // 부모 필드까지 초기화 가능
        this.cpu = cpu;
        this.hdd = hdd;
        this.ram = ram;
        this.operatingSystem = operatingSystem;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
//        return "Computer{" +
//                "cpu='" + cpu + '\'' +
//                ", hdd=" + hdd +
//                ", ram=" + ram +
//                ", operatingSystem='" + operatingSystem + '\'' +
//                "} " + super.toString();
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", hdd=" + hdd +
                ", ram=" + ram +
                ", operatingSystem='" + operatingSystem + '\'' + " " +
                super.getCode() + ", " + super.getBrand() + ", " +
                super.getName() + ", " + super.getPrice() +
                "}";
    }
}
