package com.AplicacaoRastreio.controller;

import com.AplicacaoRastreio.services.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
/**
 *Classe RestController, aqui ficam todas URLs de requisição do tipo GET para download dos arquivos gerados pelo sistema
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/pedido")
public class PedidoControllerGetDownload {
    @Autowired
    PedidoService pedidoService;

    /**
     *URL get para download de um pdf atraves de {@link PedidoService#baixarArquivo(String, String)} utilizado para baixar o pdf
     * de criação de um pedido. PDF gerado no metodo {@link PedidoService#criarPedido(String, String)}
     * @param senhaDeAcesso String
     * @throws FileNotFoundException Quando não encontrar o arquivo passado na variavel "nomeArquivo" do metodo {@link PedidoService#baixarArquivo(String, String)}
     * @return {@link PedidoService#baixarArquivo(String, String)}
     */
    @Operation(summary = "Permite o download do arquivo pdf gerado após a criação de um pedido", method = "GET")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Arquivo para download"),
            @ApiResponse(responseCode = "409", description = "Senha incorreta, você não tem permissão para acessar essa funcionalidade!")
    })
    @GetMapping("/download/criacaoPedido")
    public ResponseEntity<InputStreamResource> downloadCriacaoPedido(@RequestParam String senhaDeAcesso) throws FileNotFoundException {
        return pedidoService.baixarArquivo("relatorioCriacaoPedido", senhaDeAcesso);
    }


    /**
     *URL get para download de um pdf atraves de {@link PedidoService#baixarArquivo(String, String)} utilizado para baixar o pdf de pedidos gerados
     * atraves do metodo {@link PedidoService#buscarPorNumeroPedido(String, String)}
     * @param senhaDeAcesso String
     * @throws FileNotFoundException Quando não encontrar o arquivo passado na variavel "nomeArquivo" do metodo {@link PedidoService#baixarArquivo(String, String)}
     * @return {@link PedidoService#baixarArquivo(String, String)}
     */
    @Operation(summary = "Permite o download do arquivo pdf gerado após a busca por um pedido(metodo buscarPorNumeroPedido)", method = "GET")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Arquivo para download"),
            @ApiResponse(responseCode = "409", description = "Senha incorreta, você não tem permissão para acessar essa funcionalidade!")
    })
    @GetMapping("/download/relatorioPedido")
    public ResponseEntity<InputStreamResource> downloadRelatorioPedido(@RequestParam String senhaDeAcesso) throws FileNotFoundException {
        return pedidoService.baixarArquivo("relatorioPedido", senhaDeAcesso);
    }


    /**
     *URL get para download de um pdf atraves de {@link PedidoService#baixarArquivo(String, String)} utilizado para baixar o pdf de pedidos gerados
     * pelo metodo {@link PedidoService#buscarPorContainNumeroPedido(String, String)}
     * @param senhaDeAcesso String
     * @throws FileNotFoundException Quando não encontrar o arquivo passado na variavel "nomeArquivo" do metodo {@link PedidoService#baixarArquivo(String, String)}
     * @return {@link PedidoService#baixarArquivo(String, String)}
     */
    @Operation(summary = "Permite o download do arquivo pdf gerado após a busca por um pedido(metodo buscarPorContainNumeroPedido)", method = "GET")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Arquivo para download"),
            @ApiResponse(responseCode = "409", description = "Senha incorreta, você não tem permissão para acessar essa funcionalidade!")
    })
    @GetMapping("/download/relatorioPedidos")
    public ResponseEntity<InputStreamResource> downloadRelatorioPedidos(@RequestParam String senhaDeAcesso) throws FileNotFoundException {
        return pedidoService.baixarArquivo("relatorioPedidos", senhaDeAcesso);
    }


    /**
     *URL get para download de um pdf atraves de {@link PedidoService#baixarArquivo(String, String)} utilizado para baixar o pdf de pedidos gerados
     * pelo metodo {@link PedidoService#buscarPorNomeSetor(String, String)}
     * @param senhaDeAcesso String
     * @throws FileNotFoundException Quando não encontrar o arquivo passado na variavel "nomeArquivo" do metodo {@link PedidoService#baixarArquivo(String, String)}
     * @return {@link PedidoService#baixarArquivo(String, String)}
     */
    @Operation(summary = "Permite o download do arquivo pdf gerado após a busca por pedidos em um setor(metodo buscarPorNomeSetor)", method = "GET")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Arquivo para download"),
            @ApiResponse(responseCode = "409", description = "Senha incorreta, você não tem permissão para acessar essa funcionalidade!")
    })
    @GetMapping("/download/relatorioPedidosNoSetor")
    public ResponseEntity<InputStreamResource> downloadRelatorioPedidosSetor(@RequestParam String senhaDeAcesso) throws FileNotFoundException {
        return pedidoService.baixarArquivo("relatorioPedidosNoSetor", senhaDeAcesso);
    }
}
