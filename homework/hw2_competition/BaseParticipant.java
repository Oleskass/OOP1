package homework.hw2_competition;

public abstract class BaseParticipant implements Participant {

    private final String name;
    private final int jump;
    private final int run;
    private final int swim;
    private final int hit;

    public BaseParticipant(String name, int jump, int run, int swim, int hit) {
        this.name = name;
        this.jump = jump;
        this.run = run;
        this.swim = swim;
        this.hit = hit;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getJump() {
        return jump;
    }

    @Override
    public int getRun() {
        return run;
    }

    @Override
    public int getSwim() {
        return swim;
    }

    @Override
    public int getHitTarget() {
        return hit;
    }

}
