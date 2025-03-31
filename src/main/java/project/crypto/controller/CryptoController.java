package project.crypto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.crypto.model.Crypto;
import project.crypto.service.CryptoService;
import project.crypto.service.SortTypes;

import java.util.ArrayList;

@RestController
public class CryptoController {

    @Autowired
    CryptoService cryptoService;

    @PostMapping("cryptos")
    public ResponseEntity<Crypto> addCryptoToPortfolio(@RequestBody Crypto crypto){
        cryptoService.printPortfolio();
        return ResponseEntity.ok(cryptoService.addCrypto(crypto));
    }

    @GetMapping("cryptos")
    public ResponseEntity<ArrayList<Crypto>> getCryptos(@RequestParam(required = false) String sort){
        cryptoService.sortPortfolio(sort);
        return ResponseEntity.ok(cryptoService.getPortfolio());
    }

    @GetMapping("cryptos/{id}")
    public ResponseEntity<Crypto> getCryptoDetailsById(@PathVariable Integer id){
        return ResponseEntity.ok(cryptoService.getCryptoById(id));
    }

    @PutMapping("cryptos/{id}")
    public ResponseEntity<Crypto> updateCryptoById(@RequestBody Crypto updateData, @PathVariable Integer id){
        return ResponseEntity.ok(cryptoService.updateCryptoById(updateData, id));
    }

    @GetMapping("portfolio-value")
    public Double getPortfolioValue(){
        return cryptoService.getPortfolioValue();
    }

}
