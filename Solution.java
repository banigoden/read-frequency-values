package com.javarush.task.task18.task1804;

/* 
Самые редкие байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import static java.util.stream.Collectors.*;

public class Solution {
    public static void main(String[] args)  {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
           try( FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {

               List<Integer> values = new ArrayList<>();

               while (fileInputStream.available() > 0) {

                   int value = fileInputStream.read();
                   values.add(value);
               }

               List<Integer>notRepeated = new ArrayList<>();
               Map<Integer, Integer> nonRepeatedValues = values.stream()
                       .collect(groupingBy(Function.identity(), summingInt(e -> 1)));
               nonRepeatedValues.forEach((e, v) -> {
                   if (v < 2 && !(notRepeated.contains(e))) {
                       notRepeated.add(e);
                       System.out.print(e + " ");
                   }
               });
           }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
