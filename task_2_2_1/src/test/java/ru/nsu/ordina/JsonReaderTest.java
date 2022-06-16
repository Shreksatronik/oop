package ru.nsu.ordina;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.nsu.ordina.json.*;
import ru.nsu.ordina.order.Order;
import ru.nsu.ordina.json.PizzeriaJSON;
import ru.nsu.ordina.pizzeria.PizzeriaApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class JsonReaderTest {
    private PizzeriaJSON pizzeriaJSON;
    private CourierJSON[] courierJSON;
    private BakerJSON[] bakerJSON;
    private JSONReader jsonReader;
    private Gson gson;

    @BeforeEach
    public void init(){
        bakerJSON = new BakerJSON[]{new BakerJSON(0, 2)};
        courierJSON = new CourierJSON[]{new CourierJSON(0, 3)};
        pizzeriaJSON = new PizzeriaJSON(10, 10, bakerJSON, courierJSON);
        jsonReader = new JSONReader();
        gson = new Gson();
    }

    @Test
    public void readFromFile() throws IOException {
        PizzeriaJSON pizzeriaJSONRead = jsonReader.read();
        Assertions.assertEquals(gson.toJson(pizzeriaJSON), gson.toJson(pizzeriaJSONRead));
    }
}
