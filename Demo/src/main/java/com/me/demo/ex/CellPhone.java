package com.me.demo.ex;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public abstract class CellPhone{

    private double price;
    private LocalDate manufacturingDate;
    private String model;

    public CellPhone(double price, LocalDate manufacturingDate, String model) {
        this.price = price;
        this.manufacturingDate = manufacturingDate;
        this.model = model;
    }

    public CellPhone() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public abstract boolean isCurrent();
}

class Samsung extends CellPhone{
    public boolean isCurrent(){
        return !getManufacturingDate().isBefore(LocalDate.now().minusYears(5));
    }
}

class IPhone extends CellPhone{
    public boolean isCurrent(){
        return !getManufacturingDate().isBefore(LocalDate.now().minusYears(2));
    }
}

class Main4{
    public static void main(String[] args){

        //new CellPhone();
        CellPhone samsung = new Samsung();
        samsung.setPrice(3.4);
        boolean sumsungCurrent = samsung.isCurrent();

        CellPhone iphone = new IPhone();
        iphone.setPrice(4.5);
        boolean iphoneCurrent = iphone.isCurrent();

        List<CellPhone> cellphones = new ArrayList();
        cellphones.add(samsung); //cellphones[0]=samsung; for an array of cellphones
        cellphones.add(iphone);


        List<Samsung> samsungList = new ArrayList();
        //samsungList.add(samsung);

        List<IPhone> iphoneList = new ArrayList();
        //iphoneList.add(iphone);
    }
}

