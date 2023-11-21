package com.example.retfofitmvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

// modal class for api results (JSON)
public class Result {

   /* @SerializedName() --> hm us wqt use krte h jb json viewer me jo name ate h hm un ki jga kch or likhe ke jesa
    k yha p page ki jga page_no likh lete to ye use kr skte the*/


    // fetching the json output
    @SerializedName("page")
    @Expose // wehther field is ecluded or included
    private Integer page;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("results")
    @Expose
    private List<Movie> results = null;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }



    public Result() {
        //empty constructor to prevent any null pointer exception
    }
}
