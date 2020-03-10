package com.containerstore.whereis.viewmodel;

public class WhereIsViewModel {
    private String query;
    private String result;

    public WhereIsViewModel() {
    }

    public WhereIsViewModel(String query, String result) {
        this.query = query;
        this.result = result;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public static void main(String[] args) {
        int cnt = 0;
        for(int i=0; i<100; i++){
            cnt = cnt++;
        }

        System.out.println(cnt);

    }
}
