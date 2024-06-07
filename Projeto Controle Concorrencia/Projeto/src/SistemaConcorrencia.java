import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SistemaConcorrencia {
    public static void main(String[] args) {
        try {
            Coordenador coordenador = new Coordenador(); 
            Registry registry = LocateRegistry.createRegistry(1099); // cria o registro na porta 1099
            registry.bind("Coordenador", coordenador); 
            System.out.println("coordenador pronto e registrado no registry.");

            // crio e inicio os processos clientes
            for (int i = 0; i < 5; i++) {
                new Processo(i, coordenador).start(); // inicio cada processo cliente
            }
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.getMessage());
        }
    }
}
