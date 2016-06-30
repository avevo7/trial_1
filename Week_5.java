package Final_5;
//made edit to this branch in the webtool
/*
title: WEEK 5....the READ and Write work correctly....YEAH!!!!!  Now all that's needed is to implement the ADD function
*/

import java.util.*;				// file contains the definition of Scanner.
import java.io.*;				// file contains IO exception handling

public class Week_5
{																	
	private static Scanner Input = new Scanner(System.in);						// Create a scanner object to read user inputs
	private static WeatherStationList Stations = new WeatherStationList();		// Create WeatherStationList object
	
	public static void main(String[] Args) throws IOException 	// acknowledges exception handling at the highest level
	{
		RunIT();									// Runs the program
	}
	
	public static void Menu()  						// Displays Menu options to user
	{	
		System.out.println("Choices...................................................................................");
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("\t" + "Post......allows the user to add WeatherStations to the list.");
		System.out.println("\t" + "Post......allows the user to post temperatures.");
		System.out.println("\t" + "HighLow...displays the report of high and low temperatures.");
		System.out.println("\t" + "Daily.....display the daily report.");
		System.out.println("\t" + "Pollen....displays the daily pollen count.");
		System.out.println("\t" + "Quality...displays the daily air quality report.");
		System.out.println("\t" + "Set.......changes the name of the disk file.");
		System.out.println("\t" + "Write.....writes the contents of the list to a disk file.");
		System.out.println("\t" + "Read......rebuilds the station list from a disk file.");
		System.out.println("\t" + "Quit......exits the program.");
		System.out.println("------------------------------------------------------------------------------------------");
	}	
	
	public static void RunIT() throws IOException
	{
		String Command = "";						// Create string to hold user command

		while (!Command.equals("Quit"))				// While loop that executes the program until 
		{
			Menu();									// Call to display Menu to user
			System.out.print("Command: ");				
			Command=Input.nextLine();				// Gets user command
			System.out.println();
			if (Command.equals("Post"))			
				Stations.Post(); 				// Calls AddWeatherStation method that adds a weather station to the list
			else if (Command.equals("Post"))
				Stations.Post();					// Calls Post method from WeatherStationList that allows user to post temperature, polllen and air quality data
			else if (Command.equals("HighLow"))
				Stations.HighLow(); 					// Calls HighLow method from WeatherStationList that displays the high/low temperature
			else if (Command.equals("Daily"))
				Stations.Daily(); 				// Calls Daily method from WeatherStationList that displays the raw data and mean temperature
			else if (Command.equals("Pollen"))
				Stations.DisplayPollenCount(); 	// Calls DisplayPollenCount method from WeatherStationList that displays the pollen count
			else if (Command.equals("Quality"))
				Stations.DisplayAQScore(); 		// Calls DisplayAQScore method from WeatherStationList that displays the air quality
			else if (Command.equals("Set"))
				ChangeFileName(); 				// Calls ChangeFileName method that allows user to change the file name
			else if (Command.equals("Write"))
				Stations.SaveWeatherStationInfo(); 	// Calls SaveWeatherStationInfo method that allows user to save content to a disk file
			else if (Command.equals("Read"))
				Stations.ReadWeatherStationInfo(); 	// Calls ReadWeatherStationInfo method that allows the user to rebuild a WeatherStationList from a disk file
			else if (!Command.equals("Quit"))
				System.out.println("Invalid choice, please enter a command." + "\n"); 	// Lets the user know if they did not type in a command correctly
		}
	}
	
	public static void ChangeFileName()			// method that allows the user to change the file name
	{
		String FName;		// variable FName that will hold the user file name input
		
		System.out.println("Current File is " + Stations.GetFileName());	// displaying current file name
		System.out.print("New File Name: ");	// asking user to put in a new file name
		FName = Input.nextLine();
		Stations.SetFileName(FName);	// calling WeatherStationList mutator method to change the file name
	}

}
