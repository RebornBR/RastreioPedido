package com.AplicacaoRastreio.controller;

import com.AplicacaoRastreio.Model.Pedido;
import com.AplicacaoRastreio.services.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 *Classe RestController, aqui ficam todas URLs de requisição do tipo POST para acesso as funções do sistema
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/pedido")
public class pedidoControllerPost {
    @Autowired
    PedidoService pedidoService;
    /**
     *URL post para criação da chave de acesso através de {@link PedidoService#criarChaveAcesso(String)}
     * @param senhaChaveAcesso String
     * @return {@link PedidoService#criarChaveAcesso(String)}
     */
    @Operation(summary = "Cria chave de acesso", method = "POST")
    @ApiResponse(responseCode = "200", description = "chave de acesso criada com sucesso")
    @PostMapping("/chaveDeAcesso/criarChave")
    public String criarChave(@RequestParam String senhaChaveAcesso){
        return pedidoService.criarChaveAcesso(senhaChaveAcesso);
    }

    /**
     *URL post para criação de pedido atraves de {@link PedidoService#criarPedido(String, String)}
     * @param informacoesPedido String
     * @param senhaDeAcesso String
     * @return {@link PedidoService#criarPedido(String, String)}
     */
    @Operation(summary = "Cria um pedido", method = "POST")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Retorna um objeto 'PEDIDO'"),
            @ApiResponse(responseCode = "409", description = "Senha incorreta, você não tem permissão para acessar essa funcionalidade!")
    })
    @PostMapping("/fazerPedido")
    public Pedido CriarPedido(@RequestParam String informacoesPedido, @RequestParam String senhaDeAcesso){
        return pedidoService.criarPedido(informacoesPedido, senhaDeAcesso);
    }

}
