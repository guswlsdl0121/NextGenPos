// Class SalesLineltem
public class SalesLineltem {
    private final int quantity;
    private final ProductSpecification productSpec;

    public SalesLineltem(ProductSpecification spec, int quantity) {
        this.productSpec = spec;
        this.quantity = quantity;
    }

    public Money getSubtotal() {   return productSpec.getPrice().times(quantity);  }

    @Override
    public String toString(){
        return productSpec.toString() + " (" +quantity +"개)" + " - 합계: "  + getSubtotal() + "\n";
    }
}