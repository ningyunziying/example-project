package com.ny.services;

import com.ny.bean.SearchRequest;
import com.ny.mapper.ExtResultMapper;
import com.ny.model.KgEntity;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.NestedQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;

@Service
public class IndexService {
    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    public AggregatedPage<KgEntity> getIndex(SearchRequest searchRequest) {
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        for (String keyWord : searchRequest.getKeywords()) {
            queryBuilder.should(
                    multiMatchQuery(keyWord));
        }
        BoolQueryBuilder a_queryBuilder = QueryBuilders.boolQuery();
        for (String keyWord : searchRequest.getKeywords()) {
            a_queryBuilder.should(
                    multiMatchQuery(keyWord));
        }
        NestedQueryBuilder nestedQueryBuilder = QueryBuilders.nestedQuery("attributes", a_queryBuilder, ScoreMode.None);
        queryBuilder.should(nestedQueryBuilder);


        BoolQueryBuilder filter = searchRequest.getFilter();
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .withFilter(filter)
                .withTypes("")
                .withPageable(searchRequest.getPageRequest())
                .build();
        return elasticsearchRestTemplate.queryForPage(searchQuery, KgEntity.class, new ExtResultMapper());
    }
}
