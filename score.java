public class score {
    private static double miningStrength = 1;
    private static double points = 0;
    private static double minerStrength = 0.1;
    private static double price = 1;
    private static double minerPrice = 1;
    private static double minerToolPrice = 1;
    private static double modifier = 0.5;
    private static double increaseBy = 0.1;
    private static int numOfMiners = 0;

    public static double getPoints() {
        return points;
    }

    public static double getStrength() {
        return miningStrength;
    }

    public static double getIncreaseBy() {
        return increaseBy;
    }

    public static int getNumOfMiners() {
        return numOfMiners;
    }

    public static void changeMod(double d) {
        modifier += d + increaseBy;
    }

    public static void changePoints(double p) {
        points += p;
    }

    public static void changePrice(double modify) { // to be done for both miner tools and player tools
        price = price + (price * modify);
    }

    public static void changeStrength(double d) {
        miningStrength += d;
    }

    public static double getPlayerPrice() { // for player tools
        return price;
    }

    public static double getMinerPrice() { // when buying miners
        return minerPrice;
    }

    public static double getMod() {
        return modifier;
    }

    public static double getMinerToolPrice() {
        return minerToolPrice;
    }

    public static double getMinerStrength() {
        return minerStrength;
    }

    public static void changeMinerStrength(double r) {
        minerStrength += r;
    }

    public static void addMiners() {
        numOfMiners++;
    }

    public static void MinersMining() {
        points += numOfMiners * minerStrength;
    }

    public static void setter(double strength, double pts, double minerR8, double perice, double minerPerice,
            double minerTlPrice, double mod, double increase, int numMiners) { // for when loading the values
        miningStrength = strength;
        points = pts;
        minerStrength = minerR8;
        price = perice;
        minerPrice = minerPerice;
        minerToolPrice = minerTlPrice;
        modifier = mod;
        increaseBy = increase;
        numOfMiners = numMiners;
    }

}
