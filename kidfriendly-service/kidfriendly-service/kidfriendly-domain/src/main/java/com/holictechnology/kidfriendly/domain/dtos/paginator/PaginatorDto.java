package com.holictechnology.kidfriendly.domain.dtos.paginator;


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;


public class PaginatorDto implements Serializable {

    private static final long serialVersionUID = -5723814885898119399L;

    private Long size;
    private Long currentPage;
    private Long pageSize;

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    @DefaultValue(value = "1")
    @QueryParam(value = "currentPage")
    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    public Long getPageSize() {
        return pageSize;
    }

    @DefaultValue(value = "20")
    @QueryParam(value = "pageSize")
    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getPageTotal() {
        Long pageTotal = BigInteger.ZERO.longValue();

        if (getSize() != null && getPageSize() != null) {
            pageTotal = new BigDecimal(getSize()).divide(new BigDecimal(getPageSize())).setScale(0, RoundingMode.CEILING).longValue();
        }

        return pageTotal;
    }
}
