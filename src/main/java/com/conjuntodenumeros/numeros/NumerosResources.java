package com.conjuntodenumeros.numeros;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@RestController
public class NumerosResources {



    @GetMapping(value = "/page")
    public String getPaginas() throws IOException, JSONException {
        int pageNumber = 1;
        JSONArray numbers;
        List<JSONArray> numbersList = new ArrayList<JSONArray>();
        while (pageNumber < 10001) {
            BufferedReader rd;
            URL url = new URL("http://challenge.dienekes.com.br/api/numbers?page=" + pageNumber);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String jsonString = rd.lines().collect(Collectors.joining("numbers"));

            JSONObject jsonObject = new JSONObject(jsonString);
            numbers = jsonObject.getJSONArray("numbers");
            numbersList.add(numbers);
            pageNumber++;
        }
        return numbersList.toString();
    }



}


