package project.crypto.service;

import org.springframework.stereotype.Service;
import project.crypto.model.Crypto;

import java.util.*;

@Service
public class CryptoService {
    private final ArrayList<Crypto> portfolio = new ArrayList<>();
    private final String DEFAULT_SORT_TYPE = "name";


    public Crypto addCrypto(Crypto crypto){
        this.portfolio.add(crypto);
        return portfolio.getLast();
    }

    public String printPortfolio(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Crypto crypto : portfolio) {
            System.out.println(crypto.toString());
            stringBuilder.append(crypto.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public ArrayList<Crypto> getPortfolio() {
        return new ArrayList<>(portfolio);
    }

    public Crypto getCryptoById(Integer id){
        return portfolio.stream()
                .filter(crypto -> Objects.equals(crypto.getId(), id))
                .findAny()
                .orElse(null);
    }

    public void sortPortfolio(String sort){
        String sortType = DEFAULT_SORT_TYPE;
        if (sort != null) {
            sortType = sort;
        }
        switch (sortType) {
            case "name" -> portfolio.sort(Comparator.comparing(Crypto::getName));
            case "price" -> portfolio.sort(Comparator.comparing(Crypto::getPrice));
            case "quantity" -> portfolio.sort(Comparator.comparing(Crypto::getQuantity));
        }
    }


    public Crypto updateCryptoById(Crypto updateData, Integer id) {
        Crypto updatedCrypto = this.getCryptoById(id);
        updatedCrypto.setName(updateData.getName());
        updatedCrypto.setPrice(updateData.getPrice());
        updatedCrypto.setSymbol(updateData.getSymbol());
        updatedCrypto.setQuantity(updateData.getQuantity());
        return updatedCrypto;
    }

    public Double getPortfolioValue() {
        Double portfolioValue = 0.0;
        for (Crypto crypto : portfolio) {
            portfolioValue += crypto.getPrice() * crypto.getQuantity();
        }
        return portfolioValue;
    }

//    @Override
//    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < portfolio.size(); i++) {
//            stringBuilder.append(portfolio.get(i).toString()).append("<br>\n");
//        }
//        return stringBuilder.toString();
//    }
}
