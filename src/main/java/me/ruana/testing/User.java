package me.ruana.testing;

public class User {
    private String login;
    private String eMail;

    public User() {
    }


    public User(String login, String eMail) throws IllegalArgumentException {
        //   if (login == null && eMail != null && !login.isBlank() && !eMail.isBlank()) {
        this.login = login;
        if (login.isEmpty() || login.isBlank() || login == null) {
            throw new IllegalArgumentException("Заполните поле login!");
        }
        this.eMail = eMail;
        if (eMail == null || eMail.isBlank() || eMail.isEmpty()) {
            throw new IllegalArgumentException("Заполните поле e-mail!");
        }
        if (login.equals(eMail)) {
            throw new IllegalArgumentException("Логин не может совпадать с e-mail!");
        }
        if (!eMail.contains("@") || !eMail.contains(".") || (eMail.indexOf("@") > eMail.lastIndexOf("."))) {
            throw new IllegalArgumentException("Проверьте правильность введённого адреса");
        }
        if ((login.isEmpty() || login.isBlank()) && (eMail.isBlank() || eMail.isEmpty())) {
            throw new IllegalArgumentException("Укажите логин и е-мэйл!");
        }
    }


    public String getLogin() {
        return login;
    }

    public String getEMail() {
        return eMail;
    }

    private boolean validateEmail() throws IllegalArgumentException {

        if (eMail.contains("@") && eMail.contains(".")) {
            if (eMail.indexOf("@") < eMail.lastIndexOf(".")) {
                return true;
            } else throw new IllegalArgumentException("Проверьте правильность введённого адреса");
        }
        throw new IllegalArgumentException("Проверьте правильность введённого адреса");
    }
}

