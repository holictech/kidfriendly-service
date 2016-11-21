package com.holictechnology.kidfriendly.domain.dtos.filters;


import java.io.Serializable;

import javax.ws.rs.BeanParam;

import com.holictechnology.kidfriendly.domain.dtos.paginator.PaginatorDto;


public class AbstractFilterDto implements Serializable {

    private static final long serialVersionUID = -787193217721323332L;

    private PaginatorDto paginatorDto;

    public PaginatorDto getPaginatorDto() {
        return paginatorDto;
    }

    @BeanParam
    public void setPaginatorDto(PaginatorDto paginatorDto) {
        this.paginatorDto = paginatorDto;
    }
}
