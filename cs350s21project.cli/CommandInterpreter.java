import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.A_Command;
import cs350s21project.controller.command.view.*;
import cs350s21project.datatype.AgentID;
import cs350s21project.datatype.Altitude;
import cs350s21project.datatype.Latitude;
import cs350s21project.datatype.Longitude;

import java.util.Scanner;
//for all the window views we are most likely going to have the same longitude values.
public class CommandInterpreter {
    public static void main(String[] args) {
        CommandInterpreter ref = new CommandInterpreter();

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
}