package TestVagrant.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class IplTeamProgram {
	JSONArray array;
	Object obj;
	JSONObject jo;
	JSONObject player;
	@Test(priority=1)
	public void teamHasOnly4ForienPlayer() throws Exception
	{
		JSONParser jp = new JSONParser();
		FileReader reader = new FileReader("C:\\Users\\SHUBHAM\\eclipse-workspace\\1march\\src\\test\\java\\restapi\\march\\team.JSON.");
		 obj = jp.parse(reader);
	     jo = (JSONObject)obj;
	    array = (JSONArray) jo.get("player");
		String country = null;
		int forienplayer =0;
	for(int i=0;i<array.size();i++)
	{
	 player = (JSONObject) array.get(i);
		 country = (String) player.get("country");
		 if(!country.equalsIgnoreCase("india"))
		 {
			 forienplayer = forienplayer+1;
		 }
	}
	System.out.println(forienplayer);
	if(forienplayer>4)
	{
		System.out.println("Team is not ok");
	}
	else
	{
		System.out.println("team is ok");
	}

	}
	@Test(priority=2)
	public void AtLeastOneWicketKeeper()
	{
		
		array = (JSONArray) jo.get("player");
		String role = null;
		int WicketKeeper =0;
		for(int i=0;i<array.size();i++)
		{
			player = (JSONObject) array.get(i);
			role = (String) player.get("role");
			 if(role.equalsIgnoreCase("Wicket-keeper"))
			 {
				 WicketKeeper = WicketKeeper+1;
			 }
		}
		System.out.println( WicketKeeper);
		if( WicketKeeper>=1)
		{
			System.out.println("Team is  ok");
		}
		else
		{
			System.out.println("team not ok");
		}
		}
	}


