package java_project_f116;
import java.util.Scanner;
import java.util.*;

	public class Main {
	    private static Scanner sc = new Scanner(System.in);
	    private static Map<Integer, Product> products = new HashMap<>();
	    private static Map<Product, BOM> boms = new HashMap<>();
	    private static Map<Integer, WorkOrder> workOrders = new HashMap<>();
	    private static Warehouse warehouse = new Warehouse("Main WH");

	    public static void main(String[] args) {
	        while (true) {
	            System.out.println("\n--- Menu ---");
	            System.out.println("1. Add Product");
	            System.out.println("2. Define BOM");
	            System.out.println("3. Create Work Order");
	            System.out.println("4. Issue Materials");
	            System.out.println("5. Report Production");
	            System.out.println("6. Stock Summary");
	            System.out.println("7. WorkOrder Summary");
	            System.out.println("0. Exit");
	            System.out.print("Choice: ");
	            int ch = sc.nextInt(); sc.nextLine();
	            try {
	                switch (ch) {
	                    case 1: addProduct(); break;
	                    case 2: defineBOM(); break;
	                    case 3: createWO(); break;
	                    case 4: issueMaterials(); break;
	                    case 5: reportProduction(); break;
	                    case 6: warehouse.printStock(); break;
	                    case 7: listWorkOrders(); break;
	                    case 0: return;
	                }
	            } catch (Exception ex) {
	                System.out.println("Error: " + ex.getMessage());
	            }
	        }
	    }

	    private static void addProduct() {
	        System.out.print("Enter product id: ");
	        int id = sc.nextInt(); sc.nextLine();
	        System.out.print("Enter product name: ");
	        String name = sc.nextLine();
	        Product p = new Product(id, name);
	        products.put(id, p);
	        System.out.print("Initial stock qty? ");
	        int qty = sc.nextInt();
	        warehouse.addStock(p, qty);
	    }

	    private static void defineBOM() {
	        System.out.print("Enter parent product id: ");
	        int id = sc.nextInt(); sc.nextLine();
	        Product parent = products.get(id);
	        BOM bom = new BOM(parent);
	        while (true) {
	            System.out.print("Component product id (-1 to stop): ");
	            int cid = sc.nextInt();
	            if (cid == -1) break;
	            Product comp = products.get(cid);
	            System.out.print("Qty per unit: ");
	            int qty = sc.nextInt();
	            bom.addItem(new BOMItem(comp, qty));
	        }
	        boms.put(parent, bom);
	    }

	    private static void createWO() {
	        System.out.print("Enter product id for WO: ");
	        int id = sc.nextInt();
	        Product p = products.get(id);
	        System.out.print("Enter WO qty: ");
	        int qty = sc.nextInt();
	        WorkOrder wo = new WorkOrder(p, qty);
	        BOM bom = boms.get(p);
	        if (bom == null) {
	            System.out.println("No BOM defined.");
	            return;
	        }
	        wo.reserveMaterials(bom);
	        workOrders.put(wo.getId(), wo);
	        System.out.println("Created " + wo);
	    }

	    private static void issueMaterials() {
	        System.out.print("Enter WO id: ");
	        int id = sc.nextInt();
	        WorkOrder wo = workOrders.get(id);
	        wo.issueMaterials(warehouse);
	        System.out.println("Issued materials for " + wo);
	    }

	    private static void reportProduction() {
	        System.out.print("Enter WO id: ");
	        int id = sc.nextInt();
	        WorkOrder wo = workOrders.get(id);
	        wo.complete(warehouse);
	        System.out.println("Production reported: " + wo);
	    }

	    private static void listWorkOrders() {
	        for (WorkOrder wo : workOrders.values()) {
	            System.out.println(wo);
	        }
	    }
	}

