package java_project_f116;
class Product {
    private int id;
    private String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    @Override
    public String toString() { return name + " (ID " + id + ")"; }
}
