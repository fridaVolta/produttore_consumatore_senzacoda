public class Consumatore extends Thread {
    private RisorsaCondivisa risorsa;
    private String nome;

    public Consumatore(String nome, RisorsaCondivisa risorsa) {
        this.risorsa = risorsa;
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            // Il thread non sa nulla di wait() o notify()
            int valore = risorsa.consuma(nome);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}