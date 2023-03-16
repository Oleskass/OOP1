package seminars.seminar6.di;

public class DependencyInversionPrinciple {

    public static void main(String[] args) {
        // priceCalculator -> ndsResolver
        // priceCalculator -> ndsResolver <- cbNdsresolver

        NdsResolver ndsResolver = new CBHttpNdsResolver();
        PriceWithNdsCalculator priceWithNdsCalculator = new PriceWithNdsCalculator(ndsResolver);

        System.out.println(priceWithNdsCalculator.calculate(100.0));
    }

    static class PriceWithNdsCalculator {

        private NdsResolver ndsResolver;

        public PriceWithNdsCalculator(NdsResolver ndsResolver) {
            this.ndsResolver = ndsResolver;
        }

        public double calculate(double initialPrice) {
            return initialPrice * ndsResolver.getNds();
        }
    }

    interface NdsResolver {
        double getNds();
    }

    static class StaticNdsResolver implements NdsResolver {
        @Override
        public double getNds() {
            return 1.2;
        }
    }

    static class CBHttpNdsResolver implements NdsResolver{
        @Override
        public double getNds() {
            // представьте, что по HTTP вызыватеся цетробанк и загружается какое-то значение
            return 1.3;
        }
    }

}
