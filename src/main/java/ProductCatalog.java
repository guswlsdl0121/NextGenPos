import java.util.HashMap;
import java.util.Map;

// Class ProductCatalog
public class ProductCatalog {
    private final Map<ItemID, ProductSpecification> productSpecifications = new HashMap<>();

    public ProductCatalog() {
    //sample data
        ItemID idl = new ItemID("1");
        ItemID id2 = new ItemID("2");
        ItemID id3 = new ItemID("3");

        ProductSpecification ps;
        ps = new ProductSpecification(idl, new Money(500), "아이셔");
        productSpecifications.put(idl, ps);
        ps = new ProductSpecification(id2, new Money(800), "차카니");
        productSpecifications.put(id2, ps);
        ps = new ProductSpecification(id3, new Money(1000), "감자알칩");
        productSpecifications.put(id3, ps);
    }

    public ProductSpecification getSpecification(ItemID id) {
        return productSpecifications.get(id);
    }
}