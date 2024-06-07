import java.rmi.Remote;
import java.rmi.RemoteException;

// Interface remota
public interface CoordenadorInterface extends Remote {
    void requisitarEntrada(int idProcesso) throws RemoteException; 
    void liberarRecurso(int idProcesso) throws RemoteException; 
}
