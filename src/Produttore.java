public class Produttore extends Thread {
    private RisorsaCondivisa risorsa;
    private int valoreDaProdurre;
    private String nome;

    public Produttore(String nome, RisorsaCondivisa risorsa, int valoreDaProdurre) {
        this.risorsa = risorsa;
        this.valoreDaProdurre = valoreDaProdurre;
        this.nome = nome;
    }

    @Override
    public void run() {
        try {
            risorsa.produci(nome,valoreDaProdurre);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}