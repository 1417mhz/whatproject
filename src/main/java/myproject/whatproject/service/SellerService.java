package myproject.whatproject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myproject.whatproject.domain.seller.Seller;
import myproject.whatproject.mapper.MyMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SellerService {

    private final MyMapper myMapper;

    public List<Seller> findAllSeller() {
        return myMapper.findAllSeller();
    }

    public Seller findSellerByNo(int sellerNo) {
        return myMapper.findSellerByNo(sellerNo);
    }

}
