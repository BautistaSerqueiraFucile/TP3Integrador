package org.example.integrador3.services;


import java.util.List;

public interface BaseService<E>{

    /**
     * Servicio encargado de buscar y retornar una entidad coincidente con el id ingresado por parámetro.
     *
     * @param id Identificador únido de la entidad.
     * @return Entidad coincidente con id.
     * @throws Exception e
     */
    public E findById(Long id)throws Exception;

    /**
     * Servicio encargado de persistir una entidad ingresada por parámetro.
     * @param entity entidad a persistir
     * @return Entidad persistida con id asignado.
     * @throws Exception e
     */
    public E save(E entity)throws  Exception;

    /**
     * Servicio encargado de actualizar una entidad.
     * @param id Identificador único de la entidad a actualizar.
     * @param entity Entidad con los datos a a actualizar.
     * @return Retorna la entidad actualizada.
     * @throws Exception e
     */
    public E update(Long id, E entity)throws Exception;

}
