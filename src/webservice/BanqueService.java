package webservice;

import metier.Compte;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Cette classe appelé POJO */
@WebService(serviceName = "BanqueWS")  //nommer web service
public class BanqueService {
    @WebMethod(operationName = "ConversionEurotoDH")  //nommer la méthode
    public double conversion(@WebParam(name = "montant") double mt) {
        return mt * 10.6;
    }

    @WebMethod
    public Compte getCompte(@WebParam(name = "code") Long code) {
        return new Compte(code, Math.random(), new Date());
    }

    @WebMethod
    public List<Compte> listComptes() {
        List<Compte> comptes = new ArrayList<>();
        comptes.add(new Compte(1L, Math.random() * 90000, new Date()));
        comptes.add(new Compte(2L, Math.random() * 90000, new Date()));
        comptes.add(new Compte(3L, Math.random() * 90000, new Date()));
        return comptes;
    }
}
