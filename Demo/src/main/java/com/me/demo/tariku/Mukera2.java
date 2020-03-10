package com.me.demo.tariku;

public class Mukera2 {

    int count = 0;
    void A() throws Exception{
        try{
            count++;
            try{
                count++;
                try{
                    count++;
                    throw  new Exception();

                }catch(Exception e){
                    count++;
                    throw  new Exception();
                }
            }catch(Exception e){
                count++;
            }

        }catch(Exception e){
            count++;
        }
    }

    void  display(){
        System.out.println(count);
    }

    public static void main(String[] args) throws Exception {
        Mukera2 o = new Mukera2();
        o.A();
        o.display();
    }
}
