package com.intrawey.prueba.apirest.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.intrawey.prueba.apirest.entity.Multiplos;
import org.springframework.stereotype.Repository;
@Repository
public interface IMultipoDao extends JpaRepository<Multiplos, Long>{
	


}
