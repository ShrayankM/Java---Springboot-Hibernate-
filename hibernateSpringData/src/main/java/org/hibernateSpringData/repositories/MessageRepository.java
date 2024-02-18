package org.hibernateSpringData.repositories;

import org.hibernateSpringData.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
