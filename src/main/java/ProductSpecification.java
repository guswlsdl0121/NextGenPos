// Class ProductSpecification
public class ProductSpecification {
    private final ItemID id;
    private final Money price;
    private final String description;

    public ProductSpecification( ItemID id, Money price, String description ) {
        this.id = id;
        this.price = price;
        this.description = description;
    }

    public ItemID getltemlD()  {  return id;  }

    public Money getPrice() {  return price;  }

    public String getDescription() {   return description;   }

    @Override
    public String toString(){
        return description + " " +price.toString();
    }
}