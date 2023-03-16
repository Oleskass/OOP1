package seminars.seminar6.s;

public class SolidMain {

    public static void main(String[] args) {
        User user = new User() {
            @Override
            public void save() {

            }

            @Override
            public void delete() {

            }
        };


        User persistenceUser = new PersistenceUser(user);
        persistenceUser.save();
    }

}
