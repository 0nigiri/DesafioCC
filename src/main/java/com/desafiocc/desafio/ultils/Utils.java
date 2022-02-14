package com.desafiocc.desafio.ultils;


import com.desafiocc.desafio.model.NumeroData;
import com.google.gson.Gson;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;

public class Utils {


    public ArrayList<NumeroData> numeroData = new ArrayList<>();
    String stringUrl = "http://challenge.dienekes.com.br/api/numbers?page=";
    int page = 1;
    Gson gson = new Gson();
    Boolean jobDone = false;


    //Metodo de criar um ArrayList que foi recebido do json
    public void listNumeros() {
        while (!jobDone) {
            try {
                String jsonReceived = getUrlJsonString(page);
                if (jsonReceived.equals("{\"numbers\":[]}")) {
                    System.out.println("Completo!");
                    jobDone = true;
                } else if (!jsonReceived.isEmpty()) {
                    numeroData.add((gson.fromJson(jsonReceived, NumeroData.class)));
                    page++;
                }
            } catch (HttpServerErrorException | InternalError e) {
                System.out.println("Error: " + e);
            }

        }
    }

    // Metodo de fazer pegar o Json do url
    public String getUrlJsonString(int pag) {
        ClientHttpRequestFactory requestFactory = new
                HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate.getForObject(stringUrl + pag, String.class);
    }

    public static ArrayList<Double> ordenarNumeros(ArrayList<NumeroData> numeroData) {
        ArrayList<Double> sort = new ArrayList<>();
        for (NumeroData array : numeroData) {
            sort.addAll(array.getNumbers());
        }
        quickSort(sort, 0, sort.size() - 1);
        System.out.println("Ordenado!");
        return sort;
    }

    public static void quickSort(ArrayList<Double> array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private static int partition(ArrayList<Double> array, int low, int high) {
        double pivot = array.get(high);
        int i = (low - 1);
        for (int j = low; j <= high; j++) {
            if (array.get(j) < pivot) {
                i++;
                Collections.swap(array, i, j);
            }
        }
        Collections.swap(array, i + 1, high);
        return (i + 1);
    }
}
