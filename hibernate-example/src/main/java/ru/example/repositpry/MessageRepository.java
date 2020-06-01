package ru.example.mapper;

import org.springframework.data.repository.CrudRepository;
import ru.example.model.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
