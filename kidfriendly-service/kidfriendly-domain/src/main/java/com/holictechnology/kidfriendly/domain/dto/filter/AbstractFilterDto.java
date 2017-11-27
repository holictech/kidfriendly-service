package com.holictechnology.kidfriendly.domain.dto.filter;


import java.io.Serializable;

import javax.ws.rs.BeanParam;

import com.holictechnology.kidfriendly.domain.dto.paginator.PaginatorDto;


public abstract class AbstractFilterDto implements Serializable {

    private static final long serialVersionUID = -787193217721323332L;

    @BeanParam
    private PaginatorDto paginatorDto;

    public PaginatorDto getPaginatorDto() {
        return paginatorDto;
    }

    public void setPaginatorDto(PaginatorDto paginatorDto) {
        this.paginatorDto = paginatorDto;
    }
}
