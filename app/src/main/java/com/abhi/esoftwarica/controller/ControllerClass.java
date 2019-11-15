package com.abhi.esoftwarica.controller;

import com.abhi.esoftwarica.model.UserData;

public class ControllerClass {
    public boolean CheckUser(UserData sd) {
        if ((sd.getName().equals("abhishek")) && (sd.getPassword().equals("abhi"))) {
            return true;

        } else {
            return false;
        }
    }
}
