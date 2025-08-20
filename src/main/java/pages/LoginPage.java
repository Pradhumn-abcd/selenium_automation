package pages;

import common.SafeActions;

public class LoginPage extends SafeActions {

    String usernameField = "//input[@placeholder='Username']";
    String passwordField = "//input[@placeholder='Password']";
    String loginButton   = "//button[@type='submit']";

    public void login(String username, String password) throws Exception {
        safeType(usernameField, username);
        safeType(passwordField, password);
        safeClick(loginButton);
    }
}
