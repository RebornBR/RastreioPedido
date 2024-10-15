package com.AplicacaoRastreio.controller;

import com.AplicacaoRastreio.Model.Pedido;
import com.AplicacaoRastreio.services.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
/**
 *Classe RestController, aqui ficam todas URLs de requisição do tipo GET para acesso as funções do sistema
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/pedido")
public class pedidoControllerGet {
    @Autowired
    PedidoService pedidoService;
    /**
     *URL get para obtenção de uma list de pedidos atraves de {@link PedidoService#buscarPorNumeroPedido(String, String)}
     * @param numeroPedido  String
     * @param senhaDeAcesso String
     * @return {@link PedidoService#buscarPorNumeroPedido(String, String)}
     */
    @Operation(summary = "Busca pelos setores que um pedido passou", method = "GET")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Retorna uma lista que contém as informações dos setores que o pedido passou"),
            @ApiResponse(responseCode = "409", description = "Senha incorreta, você não tem permissão para acessar essa funcionalidade!")
    })
    @GetMapping("/buscarPorNumeroPedido")
    public List<Pedido> buscarPorNumeroPedido(@RequestParam String numeroPedido, @RequestParam String senhaDeAcesso){
        return pedidoService.buscarPorNumeroPedido(numeroPedido, senhaDeAcesso);
    }


    /**
     *URL get para obtenção de uma list de pedidos atraves de {@link PedidoService#buscarPorContainNumeroPedido(String, String)}
     * @param numeroPedido  String
     * @param senhaDeAcesso String
     * @return {@link PedidoService#buscarPorContainNumeroPedido(String, String)}
     */
    @Operation(summary = "Permite a busca de setores que um pedido passou. *Permite a busca digitando apenas uma parte do numero do pedido (CONTAIN)*", method = "GET")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Retorna uma lista que contém as informações dos setores que o pedido passou"),
            @ApiResponse(responseCode = "409", description = "Senha incorreta, você não tem permissão para acessar essa funcionalidade!")
    })
    @GetMapping("/buscarContainNumeroPedido")
    public List<Pedido> buscarContain(@RequestParam String numeroPedido, @RequestParam String senhaDeAcesso){
        return pedidoService.buscarPorContainNumeroPedido(numeroPedido, senhaDeAcesso);
    }


    /**
     *URL get para obtenção de uma list de pedidos atraves de {@link PedidoService#buscarPorNomeSetor(String, String)}
     * @param nomeSetor  String
     * @param senhaDeAcesso String
     * @return {@link PedidoService#buscarPorNomeSetor(String, String)}
     */
    @Operation(summary = "Permite a busca de todos os pedidos que estão em um determinado setor", method = "GET")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Retorna uma lista que contém as informações de todos os pedidos presentes no setor"),
            @ApiResponse(responseCode = "409", description = "Senha incorreta, você não tem permissão para acessar essa funcionalidade!")
    })
    @GetMapping("/buscarPorNomeSetor")
    public List<Pedido> buscarPorSetor(@RequestParam String nomeSetor, @RequestParam String senhaDeAcesso){
        return pedidoService.buscarPorNomeSetor(nomeSetor, senhaDeAcesso);
    }


}
