package com.example.web.model;

public class UpdatePass {
    String oldPass;
    String confirmPass;
    String newPass;
    public UpdatePass() {
    }

    public UpdatePass(String oldPass, String confirmPass, String newPass) {
        this.oldPass = oldPass;
        this.confirmPass = confirmPass;
        this.newPass = newPass;
    }

    public UpdatePass(String password) {
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }
}
