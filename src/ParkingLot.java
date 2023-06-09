import com.practice.parkinglot.ObjectRegistry;
import com.practice.parkinglot.controller.TicketCotroller;
import com.practice.parkinglot.dto.GenerateTicketRequest;
import com.practice.parkinglot.dto.GenerateTicketResponse;
import com.practice.parkinglot.model.VehicleType;
import com.practice.parkinglot.repository.ParkingLotRepository;
import com.practice.parkinglot.repository.TicketRepository;
import com.practice.parkinglot.service.GateService;
import com.practice.parkinglot.service.TicketService;
import com.practice.parkinglot.service.VehicleService;
import com.practice.parkinglot.strategy.spotassignment.RandomSpotAssignmentStrategy;
import com.practice.parkinglot.strategy.spotassignment.SpotAssignmentStrategy;

public class ParkingLot {
    public static void main(String[] args) {
        ObjectRegistry objectRegistry = new ObjectRegistry();
        VehicleService vehicleService = new VehicleService();
        GateService gateService = new GateService();
        TicketRepository ticketRepository = new TicketRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy(parkingLotRepository);
        TicketService ticketService = new TicketService(vehicleService, gateService, spotAssignmentStrategy, ticketRepository);

        TicketCotroller ticketCotroller = new TicketCotroller(ticketService);
        objectRegistry.register("ticketRepository", ticketRepository);
        GenerateTicketRequest generateTicketRequest = new GenerateTicketRequest();
        generateTicketRequest.setVehicleType(VehicleType.SMALL);
        generateTicketRequest.setVehicleNo("MH 06 AM 2001");
        generateTicketRequest.setGateId(1L);
        GenerateTicketResponse response = ticketCotroller.generateTicket(generateTicketRequest);
        System.out.println(response);


    }
}