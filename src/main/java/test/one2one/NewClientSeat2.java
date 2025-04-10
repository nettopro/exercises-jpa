package test.one2one;


import infra.DAO;
import model.one2one.Client;
import model.one2one.Seat;

public class NewClientSeat2 {
    public static void main(String[] args) {
        
        Seat seat = new Seat("4D");
        Client client = new Client("Junior", seat);

        DAO<Client> dao = new DAO<>(Client.class);
        dao.insertAtomic(client);
    }
}
