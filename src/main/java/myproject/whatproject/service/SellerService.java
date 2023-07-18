package myproject.whatproject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myproject.whatproject.domain.seller.Seller;
import myproject.whatproject.mapper.MyMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SellerService {

    private final MyMapper myMapper;

    public Seller findSellerByNum(String seller_no) {
        return myMapper.findSellerByNum(seller_no);
    }

}
