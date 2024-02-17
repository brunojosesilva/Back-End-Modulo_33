package br.com.brunojs;

import br.com.brunojs.dao.GenericDao;
import br.com.brunojs.dao.IGenericDao;
import br.com.brunojs.domain.Acessorio;
import br.com.brunojs.domain.Carro;
import br.com.brunojs.domain.Marca;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCompleto {

    @Test
    public void Cadastra() {

        IGenericDao genericDao = new GenericDao();

        //********   Adicionando a marca
        Marca marca = new Marca();
        marca.setDescricao("Toyota");

        Marca cadastroMarca = (Marca) genericDao.cadastrar(marca);

        assertNotNull(cadastroMarca);

        if (cadastroMarca.getId() > 0){
            System.out.println("Cadastrado a Marca : " +cadastroMarca.getId() + " " + cadastroMarca.getDescricao() );
        }

        //*********** Colocando os acessorios

        Acessorio acessorio1 = new Acessorio();
        acessorio1.setNome("Rodas grandes");
        acessorio1.setValor(1222.90);

//        Acessorio acessorioCadastro = (Acessorio) genericDao.cadastrar(acessorio1);

        Acessorio acessorio2 = new Acessorio();
        acessorio2.setNome("Grande motor");
        acessorio2.setValor(15552.90);

//        acessorioCadastro = (Acessorio) genericDao.cadastrar(acessorio2);


        //********* Adicionando o carro
        Carro carro = new Carro();
        carro.setNome("Corolla");
        carro.setMarca(marca);
        carro.add(acessorio1);
        carro.add(acessorio2);

        Carro cadastroCarro = (Carro) genericDao.cadastrar(carro);

        assertNotNull(cadastroCarro);

        if (cadastroCarro.getId() > 0){
            System.out.println("Cadastrado o Carro : " +cadastroCarro.getId() + " " + cadastroCarro.getNome() );
        }

        //*********** Excluindo as informacoes
        Carro excluirCarro = (Carro) genericDao.excluir(cadastroCarro);

        assertNotNull(excluirCarro);

        Marca excluirMarca = (Marca) genericDao.excluir(cadastroMarca);

        assertNotNull(excluirMarca);

    }
}
