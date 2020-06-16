package com.ny.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import java.util.List;


@Data
public class KgAttribute {

    private Long id;

    /**
     * 属性名
     */
    @MultiField(
            mainField = @Field(type = FieldType.Text, searchAnalyzer = "ik_smart", analyzer = "ik_max_word"),
            otherFields = {
                    @InnerField(suffix = "pinyin", type = FieldType.Text, searchAnalyzer = "pinyinFullIndexAnalyzer", analyzer = "pinyinFullIndexAnalyzer"),
                    @InnerField(suffix = "simple_pinyin", type = FieldType.Text, searchAnalyzer = "pinyinSimpleIndexAnalyzer", analyzer = "pinyinSimpleIndexAnalyzer")
            }
    )
    private String name;

    /**
     * 属性值
     */
    @MultiField(
            mainField = @Field(type = FieldType.Text, searchAnalyzer = "ik_smart", analyzer = "ik_max_word"),
            otherFields = {
                    @InnerField(suffix = "pinyin", type = FieldType.Text, searchAnalyzer = "pinyinFullIndexAnalyzer", analyzer = "pinyinFullIndexAnalyzer"),
                    @InnerField(suffix = "simple_pinyin", type = FieldType.Text, searchAnalyzer = "pinyinSimpleIndexAnalyzer", analyzer = "pinyinSimpleIndexAnalyzer")
            }
    )
    private List<String> value;


    /**
     * 属性名同义词
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
