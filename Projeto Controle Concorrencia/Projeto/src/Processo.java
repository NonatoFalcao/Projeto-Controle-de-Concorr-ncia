public class Processo extends Thread {
    public int id;
    public CoordenadorInterface coordenador;

    /*
     * referencias:
     * https://www.javatpoint.com/RMI
     * https://www.vogella.com/tutorials/JavaConcurrency/article.html
     */

    public Processo(int id, CoordenadorInterface coordenador) {
        this.id = id;
        this.coordenador = coordenador;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000); // simulo o trabalho
                coordenador.requisitarEntrada(id); 
                Thread.sleep(500); // simula o tempo na seção crítica
                coordenador.liberarRecurso(id); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
