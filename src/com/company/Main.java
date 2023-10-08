package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(1, 1, 1, 2, 2, 3, 3, 4, 4, 4, 4, 5, 6, 6, 6);
//        List<String> list = Arrays.asList("one", "one", "one", "two", "two", "three", "three", "four", "four", "four", "four", "five", "six", "six", "six");
//        List<Float> list = Arrays.asList(1f, 1f, 1f, 2f, 2f, 3f, 3f, 4f, 4f, 4f, 4f, 5f, 6f, 6f, 6f);
//        List<Double> list = Arrays.asList(1.0, 1.0, 1.0, 2.0, 2.0, 3.0, 3.0, 4.0, 4.0, 4.0, 4.0, 5.0, 6.0, 6.0, 6.0);
//        List<Character> list = Arrays.asList('a', 'a','a','b','b','c','c','d','d','d','d','e','f','f','f');

        int maxDuplicates = 2;

        System.out.println("Input Sequence: " + list);
        System.out.println("Acceptable Quantity Of Duplicates: " + maxDuplicates);
        System.out.println("Output Sequence: " + RemoveDuplicates(list, maxDuplicates));
    }

    public static <T> List<T> RemoveDuplicates(List<T> list, int maxDuplicates)
    {
        if (list == null || list.size() == 0)
        {
            return list;
        }

        List<T> result = new ArrayList<>();

        int count = 1;

        for (int i = 1; i < list.size(); i++)
        {
            if (list.get(i).equals(list.get(i - 1)))
            {
                count++;
            }
            else
            {
                if (count <= maxDuplicates)
                {
                    for (int j = 1; j <= count; j++)
                    {
                        result.add(list.get(i - j));
                    }
                }
                count = 1;
            }
        }

        if (count <= maxDuplicates)
        {
            for (int j = 1; j <= count; j++)
            {
                result.add(list.get(list.size() - j));
            }
        }

        return result;
    }
}