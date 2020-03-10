package com.containerstore.whereis.service;

import com.containerstore.whereis.viewmodel.WhereIsViewModel;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ConferenceRooms {

    public String locationOf(String query) {
        String location;

        switch (query.trim().toLowerCase()) {
            case "fill their baskets":
            case "service selection price":
            case "man in the desert":
            case "air of excitement":
                location = "in the vendor conference area (off of reception)";
                break;
            case "data central":
                location = "in the Information Systems area";
                break;
            case "perfect product presentation":
            case "main and main":
                location = "at the north end of the Information Systems area";
                break;
            case "1 great = 3 good":
            case "intuition does not come to an unprepared mind":
                location = "off the atrium, behind reception";
                break;
            case "gumby":
                location = "where gumby has always been located...c'mon!";
                break;
            case "contain yourself":
                location = "upstairs, south end, adjacent to CSD";
                break;
            case "we love our employees":
                location = "upstairs, south end, adjacent to CSD (seating area in front of Contain Yourself)";
                break;
            case "all eyes on elfa":
                location = "upstairs, southwest corner";
                break;
            case "service = selling":
            case "fun and functional":
                location = "upstairs, southwest corner, adjacent to loss prevention";
                break;
            case "communication is leadership":
                location = "upstairs, northwest corner, adjacent to the executive suite";
                break;
            case "we sell the hard stuff":
            case "blue sky":
                location = "up the stairs, turn right (adjacent to merchandising)";
                break;
            default:
                location = "somewhere, but I don't know where";
                break;
        }

        return String.format("%s is located %s", query, location);
    }

    public List<WhereIsViewModel> locationOfForList(List<WhereIsViewModel> viewModelList) {
        viewModelList.forEach(viewModel -> {
            viewModel.setResult(locationOf(viewModel.getQuery()));
            viewModel.setQuery(capitalizeEachWord(viewModel.getQuery()));
        });
        return viewModelList;
    }

    private String capitalizeEachWord(String query) {
        String[] arr = query.split(" ");
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < arr.length; i++){
            sb.append(Character.toUpperCase(arr[i].charAt(0)))
                    .append(arr[i].substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

    public List<WhereIsViewModel> getAllConferenceRooms() {
       return  Arrays.asList(
                    new WhereIsViewModel("fill their baskets", "in the vendor conference area (off of reception)"),
                    new WhereIsViewModel("service selection price", "in the vendor conference area (off of reception)"),
                    new WhereIsViewModel("man in the desert", "in the vendor conference area (off of reception)"),
                    new WhereIsViewModel("air of excitement", "in the vendor conference area (off of reception)"),
                    new WhereIsViewModel("data central", "in the Information Systems area"),
                    new WhereIsViewModel("perfect product presentation", "at the north end of the Information Systems area"),
                    new WhereIsViewModel("main and main", "at the north end of the Information Systems area"),
                    new WhereIsViewModel("1 great = 3 good", "off the atrium, behind reception"),
                    new WhereIsViewModel("intuition does not come to an unprepared mind", "off the atrium, behind reception"),
                    new WhereIsViewModel("gumby", "where gumby has always been located...c'mon!"),
                    new WhereIsViewModel("contain yourself", "upstairs, south end, adjacent to CSD"),
                    new WhereIsViewModel("we love our employees", "upstairs, south end, adjacent to CSD (seating area in front of Contain Yourself)"),
                    new WhereIsViewModel("all eyes on elfa", "upstairs, southwest corner"),
                    new WhereIsViewModel("service = selling", "upstairs, southwest corner, adjacent to loss prevention"),
                    new WhereIsViewModel("fun and functional", "upstairs, southwest corner, adjacent to loss prevention"),
                    new WhereIsViewModel("communication is leadership", "upstairs, northwest corner, adjacent to the executive suite"),
                    new WhereIsViewModel("we sell the hard stuff", "up the stairs, turn right (adjacent to merchandising)"),
                    new WhereIsViewModel("blue sky", "up the stairs, turn right (adjacent to merchandising)")
                );

    }
}
