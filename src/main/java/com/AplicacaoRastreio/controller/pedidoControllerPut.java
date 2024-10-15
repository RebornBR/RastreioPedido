package com.AplicacaoRastreio.controller;
import com.AplicacaoRastreio.services.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *Classe RestController, aqui fica todas URLs de requisição do tipo PUT para acesso as funções do sistema
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/pedido")
public class pedidoControllerPut {
    @Autowired
    PedidoService pedidoService;

    /**
     *URL put para modificação da chave de acesso através de {@link PedidoService#modificarChaveAcesso(String, String)}
     *  @param antigaChaveAcesso String
     *  @param novaChaveAcesso String
     *  @return {@link PedidoService#modificarChaveAcesso(String, String)}
     */
    @Operation(summary = "Modifica/Atualiza uma senha de acesso previamente cadastrada", method = "PUT")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Senha atualizada com sucesso"),
            @ApiResponse(responseCode = "409", description = "SENHA NÃO EXISTE")
    })
    @PutMapping("/chaveDeAcesso/modificarChave")
    public String modificarChave(@RequestParam String antigaChaveAcesso, String novaChaveAcesso){
        return pedidoService.modificarChaveAcesso(antigaChaveAcesso, novaChaveAcesso);
    }

    /**
     *URL put para atualização da saida de um pedido do setor atraves do metodo {@link PedidoService#pedidoSaidaDoSetor(String, String, String)}
     * @param numeroPedido String
     * @param nomeSetor  String
     * @param senhaDeAcesso String
     */
    @Operation(summary = "Atualiza a SAIDA de um pedido de um determinado setor (ESTOQUE, CORTE, ESTAMPA, EXPEDIÇÃO, ENTREGA", method = "PUT")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = ""),
            @ApiResponse(responseCode = "409", description = "Número de pedido: *numeroPedido*, não foi encontrado no setor: *nomeSetor*")
    })
    @PutMapping("/atualizarSaidaPedidoDoSetor")
    public void saidaSetor(@RequestParam String numeroPedido, String nomeSetor, @RequestParam String senhaDeAcesso){
        pedidoService.pedidoSaidaDoSetor(numeroPedido, nomeSetor, senhaDeAcesso);
    }


    /**
     *URL put para atualização da entrada de um pedido no setor atraves do metodo {@link PedidoService#pedidoEntradaNoSetor(String, String, String)}
     * @param numeroPedido String
     * @param nomeSetorQueDeuEntrada  String
     * @param senhaDeAcesso String
     */
    @Operation(summary = "Atualiza/cria a ENTRADA de um pedido em um determinado setor (CORTE, ESTAMPA, EXPEDIÇÃO, ENTREGA", method = "PUT")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = ""),
            @ApiResponse(responseCode = "409", description = "Pedido *numeroPedido* não foi encontrado || Pedido *numeroPedido* já deu entrada no setor de: *nomeSetorQueDeuEntrada*")
    })
    @PutMapping("/atualizarEntradaPedidoNoSetor")
    public void entradaSetor(@RequestParam String numeroPedido, String nomeSetorQueDeuEntrada, @RequestParam String senhaDeAcesso){
        pedidoService.pedidoEntradaNoSetor(numeroPedido, nomeSetorQueDeuEntrada, senhaDeAcesso);
    }


    /**
     *URL put para atualização do status de um pedido que está no setor ENTREGA atraves do metodo {@link PedidoService#atualizarStatus(String, String, String)}
     * @param numeroPedido String
     * @param status String
     * @param senhaDeAcesso String
     */
    @Operation(summary = "Atualiza o status de um pedido que está no setor de entrega", method = "PUT")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = ""),
            @ApiResponse(responseCode = "409", description = "Pedido: *numeroPedido*, não existe ou ainda não passou pelo setor de entrega")
    })
    @PutMapping("/atualizarStatus")
    public void atualizarStatus(@RequestParam String numeroPedido, String status, @RequestParam String senhaDeAcesso){
        pedidoService.atualizarStatus(numeroPedido, status, senhaDeAcesso);
    }
}
