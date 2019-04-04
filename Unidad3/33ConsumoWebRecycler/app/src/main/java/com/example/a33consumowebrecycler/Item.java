package com.example.a33consumowebrecycler;

public class Item {

    private String Name;
    private String Nctrl;
    private String u1;
    private String u2;
    private String u3;

//    public String getCalificacion() {
//        return calificacion;
//    }
//
//    public void setCalificacion(String calificacion) {
//        this.calificacion = calificacion;
//    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = Name;
    }

    public String getNoControl() {
        return Nctrl;
    }

    public void setNoControl(String noControl) {
        this.Nctrl = noControl;
    }

    public String getCel() {
        return u1;
    }

    public void setCel(String u1) {
        this.u1 = u1;
    }

    public String getCarrera() {
        return u2;
    }

    public void setCarrera(String u2) {
        this.u2 = u2;
    }


    public  String getU3(){
        return u3;
    }

    public void  setU3 (String u3){
        this.u3 = u3;
    }

    @Override
    public String toString(){
        return "ClassItem [nombre = "+Name+", noControl = "+Nctrl+"]";
    }
}
