package com.postitters.postitters.posts.service;




import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

@Service
public class MemeCatcher {

    public Object memeCatcher() throws IOException, ParseException {
        URL url = new URL("https://meme-api.com/gimme");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responsecode = conn.getResponseCode();
        if(responsecode !=200){
            throw new RuntimeException("HttpResponseCode:" + responsecode);
        } else{
            String inline = "";
            Scanner scanner = new Scanner(url.openStream());

            while(scanner.hasNext()){
                inline += scanner.nextLine();
            }
            scanner.close();

            //Using the JSON simple library parse the string into a json object
            JSONParser parse = new JSONParser();
            JSONObject data_obj = (JSONObject) parse.parse(inline);

            //Get the required data using its key
            return data_obj.get("url");
        }
        }
    }



