import java.util.*;

public class Main {

	public static void fun() {
		LinkedHashMap<Integer, String[]> Stock= new LinkedHashMap<Integer, String[]>();
        Scanner s = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println("1. As Shopkeeper" + "\n" + "2. As Customer");
            System.out.println("Enter Choice: ");
            int choice = s.nextInt();
            switch(choice)
            {
                case 1:{
                    boolean con = true;
                    while(con){
                        System.out.println();
                        System.out.println("1. Enter Stock" + "\n" + "2. Display Stock" +"\n" + "3. Go Back");
                        int ch = s.nextInt();
                        switch(ch){
                            case 1:{
                                String [] val = new String[2];
                                System.out.println("Enter Itemcode: ");
                                int itemcode = s.nextInt();
                                System.out.println("Enter Name: ");
                                String Name = s.next();
                                val[0] = Name;
                                System.out.println("Enter Cost: ");
                                String Cost = s.next();
                                val[1] = Cost;
                                Stock.put(itemcode, val);
                                break;
                            }
                            case 2:{
                                System.out.println("Itemcode      Name        Cost");
                                for (Map.Entry data: Stock.entrySet()){
                                    String [] value = (String[]) data.getValue();
                                    System.out.println(data.getKey()+"             "+value[0]+"         "+value[1]);
                                }
                                break;
                            }
                            case 3:{
                                con = false;
                            }
                        }
                    }
                    break;
                }
                case 2:{
                    boolean con = true;
                    Integer totalAmount = 0;
                    LinkedHashMap<Integer,String[]> Customer = new LinkedHashMap<Integer,String[]>();
                    while(con){
                        System.out.println();
                        System.out.println("1. Display Stock" + "\n" + "2. Purchase" +"\n" + "3. Bill"+"\n"+"4.Exit");
                        int ch = s.nextInt();
                        
                        switch(ch){
                            case 1:{
                                System.out.println();
                                System.out.println("Itemcode      Name        Cost");
                                for (Map.Entry data: Stock.entrySet()){
                                    String [] value = (String[]) data.getValue();
                                    System.out.println(data.getKey()+"             "+value[0]+"         "+value[1]);
                                }
                                break;
                            }
                            case 2:{
                                System.out.println();
                                System.out.println("Enter Itemcode: ");
                                int code = s.nextInt();
                                String [] value = (String[]) Stock.get(code);
                                totalAmount = totalAmount + Integer.parseInt(value[1]);
                                Customer.put(code,value);
                                break;
                            }
                            case 3:{
                                System.out.println();
                                for (Map.Entry data: Customer.entrySet()){
                                    String [] value = (String[]) data.getValue();
                                    System.out.println(data.getKey()+"             "+value[0]+"         "+value[1]);
                                }
                                System.out.println("Total Amount: "+totalAmount);
                                break;
                            }
                            case 4:{
                                System.exit(0);
                            }
                        }
                    }
                }
            }
        }
	}

	public static void main(String[] args) {
		fun();
}
}
