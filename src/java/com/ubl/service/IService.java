package com.ubl.service;

/**
 * <pre>
 * Contoh penggunaan Interface dalam konsep "Design by Interface".
 *  design by interface means you clearly specify the services an object offers, separate from its implementation.
 * </pre>
 *
 * @author edwin < edwinkun at gmail dot com >
 *
 */
public interface IService {
    String selectAll();
    String selectOne(int id);
    String insert(String name, String address);
}
