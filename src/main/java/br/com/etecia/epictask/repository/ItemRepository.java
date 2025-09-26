package br.com.etecia.epictask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.etecia.epictask.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
