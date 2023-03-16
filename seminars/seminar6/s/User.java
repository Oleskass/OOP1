package seminars.seminar6.s;

// POJO Plain Old Java Object
public abstract class User {

    private Long id;
    private String name;

    public abstract void save();

    public abstract void delete();

}
