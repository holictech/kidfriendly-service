package com.holictechnology.kidfriendly.domain.dtos.result;


import java.io.Serializable;
import java.util.Collection;

import com.holictechnology.kidfriendly.domain.dtos.paginator.PaginatorDto;


public class ResultDto<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private PaginatorDto paginatorDto;
    private Collection<T> results;

    public PaginatorDto getPaginatorDto() {
        return paginatorDto;
    }

    public void setPaginatorDto(PaginatorDto paginatorDto) {
        this.paginatorDto = paginatorDto;
    }

    public Collection<T> getResults() {
        return results;
    }

    public void setResults(Collection<T> results) {
        this.results = results;
    }
}
