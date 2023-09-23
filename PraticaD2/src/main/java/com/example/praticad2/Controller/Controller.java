package com.example.praticad2.Controller;

import com.example.praticad2.Func;
import com.example.praticad2.Model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/funcionario")
public class Controller {
    private Func funcRep;

    @Autowired
    public Controller (Func funcRep){
        this.funcRep = funcRep;
    }

    //método para mostrar todos os funcionários
     @GetMapping("/mostrarFuncionarios")
    public List<Funcionario> MostrarFuncionarios(){
        return funcRep.findAll();
    }

    //método para cadastrar um funcionário
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarFuncionario(@RequestBody Funcionario body){
        try{
            funcRep.save(body);
            return ResponseEntity.ok("Funcionário cadastrado com sucesso! :)");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Falha ao cadastrar o Funcionário :(");
        }
    }
    //Buscar Funcionario pelo ID
    @GetMapping("/mostrarFuncionarioId/{id}")
    private Optional<Funcionario> mostrarFuncId(@PathVariable Long id){
        return funcRep.findById(id);
    }


//método para alterar as informanões dos funcionários por id
    @PutMapping("/alterarInfo/{id}")
    private ResponseEntity<String> alterarInfos(@PathVariable Long id, @RequestBody Funcionario body){
        Optional<Funcionario> xpto = funcRep.findById(id);
        if(xpto.isPresent()){
            Funcionario func = xpto.get();
            func.setCargo(body.getCargo());
            func.setDepartamento(body.getDepartamento());
            func.setSalario(body.getSalario());
            funcRep.save(func);
            return ResponseEntity.ok("Informações do funcionário alteradas com sucesso");
        } else {
            return ResponseEntity.badRequest().body("erro ao alterar as informações ");
        }
    }

//    @DeleteMapping("/deletar/{data_admissao}")
//    private ResponseEntity<String> deletarData(@PathVariable Date data_admissao){
//        Optional<Funcionario> dataAdm = funcRep.findByData(data_admissao);
//        if(dataAdm.isPresent()){
//            funcRep.deleteByDataAdm(data_admissao);
//            return ResponseEntity.ok("Funcionario Apagado com sucesso ");
//        }
//        return ResponseEntity.badRequest().body("Funcionario não foi encerrado");
//    }


}
