public class ticket
{
    private int row;
    private int seat;
    private int price;
    private person person;

    public static void print(){
        for ( ticket Ticket : theatre.ticketlist){
            try
            {
                System.out.println("Person name: " + Ticket.person.getName());
                System.out.println(" Person surname: " + Ticket.person.getSurname());
                System.out.println("Person email: " + Ticket.person.getEmail());
                System.out.println("Row number: " + Ticket.row);
                System.out.println("Seat number: " + Ticket.seat);
                System.out.println("Price: " + Ticket.price);
            }
            catch (Exception e){
                System.out.println("Cancelled");

            }
        }
    }

    public ticket(int row, int seat, int price, person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ticket() {

    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public person getPerson() {
        return person;
    }
}


