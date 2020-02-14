
public class Flight {

    Airport fromAirport, toAirport;
    Pilot pilotInCommand;
    Airplane airplane;

    public Flight(Airport fromAirport, Airport toAirport, Pilot pilotInCommand, Airplane airplane){
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.pilotInCommand = pilotInCommand;
        this.airplane = airplane;

        System.out.println("\nNew Flight Plan filed:\n\t             From: "+
            fromAirport.airportCity()+"\n\t               To: "+
            toAirport.airportCity()+   "\n\t        Equipment: "+airplane.registration()+" ("+
            airplane.getMakeModel()+")\n\t Pilot In Command: "+
            pilotInCommand.pilotName());

    }
}