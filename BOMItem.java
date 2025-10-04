package java_project_f116;

class BOMItem {
    private Product component;
    private int quantityPerUnit;

    public BOMItem(Product component, int qty) {
        this.component = component;
        this.quantityPerUnit = qty;
    }
    public Product getComponent() { return component; }
    public int getQuantityPerUnit() { return quantityPerUnit; }
}