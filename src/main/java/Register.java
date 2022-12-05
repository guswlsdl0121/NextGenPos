// Class Register
public class Register {
    private final ProductCatalog catalog;
    private Sale sale;

    public Register(ProductCatalog catalog) {  this.catalog = catalog; }

    public void endSale()  {   sale.becomeComplete(); }

    public void enterltem(ItemID id, int quantity) {
        ProductSpecification spec = catalog.getSpecification(id);
        sale.makeLineltem(spec, quantity);
    }

    public void makeNewSale() {   sale = new Sale();    }

    public void makePayment(Money cashTendered) {   sale.makePayment(cashTendered);  }
}