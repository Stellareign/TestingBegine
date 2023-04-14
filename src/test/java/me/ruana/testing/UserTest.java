package me.ruana.testing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {
    String login = "vupsen";
    String invalidLogin = "pupsen@luntic.ru";
    String invalidEmail = "pupsen.luntic@ru";
    String correctEmail = "pupsen@luntic.ru";
    String noDogEmail = "pupsen/luntic.ru";

    @Test // неправильный е-мэйл
    public void shouldCheckEmailForCorrect() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            User user = new User(login, invalidEmail);
        });
    }

    @Test // ов е-мэйл нет собаки
    public void shouldCheckEmailForDog() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            User user = new User(login, noDogEmail);
        });
    }

    @Test // мыло и логин равны
    public void shouldCheckEmailAndLoginEquals() {
        Assertions.assertArrayEquals(invalidLogin.toCharArray(), correctEmail.toCharArray());
    }

    @Test // правильные данные
    public void shouldCheckEmailAndLoginNotEquals() {
        Assertions.assertNotEquals(login.toCharArray(), correctEmail.toCharArray());
    }

    @Test // логин равен мылу - исключение
    public void shouldCheckEmailEqualsLogin() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            User user = new User(invalidLogin, correctEmail);
        });
    }

    @Test // логин не заполнен
    public void shouldCheckLoginIsEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            User user = new User("", correctEmail);
        });
    }

    @Test // мыло не заполнено
    public void shouldCheckEmailIsEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            User user = new User(login, "");
        });
    }

    @Test // логин и мыло не заполнены
    public void shouldCheckEmailAndLoginIsEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            User user = new User("", "");
        });
    }

    @Test // верные данные, нет исключения
    public void shouldCorrectLoginAndEmail() {
        User user = new User(login, correctEmail);
        Assertions.assertDoesNotThrow(() -> user);
    }

}