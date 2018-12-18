package com.boot.demo.demo.domain.mapper;

import com.boot.demo.demo.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonMapper {

    @Select("select * from person")
    List<Person> findPersons();
}
