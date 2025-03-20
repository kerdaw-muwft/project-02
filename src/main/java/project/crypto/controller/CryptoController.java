package project.crypto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.crypto.model.Crypto;
import project.crypto.service.CryptoService;

import java.util.ArrayList;

@RestController
public class CryptoController {

    @Autowired
    CryptoService cryptoService;

    @PostMapping("cryptos")
    public String addCryptoToPortfolio(@RequestBody Crypto crypto){
        cryptoService.addCrypto(crypto);
        return cryptoService.printPortfolio();
    }

    @GetMapping("cryptos")
    public ArrayList<Crypto> getCryptos(@RequestParam(required = false) String sort){
        cryptoService.sortPortfolio(sort);
        return cryptoService.getPortfolio();
    }

    @GetMapping("cryptos/{id}")
    public String getCryptoDetailsById(@PathVariable Integer id){
        return cryptoService.getCryptoById(id).toString();
    }

    @PutMapping("cryptos/{id}")
    public String updateCryptoById(@RequestBody Crypto updateData, @PathVariable Integer id){
        return cryptoService.updateCryptoById(updateData, id).toString();
    }

    @GetMapping("portfolio-value")
    public Double getPortfolioValue(){
        return cryptoService.getPortfolioValue();
    }

}
