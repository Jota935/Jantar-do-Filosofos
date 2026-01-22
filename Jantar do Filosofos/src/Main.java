import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int n = 5; // número de filósofos (pode mudar livremente)

        Semaphore[] garfos = new Semaphore[n];
        Semaphore mesa = new Semaphore(n - 1);

        for (int i = 0; i < n; i++) {
            garfos[i] = new Semaphore(1);
        }

        Filosofos[] filosofos = new Filosofos[n];

        for (int i = 0; i < n; i++) {
            Semaphore esquerdo = garfos[i];
            Semaphore direito = garfos[(i + 1) % n];

            filosofos[i] = new Filosofos(i + 1, esquerdo, direito, mesa);
            filosofos[i].start();
        }
    }
}