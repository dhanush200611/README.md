package java_project_f116;
import java.util.*;
class WorkOrder {
    private static int counter = 1;
    private int id;
    private Product product;
    private int quantity;
    private String status;
    private Map<Product,Integer> reservedMaterials = new HashMap<>();
    private Map<Product,Integer> issuedMaterials = new HashMap<>();

    public WorkOrder(Product product, int quantity) {
        this.id = counter++;
        this.product = product;
        this.quantity = quantity;
        this.status = "NEW";
    }

    public int getId() { return id; }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public String getStatus() { return status; }

    public void reserveMaterials(BOM bom) {
        for (BOMItem item : bom.getItems()) {
            reservedMaterials.put(item.getComponent(),
                item.getQuantityPerUnit() * quantity);
        }
        status = "RESERVED";
    }

    public Map<Product,Integer> getReservedMaterials() { return reservedMaterials; }

    public void issueMaterials(Warehouse w) {
        if (!status.equals("RESERVED"))
            throw new IllegalStateException("WorkOrder must be RESERVED before issuing.");
        for (Map.Entry<Product,Integer> e : reservedMaterials.entrySet()) {
            w.removeStock(e.getKey(), e.getValue());
            issuedMaterials.put(e.getKey(), e.getValue());
        }
        status = "MATERIALS_ISSUED";
    }

    public void complete(Warehouse w) {
        if (!status.equals("MATERIALS_ISSUED"))
            throw new IllegalStateException("Materials must be issued first.");
        w.addStock(product, quantity);
        status = "COMPLETED";
    }

    @Override
    public String toString() {
        return "WorkOrder #" + id + " [" + product.getName() +
               ", Qty: " + quantity + ", Status: " + status + "]";
    }
}

