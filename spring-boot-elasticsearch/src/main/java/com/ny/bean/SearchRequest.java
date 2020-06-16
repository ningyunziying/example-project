package com.ny.bean;

import lombok.Data;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@Data
public class SearchRequest {
    /**
     * 搜索关键词
     */
    private List<String> keywords;


    /**
     * 分页请求
     */
    private PageRequest pageRequest;

    /**
     *过滤请求
     */
    private BoolQueryBuilder filter;


    /**
     *排序请求
     */
    private List<String> sort;

}
