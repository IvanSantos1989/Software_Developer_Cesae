package GrandesNegocios.Controllers;

import GrandesNegocios.Models.Sale;
import GrandesNegocios.Repositories.SalesRepository;

import java.io.FileNotFoundException;

public class AdminController {

    private SalesRepository salesRepository;

    public AdminController() throws FileNotFoundException {
        this.salesRepository = new SalesRepository();
    }

    public double totalSalesValue() {

        double totalSalesValue = 0;

        for (Sale saleAtual : this.salesRepository.getSalesArray()) {
            totalSalesValue += saleAtual.getQuantidadeVendida() * saleAtual.getPrecoUnitario();
        }

        return totalSalesValue;
    }

}