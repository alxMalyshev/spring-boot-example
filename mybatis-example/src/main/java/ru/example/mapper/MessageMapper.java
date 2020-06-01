package ru.example.mapper;

import org.apache.ibatis.annotations.*;
import ru.example.model.Message;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("SELECT * FROM message")
    List<Message> findAll();

    @Select("SELECT * FROM message WHERE id = #{id}")
    Message findById(Integer id);

    @Options(useGeneratedKeys = true, keyColumn ="id" ,keyProperty ="id" )
    @Insert("INSERT INTO message(text, tag) VALUES (#{text}, #{tag}) RETURNING PRIMARY KEY")
//    @SelectKey(statement = "select last_insert_id()", keyProperty = "id",before = false, resultType = Integer.class)
    Integer insert(Message message);
}
