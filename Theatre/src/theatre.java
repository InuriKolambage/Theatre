import java.io.*;
import java.util.*;

public class theatre {
    public static ArrayList<String> Tickets;
    static ArrayList<ticket> ticketlist = new ArrayList<>(20);

    //Creating method for sort tickets
    private static void sort_Tickets(){
        ticketlist.sort(Comparator.comparing(ticket::getPrice));
        for (ticket Ticket: theatre.ticketlist){
            try{
                System.out.println("Person name: " + Ticket.getPerson().getName());
                System.out.println(" Person surname: " + Ticket.getPerson().getSurname());
                System.out.println("Person email: " + Ticket.getPerson().getEmail());
                System.out.println("Row number: " + Ticket.getRow());
                System.out.println("Seat number: " + Ticket.getSeat());
                System.out.println("Price: " + Ticket.getPrice());
                System.out.println("-------------------------------------------------");
            }
            catch (Exception e){
                System.out.println("No details");
            }
        }
    }

    //Creating method for show ticket info
    private static void show_tickets_info(){
        ticket.print();
        int total_price = 0;
        for (ticket Ticket : theatre.ticketlist){
            try {
                total_price += Ticket.getPrice();{
                    System.out.println("Total price: " + total_price);
                }
            }
            catch (Exception e){
                throw new RuntimeException(e);
            }
        }


    }
    //Creating method for Load
    private static void load(int[] row_1, int[] row_2, int[] row_3) {
        File file = new File("saved_arrays.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);

            }
            scanner.close();
        } catch (FileNotFoundException e) {

            System.out.println("File not found");

        }
    }
    //Creating method for Save
    private static void save(int[] row_1, int[] row_2, int[] row_3)throws IOException{
        try {
            PrintWriter save = new PrintWriter(new File("saved_arrays.txt"));
            save.println("row number 1: "+Arrays.toString(row_1));
            save.println("row number 2: "+Arrays.toString(row_2));
            save.println("row number 3: "+Arrays.toString(row_3));
            save.close();
            System.out.println("Row's information saved successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Row's information didn't saved.");
        }



    }
    //Creating method for Show Available tickets
    private static void show_available(int[] row_1, int[] row_2, int[] row_3){
        Scanner scan = new Scanner(System.in);
        System.out.print("Seats available in row 1: ");
        for (int i=0; i<row_1.length; i++){
            if (row_1[i] != 1){
                System.out.print((i+1)+ ", ");
            }
        }
        System.out.print("\nSeats available in row 2: ");
        for (int i=0; i<row_2.length; i++){
            if (row_2[i] != 1){
                System.out.print((i+1)+ ", ");
            }
        }
        System.out.print("\nSeats available in row 3: ");
        for (int i=0; i<row_3.length; i++) {
            if (row_3[i] != 1) {
                System.out.print((i + 1) + ", ");
            }
        }
    }

    private static boolean valid(int[]row, int s_num){
        for (int i = 0; i<row.length; i++){
            if (i==s_num-1){
                if(row[i]==1){
                    return true;
                }
            }
        }
        return false;
    }
    private static void c_ticket(int[]row, int s_num){
        for (int i = 0; i<row.length; i++){
            if (i == s_num-1){
                row[i]=0;
            }
        }
    }
    //Creating method for cancelling tickets
    public static void cancel_ticket(int[]row_1, int[] row_2, int[] row_3){
        Scanner sc = new Scanner(System.in);
        Iterator<ticket> iter = ticketlist.iterator();
        while (true){
            System.out.print("Enter row number: ");
            int row = sc.nextInt();

            if (row == 1){
                System.out.println("Enter seat number: ");
                int s_num = sc.nextInt();
                if(valid(row_1, s_num)){
                    c_ticket(row_1, s_num);
                    System.out.println("Seat is cancelled");
                    break;

                }
                else{
                    System.out.println("Invalid row number or seat number");
                }
                for (int i=0; i<ticketlist.size(); i++){
                    ticket cTicket = iter.next();
                    if(cTicket.getRow()==1 && cTicket.getSeat()==s_num){
                        iter.remove();
                    }
                }
                break;
            }
            else if(row == 2){
                System.out.println("Enter seat number: ");
                int s_num = sc.nextInt();
                if (valid(row_2, s_num)){
                    c_ticket(row_2, s_num);
                    System.out.println("Seat is cancelled");
                    break;
                }
                else {
                    System.out.println("Invalid row number or seat number");
                }
                for (int i = 0; i<ticketlist.size(); i++){
                    ticket cTicket = iter.next();
                    if (cTicket.getRow()==1 && cTicket.getSeat()==s_num){
                        iter.remove();
                    }
                }
                break;
            }
            else if (row==3){
                System.out.println("Enter seat number");
                int s_num = sc.nextInt();
                if (valid(row_3, s_num)){
                    c_ticket(row_3, s_num);
                    System.out.println("Seat is cancelled");
                    break;
                }
                else {
                    System.out.println("Invalid row number or seat number");
                }
                for (int i=0; i<ticketlist.size(); i++){
                    ticket cTicket = iter.next();
                    if (cTicket.getRow()==1 && cTicket.getSeat()==s_num){
                        iter.remove();
                    }
                }
                break;
            }
            else {
                System.out.println("Invalid row number");
            }

        }

    }

    public static void print_seating_area(int[] row_1, int[] row_2, int[] row_3){
        System.out.println("     ***********     ");
        System.out.println("      * STAGE *      ");
        System.out.println("     ***********     ");
        int i;
        int j;
        int space_1 = 4;
        //for row number 1
        for (i=0; i<row_1.length; i++){
            for (j=0; j<space_1; j++){
                System.out.print(" ");
            }
            for (j=0; j<row_1.length; j++)
                if (j != row_1.length/2) {
                    if (row_1[j] != 0) {
                        System.out.print("X");
                        //not available = X
                    } else {
                        System.out.print("O");
                        //available = O
                    }
                }
                else {
                    System.out.print(" ");
                    if (row_1[j] != 0) {
                        System.out.print("X");
                        //not available = X
                    } else {
                        System.out.print("O");
                        //available = O
                    }
                }
            break;
        }
        //for row number 2
        System.out.println();
        for (i=0; i<row_2.length; i++){
            int space_2 = 2;
            for (j=0; j<space_2; j++){
                System.out.print(" ");
            }
            for (j=0; j<row_2.length; j++)
                if (j!=row_2.length/2){
                    if (row_2[j]!= 0){
                        System.out.print("X");
                        //not available = X
                    }
                    else {
                        System.out.print("O");
                        //available = O
                    }
                }
                else {
                    System.out.print(" ");
                    if (row_2[j] != 0){
                        System.out.print("X");
                        //not available = X
                    }
                    else {
                        System.out.print("O");
                        //available = O
                    }
                }
            break;


        }
        //for row number 3
        System.out.println();
        for (i=0; i<row_3.length; i++){
            if (i!=row_3.length/2){
                if (row_3[i] != 0){
                    System.out.print("X");
                    //not available = X
                }
                else {
                    System.out.print("O");
                    //available = O
                }
            }
            else {
                System.out.print(" ");
                if (row_3[i] != 0){
                    System.out.print("X");
                    //not available = X
                }
                else {
                    System.out.print("O");
                    //available = O
                }
            }
        }

    }

    public static boolean availableSeats(int[] row, int seat_num){
        for(int i=0; i<row.length; i++){
            if(row[seat_num -1]==0){
                return true;
            }
        }
        return false;
    }
    public static void occupiedSeats(int[] row, int seat_num, ArrayList<String>Tickets){
        for(int i=0; i<row.length; i++){
            if(i== seat_num-1){
                System.out.println("");
                row[seat_num-1]=1;
                System.out.println("You purchased the ticket successfully");
            }
        }
    }
    private static void buy_ticket(int[] row_1, int[] row_2, int[] row_3){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your surname: ");
        String surname = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        person person = new person(name, surname, email);
        System.out.println("Enter row number: ");
        int row = scanner.nextInt();
        System.out.print("Enter seat number: ");
        int seat_num = scanner.nextInt();
        System.out.print("Enter the price: ");
        int price = scanner.nextInt();

        // creates a new object of the class 'ticket'
        ticket ticketobj = new ticket(row, seat_num, price, person);
        while (true){
            //row number 1
            if (row == 1 && (seat_num<=12 && seat_num>0)){
                System.out.println("Row 1 and Seat " + seat_num);
                if(availableSeats(row_1, seat_num)){
                    occupiedSeats(row_1, seat_num, Tickets);
                    break;
                }
                else {
                    System.out.println("Sorry,seat " + seat_num + "is not available");
                }
                //row number 2
            }else if(row == 2 && (seat_num<= 16 && seat_num>0)){
                System.out.println("Row 2 and seat " + seat_num);
                if(availableSeats(row_2, seat_num)){
                    occupiedSeats(row_2, seat_num, Tickets);
                    break;
                }
                else{
                    System.out.println("Sorry,seat " + seat_num + "is not available");
                }
                //row number 3
            }
            else if(row==3 && (seat_num<=20 && seat_num>0)){
                System.out.println("Row 3 and seat " + seat_num);
                if (availableSeats(row_3,seat_num)){
                    occupiedSeats(row_3, seat_num, Tickets);
                    break;
                }
                else {
                    System.out.println("Sorry,seat "+seat_num+"is not available");
                }
            }
            else {
                System.out.println("Invalid row number or seat number");
                break;
            }
        }
        ticketlist.add(ticketobj);

    }

    public static void main(String[] args) throws IOException{
        System.out.println();
        System.out.println("Welcome to the New Theatre");
        //Implement the seats for each rows
        int[] row_1 = new int[12];
        int[] row_2 = new int[16];
        int[] row_3 = new int[20];
        //set seats to free
        Arrays.fill(row_1, 0);
        Arrays.fill(row_2, 0);
        Arrays.fill(row_3, 0);

        Scanner scanner = new Scanner(System.in);
        int option = -1;
        //adding main menu
        while (option != 0){
            System.out.println("\n-------------------------------------------------");
            System.out.println("Please select an option:");
            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("4) List available seats");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file");
            System.out.println("7) Print ticket information and total price");
            System.out.println("8) Sort tickets by price");
            System.out.println("0) Quit");
            System.out.println("-------------------------------------------------");
            System.out.println("Enter option:");
            option = scanner.nextInt();
            switch (option){
                case 0:
                    //User input 0 progamme will terminate
                    return;
                case 1:
                    //User input 1 programme show buy_ticket method
                    buy_ticket(row_1,row_2,row_3);
                    break;
                case 2:
                    // User input '2' programme show print_seating_area method
                    print_seating_area(row_1,row_2,row_3);
                    break;
                case 3:
                    // User can make the seat available again
                    cancel_ticket(row_1,row_2,row_3);
                    break;
                case 4:
                    // Each of the 3 rows displays the seats that are still available
                    show_available(row_1,row_2,row_3);
                case 5:
                    // saves the 3 arrays with the row’s information in a file
                    save(row_1,row_2,row_3);
                    break;
                case 6:
                    // loads the file saved in  and restores the 3 arrays with the row’s information
                    load(row_1,row_2,row_3);
                    break;
                case 7:
//                    // User can get the information about the tickets that he bought
                    show_tickets_info();
                    break;
                case 8:
                    //sort the tickect by their price
                    sort_Tickets();
                    break;

            }
        }
    }
}
