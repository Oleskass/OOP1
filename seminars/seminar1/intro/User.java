package seminars.seminar1.intro;

public class User {
    private String username;

    public void rename(String newUsername) {
        if (newUsername != null && !newUsername.isBlank()) {
            username = newUsername.trim();
        }
    }

    @Override
    public String toString() {
        return username;
    }
}
