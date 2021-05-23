import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.A_Command;
import cs350s21project.controller.command.view.CommandViewCreateWindowFront;
import cs350s21project.controller.command.view.CommandViewCreateWindowSide;
import cs350s21project.controller.command.view.CommandViewCreateWindowTop;
import cs350s21project.datatype.AgentID;
import cs350s21project.datatype.Altitude;
import cs350s21project.datatype.Latitude;
import cs350s21project.datatype.Longitude;

import java.util.Scanner;
//for all the window views we are most likely going to have the same longitude values.
public class CommandInterpreter {
    public static void main(String[] args) {
        CommandInterpreter ref = new CommandInterpreter();
        ref.buildAltitudeCoordinate(4.00);
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
        int size = 1080 *1920;
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

    public void buildTopView(AgentID idWindow, CommandManagers windowManager, Latitude latitudeOrigin, Latitude latitudeExtent, Latitude latitudeInterval,
                             Longitude longitudeOrigin, Longitude longitudeExtent, Longitude longitudeInterval)
    {
        //window sizing and name setup
        String windowName = "Top View";
        int size = 1920 * 1080;

        //building
        CommandViewCreateWindowTop TopWindow = new CommandViewCreateWindowTop(windowManager, windowName, idWindow, size, latitudeOrigin, latitudeExtent,
                latitudeInterval, longitudeOrigin, longitudeExtent, longitudeInterval);

        //execute Window
        TopWindow.execute();
    }

    public void buildFrontView(AgentID idWindow, CommandManagers windowManager, Longitude longitudeOrigin, Longitude longitudeExtent, Longitude longitudeInterval,
                               Altitude altitudeOrigin, Altitude altitudeExtent, Altitude altitudeAGLInterval, Altitude altitudeBGLInterval)
    {
        //window sizing and name setup
        String windowName = "Front View";
        int size = 1920 * 1080;

        //building
        CommandViewCreateWindowFront frontWindow = new CommandViewCreateWindowFront(windowManager, windowName, idWindow, size,
                longitudeOrigin, longitudeExtent, longitudeInterval, altitudeOrigin, altitudeExtent, altitudeAGLInterval, altitudeBGLInterval);

        //execute Window
        FrontWindow.execute();

    }

    public void buildSideView(AgentID idWindow, CommandManagers windowManager, Latitude latitudeOrigin, Latitude latitudeExtent, Latitude latitudeInterval,
                              Altitude altitudeOrigin, Altitude altitudeExtent, Altitude altitudeAGLInterval, Altitude altitudeBGLInterval)
    {
        //window sizing in pixels and name setup
        String windowName = "Side View";
        int size = 1920 * 1080;
        //building
        CommandViewCreateWindowSide sideWindow = new CommandViewCreateWindowSide(windowManager, windowName, idWindow, size, latitudeOrigin, latitudeExtent,
                latitudeInterval, altitudeOrigin, altitudeExtent, altitudeAGLInterval, altitudeBGLInterval);

        //execute Window
        sideWindow.execute();
    }

    //temporary methods utilized for displaying what makes a latitude, longitude, and altitude object.
    public Altitude buildAltitudeCoordinate(double initialAltitude) {
        Altitude newAltitudeCoordinate = new Altitude(5.00);
        System.out.println("The following coordinate has been set for Altitude: " + newAltitudeCoordinate.toString());
        return newAltitudeCoordinate;
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