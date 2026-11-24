public class RisorsaCondivisa {
    private int dato;
    private boolean disponibile = false;

    // Metodo richiamato dal Thread Consumatore
    public synchronized int consuma(String nomeConsumatore) throws InterruptedException {
        while (!disponibile) {
            System.out.println("risorsa / dato non disponibile per "+nomeConsumatore);
            wait(); // Il thread corrente si mette in attesa sul monitor di questa risorsa
        }
        System.out.println("Consumato: " + dato + " da " + nomeConsumatore);
        disponibile = false;
        notifyAll(); // Risveglia i thread in attesa su questa risorsa
        return dato;
    }

    // Metodo richiamato dal Thread Produttore
    public synchronized void produci(String nomeProduttore, int nuovoDato) throws InterruptedException {
        while (disponibile) {
            System.out.println(nomeProduttore+" deve attendere: dato non ancora consumato");
            wait(); // Aspetta che il dato precedente venga consumato
        }
        this.dato = nuovoDato;
        System.out.println("Prodotto: " + dato + " da " + nomeProduttore);
        disponibile = true;
        notifyAll(); // Risveglia il consumatore
    }
}