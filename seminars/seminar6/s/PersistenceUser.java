package seminars.seminar6.s;

public class PersistenceUser extends User {

    private User decorate;

    public PersistenceUser(User decorate) {
        this.decorate = decorate;
    }

    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }
}
