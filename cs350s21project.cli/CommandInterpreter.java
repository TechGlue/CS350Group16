import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.A_Command;
import cs350s21project.controller.command.view.CommandViewCreateWindowFront;
import cs350s21project.controller.command.view.CommandViewCreateWindowTop;
import cs350s21project.datatype.AgentID;
import cs350s21project.datatype.Latitude;
import cs350s21project.datatype.Longitude;

import java.util.Scanner;
//for all the window views we are most likely going to have the same longitude values.
public class CommandInterpreter {
    public static void main(String[] args) {
        CommandInterpreter ref = new CommandInterpreter();
 /*       Scanner rf = new Scanner(System.in);
        String f = rf.nextLine();
        ref.evaluate(f);*/

        ref.buildLatitudeCoordinate(4, 4, 1.00);

        ref.buildView();
    }

    public void evaluate(String input) {
        if (input == null || input.isEmpty()) {
            throw new RuntimeException();
        }

        CommandManagers newManager = new CommandManagers();
        String buildCommand = "//" + input;

        A_Command nc = new A_Command(newManager, buildCommand) {
            public void execute() {
                if (buildCommand.equals("hello"))
                    System.out.println("hello world");
            }
        };

        //this will pop up with a gui where you input code and then you can change
        CommandManagers.getInstance().schedule(nc);
    }

    //latitude and longitude has the following fields it has degrees, minutes, and seconds.
    //If the fields are not satisfied then we will not get a working view.


    //the buildView will be in charge of handling the views
    // I'll have it be passed in parameters for the different views
    //build view will contain
    //String name, int size, AgentId which takes in a string and builds a AgentID object.
    //A manager responsible for creating
    public void buildView() {
        String name = "Top Window view";
        int size = 1000;
        AgentID idWindow = new AgentID("TPview");
        CommandManagers manager = new CommandManagers();
        Latitude latitudeOrigin = new Latitude(2, 4, 1.00);
        Latitude latitudeExtent = new Latitude(2, 4, 1.00);
        Latitude latitudeInterval = new Latitude(2, 4, 1.00);
        Longitude longitudeOrigin = new Longitude(2, 4, 1.00);
        Longitude longitudeExtent = new Longitude(2, 4, 1.00);
        Longitude longitudeInterval = new Longitude(2, 4, 1.00);

        CommandViewCreateWindowTop ref = new CommandViewCreateWindowTop(manager, name, idWindow, size, latitudeOrigin, latitudeExtent,
                latitudeInterval, longitudeOrigin, longitudeExtent, longitudeInterval);

        ref.execute();
    }


    //temporary method utilized for displaying what makes a latitude object.
    public Latitude buildLatitudeCoordinate(int degrees, int minutes, double seconds) {
        Latitude newLatitude = new Latitude(degrees, minutes, seconds);
        System.out.println("The following coordinate has been set for Latitude: " + newLatitude.toString());
        return newLatitude;
    }

    public Longitude buildLongitudeCoordinate(int degrees, int minutes, double seconds) {
        Longitude newLongitude = new Longitude(degrees, minutes, seconds);
        System.out.println("The following data has been set for Longitude: " + newLongitude.toString());
        return newLongitude;
    }
//
}