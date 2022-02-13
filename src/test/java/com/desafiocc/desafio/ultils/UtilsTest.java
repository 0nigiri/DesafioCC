package com.desafiocc.desafio.ultils;

import com.desafiocc.desafio.model.Numero;
import com.desafiocc.desafio.model.NumeroData;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

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
        ArrayList<Double> array1 = new ArrayList<>();
        array1.add(0.123);
        array1.add(0.12345);
        array1.add(0.123);
        array1.add(0.1234);
        array1.add(0.01233245);
        array1.add(0.9);
        array1.add(0.31231);
        array1.add(0.1673);


        ArrayList<Double> array2 = new ArrayList<>();
        array2.add(0.123);
        array2.add(0.12345);
        array2.add(0.01233245);
        array2.add(0.1234);
        array2.add(0.123);
        array2.add(0.31231);
        array2.add(0.1673);
        array2.add(0.9);

        assertNotEquals(array1, array2);
        Collections.sort(array1);
        Utils utils = new Utils();
        Utils.quickSort(array2, 0, array2.size() - 1);

        assertEquals(array1,  array2);


    }

    @Test
    void testarTudo() {
        Utils util = new Utils();
        util.listNumeros();
        ArrayList<Double> lista = new ArrayList<>();
        for (Double num : Utils.ordenarNumeros(util.numeroData)) {
            lista.add(num);
        }



        assertEquals(1000000, lista.size());

    }



    @Test
    void testarTudosql() {
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