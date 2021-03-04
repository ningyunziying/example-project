package com.ny.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;
import org.springframework.data.elasticsearch.annotations.Setting;

import javax.persistence.Id;
import java.util.List;

@Data
@Document(indexName = "aks-kg")
@Setting(settingPath = "/es/data-setting.json")
public class KgEntity {

    @Field(type = FieldType.Keyword)
    @Id
    private Long id;

    /**
     * 机器人ID
     */
    @Field(type = FieldType.Keyword)
    private String appId;

    /**
     * 实体名
     */
    @MultiField(
            mainField = @Field(type = FieldType.Text, searchAnalyzer = "ik_smart", analyzer = "ik_max_word"),
            otherFields = {
                    @InnerField(suffix = "pinyin", type = FieldType.Text, searchAnalyzer = "pinyinFullIndexAnalyzer", analyzer = "pinyinFullIndexAnalyzer"),
                    @InnerField(suffix = "simple_pinyin", type = FieldType.Text, searchAnalyzer = "pinyinSimpleIndexAnalyzer", analyzer = "pinyinSimpleIndexAnalyzer")
            }
    )
    private String name;


    @Field(type = FieldType.Nested)
    private List<KgAttribute> attributes;


    /**
     * 实体名同义词
     */
    @MultiField(
            mainField = @Field(type = FieldType.Text, searchAnalyzer = "ik_smart", analyzer = "ik_max_word"),
            otherFields = {
                    @InnerField(suffix = "pinyin", type = FieldType.Text, searchAnalyzer = "pinyinFullIndexAnalyzer", analyzer = "pinyinFullIndexAnalyzer"),
                    @InnerField(suffix = "simple_pinyin", type = FieldType.Text, searchAnalyzer = "pinyinSimpleIndexAnalyzer", analyzer = "pinyinSimpleIndexAnalyzer")
            }
    )
    private List<String> synonyms;

}
