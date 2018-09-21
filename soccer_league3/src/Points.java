
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import static java.util.Map.Entry.comparingByValue;
import java.util.TreeMap;

import java.util.Collections;

import java.util.Comparator;

import java.util.HashMap;

import java.util.LinkedHashMap;

import java.util.Map;

import static java.util.stream.Collectors.*;

import static java.util.Map.Entry.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author frase
 */
public class Points {

    private String name;
    private int score;
    TreeMap<String, Integer> tm = new TreeMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void displayTeams() {
        System.out.println(name);
        System.out.println(score);
    }

    public void scoreCalc(String name2, int score2) {
        int count = 0;
        if (!tm.containsKey(name)) {
            tm.put(name, 0);
        }
        if (!tm.containsKey(name2)) {
            tm.put(name2, 0);
        }
        if (score != score2) {
            if (score > score2) {
                count = count + tm.get(name);
                tm.put(name, count + 3);
                count = 0;
            }
            if (score < score2) {
                count = count + tm.get(name2);
                tm.put(name2, count + 3);
                count = 0;
            }
        } else {
            if (tm.containsKey(name)) {
                count = tm.get(name);
                tm.put(name, count + 1);
            }
            if (tm.containsKey(name2)) {
                count = tm.get(name2);
                tm.put(name2, count + 1);
            }
        }
    }

    public void ScoreBoard() {
        Map<String, Integer> sorted = tm
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
        
        System.out.println("****Scoreboard****");
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
