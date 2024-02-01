package com.code.challenge.arrays;

import org.assertj.core.api.Assertions;

import java.util.*;

public class TournamentWinner {

    public static void main(String[] args) {

        List<List<String>> competitions = new ArrayList<>();

        List<String> firstCompetition = Arrays.asList("HTML","C#");
        competitions.add(firstCompetition);

        List<String> secondCompetition = Arrays.asList("C#","Python");
        competitions.add(secondCompetition);

        List<String> thirdCompetition = Arrays.asList("Python", "HTML");
        competitions.add(thirdCompetition);

        List<Integer> results = Arrays.asList(0,0,1);

        String expectedWinner = "Python";

        String winner = tournamentWinner(competitions, results);

        Assertions.assertThat(expectedWinner).isEqualTo(winner);

    }


    // runs Big O(n) time and Big O(k) space
    public static String tournamentWinner(List<List<String>> competitions, List<Integer> results) {
        Map<String, Integer> winners = new HashMap<>();

        for(int i = 0; i < competitions.size(); i++) {
            String currentWinner = results.get(i) == 0 ? competitions.get(i).get(1) : competitions.get(i).get(0);
            if(winners.containsKey(currentWinner)) {
                int score = winners.get(currentWinner);
                winners.put(currentWinner, score+3);
            } else {
                winners.put(currentWinner,3);
            }
        }
        String winner = "";
        Integer result = 0;

        for(Map.Entry<String,Integer> entry: winners.entrySet()){
            if(entry.getValue() > result)
                winner=entry.getKey();
        }
        return winner;
    }
}
