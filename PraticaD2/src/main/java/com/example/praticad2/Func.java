package com.example.praticad2;

import com.example.praticad2.Model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface Func extends JpaRepository<Funcionario, Long> {
//    Optional<Funcionario> findByData(Date data);
//    List<Funcionario> deleteByDataAdm( Date data2);
}
