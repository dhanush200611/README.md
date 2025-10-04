package java_project_f116;
import java.util.*;
class BOM {
    private Product product;
    private List<BOMItem> items = new ArrayList<>();

    public BOM(Product product) { this.product = product; }
    public void addItem(BOMItem item) { items.add(item); }
    public List<BOMItem> getItems() { return items; }
    public Product getProduct() { return product; }
}