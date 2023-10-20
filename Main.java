public class Main {
    public static void main(String[] args) {

        Fighter a = new Fighter("Fighter A", 50);
        Fighter b = new Fighter("Fighter B", 50);

        attack(a, b);

        String result = winnerOrEven(a, b);
        System.out.println(result);
    }

    // Slagsmålet
    public static void attack(Fighter a, Fighter b) {
        do {
            try {
                // A attackerar B
                int attackA = (int) (Math.random() * 15 + 1);
                b.setHp(b.getHp() - attackA);
                System.out.printf("%s attackerade %s med %d hp\n", a.getName(), b.getName(), attackA);
                Thread.sleep(800); // Skapa fördröjning mellan attackerna
                // B attackerar A
                int attackB = (int) (Math.random() * 15 + 1);
                a.setHp(a.getHp() - attackB);
                System.out.printf("%s attackerade %s med %d hp\n", b.getName(), a.getName(), attackB);
                Thread.sleep(800);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (a.getHp() > 0 && b.getHp() > 0); // Slåss så länge hälsan ligger över 0
    }
    
    // Vinnare eller oavgjort
    public static String winnerOrEven(Fighter a, Fighter b) {
        if (a.getHp() <= 0 && b.getHp() <= 0) {
            return "Det blev lika";
        } else if (a.getHp() <= 0) {
            return "%s vinner!".formatted(b.getName());
        }
        return "%s vinner!".formatted(a.getName());
    }
}
