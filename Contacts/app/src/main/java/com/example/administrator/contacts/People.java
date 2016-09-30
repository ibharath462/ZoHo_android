package com.example.administrator.contacts;

/**
 * Created by Administrator on 9/30/2016.
 */

public class People {

    private String firstName,secondName,mobile,mail,image,home;

    People(String tfName,String tsname,String tM,String tMa,String tH,String tI){

        this.firstName=tfName;
        this.secondName=tsname;
        this.mobile=tM;
        this.mail=tMa;
        this.image=tI;
        this.home=tH;

    }

    public String getfName(){
        return firstName;
    }

    public String getSecondName(){
        return secondName;
    }


    public String getMobile(){
        return mobile;
    }

    public String getMail(){
        return  mail;
    }

    public String getImage(){
        return image;
    }

    public String getHome(){
        return home;
    }

}
