package com.desafiocc.desafio.ultils;

import com.desafiocc.desafio.model.Numero;
import com.desafiocc.desafio.model.NumeroData;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UtilsTest {
    Gson gson = new Gson();
    Utils test = new Utils();


    @Test
    void testandoParseJsonFromUrl() {
        String jsonString = test.getUrlJsonString(1);
        NumeroData numeroData = gson.fromJson(jsonString, NumeroData.class);
        System.out.println(numeroData);
        assertEquals(100, numeroData.getNumbers().size());
    }


    @Test
    void recurisonTestStackOverflow() {
        boolean thrown = true;
        try {
            test.listNumeros();
        } catch (StackOverflowError error) {
            thrown = false;
            assertEquals("message", error.getMessage());
        }
        assertTrue(thrown);

    }


    @Test
    void testarQuickSort() {
        ArrayList<Double> array = new ArrayList<>();
        array.add(0.123);
        array.add(0.12345);
        array.add(0.123);
        array.add(0.1234);
        array.add(0.01233245);
        array.add(0.9);
        array.add(0.31231);
        array.add(0.1673);
        System.out.println(array);
        Utils.quickSort(array, 0, array.size() - 1);
        System.out.println(array);


    }

    @Test
    void testarTudo() {
        test.listNumeros();
        ArrayList<Numero> numeros = new ArrayList<>();
        System.out.println("done");

        for (Double num : Utils.ordenarNumeros(test.numeroData)) {
            Numero n = new Numero();
            n.setNumero(num);
            numeros.add(n);
        }

        assertEquals(10000, numeros.size());

    }



}