import java.util.concurrent.Semaphore;

public class Filosofos extends Thread {
    private int id;
    private Semaphore garfoEsquerdo;
    private Semaphore garfoDireito;
    private Semaphore mesa;

    public Filosofos(int id, Semaphore esquerdo, Semaphore direito, Semaphore mesa) {
        this.id = id;
        this.garfoEsquerdo = esquerdo;
        this.garfoDireito = direito;
        this.mesa = mesa;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filósofo " + id + " está pensando.");
        Thread.sleep((int)(Math.random() * 1000));
    }

    private void comer() throws InterruptedException {
        System.out.println("Filósofo " + id + " está comendo.");
        Thread.sleep((int)(Math.random() * 1000));
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();

                mesa.acquire(); // entra na mesa

                garfoEsquerdo.acquire();
                System.out.println("Filósofo " + id + " pegou o garfo esquerdo.");

                garfoDireito.acquire();
                System.out.println("Filósofo " + id + " pegou o garfo direito.");

                comer();

                garfoDireito.release();
                garfoEsquerdo.release();
                mesa.release(); // sai da mesa
            }
        } catch (InterruptedException e) {
            System.out.println("Filósofo " + id + " foi interrompido.");
        }
    }
}