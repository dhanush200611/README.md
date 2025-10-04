package java_project_f116;

class ProductionReport {
    private static int counter = 1;
    private int id;
    private WorkOrder workOrder;
    private int producedQty;
    private int scrapQty;

    public ProductionReport(WorkOrder wo, int produced, int scrap) {
        this.id = counter++;
        this.workOrder = wo;
        this.producedQty = produced;
        this.scrapQty = scrap;
    }
}
