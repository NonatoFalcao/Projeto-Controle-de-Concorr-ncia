import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * referencias:
 * https://www.geeksforgeeks.org/reentrant-lock-java/
 * https://www.geeksforgeeks.org/how-to-run-java-rmi-application/
 */
public class Coordenador extends UnicastRemoteObject implements CoordenadorInterface {
    //https://www.vogella.com/tutorials/JavaConcurrency/article.html
    
    public Lock lock = new ReentrantLock(); // lock que controla acesso a secao critica

    public Coordenador() throws RemoteException {
    }

    public void requisitarEntrada(int idProcesso) {
        lock.lock(); // adquiro o lock para entrar na seção crítica
        System.out.println("Processo " + idProcesso + " entrou na seção crítica.");
    }

    public void liberarRecurso(int idProcesso) {
        System.out.println("Processo " + idProcesso + " saiu da seção crítica.");
        lock.unlock(); // libera o lock para sair da seção crítica
    }
}
