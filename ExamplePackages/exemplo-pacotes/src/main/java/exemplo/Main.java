package exemplo;

import com.mastersoft.clinical.model.Cliente;
import com.mastersoft.clinical.model.Exame;
import com.mastersoft.clinical.service.ExameService;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Exame exame = new Exame();
        ExameService service = new ExameService();

        service.salvarExame(exame);
    }
}