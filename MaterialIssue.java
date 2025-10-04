package java_project_f116;
import java.util.*;
class MaterialIssue {
    private static int counter = 1;
    private int id;
    private WorkOrder workOrder;
    private Warehouse warehouse;
    private Map<Product,Integer> items;

    public MaterialIssue(WorkOrder wo, Warehouse w, Map<Product,Integer> items) {
        this.id = counter++;
        this.workOrder = wo;
        this.warehouse = w;
        this.items = items;
    }
}