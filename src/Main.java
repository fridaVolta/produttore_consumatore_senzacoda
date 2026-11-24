public class Main {
    public static void main(String[] args) {
        RisorsaCondivisa risorsa = new RisorsaCondivisa();

        Consumatore consumatore1 = new Consumatore("C1",risorsa);
        Consumatore consumatore2 = new Consumatore("C2",risorsa);
        Produttore produttore1 = new Produttore("P1",risorsa, 41);
        Produttore produttore2 = new Produttore("P2",risorsa, 32);
        consumatore1.start();
        consumatore2.start();
        produttore1.start();
        produttore2.start();
    }
}