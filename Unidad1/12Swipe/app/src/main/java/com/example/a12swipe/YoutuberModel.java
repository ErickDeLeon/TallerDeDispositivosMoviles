package com.example.a12swipe;

import java.io.Serializable;

public class YoutuberModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String emailId;
    private String carrera;

    public YoutuberModel() {
    }

    public YoutuberModel(String name, String emailId, String carrera) {
        this.name = name;
        this.emailId = emailId;
        this.carrera = carrera;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
