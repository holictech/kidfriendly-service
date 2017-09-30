package com.holictechnology.kidfriendly.domain.dto.result;


import java.io.Serializable;
import java.util.Collection;

import com.holictechnology.kidfriendly.domain.dto.paginator.PaginatorDto;


public final class ResultDto<T> implements Serializable {

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
