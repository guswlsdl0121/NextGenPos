import java.io.Serializable;

public record ItemID(String id) implements Serializable {

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemID)) {
            return false;
        }
        return id.equals(((ItemID) obj).id());
    }

    @Override
    public int hashCode() {
        //can be replaced with more complex hashing operation
        return Integer.parseInt(id);
    }
}
