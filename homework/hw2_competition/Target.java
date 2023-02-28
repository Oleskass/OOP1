package homework.hw2_competition;

public class Target {
    private final int hits;

    public Target(int hits) {
        this.hits = hits;
    }

    public boolean pass(CanHitTarget canHitTarget) {
        return canHitTarget.getHitTarget() >= hits;
    }

}
