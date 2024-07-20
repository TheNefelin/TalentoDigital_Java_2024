package cl.praxis.biblioteca.controllers;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBaseControllerCRUD<T> {
    List<T> findAll();
    ResponseEntity<T> findById(int id);
    ResponseEntity<T> create(T t);
    ResponseEntity<T> update(T t);
    ResponseEntity<Void> delete(int id);
}
